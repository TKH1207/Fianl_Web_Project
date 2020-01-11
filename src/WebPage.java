import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public double score;
	public ArrayList<String> exsistKeyword;
	public WebPage(String url,String name){
		this.url = url;
		this.name = name;
		this.exsistKeyword = new ArrayList<String>();
	}
	public void setScore(int s){
		score = s;
	}
	
}