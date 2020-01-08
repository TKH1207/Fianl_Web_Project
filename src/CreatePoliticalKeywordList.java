import java.util.ArrayList;

public class CreatePoliticalKeywordList {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		create();
	}*/

	public static ArrayList<Keyword> create() {
		ArrayList<Keyword>  kLst = new ArrayList<Keyword>();
		Keyword k1 = new Keyword("台灣", 0, 1.0);
		Keyword k2 = new Keyword("中國", 0, 1.0);
		Keyword k3 = new Keyword("總統", 0, 1.0);
		Keyword k4 = new Keyword("選舉", 0, 1.0);
		Keyword k5 = new Keyword("市長", 0, 1.0);
		Keyword k6 = new Keyword("黨", 0, 1.0);
		Keyword k7 = new Keyword("議員", 0, 1.0);
		Keyword k8 = new Keyword("立法", 0, 1.0);
		Keyword k9 = new Keyword("彈劾", 0, 1.0);
		Keyword k10 = new Keyword("大選", 0, 1.0);
		kLst.add(k1);
		kLst.add(k2);
		kLst.add(k3);
		kLst.add(k4);
		kLst.add(k5);
		kLst.add(k6);
		kLst.add(k7);
		kLst.add(k8);
		kLst.add(k9);
		kLst.add(k10);
		//kLst.outputCount(0);
		return kLst;
	}

}
