import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("請輸入關鍵字：");
		String keyword = in.next();
		
		try {
			System.out.println(new Query2(keyword).initialQuery(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}