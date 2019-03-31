package interpreteur;
import javax.swing.SwingUtilities;

public class main {
	private static String input = new String();
	private static String output = new String();
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			public void run()
			{
				
				jeux_des_nombresV2.mainClasseV2 moteur = new jeux_des_nombresV2.mainClasseV2();
				interfaceGraphique.mainBox fenetre = new interfaceGraphique.mainBox();
				fenetre.setVisible(true);
				input = interfaceGraphique.mainBox.entree;
//				output = jeux_des_nombresV2.mainClasseV2.retour;
				
				
				
				
				
				
			}
		});
	}	
}