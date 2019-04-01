package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;



 public class Pbm1Box extends JFrame implements ActionListener {
	 
	private panneau1 fenetre = new panneau1();
	private JTextField texteNbGen = new JTextField();
	public static String generateur = new String("NA");
	public static int etat = 0;
	
	private JButton OK = new JButton("OK");
	
	public Pbm1Box() {
		super();
		build();
	}
	
	public String getString() {
		return generateur;
	}
	
	public int getState() {
		return etat;
	}
	
	private void build()
	{
		setTitle("Jeux de Nombres - Problème 1");
		setSize(920,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(fenetre);
		fenetre.setLayout(null);
		texteNbGen.setColumns(10);
		texteNbGen.setSize(30, 15);
		texteNbGen.setBounds(300, 210, 150, 50);
		add(texteNbGen);
		getContentPane().add(OK);
		OK.setBounds(100, 300, 150, 50);
		OK.addActionListener(this);
			
	 }
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == OK) {
			generateur = texteNbGen.getText();
			etat = 1;
			this.dispose();
		}
	
	}
	 
	
	
 }