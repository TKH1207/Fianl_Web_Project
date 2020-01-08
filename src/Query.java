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
	
	
	public Query(String searchKeyword)
	{
		politicalList = political.create();
		sportsList = sports.create();
		this.searchKeyword = searchKeyword;
		this.url = "https://tw.appledaily.com/search/result?querystrS="+searchKeyword;
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
	
	public HashMap<String, String> initialQuery(int num) throws IOException{
		if(content==null){
			content= initialFetchContent();
		}
		HashMap<String, String> retVal = new HashMap<String, String>();
		Document doc = Jsoup.parse(content);
		int n = 1;
		while(true) {
			String initialTitle = doc.select("#result > li:nth-child("+n+") > div > h2").text();
			if(initialTitle.equals("")) {
				break;
			}
			System.out.println(initialTitle);
			n++;
		}
		//第一個結果
		/*Elements lis = doc.select("#result > li:nth-child(1) > div > h2 > a");
		retVal.put(lis.text(), lis.get(0).attr("href"));
		query(lis.get(0).attr("href"));*/
		//其他結果
		int i = 1;
		while(i<=7) {
		Elements lis = doc.select("#result > li:nth-child("+i+") > div > h2 > a");
		//System.out.println(lis.text());
		//System.out.println(lis.get(0).attr("href"));
		query(lis.get(0).attr("href"), num);
		i++;
		}
		
		System.out.println();
		System.out.println("搜尋結果：");
		i = 1;
		while(i<=7) {
			WebPage w = heap.removeMax();
			retVal.put(w.name, w.url);
			System.out.println();
			i++;
		}
		return retVal;
	}
	
	
	
	public void query(String url, int num) throws IOException{
		String subContent = fetchSubWebContent(url);
		Document doc = Jsoup.parse(subContent);
		String title = "";
		String content = "";
		title = doc.select("#article-header > header").text();
		title += doc.select("#article > div.wrapper > div > main > article > hgroup > h1").text();
		content = doc.select("#articleBody").text();
		content += doc.select("#article > div.wrapper > div > main > article > div.thoracis > div.ndArticle_contentBox > article > div.ndArticle_margin > p:nth-child(1)").text();		
		WebPage page = new WebPage(url, title);
		//算分數
		int score = 0;
		
		if(num == 1) {
			for(Keyword k : sportsList){
				score += countKeyword(k.name, content)* k.weight;	
			}
			page.setScore(score);
			heap.add(page);
			//System.out.println(content);
			//sportsList.printKeywordList();
		}
		else if(num == 2){
			for(Keyword k : politicalList){
				score += countKeyword(k.name, content)* k.weight;	
			}
			page.setScore(score);
			heap.add(page);
			//System.out.println("One Report Done");
			//System.out.println(content);
			//System.out.println(countKeyword(searchKeyword, contentNeeded(doc.text())));
		}
		
	}
	
	
	public int countKeyword(String keyword, String content) throws IOException{
		String cont = content;
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		//cont = cont.toUpperCase();
		//keyword = keyword.toUpperCase();
	
		int retVal = 0; 
		while(cont.indexOf(keyword)!=-1) {
			retVal++;
			cont = cont.substring(cont.indexOf(keyword) + keyword.length());
		}
		
		return retVal;
    }
}