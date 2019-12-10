package roommateExpenses;

import java.util.Scanner;

public class Calculator {
	
	public static Calculator calc;
	public final int QTY = 3;
	Roommate friend1, friend2;
	
	Scanner userInput = new Scanner(System.in);
	
	public Calculator() {
		
		// First roommate info
		this.friend1 = prompt(1);
		
		// Second roommmate info
		this.friend2 = prompt(2);
		
		// Calculate Difference
		this.getPay(friend1, friend2);
			
	}
	
	public Roommate prompt(int count) {
		String name, type;
		double paid;
		Expense[] exps = new Expense[QTY];
		
		System.out.println(count + ": Enter roommate name:");
		name = userInput.next();

		System.out.println("Enter roommate's expenses:");
		for(int i = 0; i < QTY; i++) {
			type = "Electric";
		    paid = userInput.nextDouble();
		    exps[i] = new Expense(type, paid);
		}
		return new Roommate(name, exps);
	}
	
	public void getPay(Roommate pal1, Roommate pal2) {
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
		
		calc = new Calculator();
		
	}
	
}