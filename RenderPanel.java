package roommateExpenses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

	public static final int FRAMEX = 750, FRAMEY = 300, LABELX = 150, FIELDX = 300;
	public static final int MAXEXPS = 6, MAXROWS = 9;
	
	public NumberFormat amountFormat = NumberFormat.getNumberInstance();

	public JTextField rmname1 = new JTextField(" ",15);
	public JTextField rmname2 = new JTextField(" ",15);
	public JFormattedTextField[] rm1exs = new JFormattedTextField[6];
	public JFormattedTextField[] rm2exs = new JFormattedTextField[6];
	public JTextField rtnFld  = new JTextField(" ",15);
	public String owedStatement = " ";

	public RenderPanel() {
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

		// Panel Layout
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

		JPanel rtnPane = new JPanel(new GridLayout(1, 0));
		rtnPane.add(rtnFld);

		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add(labelPane, BorderLayout.WEST);
		this.add(rm1Pane, BorderLayout.CENTER);
		this.add(rm2Pane, BorderLayout.EAST);
		this.add(rtnPane, BorderLayout.SOUTH);
	}

	public JTextField getRmname1() {
		return rmname1;
	}

	public void setRmname1(JTextField rmname1) {
		this.rmname1 = rmname1;
	}

	public JTextField getRmname2() {
		return rmname2;
	}

	public void setRmname2(JTextField rmname2) {
		this.rmname2 = rmname2;
	}

	public JFormattedTextField[] getRm1exs() {
		return rm1exs;
	}

	public void setRm1exs(JFormattedTextField[] rm1exs) {
		this.rm1exs = rm1exs;
	}

	public JFormattedTextField[] getRm2exs() {
		return rm2exs;
	}

	public void setRm2exs(JFormattedTextField[] rm2exs) {
		this.rm2exs = rm2exs;
	}

	public JTextField getRtnFld() {
		return rtnFld;
	}

	public void setRtnFld(JTextField rtnFld) {
		this.rtnFld = rtnFld;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Background
//		g.setColor(Color.DARK_GRAY);
//		g.fillRect(0, 0, FRAMEX, FRAMEY);

	}




}


