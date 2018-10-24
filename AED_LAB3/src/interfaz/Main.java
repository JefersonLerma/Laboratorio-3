package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	
	public Main() {
		// TODO Auto-generated constructor stub
		setTitle("Players");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
	}
	
	
	public static void main(String [] args) {
		Main toAdd = new Main();
	}
	

}
