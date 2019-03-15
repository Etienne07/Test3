package jeux_des_nombresV2;

public class Valeurs_trouvees
{
	protected int [] liste_valeurs;
		
	public Valeurs_trouvees ()
	{
		int [] liste_valeurs = new int[0];
	}
	
	public Valeurs_trouvees (int [] liste_val)
	{
		liste_valeurs = liste_val;
	}
	
	public Valeurs_trouvees ajouter_valeur(int val)
	{
		if (this.liste_valeurs == null)
		{
			int [] init = new int[0];
			this.liste_valeurs = init;
		}
		
		int taille = this.liste_valeurs.length;
		int [] nouv_liste = new int [taille +1];
		if (taille == 0)
		{
			nouv_liste[0]=val;
		}
		else
		{
			for (int i=0; i<taille;i++)
			{
				nouv_liste[i]=this.liste_valeurs[i];
			}
			nouv_liste[taille]=val;
		}
		Valeurs_trouvees solut = new Valeurs_trouvees(nouv_liste);
		return(solut);
	}
	
	public boolean is_in(int val)
	{
		if (this.liste_valeurs == null)
		{
			int [] init = new int[0];
			this.liste_valeurs = init;
		}
		
		int marqueur = 0;
		for (int elem1 : this.liste_valeurs)
		{
			if (elem1 == val)
			{
				marqueur += 1;
			}
		}
		if (marqueur == 0)
			{
				return false;
			}
		else
			{
				return true;
			}
	}
}
