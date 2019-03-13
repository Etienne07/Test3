package jeux_des_nombresV2;

import java.util.Arrays;

public class Division extends Arbre
{
	protected Arbre arbre1 = new Arbre();
	protected Arbre arbre2 = new Arbre();
				
	public Division ()
	{
		super();
		Arbre arbre1 = new Arbre();
		Arbre arbre2 = new Arbre();
	}
	
	public Division (int nouvelle_valeur,int [] liste_gen, Arbre nouvel_arbre1, Arbre nouvel_arbre2)
	{
		super(nouvelle_valeur,liste_gen);
		arbre1 = nouvel_arbre1;
		arbre2 = nouvel_arbre2;
	}
	
	public void operation(Arbre arbre1,Arbre arbre2)
	{
		int valeur1 = arbre1.valeur;
		int valeur2 = arbre2.valeur;
		if (valeur1!=0 && valeur2 != 0)
		{
			if (valeur1 >= valeur2)
			{
				//Division nouvel_arbre = new Division();
				this.arbre1 = arbre1;
				this.arbre2 = arbre2;
				int nouvelle_valeur = valeur1 / valeur2;
				this.valeur = nouvelle_valeur;
				//return(nouvel_arbre);
			}
			else
			{
				//Division nouvel_arbre = new Division();
				this.arbre1 = arbre2;
				this.arbre2 = arbre1;
				int nouvelle_valeur = valeur2 / valeur1;
				this.valeur = nouvelle_valeur;
				//return(nouvel_arbre);
			}
		}
		else
			{
				///Division test = new Division();
				//return(test);
			//!!!!!! que renvoyer si l'un des deux vaut 0 ?????
			int [] test1 = {1};
			Nombre test = new Nombre(1,test1);
			this.arbre1=test;
			this.arbre2=test;
			this.valeur=1;
			System.out.println("erreur : division par 0");
			}	
	}

	public String lire_solution()
	{
	    String solution = new String();
	    if (!(this.arbre1 instanceof Nombre) && !(this.arbre2 instanceof Nombre)) 
	    {
	    	if (this.arbre1 instanceof Addition || this.arbre1 instanceof Soustraction)
		    	solution = "(" + this.arbre1.lire_solution() + ")/(" + this.arbre2.lire_solution() + ")";
		    else
		    	solution = this.arbre1.lire_solution() + "/(" + this.arbre2.lire_solution() + ")";
		    return(solution);
	    }
	    if (this.arbre1 instanceof Nombre && !(this.arbre2 instanceof Nombre))
	    {
	    	solution = this.arbre1.lire_solution() + "/(" + this.arbre2.lire_solution() + ")";
		    return(solution);
	    }
	    else
	    {
	    	if (this.arbre1 instanceof Addition || this.arbre1 instanceof Soustraction)
		    	solution = "(" + this.arbre1.lire_solution() + ")/" + this.arbre2.lire_solution();
		    else
		    	solution = this.arbre1.lire_solution() + "/" + this.arbre2.lire_solution();
		    return(solution);
	    }
    } 
	
	public String toString()
	{
		String str = "[" + this.arbre1.toString() + ";" + this.arbre2.toString() + "; val = " + this.valeur + "]";
		return str;
	}
}
