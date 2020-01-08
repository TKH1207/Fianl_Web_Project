import java.util.Comparator;

public class WebNodeComparator implements Comparator<WebPage>{
	@Override
	public int compare(WebPage o1, WebPage o2){
		if(o1==null || o2==null) throw new NullPointerException();
		
		
		if(o1.score>o2.score){
			return -1;
		}else if(o1.score<o2.score){
			return 1;
		}
		return 0;
	}
}
