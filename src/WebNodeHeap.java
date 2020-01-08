import java.util.PriorityQueue;

public class WebNodeHeap {
	private PriorityQueue<WebPage> heap;
	
	public WebNodeHeap(){
		this.heap = new PriorityQueue<WebPage>(10, new WebNodeComparator());
	}
	
	public void add(WebPage k){
		heap.offer(k);
		System.out.println("Done");
	}
	
	public void peek(){
		if(heap.peek() == null){
			System.out.println("InvalidOperation");
			return;
		}
		
		WebPage k = heap.peek();		
		System.out.println(k.name);
	}
	
	public WebPage removeMax(){
		//TODO: write remove minimal element logic here...
		WebPage k = heap.poll();
		System.out.println(k.name + " " + k.score);	
		return k;
	}
	
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		WebPage k;
		
		while((k = heap.poll()) != null){
			sb.append(k.toString());
			if(heap.peek() != null) sb.append("");
		}
		
		System.out.println(sb.toString());	
	}
}