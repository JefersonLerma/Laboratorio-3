package interfaz;

import java.awt.BorderLayout;
import java.io.IOException;

import wolrd.*;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private DataBase world;
	public Main() {
		// TODO Auto-generated constructor stub
		setTitle("Players");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		world = new DataBase();
		try {
			world.fileUpload();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String [] args) {
		Main toAdd = new Main();
	}
	

}
