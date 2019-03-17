package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;


 public class Pbm1Box extends JFrame {
	 
	private panneau1 fenetre = new panneau1();
	private JTextField texteNbGen = new JTextField();
	
	public Pbm1Box() {
		super();
		build();
	}
	
	private void build() 
	{
		setTitle("Jeux de Nombres - Problème 1");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(fenetre);
		fenetre.setLayout(null);
		texteNbGen.setColumns(10);
		texteNbGen.setSize(30, 15);
		texteNbGen.setBounds(300, 210, 150, 50);
		add(texteNbGen);
		
	}
	
	
	
 }