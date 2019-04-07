package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;
import java.util.List;
import java.util.ArrayList;


 public class mainBox {

	 private static String[] liste;
	 private static String indicateur = new String("NA");
	 private String output;
	 
	public static void main(String[] args) throws InterruptedException {
		System.out.println(liste);
		System.out.println("entree"+indicateur);
		pan panneau = new mainBox().new pan();	
		panneau.build();
		panneau.setVisible(true);
		
		while(indicateur == "NA") {
			Thread.sleep(1000);
		}
		
		System.out.println("sortie"+indicateur);
		
		indicateur = "NA";

		jeux_des_nombresV2.mainEngine moteur = new jeux_des_nombresV2.mainEngine(liste);
		
		ResultatBox pan_resultat = new ResultatBox(moteur);
		pan_resultat.setVisible(true);
		

		
			
		}
		
		
	
	
	class pan extends JFrame implements ActionListener{

		private panneau fenetre = new panneau();
		private JButton pbm1 = new JButton("OK");
		private JButton pbm2 = new JButton("OK");
		private JButton pbm3 = new JButton("OK");
		private JTextField textePbm1 = new JTextField();
		private JTextField texte1Pbm2 = new JTextField();
		private JTextField texte2Pbm2 = new JTextField();
		private JTextField texte1Pbm3 = new JTextField();
		private JTextField texte2Pbm3 = new JTextField();
		
		private void build() {
			this.setTitle("Jeux de Nombres");	
			setTitle("Jeux de Nombres");
			setSize(920,750);
			setLocationRelativeTo(null);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setContentPane(fenetre);
			
			fenetre.setLayout(null);
			getContentPane().add(pbm1);
			getContentPane().add(pbm2);
			getContentPane().add(pbm3);
			pbm1.setBounds(80, 450, 150, 50);
			pbm2.setBounds(350, 550, 150, 50); 
			pbm3.setBounds(680, 550, 150, 50);
			pbm1.addActionListener(this);
			pbm2.addActionListener(this);
			pbm3.addActionListener(this);
			textePbm1.setColumns(10);
			textePbm1.setSize(30, 15);
			textePbm1.setBounds(80, 350, 150, 50);
			add(textePbm1);
			texte1Pbm2.setColumns(10);
			texte1Pbm2.setSize(30, 15);
			texte1Pbm2.setBounds(350, 350, 150, 50);
			add(texte1Pbm2);
			texte2Pbm2.setColumns(10);
			texte2Pbm2.setSize(30, 15);
			texte2Pbm2.setBounds(350, 475, 150, 50);
			add(texte2Pbm2);
			texte1Pbm3.setColumns(10);
			texte1Pbm3.setSize(30, 15);
			texte1Pbm3.setBounds(680, 350, 150, 50);
			add(texte1Pbm3);
			texte2Pbm3.setColumns(10);
			texte2Pbm3.setSize(30, 15);
			texte2Pbm3.setBounds(680, 475, 150, 50);
			add(texte2Pbm3);

		}
	
		public synchronized void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if(source == pbm1) {	
				System.out.println(textePbm1.getText());
				indicateur = "OK";
				liste = new String[2];
				liste[1] = (textePbm1.getText());
				liste[0] = "1";
				}		
			
			else if(source == pbm2) {
				indicateur = "OK";
				liste = new String[3];
				liste[1] = (texte1Pbm2.getText());
				liste[2] = (texte2Pbm2.getText());
				liste[0] = "2";
			}
				
			else if(source == pbm3) {
				indicateur = "OK";
				liste = new String[3];
				liste[1] = (texte1Pbm3.getText());
				liste[2] = (texte2Pbm3.getText());
				liste[0] = "3";
			}
			}	
		
	}
 }
 
