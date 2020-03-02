package main.java.org.nielsen.mediaworks.util;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Dimension size = new Dimension(800, 600);
	public static Dimension realSize;
	
	public Main() {
		add(new Grafika());
		
		setTitle("XML Parsanje");
		setPreferredSize(size);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		realSize = getContentPane().getSize();
		setPreferredSize(realSize);
		pack();
		//listenerji
		getContentPane().addMouseListener(new Listener());
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
