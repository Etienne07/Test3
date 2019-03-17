package interfaceGraphique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneau extends JPanel {

  public void paintComponent(Graphics g){
	Font font = new Font("Arial", Font.BOLD, 22);
	g.setFont(font);
    g.drawString("Choisissez un problème", 320, 40);
	Font font2 = new Font("Arial", Font.BOLD, 16);
	g.setFont(font2);
    g.drawString("Problème 1 : à partir d'un nombre générateur, trouver tous les entiers naturels inférieurs avec des opérations",10,100);
    g.drawString("élémentaires simples sur le générateur (minimum d'opérations)", 10, 122);
    g.drawString("Problème 2 : à partir d'un nombre générateur, trouver tous les entiers naturels inférieurs avec des opérations",10,162);
    g.drawString("élémentaires simples sur le générateur (avec un nombre fixe d'opérations)", 10, 182);
    g.drawString("Problème 3 : à partir de plusieurs générateurs, trouver un nombre cible avec un minimum d'opérations élémentaires",10,222);
    g.drawString("et en utilisant une seule fois chaque opérateur", 10, 242);
    
   
  }        

}