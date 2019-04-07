package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;


public class ResultatBox extends JFrame {
	 
	private String[] str;
	
	
	public ResultatBox(String[] resultat) {
		str = resultat;
		build();
	}
	
	private void build() {
		setTitle("Résultats");
		setSize(920,950);
		setLocationRelativeTo(null);
		setResizable(true);
		setContentPane(buildContentPane());
		
	}
	
	private JPanel buildContentPane() {
		panneauResultat panneauR = new panneauResultat();
		panneauR.panneauResultat(str);
		
		panneauR.setLayout(new FlowLayout());	
		return panneauR;
	}
	
}