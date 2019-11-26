package roommateExpenses;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import roommateExpenses.Expenses;

public class Expenses implements ActionListener, KeyListener {
	
	public static Expenses bla;
	public JFrame jframe;
	public RenderPanel renderPanel;

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	public static final int FRAMESIZE = 750, SCALE = 10;
	public static final int XMAX = FRAMESIZE / SCALE;
	public static final int YMAX = (FRAMESIZE / SCALE) - 2;
	
	public int ticks;
	public Dimension dim;

	// Constructor:
	public Expenses() {

		jframe = new JFrame("Snake");
		jframe.setSize(FRAMESIZE, FRAMESIZE);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, 0);
		jframe.add(renderPanel = new RenderPanel());
		jframe.setResizable(false);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
	}

	// What to perform on every tick:
	@Override
	public void actionPerformed(ActionEvent args) {
		renderPanel.repaint();
		ticks++;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
//		if ((i == KeyEvent.VK_UP || i == KeyEvent.VK_W) && direction != DOWN) {	
//		if (i == KeyEvent.VK_SPACE) {
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
