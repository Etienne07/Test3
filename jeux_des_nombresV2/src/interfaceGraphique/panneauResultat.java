package interfaceGraphique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneauResultat {

	public panneauResultat(String resultat) {
		public JPanel pan = new JPanel();
		
		
		
	}

  public void paintComponent(Graphics g, String resultat){
	Font font = new Font("Arial", Font.BOLD, 13);
	g.setFont(font);
    g.drawString(resultat, 100, 100);
    
  }        

}