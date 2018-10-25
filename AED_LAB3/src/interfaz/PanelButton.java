package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelButton extends JPanel implements ActionListener{
	
	public final static String SEARCH = "s";
	public final static String DELETE = "d";
	public final static String ADD = "a";
	public final static String LOAD = "l";
	
	
	private JButton buscar;
	private JButton eliminar;
	private JButton agregar;
	private JButton cargar;
	private Main main;
    private JTextField txtPorEncimaDe;
    private JTextField txtPorDebajoDe;
    private JLabel lbPorEncimaDe;
    private JLabel lbPorDebajoDe;
    private JLabel porciento;
    private JLabel porciento1;
    private JPanel panelAux1;
    private JPanel panelAux2;
    private JPanel panelAux3;
    private JCheckBox opc1;
    private JCheckBox opc2;
    private JCheckBox opc3;
    private JCheckBox opc4;
    
    
    
	public PanelButton(Main pMain) {
		// TODO Auto-generated constructor stub
		main = pMain;
		setBorder(new TitledBorder("Opciones"));
		setLayout(new BorderLayout());
		buscar = new JButton("Buscar");
		buscar.addActionListener(this);
		buscar.setActionCommand(SEARCH);
		
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		eliminar.setActionCommand(DELETE);
		
		agregar = new JButton("Buscar");
		agregar.addActionListener(this);
		agregar.setActionCommand(SEARCH);
		
		cargar = new JButton("Cargar Archivo");
		cargar.addActionListener(this);
		cargar.setActionCommand(LOAD);
		
		opc1 = new JCheckBox("TS%");
		opc2 = new JCheckBox("ORB%");
		opc3 = new JCheckBox("DRB%");
		opc4 = new JCheckBox("AST%");
		
		
		lbPorDebajoDe = new JLabel("Buscar por debajo de: ");
		lbPorEncimaDe = new JLabel("Buscar por encima de: ");
		porciento = new JLabel("%");
		porciento1 = new JLabel("%");
		
		txtPorDebajoDe = new JTextField();
		txtPorEncimaDe = new JTextField();
		
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();
		panelAux3 = new JPanel();
		
		panelAux1.setBorder(new TitledBorder("1"));
		panelAux1.setLayout(new GridLayout(1, 4));
		panelAux1.add(cargar);
		panelAux1.add(eliminar);
		panelAux1.add(agregar);
		add(panelAux1, BorderLayout.NORTH);
		
		panelAux2.setLayout(new GridLayout(1, 4));
		panelAux2.setBorder(new TitledBorder(""));
		panelAux2.add(buscar);
		panelAux2.add(opc1);
		panelAux2.add(opc2);
		panelAux2.add(opc3);
		panelAux2.add(opc4);
		panelAux2.setPreferredSize(new Dimension(200, 30));
		add(panelAux2, BorderLayout.CENTER);
	
		panelAux3.setBorder(new TitledBorder(""));
		panelAux3.setLayout(new GridLayout(1, 6));
		panelAux3.add(lbPorEncimaDe);
		panelAux3.add(txtPorEncimaDe);
		panelAux3.add(porciento);
		panelAux3.add(lbPorDebajoDe);
		panelAux3.add(txtPorDebajoDe);
		panelAux3.add(porciento1);
		panelAux3.setPreferredSize(new Dimension(200, 30));
		add(panelAux3, BorderLayout.SOUTH);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		
		if(event.equals(SEARCH)) {
			
			main.changeTam(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese n")));
		
			
		}
	}

}
