package jeux_des_nombresV2;

public class Famille
{
		protected int nb_operations;
		protected Arbre liste_famille_arbre[];
		
		public Famille ()
		{
			nb_operations = 0;
			Arbre liste_famille_arbre[] = new Arbre[0];
		}
		
		public Famille (int nb_ope, Arbre [] liste_famille)
		{
			nb_operations = nb_ope;
			liste_famille_arbre = liste_famille;
		}

		public Famille ajouter_arbre_famille(Arbre arbre)
		{			
			if (this.liste_famille_arbre == null)
			{
				Arbre [] init = new Arbre[0];
				this.liste_famille_arbre = init;
			}
			int taille = this.liste_famille_arbre.length;
			Arbre [] nouv_liste = new Arbre [taille +1];
			int nouv_ope = 0;// Peut poser pb pour des cas particuliers
			if (taille == 0)
			{
				nouv_liste[0]=arbre;
			}
			else
			{
				int i=0;
				while (i<taille)
				{
					nouv_liste[i]=this.liste_famille_arbre[i];
					i+=1;
				}
				nouv_liste[taille]=arbre;
				nouv_ope=this.nb_operations;
			}
			Famille solut = new Famille(nouv_ope,nouv_liste);
			return(solut);
		}
}
