package interfaceGraphique;
import javax.swing.SwingUtilities;

public class mainEngine {
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			public void run()
			{
				
				mainBox fenetre = new mainBox();
				fenetre.setVisible(true);
			}
		});
	}
}