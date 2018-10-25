package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class DataPanel extends JPanel{
	
	public final static int COLUMNS = 8;
	private JTextField[] dataPlayers;
	private Main main;
	private JPanel panelAux1;
	private JPanel panelAux2;
	private int tam;
    private JTextArea area;
    private JScrollPane scroll;
	
	public DataPanel(Main pMain) {
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
	
	   
		main = pMain;
		tam = 2;
		dataPlayers = new JTextField[COLUMNS];
		setBorder(new TitledBorder("Información Jugadores"));
		setLayout(new BorderLayout());
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();
		panelAux1.setLayout(new GridLayout(1, COLUMNS));
		panelAux2.setLayout(new GridLayout(1, COLUMNS));
		 JLabel fact0 = new JLabel("Nombre");
		 JLabel fact1 = new JLabel("Edad");
		 JLabel fact2 = new JLabel("Equipo");
		 JLabel fact3 = new JLabel("(TS%) ");
		 JLabel fact4 = new JLabel("(ORB%)  ");
		 JLabel fact5 = new JLabel("(DRB%) ");
		 JLabel fact6 = new JLabel("(TRB%)");
		 JLabel fact7 = new JLabel("(AST%) ");
		 panelAux1.add(fact0);
		 panelAux1.add(fact1);
		 panelAux1.add(fact2);
		 panelAux1.add(fact3);
		 panelAux1.add(fact4);
		 panelAux1.add(fact5);
		 panelAux1.add(fact6);
		 panelAux1.add(fact7);
		 panelAux2.add(scroll);
	  
		 
		 add(panelAux1, BorderLayout.NORTH);
		 add(panelAux2, BorderLayout.CENTER);
		
	}

	public void xd () {
		 for(int i = 0; i<dataPlayers.length; i++) {
			 JTextField txt = new JTextField("");
			 txt.setEditable(false);
			 dataPlayers[i] = txt;
			 panelAux2.add(dataPlayers[i]);
		 }
	}
	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	

}
