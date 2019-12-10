package roommateExpenses;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
	
	public static Roommate buddy1;
	public static Roommate buddy2;
	
	public Calculator(Roommate b1, Roommate b2) {
		this.buddy1 = b1;
		this.buddy2 = b2;
	}
	
	public static void getPay(Roommate pal1, Roommate pal2) {
		double diff, tot1 = 0, tot2 = 0;
		
		for(Expense e : pal1.getExps()) {
			tot1 += e.amount;
		}
		for(Expense e : pal2.getExps()) {
			tot2 += e.amount;
		}
		diff = tot1 - tot2;
		
		if (diff == 0) {
			System.out.println("Both roommates have paid the same amount.");
		} else if (diff > 0) {
			System.out.println(pal2.name + " owes " + pal1.name + " $" + String.format( "%.2f", diff/2));
		} else {
			System.out.println(pal1.name + " owes " + pal2.name + " $" + String.format( "%.2f", diff/-2));
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		String name1, name2;
		String type;
		double paid;
		
		int qty = 3;
		
		Expense exp;
		Expense[] exps1 = new Expense[qty];
		Expense[] exps2 = new Expense[qty];

		
		// First roommmate info
		System.out.println("Enter first roommate name:");
		name1 = userInput.next();
	
		System.out.println("Enter first roommate's expenses:");
		for(int i = 0; i < qty; i++) {
			type = "Groceries";
		    paid = userInput.nextDouble();
		    exp = new Expense(type, paid);
		    exps1[i] = exp;
		}
		Roommate friend1 = new Roommate(name1, exps1);
		
		// Second roommmate info
		System.out.println("Enter second roommate name:");
		name2 = userInput.next();

		System.out.println("Enter second roommate's expenses:");
		for(int i = 0; i < qty; i++) {
			type = "Electric";
		    paid = userInput.nextDouble();
		    exp = new Expense(type, paid);
		    exps2[i] = exp;
		}
		Roommate friend2 = new Roommate(name2, exps2);

		
		
		// Calculate Difference
		getPay(friend1, friend2);
		
		
	}
	
}