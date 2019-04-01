package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import jeux_des_nombresV2.mainClasseV2;
import java.awt.Graphics;


public class ResultatBox extends JFrame {
	 
	private String str = new String();
	
	public ResultatBox(String resultat) {
		str = resultat;
		build();
	}
	
//	private panneauResultat fenetre = new panneauResultat(str);
	private JPanel panneau = new JPanel();
	private JLabel resultat = new JLabel(str);
	
	private void build() {
		setTitle("Résultats");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(true);
		
//		FlowLayout ctr = new FlowLayout(FlowLayout.CENTER);
//		panneau.setLayout(ctr);
		panneau.add(resultat);
		
		setContentPane(panneau);
		panneau.setLayout(null);

		
//		setContentPane(fenetre);
//		fenetre.setLayout(null);
		
	}
}