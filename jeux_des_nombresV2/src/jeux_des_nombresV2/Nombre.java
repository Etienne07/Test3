package jeux_des_nombresV2;

import java.util.Arrays;

public class Nombre extends Arbre
{			
	public Nombre ()
	{
		super();
	}
	
	public Nombre(int nouvelle_valeur, int [] liste_gen)
	{
		super(nouvelle_valeur, liste_gen);
	}
		
	public String lire_solution()
	{
	    String solution = new String();
	    solution = String.valueOf(this.valeur);
		return(solution);
    } 
}
