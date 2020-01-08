import java.util.ArrayList;

public class CreateSportsKeywordList {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		create();
	}*/

	public static ArrayList create() {
		ArrayList<Keyword>  kLst = new ArrayList<Keyword>();
		Keyword k1 = new Keyword("體育", 0, 1.0);
		Keyword k2 = new Keyword("運動", 0, 1.0);
		Keyword k3 = new Keyword("籃球", 0, 1.0);
		Keyword k4 = new Keyword("棒球", 0, 1.0);
		Keyword k5 = new Keyword("排球", 0, 1.0);
		Keyword k6 = new Keyword("球員", 0, 1.0);
		Keyword k7 = new Keyword("比賽", 0, 1.0);
		Keyword k8 = new Keyword("奧運", 0, 1.0);
		Keyword k9 = new Keyword("犯規", 0, 1.0);
		Keyword k10 = new Keyword("冠軍", 0, 1.0);
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
