package interfaceGraphique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneau extends JPanel {

  public void paintComponent(Graphics g){
	Font font = new Font("Arial", Font.BOLD, 22);
	g.setFont(font);
    g.drawString("Choisissez un probl�me", 320, 40);
	Font font2 = new Font("Arial", Font.BOLD, 16);
	g.setFont(font2);
    g.drawString("Probl�me 1 : � partir d'un nombre g�n�rateur, trouver tous les entiers naturels inf�rieurs avec des op�rations",10,100);
    g.drawString("�l�mentaires simples sur le g�n�rateur (minimum d'op�rations)", 10, 122);
    g.drawString("Probl�me 2 : � partir d'un nombre g�n�rateur, trouver tous les entiers naturels inf�rieurs avec des op�rations",10,162);
    g.drawString("�l�mentaires simples sur le g�n�rateur (avec un nombre fixe d'op�rations)", 10, 182);
    g.drawString("Probl�me 3 : � partir de plusieurs g�n�rateurs, trouver un nombre cible avec un minimum d'op�rations �l�mentaires",10,222);
    g.drawString("et en utilisant une seule fois chaque op�rateur", 10, 242);
    
   
  }        

}