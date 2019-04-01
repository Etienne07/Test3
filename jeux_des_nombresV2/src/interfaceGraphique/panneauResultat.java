package interfaceGraphique;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneauResultat extends JPanel {
	
	private String str = new String();
	
	public panneauResultat(String resultat, Graphics g) {
		str = resultat;
		Font font = new Font("Arial", Font.BOLD, 22);
		g.setFont(font);
	    g.drawString("Problème 1", 320, 40);
		Font font2 = new Font("Arial", Font.BOLD, 16);
		g.setFont(font2);
	    g.drawString(str, 100, 100); 
		
	}      

}