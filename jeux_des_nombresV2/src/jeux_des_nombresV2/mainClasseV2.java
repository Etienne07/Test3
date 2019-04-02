package jeux_des_nombresV2;
import java.util.Scanner;
//<<<<<<< HEAD


//=======
//>>>>>>> branch 'master' of https://github.com/Etienne07/Test3.git
public class mainClasseV2 {
    public static void main(String[] args)
	{
    	String [] pb1 = new String[2];
    	String [] pb2 = new String[3];
    	String [] pb3 = new String[5];
    	pb1[0] = "1";
    	pb1[1] = "10";
    	
    	pb2[0] = "2";
    	pb2[1] = "10";
    	pb2[2] = "5";
    	
    	pb3[0] = "3";
    	pb3[1] = "10";
    	pb3[2] = "2";
    	pb3[3] = "5";
    	pb3[4] = "3";    	
    	
    	mainEngine sol_pb = new mainEngine();
    	
    	System.out.println(sol_pb.mainEngine(pb1)+"\n"+"\n");
    	System.out.println(sol_pb.mainEngine(pb2)+"\n"+"\n");
    	System.out.println(sol_pb.mainEngine(pb3)+"\n"+"\n");    	
    	
		Scanner sc = new Scanner(System.in);

	    //Initialisation des variables
	    char reponse=' ', mode = ' ';
	        
	    //Mise en placec du menu principal
	    System.out.println("JEUX DES NOMBRES");
	    System.out.println("-------------------------------------------------");
	    	      
	    do{//Tant que reponse = O //boucle principale
	    	
	    	do{//Tant que reponse invalide

	    		mode = ' ';

		        System.out.println("Choisissez le mode de conversion : ");

		        System.out.println("1 - Un seul générateur - Le moins d'opérations");

		        System.out.println("2 - Un seul générateur - Un nombre donné d'opérations");

		        System.out.println("3 - Plusieurs générateurs - Le moins d'opérations");
		        
		        mode = sc.nextLine().charAt(0);
	   
		        //Vérifie que la réponse est valide
		        if(mode != '1' && mode != '2' && mode != '3')

		        	System.out.println("Mode inconnu, veuillez réitérer votre choix.");


	    	}while (mode != '1' && mode != '2' && mode != '3');
	      
	    	if(mode == '1')
	    	{
	    		//Saisie du générateur
	    		//do {//Tant que reponse invalide
			    System.out.println("Entrer un entier générateur :");
			    
			    int generateur_pb1 = sc.nextInt();
			    //Pensez à vider la ligne lue
			    sc.nextLine();
			    
			  //Vérifie que la réponse est valide
		       // if(!(mode instanceof ))

		        	//System.out.println("Entrer un entier naturel valide");


	    		//}while (mode != '1' && mode != '2' && mode != '3');

		  //Initialisation du pb 1
			    
			    //Initialisation de l'arbre générateur :
			    Nombre arbre_pb1 = new Nombre(); 
			    arbre_pb1.valeur = generateur_pb1;
			    int [] liste_gen_pb1 = {generateur_pb1};
			    arbre_pb1.liste_generateurs = liste_gen_pb1; 

			    //Initialisation de Famille
			    Arbre [] liste_arbre_pb1 = new Arbre[1];
			    liste_arbre_pb1[0] = arbre_pb1;
			    Famille fam_pb1 = new Famille(0,liste_arbre_pb1);
			    
			    //Initialisation de Foret
			    Famille [] liste_fam_pb1 = new Famille[1];
			    liste_fam_pb1[0] = fam_pb1;
			    Foret for_pb1 = new Foret(liste_fam_pb1);
			    			    
			    //Initialisation de Valeurs_trouvees
			    int [] liste_val_pb1 = new int[1];
			    liste_val_pb1[0] = arbre_pb1.valeur;
			    Valeurs_trouvees val_trouvees_pb1 = new Valeurs_trouvees(liste_val_pb1);
			    
			    //Initialisation de Solutions
			    Arbre [] liste_solution_pb1 = new Arbre[1];
			    liste_solution_pb1[0]=arbre_pb1;
			    Solutions sol_pb1 = new Solutions(liste_solution_pb1);
			    int taille = sol_pb1.liste_solution.length;
			    
		//Debut de la boucle principale de calculs des arbres
			    int etape = 1;
			    while (taille <= generateur_pb1)	    
			    {  	
			    //Creation de la nouvelle famille:
			    	Famille fam_nvlle_etape_pb1 = new Famille();
			    	fam_nvlle_etape_pb1.nb_operations=etape;
			    	
			    	//Preparation de la boucle principale
			    	int i = 0;
			    	int j = etape-1;
			    	while (i<=j)//Permet de donner les couples de familles à combiner par des opérations		
			    		{
			    	
			    	//Pacours des familles complémentaires
			    		
			    		//Simplification de la notation
			    		int taillei = for_pb1.liste_famille[i].liste_famille_arbre.length;
			    		int taillej = for_pb1.liste_famille[j].liste_famille_arbre.length;
			    		Famille famillei = for_pb1.liste_famille[i];
			    		Famille famillej = for_pb1.liste_famille[j];
			    		
			    		//i1 et j1 vont permettre de parcourrir les familles i et j retenues
			    		for (int i1 = 0; i1 < taillei; i1++)
			    		{
			    			for (int j1 = 0; j1 < taillej; j1++)
			    			{
			    			//On effectue les 3 opérations (on garde la division pour juste après)			    				
			    				Addition add_pb1 = new Addition();
			    				add_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    					
			    				Soustraction sous_pb1 = new Soustraction();
		    					sous_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    					
		    					Multiplication mult_pb1 = new Multiplication();
		    					mult_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    						
		    					//Regroupement des résultats dans la liste "nouv_arbres"
								Arbre [] nouv_arbres_pb1 = {add_pb1,sous_pb1,mult_pb1};
								
								//Cas particulier de la division
								//On ne divise pas par 0 :
		    					if (famillei.liste_famille_arbre[i1].valeur!=0 && famillej.liste_famille_arbre[j1].valeur!=0)
		    					{
		    						//La division doit donner un entier :
		    						if (famillei.liste_famille_arbre[i1].valeur % famillej.liste_famille_arbre[j1].valeur ==0 || famillej.liste_famille_arbre[j1].valeur % famillei.liste_famille_arbre[i1].valeur==0)
		    						{
		    							//Alors seulement on effectue la division
		    							Division div_pb1 = new Division();
		    							div_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    						Arbre [] nouv_arbres_v2 = {add_pb1,sous_pb1,mult_pb1,div_pb1};
			    						nouv_arbres_pb1 = nouv_arbres_v2;
			    					}
		    					}
	    						
	    						//Ajout ou non des nouveaux arbres dans la solution
	    						for (Arbre arbres_pb1 : nouv_arbres_pb1)
	    						{
	    							//Regarde si la valeur n'a pas déjà été trouvée dans le passé, et si on ne dépasse pas la capacité du type "int"
	    							if (!val_trouvees_pb1.is_in(arbres_pb1.valeur) && arbres_pb1.valeur>=0)
	    							{
	    								val_trouvees_pb1=val_trouvees_pb1.ajouter_valeur(arbres_pb1.valeur);
	    								
	    								//Regarde si la valeur est solution
	    								if (arbres_pb1.valeur <= generateur_pb1)
	    									sol_pb1=sol_pb1.ajouter_arbre_solution(arbres_pb1);//si oui, on l'ajoute à la liste des solutions

		    							//Met à jour la famille pour les valeurs retenues
		    							fam_nvlle_etape_pb1=fam_nvlle_etape_pb1.ajouter_arbre_famille(arbres_pb1);
	    							}
	    						}	
	    					}		
		    			}
			    		
			    		//Passe aux familles restantes
			    		i+=1;
			    		j-=1;
			    	}
			    	//Ajoute la famille trouvée à cette étape et passe à l'étape suivante 		    	
			    	for_pb1=for_pb1.ajouter_famille(fam_nvlle_etape_pb1);
			    	etape += 1;
			    	
			    	//Met à jour la condition de fermeture de la boucle cas
			    	taille = sol_pb1.liste_solution.length;
			    }
			    
		//Une fois la solution trouvées, on la trie, puis on afficher le résultat
			    sol_pb1.tri_solutions();
			    System.out.println(sol_pb1.lire_solution_finale());
	    	}
	    	
	    	
	    	if(mode == '2')
	    	{
	    		//Saisie du générateur

			    System.out.println("Entrer un entier générateur :");
			    
			    int generateur_pb2 = sc.nextInt();
			    //Pensez à vider la ligne lue
			    sc.nextLine();
			    
			    //Saisie du nombre d'opérations
			    System.out.println("En combien d'opérations ? :");
			    
			    int nombre_d_ope = sc.nextInt();
			    //Pensez à vider la ligne lue
			    sc.nextLine();

		  //Initialisation du pb 2
			    
			    //Initialisation de l'arbre générateur :
			    Nombre arbre_pb2 = new Nombre(); 
			    arbre_pb2.valeur = generateur_pb2;
			    int [] liste_gen_pb2 = {generateur_pb2};
			    arbre_pb2.liste_generateurs = liste_gen_pb2; 

			    //Initialisation de Famille
			    Arbre [] liste_arbre_pb2 = new Arbre[1];
			    liste_arbre_pb2[0] = arbre_pb2;
			    Famille fam_pb2 = new Famille(0,liste_arbre_pb2);
			    
			    //Initialisation de Foret
			    Famille [] liste_fam_pb2 = new Famille[1];
			    liste_fam_pb2[0] = fam_pb2;
			    Foret for_pb2 = new Foret(liste_fam_pb2);
			  
			    //Initialisation de Valeurs_trouvees
			    int [] liste_val_pb2 = new int[1];
			    liste_val_pb2[0] = arbre_pb2.valeur;
			    Valeurs_trouvees val_trouvees_pb2 = new Valeurs_trouvees(liste_val_pb2);
			    
			    //Initialisation de Solutions
			    Solutions sol_pb2 = new Solutions();
			    
		//Debut de la boucle principale de calculs des arbres
			    int etape = 1;
			    while (etape <= nombre_d_ope)	    
			    {  	
			    
			    //Creation de la nouvelle famille
			    	Famille fam_nvlle_etape_pb2 = new Famille();
			    	fam_nvlle_etape_pb2.nb_operations = etape; 
			    	
			    	//Preparation de la boucle principale
			    	int i = 0;
			    	int j = etape-1;
			    	while (i<=j)//Permet de donner les couples de familles à combiner par des opérations		
			   		{
			   	
			    		//Pacours des familles complémentaires
		    
			    		//Simplification de la notation
			    		int taillei = for_pb2.liste_famille[i].liste_famille_arbre.length;
			    		int taillej = for_pb2.liste_famille[j].liste_famille_arbre.length;
			    		Famille famillei = for_pb2.liste_famille[i];
			   			Famille famillej = for_pb2.liste_famille[j];
			   		
			   			//i1 et j1 vont permettre de parcourrir les familles i et j retenues
			   			for (int i1 = 0; i1 < taillei; i1++)
			   			{
			   				for (int j1 = 0; j1 < taillej; j1++)
			   				{
			   					//On effectue les 4 opérations			    				
			   					if (famillei.liste_famille_arbre[i1].valeur!=0 && famillej.liste_famille_arbre[j1].valeur!=0)	
			   					{
			   						Addition add_pb2 = new Addition();
				    				add_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
				    					
				    				Soustraction sous_pb2 = new Soustraction();
			    					sous_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    					
			    					Multiplication mult_pb2 = new Multiplication();
			    					mult_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    						
			    					//Regroupement des résultats dans la liste "nouv_arbres"
									Arbre [] nouv_arbres_pb2 = {add_pb2,sous_pb2,mult_pb2};
										
									//Cas particulier de la division
									//On ne divise pas par 0 :
				   					if (famillei.liste_famille_arbre[i1].valeur!=0 && famillej.liste_famille_arbre[j1].valeur!=0)
				    				{
				   					//La division doit donner un entier :
				    					if (famillei.liste_famille_arbre[i1].valeur % famillej.liste_famille_arbre[j1].valeur ==0 || famillej.liste_famille_arbre[j1].valeur % famillei.liste_famille_arbre[i1].valeur==0)
			    						{
				    						//Alors seulement on effectue la division
			    							Division div_pb2 = new Division();
			    							div_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
				    						Arbre [] nouv_arbres_v2 = {add_pb2,sous_pb2,mult_pb2,div_pb2};
				    						nouv_arbres_pb2 = nouv_arbres_v2;
					   					}
			    					}
			   						
			    					//Ajout ou non des nouveaux arbres dans la solution
			    					for (Arbre arbres_pb2 : nouv_arbres_pb2)
			    					{
			    						//Si on ne dépasse pas la capacité du type "int"
			    						if (arbres_pb2.valeur >= 0)
			    						{
			    							//On rajoute ces valeurs à la famille en cours de remplissage
				    						fam_nvlle_etape_pb2=fam_nvlle_etape_pb2.ajouter_arbre_famille(arbres_pb2);
				    						
				    						//On n'ajoute ces valeurs à la solution que si elles ont le bon nombre d'opération
				   							if (nombre_d_ope == etape && arbres_pb2.valeur <= generateur_pb2)
				   							{    								
				   								//Et si on ne les a pas encore trouvées avant
				   								if (!val_trouvees_pb2.is_in(arbres_pb2.valeur))
				    							{
					    							sol_pb2=sol_pb2.ajouter_arbre_solution(arbres_pb2);
					    							val_trouvees_pb2 = val_trouvees_pb2.ajouter_valeur(arbres_pb2.valeur);	
				    							}
				    						}
			    						}
			    					}
			    				}
	    					}		
		    			}
			    		
			    		//Passe aux familles restantes
			    		i+=1;
			    		j-=1;
			    	}
			    	//Ajoute la famille trouvée à cette étape et passe à l'étape suivante 		    	
			    	for_pb2=for_pb2.ajouter_famille(fam_nvlle_etape_pb2);
			    	etape += 1;
			    }
			    
		//Une fois la solution trouvées, on la trie, puis on afficher le résultat
			    sol_pb2.tri_solutions();
			    System.out.println(sol_pb2.lire_solution_finale());
	    	}
	    
	    if (mode == '3')
	    {   	
	    	
	    //Initialisation du pb 3
	    	
		    Solutions sol_pb3 = new Solutions();
		    
		  //Initialisation de Valeurs_trouvees
		    Valeurs_trouvees val_trouvees_pb3 = new Valeurs_trouvees();
		    
	    	//On initialise la liste de générateurs
	    	int nb_entier = 0;
	    	int [] liste_generateurs = {};
	    	Famille fam_pb3 = new Famille();
	    	fam_pb3.nb_operations = 0;
	    	
	    	System.out.println("Quel nombre voulez-vous trouver ?");
		    
		    int nb_trouve = sc.nextInt();
		    //Pensez à vider la ligne lue
		    sc.nextLine();
	    
		    

		    //Ici il faudrait un bouton : "Ajouter un entier" et un "Lancer le jeu" -> à voir pour l'interface graphique
		    
	    	//Je remplace ici le bouton "Ajouter un entier" par 1 en entrée
	    	while (nb_entier != -1 )
	    	{
	    		System.out.println("Ajouter un entier");
			    
			    nb_entier = sc.nextInt();
			    //Pensez à vider la ligne lue
			    sc.nextLine();
			    
			    if (nb_entier != -1)
			    {
			    	//On ajoute l'entier à la liste
				    int [] liste_doublon = new int[liste_generateurs.length+1];
				    for (int i=0; i<liste_generateurs.length;i++) 
				    {
				    	liste_doublon[i] = liste_generateurs[i];
				    }
				    liste_doublon[liste_generateurs.length] = nb_entier;
				    liste_generateurs = liste_doublon;
				    
				  //On ajoute l'arbre correspondant à la famille initiale
				    Nombre arbre_pb3 = new Nombre();
				    arbre_pb3.valeur = nb_entier;
				    int [] liste_gen_pb3 = {nb_entier};
				    arbre_pb3.liste_generateurs = liste_gen_pb3;
				    fam_pb3=fam_pb3.ajouter_arbre_famille(arbre_pb3);
				    
				    if (nb_trouve == nb_entier)
				    {
				    	sol_pb3.liste_solution[0] = arbre_pb3;
				    }
				    
				    if (val_trouvees_pb3.is_in(nb_entier))
				   	{
				    	val_trouvees_pb3.ajouter_valeur(nb_entier);
			 		}
			    }			    
	    	}
		    
		    //Initialisation de Foret
		    Famille [] liste_fam_pb3 = new Famille[1];
		    liste_fam_pb3[0] = fam_pb3;
		    Foret for_pb3 = new Foret(liste_fam_pb3);
		    
		    //Debut de la boucle principale de calculs des arbres
		    int etape = 1;
		    
	    	//La condition d'arrêt portera sur la solution : dès qu'il y en a une on la renvoie
		    int taille = 0;
	    	if (sol_pb3.liste_solution != null)
	    	{	    		
	    		taille = sol_pb3.liste_solution.length;
	    	}
	    	
	    	//int nb_de_generateurs = fam_pb3.liste_famille_arbre.length;
	    	//tant qu'on n'a pas trouvé de solution ou qu'il n'y a pas de solution (etape < nb_de_generateurs de départ + 1)
	    	while (taille == 0 && etape < for_pb3.liste_famille[0].liste_famille_arbre.length + 1) 
	    	{
	    					    
			  //Creation de la nouvelle famille
		    	Famille fam_nvlle_etape_pb3 = new Famille();
		    	fam_nvlle_etape_pb3.nb_operations = etape;
		    	
	    		//Preparation de la boucle principale
		    	int i = 0;
		    	int j = etape-1;
		    	while (i<=j)//Permet de donner les couples de familles à combiner par des opérations		
		    	{
		    		
		    		//Pacours des familles complémentaires
		    		
		    		//gestion de familles nulles
		    		Arbre [] vide = new Arbre[0];
		    		if (for_pb3.liste_famille[i].liste_famille_arbre == null)
		    			for_pb3.liste_famille[i].liste_famille_arbre = vide;
		    		if (for_pb3.liste_famille[j].liste_famille_arbre == null)
		    			for_pb3.liste_famille[j].liste_famille_arbre = vide;
		    		
			    	//Simplification de la notation
			    	int taillei = for_pb3.liste_famille[i].liste_famille_arbre.length;
			   		int taillej = for_pb3.liste_famille[j].liste_famille_arbre.length;
			   		Famille famillei = for_pb3.liste_famille[i];
			   		Famille famillej = for_pb3.liste_famille[j];
			   		
		    		//i1 et j1 vont permettre de parcourrir les familles i et j retenues
		    		for (int i1 = 0; i1 < taillei; i1++)
		    		{			    			
		    			for (int j1 = 0; j1 < taillej; j1++)
			    		{
		    		//On vérifie que les deux arbres n'ont pas de générateurs communs 
		    			//boolean verification = famillei.liste_famille_arbre[i1].compare_generateurs(famillej.liste_famille_arbre[j1]);
			   			if (famillei.liste_famille_arbre[i1].compare_generateurs(famillej.liste_famille_arbre[j1]))
			   			{
			   			//On effectue les 4 opérations
		    			
			   				Addition add_pb3 = new Addition();
			   				add_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			   					
		    				Soustraction sous_pb3 = new Soustraction();
	    					sous_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
	    					
	    					Multiplication mult_pb3 = new Multiplication();
	    					mult_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
	    					
	    					//Regroupement des résultats dans la liste "nouv_arbres"
							Arbre [] nouv_arbres_pb3 = {add_pb3,sous_pb3,mult_pb3};
							
							//Cas particulier de la division
							//On ne divise pas par 0 :
	    					if (famillei.liste_famille_arbre[i1].valeur!=0 && famillej.liste_famille_arbre[j1].valeur!=0)
	    					{
	    						//La division doit donner un entier :
	    						if (famillei.liste_famille_arbre[i1].valeur % famillej.liste_famille_arbre[j1].valeur ==0 || famillej.liste_famille_arbre[j1].valeur % famillei.liste_famille_arbre[i1].valeur==0)
	    						{
	    							//Alors seulement on effectue la division
	    							Division div_pb3 = new Division();
	    							div_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    						Arbre [] nouv_arbres_v2 = {add_pb3,sous_pb3,mult_pb3,div_pb3};
		    						nouv_arbres_pb3 = nouv_arbres_v2;
		    					}
	    					}
		    				
	    					//Ajout ou non des nouveaux arbres dans la solution
							for (Arbre arbres_pb3 : nouv_arbres_pb3)
							{
								//Regarde si la valeur n'a pas déjà été trouvée dans le passé, et si on ne dépasse pas la capacité du type "int"
								if (!val_trouvees_pb3.is_in(arbres_pb3.valeur) && arbres_pb3.valeur >= 0)
								{
									val_trouvees_pb3=val_trouvees_pb3.ajouter_valeur(arbres_pb3.valeur);
									
									//Regarde si la valeur est solution
									if (arbres_pb3.valeur == nb_trouve)
										sol_pb3=sol_pb3.ajouter_arbre_solution(arbres_pb3);//si oui, on l'ajoute à la liste des solutions
									
									//Met à jour la famille pour les valeurs retenues
									fam_nvlle_etape_pb3=fam_nvlle_etape_pb3.ajouter_arbre_famille(arbres_pb3);
								}
							}
			   			}
					}		
	    		}
		    		
		    	//Passe aux familles restantes
		   		i+=1;
		   		j-=1;		
		    		
		   	}
	    	//Ajoute la famille trouvée à cette étape et passe à l'étape suivante 		    	
	    	for_pb3=for_pb3.ajouter_famille(fam_nvlle_etape_pb3);
	   		etape += 1;
	   	
	   		//Met à jour la condition de fermeture de la boucle cas
	   		
	   		//Si il y a une solution de trouvée, on arrête la boucle
	   		if (sol_pb3.liste_solution != null)
	   			taille = sol_pb3.liste_solution.length;		   			
    	}
		    
    //Une fois la solution trouvées, on la trie, puis on afficher le résultat
    	System.out.println(sol_pb3.lire_solution_finale());
    }    	
     
    //On invite l'utilisateur à recommencer ou à quitter

    	

//<<<<<<< HEAD
	      //On invite l'utilisateur à recommencer ou à quitter

	      do{       

	        System.out.println("Souhaitez-vous rejouer ? (O/N)");
	        reponse = sc.nextLine().charAt(0);
	       

	      }while(reponse != 'O' && reponse != 'N');

	    

	    }while(reponse == 'O');

	    

	  System.out.println("Au revoir !");
	  sc.close();
	  

	  //Fin de programme

	 			
	}
}

//=======
//>>>>>>> branch 'master' of https://github.com/Etienne07/Test3.git
