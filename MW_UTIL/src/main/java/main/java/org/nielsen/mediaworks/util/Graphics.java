package main.java.org.nielsen.mediaworks.util;

import java.awt.*;
import javax.swing.*;

public class Graphics extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private Dimension okno = new Dimension(100, 50);
	public static Rectangle[] buttons = new Rectangle[5];

	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		fileChooser(g);
		
		System.out.println(Listener.mouse);
		
		repaint();
	}
	
	public void fileChooser(java.awt.Graphics g) {
		g.drawRect(Main.size.width / 2 - okno.width / 2, Main.size.height * 3 / 4 - okno.height / 2, okno.width, okno.height);
		buttons[0] = new Rectangle(Main.size.width / 2 - okno.width / 2, Main.size.height * 3 / 4 - okno.height / 2, okno.width, okno.height);
	}
	
	
}
