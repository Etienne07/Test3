package jeux_des_nombresV2;

import java.util.Arrays;

public class Soustraction extends Arbre
{
	protected Arbre arbre1 = new Arbre();
	protected Arbre arbre2 = new Arbre();
				
	public Soustraction ()
	{
		super();
		Arbre arbre1 = new Arbre();
		Arbre arbre2 = new Arbre();
	}
	
	public Soustraction (int nouvelle_valeur,int [] liste_gen, Arbre nouvel_arbre1, Arbre nouvel_arbre2)
	{
		super(nouvelle_valeur,liste_gen);
		arbre1 = nouvel_arbre1;
		arbre2 = nouvel_arbre2;
	}
	
	public void operation(Arbre arbre1,Arbre arbre2) //Effectue la soustraction entre deux arbres
	{
		int valeur1 = arbre1.valeur;
		int valeur2 = arbre2.valeur;
		//On créé un nouvel objet soustraction entre les deux arbres
		//On va donc initialiser les instances de ce nouvel arbre
		if (valeur1 >= valeur2) //Permet de ne pas avoir de nombres négatifs
		{
			this.arbre1 = arbre1;
			this.arbre2 = arbre2;
			int nouvelle_valeur = valeur1 - valeur2;
			this.valeur = nouvelle_valeur;
		}
		else
			{
			this.arbre1 = arbre2;
			this.arbre2 = arbre1;
			int nouvelle_valeur = valeur2-valeur1;
			this.valeur = nouvelle_valeur;
			}
		int [] liste_gen = new int[arbre1.liste_generateurs.length + arbre2.liste_generateurs.length];
		for (int i = 0;i < arbre1.liste_generateurs.length;i++)
		{
			liste_gen[i]= arbre1.liste_generateurs[i];
		}
		for (int j = 0;j < arbre2.liste_generateurs.length;j++)
		{
			liste_gen[j+arbre1.liste_generateurs.length]= arbre2.liste_generateurs[j];
		}
		this.liste_generateurs = liste_gen;
	}
	
	public String lire_solution() //Renvoie la solution correspondante de l'arbre en plaçant bien les parenthèses
	{
	    String solution = new String();
	    if (this.arbre2 instanceof Addition)
	    	solution = this.arbre1.lire_solution() + "-(" + this.arbre2.lire_solution() + ")";
	    else if (this.arbre2 instanceof Soustraction)
	    	solution = this.arbre1.lire_solution() + "-(" + this.arbre2.lire_solution() + ")";
	    else
	    	solution = this.arbre1.lire_solution() + "-" + this.arbre2.lire_solution();
	    return(solution);
    } 
}
