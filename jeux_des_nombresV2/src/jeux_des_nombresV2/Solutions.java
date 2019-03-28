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
	
	//Méthode d'ajout d'arbre dans la solution
	public Solutions ajouter_arbre_solution(Arbre arbre)
	{
		//Vérifie si la liste de solution est vide
		if (this.liste_solution == null)
		{
			Arbre [] init = new Arbre[0]; //Si oui, on renvoie une liste avec l'arbre solution
			this.liste_solution = init;
		}
		int taille = this.liste_solution.length;
		Arbre [] nouv_liste = new Arbre [taille +1];
		if (taille == 0)
		{
			nouv_liste[0]=arbre;
		}
		else //Sinon, on va créer une nouvelle liste en partant de l'ancienne et en ajoutant le nouvel arbre solution
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
	
	// Méthode de lecture de la solution
	public String lire_solution_finale()
	{
		//S'il n'y a pas de solution :
		if (this.liste_solution == null || this.liste_solution.length == 0)
			return("\n Il n'existe pas de solution \n");

		//Sinon
		else
		{
			// On créé une chaîne de caractère en parcourant 
			String expression = new String();
			expression += "\nL'ensemble des solutions trouvées est :";
			int taille = this.liste_solution.length;
			for (int i=0;i<taille;i++)
			{
				String nouvelle_expression = new String();
				//On utilise ici la méthode 'lire_solution' sur chacune des solutions :
				nouvelle_expression = this.liste_solution[i].lire_solution(); 
				expression+="\n"+ this.liste_solution[i].valeur + "=" + nouvelle_expression;
			}
			return(expression); //On renvoie la solution finale
		}
	}

	//Méthode de tri de la solution
	public void tri_solutions()
	{
		//Vérifie si la solution est vide
		if (this.liste_solution == null)
		{
			Arbre [] init = new Arbre[0];
			this.liste_solution = init;
		}
		else //Sinon on effectue un algorithme de tri sélection pour placer à chaque étape le plus petit arbre de la liste en 1ère position
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
							//Evite l'erreur. C'est la seule combine trouvée pour que la boucle 'if' soit effectivement lue.
						}
						
						else
						{
							debut = this.liste_solution[j];
							jmarqueur = j;
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
