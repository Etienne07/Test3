package interfaceGraphique;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

 public class mainBox extends JFrame {
	 
	private panneau fenetre = new panneau();
	private JButton pbm1 = new JButton();
	
	
	
	public mainBox() {
		super();
		build();
	}
	
	private void build() 
	{
		setTitle("Jeux de Nombres");
		setSize(920,650);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(fenetre);
		getContentPane().add(pbm1);
		
	}
	
 }