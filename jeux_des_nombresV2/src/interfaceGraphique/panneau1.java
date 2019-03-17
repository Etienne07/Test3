package interfaceGraphique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneau1 extends JPanel {

  public void paintComponent(Graphics g){
	Font font = new Font("Arial", Font.BOLD, 22);
	g.setFont(font);
    g.drawString("Problème 1", 320, 40);
	Font font2 = new Font("Arial", Font.BOLD, 16);
	g.setFont(font2);
    g.drawString("À partir d'un nombre générateur, trouver tous les entiers naturels inférieurs avec des opérations élémentaires",10,122);
    g.drawString("simples sur le générateur (avec un minimum d'opérations)", 10, 142);
    g.drawString("Entrez un générateur (entier positif) :", 10, 182); 
    
  }        

}