package roommateExpenses;

public class Expense {
	
	String title;
	double amount;
	
	// Constructor:
	public Expense(String t, double a) {
		this.title = t;
		this.amount = a;	
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
