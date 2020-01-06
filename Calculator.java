package roommateExpenses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculator implements ActionListener, KeyListener{

	public JFrame frame = new JFrame("Roommate Expenses Calculator");
	public RenderPanel renderPanel = new RenderPanel();
	
	public Calculator() {
		frame.add(renderPanel);
		frame.setSize(renderPanel.FRAMEX, renderPanel.FRAMEY);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		renderPanel.repaint();
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		String name;
		double amount;
		Expense[] exps;

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			// Create Roommate #1
			exps = null;
			name = renderPanel.rmname1.getText();
			for (int i = 0; i < renderPanel.MAXEXPS; i++) {
				amount = (double) renderPanel.rm1exs[i].getValue();
				exps[i] = new Expense(" ", amount);	
			}
			Roommate friend1 = new Roommate(name, exps);

			// Create Roommate #2
			exps = null;
			name = renderPanel.rmname2.getText();
			for (int i = 0; i < renderPanel.MAXEXPS; i++) {
				amount = (double) renderPanel.rm2exs[i].getValue();
				exps[i] = new Expense(" ", amount);	
			}
			Roommate friend2 = new Roommate(name, exps);

			// Calculate Difference
			renderPanel.owedStatement = getPay(friend1, friend2); 

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

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