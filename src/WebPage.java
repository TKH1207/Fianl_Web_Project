import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	//public String content;
	public String name;
	public WordCounter counter;
	public double score;
	
	/*public WebPage(String url,String name, String content){
		this.url = url;
		this.name = name;
		this.content = content;
		this.counter = new WordCounter(url);	
	}*/
	
	public WebPage(String url,String name){
		this.url = url;
		this.name = name;
	}
	
	/*public void setContent(String c) {
		content = c;
	}*/
	
	/*public void setScore(KeywordList kLst) throws IOException{
		score = 0;
		for(Object k : kLst){
			score += counter.countKeyword(((Keyword)k).name)* ((Keyword)k).weight;	
		}
	}*/
	
	public void setScore(int s){
		score = s;
	}
	
}