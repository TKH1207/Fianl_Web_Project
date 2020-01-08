import java.util.ArrayList;

public class KeywordList{
	private ArrayList<Keyword> list;
	
	public KeywordList(){
		this.list = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		// add keyword to proper index base on its count
		list.add(keyword);
    }
		
	/*public void outputIndex(int n){
		if(n>list.size()-1){
		    System.out.println("InvalidOperation");
		    return;
		}
		LinkedList<Keyword> results = new LinkedList<Keyword>();
		Keyword k = list.get(n);		    
		results.add(k);		    		
		printKeywordList(results);	
	}
	
	public void outputCount(int c){
		LinkedList<Keyword> results = new LinkedList<Keyword>();
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    if(k.count == c){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
    }
	
	public void outputHas(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    if(k.name.contains(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
	}
	
	public void outputName(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    if(k.name.equals(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
	}
	
	public void outputFirstN(int n){
		if(n>list.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
		    Keyword k = list.get(i);
		    if(i>0){
		    	sb.append(" ");
		    }
		    sb.append(k.toString());   
		}
		System.out.println(sb.toString());
    }
	
	public void outputScore(){
		float results = 0;
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    results += k.weight * k.count;
		}
		
		System.out.println(results);
	}*/
	
	/*public void deleteIndex(int n){
		if(n>=list.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
			
		list.remove(n);
		
		System.out.println("Done");	
	}
	
	public void deleteCount(int cnt){
		// remove nodes that the count is equal to cnt
		LinkedList<Keyword> results = new LinkedList<Keyword>();
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    if(k.count == cnt){
		    	list.remove(i);
		    	results.add(k);
		    	i--;
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
			System.out.println("Done");
		}
    }
	
	public void deleteHas(String pattern){
		// remove nodes that the name contains input name
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    if(k.name.contains(pattern)){
		    	list.remove(i);
		    	results.add(k);
		    	i--;
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
			System.out.println("Done");
		}
    }
	
	public void deleteName(String name){
		// remove nodes that the name is equal to input name
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i=0;i<list.size();i++){
		    Keyword k = list.get(i);
		    if(k.name.equals(name)){
		    	list.remove(i);
		    	results.add(k);
		    	i--;
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
			System.out.println("Done");
		}
    }
	
	public void deleteFirstN(int n){
		//remove first n nodes
		if(n>list.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		for(int i=0;i<n;i++){
		    list.remove(0);   
		}
		System.out.println("Done");
    }	*/
	
	/*public void deleteAll(){
		list = new LinkedList<Keyword>();
		System.out.println("Done");
    }*/
	
	public void printKeywordList(){
		System.out.println(list.toString());
    }
}