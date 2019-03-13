package jeux_des_nombresV2;

import java.util.Arrays;

public class Addition extends Arbre
{
	protected Arbre arbre1 = new Arbre();
	protected Arbre arbre2 = new Arbre();
				
	//test
	public Addition ()
	{
		super();
		Arbre arbre1 = new Arbre();
		Arbre arbre2 = new Arbre();
	}
	
	public Addition (int nouvelle_valeur,int [] liste_gen, Arbre nouvel_arbre1, Arbre nouvel_arbre2)
	{
		super(nouvelle_valeur,liste_gen);
		arbre1 = nouvel_arbre1;
		arbre2 = nouvel_arbre2;
	}
	
	public void operation(Arbre arbre1,Arbre arbre2)
	{
		int valeur1 = arbre1.valeur;
		int valeur2 = arbre2.valeur;
		//Addition nouvel_arbre = new Addition();
		this.arbre1 = arbre1;
		this.arbre2 = arbre2;
		int nouvelle_valeur = valeur1 + valeur2;
		this.valeur = nouvelle_valeur;
		//return(nouvel_arbre);
	}

	public String lire_solution()
	{
	    String solution = new String();
		solution = this.arbre1.lire_solution() + "+" + this.arbre2.lire_solution();
	    return(solution);
    } 
	
	public String toString()
	{
		String str = "[" + this.arbre1.toString() + ";" + this.arbre2.toString() + "; val = " + this.valeur + "]";
		return str;
	}
}
