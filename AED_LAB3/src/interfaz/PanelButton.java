package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelButton extends JPanel implements ActionListener{
	
	public final static String PRUEBA = "p";
	private JButton prueba;
	private Main main;
	
	public PanelButton(Main pMain) {
		// TODO Auto-generated constructor stub
		main = pMain;
		prueba = new JButton("Prueba");
		setBorder(new TitledBorder("Opciones"));
		prueba.addActionListener(this);
		prueba.setActionCommand(PRUEBA);
		add(prueba);
		
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		
		if(event.equals(PRUEBA)) {
			
			main.changeTam(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese n")));
		
			
		}
	}

}
