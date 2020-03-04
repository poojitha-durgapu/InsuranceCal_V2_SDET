package javaPractice;

public class StaticKeywrd {

	static String BankName;
	static String ReportName;
	String customerName;
	int AcntNum;
	int AccBal;
	
	public void generateReport() {
		System.out.println(BankName);
		System.out.println(ReportName);
		System.out.println(customerName);
		System.out.println(AcntNum);
		System.out.println(AccBal);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticKeywrd k1 = new StaticKeywrd();
		StaticKeywrd.BankName="ABC bank";
		StaticKeywrd.ReportName="LOC report";
		k1.customerName="Robert";
		k1.AcntNum=111;
		k1.AccBal=100;
		
		
		StaticKeywrd k2 = new StaticKeywrd();
		StaticKeywrd.BankName="XYZ bank";
		StaticKeywrd.ReportName="LOVJHGFK report";
		k2.customerName="poojitha";
		k2.AcntNum=222;
		k2.AccBal=200;
		
		k1.generateReport();
		k2.generateReport();
	}
	

}
