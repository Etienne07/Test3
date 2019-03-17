package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;


 public class Pbm2Box extends JFrame {
	 
	private panneau2 fenetre = new panneau2();
	
	public Pbm2Box() {
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
		
	}
	
	
	
 }