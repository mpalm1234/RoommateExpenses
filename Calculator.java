package roommateExpenses;

import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Scanner;


public class Calculator extends JPanel implements PropertyChangeListener{

	public RenderPanel renderPanel;
	public JFrame jframe;
	public Dimension dim;
	public NumberFormat amountFormat;

	public JTextField rmname1, rmname2;
	public JFormattedTextField rm1ex1, rm1ex2, rm1ex3, rm1ex4, rm1ex5;
	public JFormattedTextField rm2ex1, rm2ex2, rm2ex3, rm2ex4, rm2ex5;


	public static Calculator calc;
	Roommate friend1, friend2;

	Scanner userInput = new Scanner(System.in);

	public static final int QTY = 3;
	public static final int FRAMESIZE = 750;

	public Calculator() {

		super(new GridLayout());
		amountFormat = NumberFormat.getNumberInstance();
		displayFields();

		// Calculate Expenses
		//		this.friend1 = prompt(1);		// Get 1st roommate info
		//		this.friend2 = prompt(2);		// Get 2nd roommate info
		//		this.getPay(friend1, friend2);	// Calculate difference

	}

	public void displayFields() {
		
		// Name Fields
		rmname1 = new JTextField(" ",15);
		rmname1.addPropertyChangeListener("value", this);
		
		rmname2 = new JTextField(" ",15);
		rmname2.addPropertyChangeListener("value", this);
		
		// Expense Fields
		rm1ex1 = new JFormattedTextField(amountFormat);
		rm1ex1.setValue(0);
		rm1ex1.addPropertyChangeListener("value", this);
		
		rm1ex2 = new JFormattedTextField(amountFormat);
		rm1ex2.setValue(0);
		rm1ex2.addPropertyChangeListener("value", this);
		
		rm1ex3 = new JFormattedTextField(amountFormat);
		rm1ex3.setValue(0);
		rm1ex3.addPropertyChangeListener("value", this);
		
		rm1ex4 = new JFormattedTextField(amountFormat);
		rm1ex4.setValue(0);
		rm1ex4.addPropertyChangeListener("value", this);
		
		rm1ex5 = new JFormattedTextField(amountFormat);
		rm1ex5.setValue(0);
		rm1ex5.addPropertyChangeListener("value", this);
		
		rm2ex1 = new JFormattedTextField(amountFormat);
		rm2ex1.setValue(0);
		rm2ex1.addPropertyChangeListener("value", this);
		
		rm2ex2 = new JFormattedTextField(amountFormat);
		rm2ex2.setValue(0);
		rm2ex2.addPropertyChangeListener("value", this);
		
		rm2ex3 = new JFormattedTextField(amountFormat);
		rm2ex3.setValue(0);
		rm2ex3.addPropertyChangeListener("value", this);
		
		rm2ex4 = new JFormattedTextField(amountFormat);
		rm2ex4.setValue(0);
		rm2ex4.addPropertyChangeListener("value", this);
		
		rm2ex5 = new JFormattedTextField(amountFormat);
		rm2ex5.setValue(0);
		rm2ex5.addPropertyChangeListener("value", this);
		
		// Labels		
		JLabel title1 = new JLabel("Roommate #1");
		JLabel title2 = new JLabel("Roommate #2");
		JLabel nameLabel = new JLabel("Name: ");
		JLabel exLabel = new JLabel("Expenses: ");

		// Panel Layout
		JPanel labelPane = new JPanel(new GridLayout(2,1));
		labelPane.add(nameLabel);
		labelPane.add(exLabel);
		
		JPanel rm1Pane = new JPanel(new GridLayout(7,0));
		rm1Pane.add(title1);
		rm1Pane.add(rmname1);
		rm1Pane.add(rm1ex1);
		rm1Pane.add(rm1ex2);
		rm1Pane.add(rm1ex3);
		rm1Pane.add(rm1ex4);
		rm1Pane.add(rm1ex5);
		
		JPanel rm2Pane = new JPanel(new GridLayout(7,0));
		rm2Pane.add(title2);
		rm2Pane.add(rmname2);
		rm2Pane.add(rm2ex1);
		rm2Pane.add(rm2ex2);
		rm2Pane.add(rm2ex3);
		rm2Pane.add(rm2ex4);
		rm2Pane.add(rm2ex5);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(labelPane, BorderLayout.WEST);
		add(rm1Pane, BorderLayout.CENTER);
		add(rm2Pane, BorderLayout.EAST);

	}

	public Roommate prompt(int count) {
		String name, type;
		double paid;
		Expense[] exps = new Expense[QTY];

		System.out.println(count + ": Enter roommate name:");
		name = userInput.next();

//		System.out.println("Enter roommate's expenses:");
//		for(int i = 0; i < QTY; i++) {
//			type = "Electric";
//			paid = userInput.nextDouble();
//			exps[i] = new Expense(type, paid);
//		}
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Roommate Expenses Calculator");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Calculator());
		frame.pack();
		frame.setVisible(true);
    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {  
				createAndShowGUI();
			}
		});
	}



}