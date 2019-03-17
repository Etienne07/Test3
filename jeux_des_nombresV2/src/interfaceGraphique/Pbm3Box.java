package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;


 public class Pbm3Box extends JFrame {
	 
	private panneau3 fenetre = new panneau3();
	private JTextField texteNbGen = new JTextField();
	private JTextField texteNbGen2 = new JTextField();
	
	public Pbm3Box() {
		super();
		build();
	}
	
	private void build() 
	{
		setTitle("Jeux de Nombres - Problème 2");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(fenetre);
		fenetre.setLayout(null);
		texteNbGen.setColumns(10);
		texteNbGen.setSize(30, 15);
		texteNbGen.setBounds(300, 210, 150, 50);
		add(texteNbGen);
		texteNbGen2.setColumns(10);
		texteNbGen2.setSize(30, 15);
		texteNbGen2.setBounds(300, 320, 150, 50);
		add(texteNbGen2);
		
	}
	
	
	
 }