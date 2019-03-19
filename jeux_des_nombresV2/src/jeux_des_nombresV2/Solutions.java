package jeux_des_nombresV2;

public class Solutions
{
	protected Arbre liste_solution [];
	
	public Solutions ()
	{
		Arbre liste_solutions[] = new Arbre[0];
	}
	
	public Solutions (Arbre [] nouvelle_liste_arbre)
	{
		liste_solution = nouvelle_liste_arbre;
	}
	
	public Solutions ajouter_arbre_solution(Arbre arbre)
	{
		if (this.liste_solution == null)
		{
			Arbre [] init = new Arbre[0];
			this.liste_solution = init;
		}
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
		if (this.liste_solution == null || this.liste_solution.length == 0)
			return("\n Il n'existe pas de solution \n");
		else
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
	}

	public void tri_solutions()
	{
		if (this.liste_solution == null)
		{
			Arbre [] init = new Arbre[0];
			this.liste_solution = init;
		}
		else
		{
			int taille = this.liste_solution.length;
			if (taille != 0)
			{
				int i = 0;
				int j = 1;
				int jmarqueur = 0;
				Arbre debut = new Arbre();
				Arbre doublon [] = new Arbre[taille];
				while (i<taille)
				{
					j=i+1;
					jmarqueur = i;
					debut = this.liste_solution[i];
					while (j<taille)
					{
						if (debut.valeur <= this.liste_solution[j].valeur)
						{
							//Evite l'erreur
						}
						
						else
						{
							System.out.println("debut = " + debut.valeur);
							System.out.println("new  = " + this.liste_solution[j].valeur);
							debut = this.liste_solution[j];
							jmarqueur = j;
							System.out.println("etape i = " + i);
							System.out.println("etape j = " + j);
							
							
							
							System.out.println("jmarqueur = " + jmarqueur);
							System.out.println("jvaleur = " + debut.valeur + "\n");
						}
						j+=1;
					}
					this.liste_solution[jmarqueur]=this.liste_solution[i];
					this.liste_solution[i]=debut;
					i+=1;
				}
			}
		}
	}


}
