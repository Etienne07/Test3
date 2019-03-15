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
			if (taille == 0)
			{
				nouv_liste[0]=arbre;
			}
			else
			{
				for (int i=0; i<taille;i++)
				{
					nouv_liste[i]=this.liste_famille_arbre[i];
				}
				nouv_liste[taille]=arbre;
			}
			Famille solut = new Famille(this.nb_operations,nouv_liste);
			return(solut);
		}
}
