package interfaz;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	    setSize(1100, 500);
	
	}
	
	
	public static void main(String [] args) {
		Main toAdd = new Main();
	}


	public void changeTam(int n) {
		
		dataPanel.setTam(n);
		
		dataPanel.updateUI();
		dataPanel.xd();
	}
	
	public void loadFile() {
		try {
			JOptionPane.showMessageDialog(null, "Espera entre 30 y 45 segundos, mientras se carga el volumen de los datos \n se desplegara un mensaje cuando estos esten listos. Por defecto Se cargaran 42000 archivos en 3 arboles.");
			world.fileUpload();
			JOptionPane.showMessageDialog(null, "!Se cargo satisfactoriamente¡");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "!No se enconto el Archivo¡");
		}
	}
	
	public String SearchForTS(double n, int p) {
		String x = "";
		
		return x;
	}
	
	public boolean isLoad() {
		return world.isLoad();
	}

}
