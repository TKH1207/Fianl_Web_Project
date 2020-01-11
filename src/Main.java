import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("請輸入關鍵字：");
		String keyword = in.next();
		System.out.println("請輸入查詢類別：運動(1), 政治(2)");
		int type = in.nextInt();
		if(type==1) {
			try {
				System.out.println("請稍候...");
				Query q = new Query(keyword);
				String[][] s = q.initialQuery(1);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(type==2) {
			try {
				System.out.println("請稍候...");
				Query q = new Query(keyword);
				String[][] s = q.initialQuery(2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("看不懂中文？");
		}
		
	}

}