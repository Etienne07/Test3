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
				
				synchronized(fenetre) {
					
					fenetre.setVisible(true);
					while(fenetre.getString() == "NA") {
						try{
							wait();
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					System.out.println(fenetre.getString());
					
					
				}
				
//				input = interfaceGraphique.mainBox.entree;
//				System.out.println(input);
//				output = jeux_des_nombresV2.mainClasseV2.retour;
				
//				output = input;
//				interfaceGraphique.ResultatBox fenetre_resultat = new interfaceGraphique.ResultatBox(output);
//				fenetre_resultat.setVisible(true);
			
				
			}
		});
	}	
}