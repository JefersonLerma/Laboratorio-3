package interfaz;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.io.IOException;

import wolrd.*;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private DataBase world;
	private int quantity;
	private DataPanel dataPanel;
	private ScrollPane scroll;
	
	public Main() {
		// TODO Auto-generated constructor stub
		dataPanel = new DataPanel(this);
		quantity = 2;
		setTitle("Players");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		world = new DataBase();
		scroll = new ScrollPane();
		scroll.add(dataPanel);
		add(scroll, BorderLayout.CENTER);
	//   add(dataPanel, BorderLayout.SOUTH);
	   setSize(1100, 200);
	
	}
	
	
	public static void main(String [] args) {
		Main toAdd = new Main();
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
