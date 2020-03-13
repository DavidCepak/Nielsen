package main.java.org.nielsen.mediaworks.util;

import java.awt.*;
import javax.swing.*;

public class Grafika extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private Dimension okno = new Dimension(100, 40);
	private Rectangle[] btn = new Rectangle[5];
	public boolean[] btnPressed = new boolean[btn.length];

	public void paintComponent(Graphics g) {
		
		repaint();
	}
	
	
}
