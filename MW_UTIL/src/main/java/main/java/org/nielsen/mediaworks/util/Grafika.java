package main.java.org.nielsen.mediaworks.util;

import java.awt.*;
import javax.swing.*;

public class Grafika extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private Dimension okno = new Dimension(100, 40);
	private Rectangle[] btn = new Rectangle[5];
	public boolean[] btnPressed = new boolean[btn.length];

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, Main.realSize.width, Main.realSize.height);
		
		gumb(g);
		
		repaint();
	}
	
	public void gumb(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(Main.realSize.width / 2 - okno.width / 2, Main.realSize.height * 3 / 4 - okno.height / 2, okno.width, okno.height);
		btn[0] = new Rectangle(Main.realSize.width / 2 - okno.width / 2, Main.realSize.height * 3 / 4 - okno.height / 2, okno.width, okno.height);
		if(btn[0].contains(Listener.mouse)) {
			btnPressed[0] = true;
			XMLParsing.povleciDatoteko(btnPressed[0]);
			
			g.setColor(new Color(0, 0, 0, 50));
			g.fillRect(Main.realSize.width / 2 - okno.width / 2, Main.realSize.height * 3 / 4 - okno.height / 2, okno.width, okno.height);
		} else {
			btnPressed[0] = false;
			XMLParsing.enKlik = false;
		}
		
		g.setColor(Color.BLACK);
		g.drawString("Povleci datoteko", Main.realSize.width / 2 - okno.width / 2 + 5, Main.realSize.height * 3 / 4 + 5);
		
	}
	
	
}
