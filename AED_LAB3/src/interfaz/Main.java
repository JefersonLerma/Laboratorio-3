package interfaz;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.io.IOException;

import javax.swing.JFrame;

import world.*;

public class Main extends JFrame{
	
	private DataBase world;
	
	private DataPanel dataPanel;
	private PanelButton panelButton;

	
	public Main() {
		// TODO Auto-generated constructor stub
		dataPanel = new DataPanel(this);
		panelButton = new PanelButton(this);
	
		setTitle("Players");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		world = new DataBase();
	    add(dataPanel, BorderLayout.CENTER);
	    add(panelButton, BorderLayout.SOUTH);
	    setSize(1100, 300);
	
	}
	
	
	public static void main(String [] args) {
		Main toAdd = new Main();
	}


	public void changeTam(int n) {
		
		dataPanel.setTam(n);
		
		dataPanel.updateUI();
		dataPanel.xd();
	}
	
	
	
	

}
