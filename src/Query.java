import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.lang.StringBuffer;
import java.util.ArrayList;
public class Query 
{
	public String searchKeyword;
	public String url;
	public String content;
	public WebNodeHeap heap = new WebNodeHeap();
	public CreatePoliticalKeywordList political= new CreatePoliticalKeywordList();
	public CreateSportsKeywordList sports= new CreateSportsKeywordList();
	public ArrayList<Keyword> politicalList;
	public ArrayList<Keyword> sportsList;
	public int maxNumber = 100;
	public String[][] finalResult = new String[maxNumber][2];
	public int nominalNumber;
	public int realNumber;
	
	public Query(String searchKeyword)
	{
		politicalList = political.create();
		sportsList = sports.create();
		this.searchKeyword = searchKeyword;
		this.url = "https://udn.com/search/result/2/"+searchKeyword;
	}
	
	private String initialFetchContent() throws IOException
	{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;
		while((line=bufReader.readLine())!=null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	private String fetchSubWebContent(String url) throws IOException
	{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in,"utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;
		while((line=bufReader.readLine())!=null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public String[][] initialQuery(int num) throws IOException{
		realNumber = 0;
		if(content==null) {
			content= initialFetchContent();
		}
		Document doc = Jsoup.parse(content);
		//先看看原本的網頁是什麼順序 順便算有幾篇(有可能有重複的)
		int n = 2;
		while(true) {
			String initialTitle = 
					doc.select("#search_content > dt:nth-child("+n+") > a > h2").text();
			if(initialTitle.equals("")) {
				nominalNumber = n-2;
				break;
			}
			System.out.println(initialTitle);
			n++;
		}
		realNumber = nominalNumber;
		//進入每個網頁評分 並放入heap排序
		int i = 0;
		String temp = "";
		while(i<nominalNumber) {
			String initialTitle = 
					doc.select("#search_content > dt:nth-child("+(i+2)+") > a > h2").text();
			if(initialTitle.equals(temp)) {
				realNumber --;
				i++;
				continue;
			}
			temp = initialTitle;
			Elements lis = doc.select("#search_content > dt:nth-child("+(i+2)+") > a");
			try {
				query(lis.get(0).attr("href"), num);
			}catch(java.net.ConnectException e) {
				realNumber --;
				i++;
				continue;
			}
			
			i++;
		}
		finalResult = new String[realNumber][2];
		//先在console上印出結果，以及把結果依序放入finalResult
		printResult();
		return finalResult;
	}

	public void query(String url, int num) throws IOException{
		String subContent = fetchSubWebContent(url);
		Document doc = Jsoup.parse(subContent);
		String title = "";
		String content = "";
		String relatedNewsContent = "";
		title = doc.select("#story_art_title").text();
		if(title.equals("")) {
			realNumber --;
			return;
		}
		content = doc.select("#article_body").text();
		//子網頁(相關新聞的標題)
		int link = 1;
		while(true) {
			String current = doc.select("#mainbar > div.also_listing > div:nth-child(1) > dl > dt:nth-child("+link+") > a > h3").text();
			if(current.equals("")) {
				break;
			}
			relatedNewsContent += current;
			link++;
		}
		//
		WebPage page = new WebPage(url, title);
		//算分數
		int score = 0;
		if(num == 1) {
			for(Keyword k : sportsList){
				int count = countKeyword(k.name, title+content+relatedNewsContent);
				score += count* k.weight;
				//score += countKeyword(k.name, content)* k.weight;
				if(count!=0) {
					page.exsistKeyword.add(k.name);
				}
			}
			page.setScore(score);
			heap.add(page);
			System.out.println(title);
			//sportsList.printKeywordList();
		}else if(num == 2){
			for(Keyword k : politicalList){
				int count = countKeyword(k.name, title+content);
				score += count* k.weight;
				//score += countKeyword(k.name, content)* k.weight;
				if(count!=0) {
					page.exsistKeyword.add(k.name);
				}
			}
			page.setScore(score);
			heap.add(page);
			//System.out.println("One Report Done");
			System.out.println(title);
			//System.out.println(countKeyword(searchKeyword, contentNeeded(doc.text())));
		}
		
	}
	
	public int countKeyword(String keyword, String content) throws IOException{
		String cont = content;
		int retVal = 0; 
		while(cont.indexOf(keyword)!=-1) {
			retVal++;
			cont = cont.substring(cont.indexOf(keyword) + keyword.length());
		}
		return retVal;
    }
	
	public void printResult() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("搜尋結果：");
		for(int i = 0; i<realNumber; i++) {
			WebPage w = heap.removeMax();
			//finalResult.put(i + " " + w.name, w.url);
			finalResult[i][0] = w.name;
			finalResult[i][1] = w.url;
			System.out.println();
		}
	}
}