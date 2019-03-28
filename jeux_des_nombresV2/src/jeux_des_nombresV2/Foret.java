package jeux_des_nombresV2;

public class Foret 
{
	protected Famille liste_famille[];
	
	public Foret ()
	{
		Famille liste_famille[] = new Famille[0];
	}
	
	public Foret (Famille [] family)
	{
		liste_famille = family;
	}

	public Foret ajouter_famille(Famille family)
	{
		//Vérifie si la forêt est vide
		if (this.liste_famille == null)//Si oui, on renvoie une forêt avec la nouvelle famille
		{
			Famille [] init = new Famille[0];
			this.liste_famille = init;
		}
		//Sinon on créé une nouvelle forêt duplicant la 1ère et ajoutant la nouvelle famille 
		int taille = this.liste_famille.length;
		Famille [] nouv_liste = new Famille [taille +1];
		if (taille == 0)
		{
			nouv_liste[0] = family;
		}
		else
		{
			for (int i=0; i<taille;i++)
			{
				nouv_liste[i]=this.liste_famille[i];
			}
			nouv_liste[taille]=family;
		}
		Foret nouv_foret = new Foret(nouv_liste);
		return(nouv_foret);
	}
}
