package main.java.org.nielsen.mediaworks.util;

import java.awt.*;
import java.awt.event.*;

public class Listener implements MouseListener {

	public static Point mouse = new Point(0, 0);
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent e) {
		mouse.setLocation(e.getX(), e.getY());
	}

	
	public void mouseReleased(MouseEvent e) {
		mouse = new Point(0, 0);
	}

}
