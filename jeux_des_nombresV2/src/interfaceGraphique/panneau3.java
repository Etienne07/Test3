package interfaceGraphique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneau3 extends JPanel {

  public void paintComponent(Graphics g){
	Font font = new Font("Arial", Font.BOLD, 22);
	g.setFont(font);
    g.drawString("Problème 3", 320, 40);
	Font font2 = new Font("Arial", Font.BOLD, 16);
	g.setFont(font2);
    g.drawString("À partir de plusieurs générateurs, trouver un nombre cible avec un minimum d'opérations élémentaires et en utilisant",10,122);
    g.drawString("une seule fois chaque opérateur", 10, 142);
    
  }        

}