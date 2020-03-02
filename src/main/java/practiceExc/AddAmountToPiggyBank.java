package practiceExc;

public class AddAmountToPiggyBank {
	
	int Amount = 50;
	int FinalAmount;

	public AddAmountToPiggyBank() {
		FinalAmount = Amount + 0;
		System.out.println("Final Amount is "+ FinalAmount);
	}
	public AddAmountToPiggyBank(int amt) {
		FinalAmount = Amount + amt;
		System.out.println("Final Amount is "+ FinalAmount);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddAmountToPiggyBank obj = new AddAmountToPiggyBank();
		AddAmountToPiggyBank obj1 = new AddAmountToPiggyBank(45);
	}

}
