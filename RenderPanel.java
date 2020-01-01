package roommateExpenses;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		Calculator calc = Calculator.calc;

		//Background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Calculator.FRAMESIZE, Calculator.FRAMESIZE);

	}
}


