package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;
import javax.swing.JTextField;


 public class ResultatBox extends JFrame {
	 String resultat ;
	private panneauResultat fenetre = new panneauResultat(resultat);

	public ResultatBox() {
		super();
		build();
	}
	
	private void build() 
	{
		setTitle("Résultats");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(true);
		setContentPane(fenetre);
		fenetre.setLayout(null);
	
	}
	
	
	
 }