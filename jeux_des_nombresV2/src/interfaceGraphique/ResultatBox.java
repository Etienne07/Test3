package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;


public class ResultatBox extends JFrame {
	 
	private String str = new String();
	
	public ResultatBox(String resultat) {
		str = resultat;
		build();
	}
	
	private void build() {
		setTitle("Résultats");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(true);
		setContentPane(buildContentPane());
		
	}
	
	private JPanel buildContentPane() {
		JPanel panneau = new JPanel();
		JLabel resultat = new JLabel(str);
		Font font = new Font("Arial", Font.BOLD, 16);
		
		resultat.setFont(font);
		panneau.setLayout(new FlowLayout());	
		panneau.add(resultat);
		return panneau;
	}
}