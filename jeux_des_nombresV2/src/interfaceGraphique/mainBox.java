package interfaceGraphique;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeux_des_nombresV2.mainClasseV2;


 public class mainBox extends JFrame implements ActionListener {
	 
	private panneau fenetre = new panneau();
	private JButton pbm1 = new JButton("Probl�me 1");
	private JButton pbm2 = new JButton("Probl�me 2");
	private JButton pbm3 = new JButton("Probl�me 3");	
	
	public mainBox() {
		super();
		build();
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
		
		if(source == pbm1) {
			Pbm1Box fenetre1 = new Pbm1Box();
			fenetre1.setVisible(true);
		}
		else if(source == pbm2){
			Pbm2Box fenetre2 = new Pbm2Box();
			fenetre2.setVisible(true);
		}
		else if(source == pbm3){
			Pbm3Box fenetre3 = new Pbm3Box();
			fenetre3.setVisible(true);
		}
	}
	
	
 }