package jeux_des_nombresV2;

public class Solutions
{
	protected Arbre liste_solution [];
	
	public Solutions ()
	{
		Arbre liste_solutions[] = {};
	}
	
	public Solutions (Arbre [] nouvelle_liste_arbre)
	{
		liste_solution = nouvelle_liste_arbre;
	}
	
	//public String toString()
	//{
		//return();
	//}
	
	public Solutions ajouter_arbre_solution(Arbre arbre)
	{
		int taille = this.liste_solution.length;
		Arbre [] nouv_liste = new Arbre [taille +1];
		if (taille == 0)
		{
			nouv_liste[0]=arbre;
		}
		else
		{
			for (int i=0; i<taille;i++)
			{
				nouv_liste[i]=this.liste_solution[i];
			}
			nouv_liste[taille]=arbre;
		}
		Solutions solut = new Solutions(nouv_liste);
		return(solut);
	}
	
	public String lire_solution_finale()
	{
		String expression = new String();
		expression += "\nL'ensemble des solutions trouvées est :";
		int taille = this.liste_solution.length;
		for (int i=0;i<taille;i++)
		{
			String nouvelle_expression = new String();
			nouvelle_expression = this.liste_solution[i].lire_solution();
			expression+="\n"+ this.liste_solution[i].valeur + "=" + nouvelle_expression;
		}
		return(expression);
	}

	public void tri_solutions()
	{
		int taille = this.liste_solution.length;
		if (taille != 0)
		{
			Arbre liste_doublon [] = new Arbre[taille];
			int i = 0;
			int j = 0;
			Arbre debut = new Arbre();
			while (i<taille)
			{
				j=i;
				debut = this.liste_solution[i];
				while (j<taille)
				{
					
					debut = this.liste_solution[i];
					
					j+=1;
				}
			i+=1;
			}
		
		}
	}


}
