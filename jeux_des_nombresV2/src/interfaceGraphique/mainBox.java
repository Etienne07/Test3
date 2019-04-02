package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;
import java.lang.Thread;


 public class mainBox extends JFrame implements ActionListener {

	private panneau fenetre = new panneau();
	private JButton pbm1 = new JButton("Problème 1");
	private JButton pbm2 = new JButton("Problème 2");
	private JButton pbm3 = new JButton("Problème 3");	
	public static String entree = new String("NA");
	
	public mainBox() {
		super();
		build();
		
		synchronized(this) {
			if(entree != "NA") {
				notify();
				System.out.println("notify"+entree);
			}
		}
	}
	
	public String getString() {
		return entree;
	}
	
	private void build() 
	{
		setTitle("Jeux de Nombres");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(fenetre);
		
		fenetre.setLayout(null);
		getContentPane().add(pbm1);
		getContentPane().add(pbm2);
		getContentPane().add(pbm3);
		pbm1.setBounds(100, 300, 150, 50);
		pbm2.setBounds(350, 300, 150, 50); 
		pbm3.setBounds(600, 300, 150, 50);
		pbm1.addActionListener(this);
		pbm2.addActionListener(this);
		pbm3.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
//		Pbm1Box fenetre1 = new Pbm1Box();
//		fenetre1.setVisible(true);
		
		if(source == pbm1) {
				
				entree = (String)JOptionPane.showInputDialog("Générateur", null);			
					
				}			
		}
				

		
	/*
		else if(source == pbm2){
			Pbm2Box fenetre2 = new Pbm2Box();
			fenetre2.setVisible(true);
		}
		else if(source == pbm3){
			Pbm3Box fenetre3 = new Pbm3Box();
			fenetre3.setVisible(true);
		}
		
		*/
		
}
	
	