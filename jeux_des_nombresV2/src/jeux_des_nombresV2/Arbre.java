package jeux_des_nombresV2;

import java.util.Arrays;

public class Arbre
{
	protected int valeur;
	protected int liste_generateurs[];
	
	public Arbre ()
	{
		valeur = 0;
		int liste_generateurs[] = {};
	}
	
	public Arbre (int nouvelle_valeur, int [] liste_gen)
	{
		valeur = nouvelle_valeur;
		liste_generateurs = liste_gen;
	}
	
	public String lire_solution()
	{
		return(this.lire_solution());
	}

	public String toString()
	{
		String str = "\n Arbre non conforme \n";
		return str;
	}
	
	//Méthode renvoyant 'true' si les 2 arbres n'ont pas de générateurs en commun
	public boolean compare_generateurs(Arbre arbre)
	{
		int marqueur = 0;
		int[] liste_generateurs1 = this.liste_generateurs;
		int[] liste_generateurs2 = arbre.liste_generateurs;
		for (int elem1 : liste_generateurs1)
			{
			for (int elem2 : liste_generateurs2)
				{
				if (elem1 == elem2)
					{
						marqueur += 1;
					}
				}
			}
		if (marqueur == 0)
			{
				return true;
			}
		else
			{
				return false;
			}
	}
}
