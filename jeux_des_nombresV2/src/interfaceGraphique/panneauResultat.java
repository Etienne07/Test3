package interfaceGraphique;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneauResultat extends JPanel {
	
	private String[] str;
	private String[] transition;
	private String st = new String();
	private int i;
	private int j;
	private int l;
			
	public void panneauResultat(String[] resultats) {
		str = resultats;
		i = 0;
	}

  public void paintComponent(Graphics g){

	l = str.length;
	j = 0;
	Font font2 = new Font("Arial", Font.BOLD, 16);
	g.setFont(font2);
	
	
	
	while(j < l) {
		st = str[j];
		g.drawString(st, 10, i);
		i = i + 20;
		j++;
	}
   
  }        

}