package interfaceGraphique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class panneau2 extends JPanel {

  public void paintComponent(Graphics g){
	  
	Font font = new Font("Arial", Font.BOLD, 22);
	g.setFont(font);
    g.drawString("Probl�me 2", 320, 40);
	Font font2 = new Font("Arial", Font.BOLD, 16);
	g.setFont(font2);
    g.drawString("� partir d'un nombre g�n�rateur, trouver tous les entiers naturels inf�rieurs avec des op�rations �l�mentaires",10,122);
    g.drawString("simples sur le g�n�rateur (avec un nombre fixe d'op�rations)", 10, 142); 
    g.drawString("Entrez un g�n�rateur (entier positif) :", 10, 182); 
    g.drawString("Entrez un nombre d'op�rations (entier positif) :", 10, 292); 
    
  }        

}