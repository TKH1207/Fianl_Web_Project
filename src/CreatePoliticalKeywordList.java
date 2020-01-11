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
		Keyword k4 = new Keyword("選舉", 0, 3.0);
		Keyword k5 = new Keyword("市長", 0, 1.0);
		Keyword k6 = new Keyword("黨", 0, 1.0);
		Keyword k7 = new Keyword("議員", 0, 1.0);
		Keyword k8 = new Keyword("立法", 0, 1.0);
		Keyword k9 = new Keyword("彈劾", 0, 1.0);
		Keyword k10 = new Keyword("大選", 0, 1.0);
		Keyword k11 = new Keyword("國民黨", 0, 2.0);
		Keyword k12 = new Keyword("民進黨", 0, 2.0);
		Keyword k13 = new Keyword("韓國瑜", 0, 3.0);
		Keyword k14 = new Keyword("蔡英文", 0, 3.0);
		Keyword k15 = new Keyword("宋楚瑜", 0, 3.0);
		Keyword k16 = new Keyword("柯文哲", 0, 3.0);
		Keyword k17 = new Keyword("綠營", 0, 3.0);
		Keyword k18 = new Keyword("藍營", 0, 3.0);
		Keyword k19 = new Keyword("投票", 0, 1.0);
		Keyword k20 = new Keyword("委員", 0, 1.0);
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
		kLst.add(k11);
		kLst.add(k12);
		kLst.add(k13);
		kLst.add(k14);
		kLst.add(k15);
		kLst.add(k16);
		kLst.add(k17);
		kLst.add(k18);
		kLst.add(k19);
		kLst.add(k20);
		return kLst;
	}

}
