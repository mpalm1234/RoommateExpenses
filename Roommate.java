package roommateExpenses;

public class Roommate {
	
	String name;
	Expense[] exps;
	
	// Constructor:
	public Roommate(String n, Expense[] es) {
		this.name = n;
		this.exps = es;	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expense[] getExps() {
		return exps;
	}

	public void setExps(Expense[] exps) {
		this.exps = exps;
	}

}
