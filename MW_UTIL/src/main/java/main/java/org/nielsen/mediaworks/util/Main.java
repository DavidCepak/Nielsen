package main.java.org.nielsen.mediaworks.util;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Dimension size = new Dimension(800, 600);
	
	public Main() {
		add(new Graphics());
		
		setTitle("XML Parsanje");
		setPreferredSize(size);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		addMouseListener(new Listener());
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
