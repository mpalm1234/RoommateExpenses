package roommateExpenses;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Calculator extends JPanel implements ActionListener{

	public static final int LABELX = 150, FIELDX = 300, FRAMEY = 300;
	public static final int MAXEXPS = 6, MAXROWS = 9;

	public NumberFormat amountFormat = NumberFormat.getNumberInstance();

	public JTextField rmname1 = new JTextField(" ",15);
	public JTextField rmname2 = new JTextField(" ",15);
	public JFormattedTextField[] rm1exs = new JFormattedTextField[MAXEXPS];
	public JFormattedTextField[] rm2exs = new JFormattedTextField[MAXEXPS];

	public JButton submitBtn = new JButton("SUBMIT");
	public JTextField rtnFld  = new JTextField(" ",15);
	public String owedStatement = " ";


	public Calculator() {
		super(new BorderLayout());

		// Labels 
		JLabel title1 = new JLabel("Roommate #1");
		JLabel title2 = new JLabel("Roommate #2");

		JLabel blankLabel = new JLabel(" ");
		JLabel nameLabel = new JLabel("Name:");
		JLabel rentLabel = new JLabel("Rent:");
		JLabel waterLabel = new JLabel("Water:");
		JLabel electricLabel = new JLabel("Electric:");
		JLabel cableLabel = new JLabel("Cable:");
		JLabel groceriesLabel = new JLabel("Groceries:");
		JLabel otherLabel = new JLabel("Other:");

		// Expense Fields
		double amount = 0;
		for (int i = 0; i < MAXEXPS; i++) {
			rm1exs[i] = new JFormattedTextField(amountFormat);
			rm1exs[i].setValue(amount);

			rm2exs[i] = new JFormattedTextField(amountFormat);
			rm2exs[i].setValue(amount);
		}

		// Create Panels
		JPanel labelPane = new JPanel(new GridLayout(MAXROWS, 0));
		labelPane.setPreferredSize(new Dimension(LABELX, FRAMEY));
		labelPane.add(blankLabel);
		labelPane.add(nameLabel);
		labelPane.add(rentLabel);
		labelPane.add(waterLabel);
		labelPane.add(electricLabel);
		labelPane.add(cableLabel);
		labelPane.add(groceriesLabel);
		labelPane.add(otherLabel);

		JPanel rm1Pane = new JPanel(new GridLayout(MAXROWS, 0));
		rm1Pane.setPreferredSize(new Dimension(FIELDX, FRAMEY));
		rm1Pane.add(title1);
		rm1Pane.add(rmname1);
		for (int i = 0; i < MAXEXPS; i++) {
			rm1Pane.add(rm1exs[i]);
		}

		JPanel rm2Pane = new JPanel(new GridLayout(MAXROWS, 0));
		rm2Pane.setPreferredSize(new Dimension(FIELDX, FRAMEY));
		rm2Pane.add(title2);
		rm2Pane.add(rmname2);
		for (int i = 0; i < MAXEXPS; i++) {
			rm2Pane.add(rm2exs[i]);
		}

		JPanel rtnPane = new JPanel(new GridLayout(2, 0));
		submitBtn.addActionListener(this);
		rtnPane.add(submitBtn);
		rtnPane.add(rtnFld);

		// Layout
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add(labelPane, BorderLayout.WEST);
		this.add(rm1Pane, BorderLayout.CENTER);
		this.add(rm2Pane, BorderLayout.EAST);
		this.add(rtnPane, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double amount;
		String name1, name2;
		Expense[] exps1 = new Expense[MAXEXPS];
		Expense[] exps2 = new Expense[MAXEXPS];

		// Create Roommate #1
		name1 = this.getRmname1();
		for (int i = 0; i < MAXEXPS; i++) {
			amount = this.getRm1exp(i);
			exps1[i] = new Expense(" ", amount);	
		}
		Roommate friend1 = new Roommate(name1, exps1);

		// Create Roommate #2
		name2 = this.getRmname2();			
		for (int i = 0; i < MAXEXPS; i++) {
			amount = this.getRm2exp(i);
			exps2[i] = new Expense(" ", amount);	
		}
		Roommate friend2 = new Roommate(name2, exps2);

		// Calculate Difference
		this.setOwedStatement(getPay(friend1, friend2)); 
		rtnFld.setText(owedStatement);
	}


	public String getPay(Roommate pal1, Roommate pal2) {
		double diff, tot1 = 0, tot2 = 0;

		for(Expense e : pal1.getExps()) {
			tot1 += e.getAmount();
		}
		for(Expense e : pal2.getExps()) {
			tot2 += e.getAmount();
		}
		diff = tot1 - tot2;

		if (diff == 0) {
			return "Both roommates have paid the same amount.";
		} else if (diff > 0) {
			return pal2.getName() + " owes " + pal1.getName() + " $" + String.format("%.2f", diff/2);
		} else {
			return pal1.getName() + " owes " + pal2.getName() + " $" + String.format("%.2f", diff/-2);
		}

	}

	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("Roommate Expenses Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		//Add contents to the window.
		frame.add(new Calculator());

		//Display the window.
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		
		//Schedule a job for the event dispatch thread:
		//creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
	
	
	/// GETTERS AND SETTERS ///
	
	public String getRmname1() {
		return rmname1.getText();
	}

	public void setRmname1(JTextField rmname1) {
		this.rmname1 = rmname1;
	}

	public String getRmname2() {
		return rmname2.getText();
	}

	public void setRmname2(JTextField rmname2) {
		this.rmname2 = rmname2;
	}

	public double getRm1exp(int i) {
		return ((Number)rm1exs[i].getValue()).doubleValue();
	}
	
	public JFormattedTextField[] getRm1exs() {
		return rm1exs;
	}

	public void setRm1exs(JFormattedTextField[] rm1exs) {
		this.rm1exs = rm1exs;
	}
	
	public double getRm2exp(int i) {
		return ((Number)rm2exs[i].getValue()).doubleValue();
	}

	public JFormattedTextField[] getRm2exs() {
		return rm2exs;
	}

	public void setRm2exs(JFormattedTextField[] rm2exs) {
		this.rm2exs = rm2exs;
	}
	
	public JButton getSubmit() {
		return submitBtn;
	}
	
	public void setOwedStatement(String statement) {
		this.owedStatement = statement;
	}





}