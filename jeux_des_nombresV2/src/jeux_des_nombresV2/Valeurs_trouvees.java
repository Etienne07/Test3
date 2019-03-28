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
	
	//Ajoute une valeur à la liste des valeurs trouvées
	public Valeurs_trouvees ajouter_valeur(int val) 
	{
		if (this.liste_valeurs == null) //Regarde si la liste est vide
		{
			int [] init = new int[0];
			this.liste_valeurs = init; //Si oui, on renvoie une liste vide
		}
		
		//Création de la nouvelle liste de valeurs à renvoyer que l'on rempli des valeurs déjà trouvées et de la nouvelle valeur
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
	
	//Verifier si la valeur a déjà été trouvée
	public boolean is_in(int val)
	{
		if (this.liste_valeurs == null)
		{
			int [] init = new int[0];
			this.liste_valeurs = init;
		}
		
		int marqueur = 0; //Marqueur valant 0 tant qu'on ne trouve pas cette valeur en parcourant la liste des valeurs
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
