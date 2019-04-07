package interfaceGraphique;
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
    g.drawString("Problème 1 / rentrer le générateur : ", 10, 300);
    g.drawString("Problème 2 / rentrer le générateur :", 310, 300);
    g.drawString("Problème 2 / rentrer le nombre ", 310, 430);
    g.drawString("d'opérations :", 310, 450);
    g.drawString("Problème 3 / rentrer le nombre cible :", 610, 300);
    g.drawString("Problème 3 / rentrer les générateurs ", 610, 430);
    g.drawString("séparés par une virgule (ex : 1,4,5,19)", 610, 450);
   
  }        

}