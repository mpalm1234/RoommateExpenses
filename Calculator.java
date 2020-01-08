package roommateExpenses;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener{

	public JFrame frame = new JFrame("Roommate Expenses Calculator");
	public RenderPanel renderPanel = new RenderPanel();

	public Calculator() {
		frame.setSize(renderPanel.FRAMEX, renderPanel.FRAMEY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		renderPanel.getSubmit().addActionListener(this);
		frame.add(renderPanel);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double amount;
		String name1, name2;
		Expense[] exps1 = new Expense[renderPanel.MAXEXPS];
		Expense[] exps2 = new Expense[renderPanel.MAXEXPS];

		
		// Create Roommate #1
		name1 = renderPanel.getRmname1();
		for (int i = 0; i < renderPanel.MAXEXPS; i++) {
			amount = renderPanel.getRm1exp(i);
			exps1[i] = new Expense(" ", amount);	
		}
		Roommate friend1 = new Roommate(name1, exps1);

		// Create Roommate #2
		name2 = renderPanel.getRmname2();			
		for (int i = 0; i < renderPanel.MAXEXPS; i++) {
			amount = renderPanel.getRm2exp(i);
			exps2[i] = new Expense(" ", amount);	
		}
		Roommate friend2 = new Roommate(name2, exps2);

		// Calculate Difference
		renderPanel.setOwedStatement(getPay(friend1, friend2)); 
		System.out.println(renderPanel.owedStatement);
	}


	public String getPay(Roommate pal1, Roommate pal2) {
		double diff, tot1 = 0, tot2 = 0;

		for(Expense e : pal1.getExps()) {
			tot1 += e.amount;
		}
		for(Expense e : pal2.getExps()) {
			tot2 += e.amount;
		}
		diff = tot1 - tot2;

		if (diff == 0) {
			return "Both roommates have paid the same amount.";
		} else if (diff > 0) {
			return pal2.name + " owes " + pal1.name + " $" + String.format("%.2f", diff/2);
		} else {
			return pal1.name + " owes " + pal2.name + " $" + String.format("%.2f", diff/-2);
		}

	}

	public static void main(String[] args) {
		new Calculator();
	}




}