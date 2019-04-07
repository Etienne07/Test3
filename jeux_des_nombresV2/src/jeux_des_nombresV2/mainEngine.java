package jeux_des_nombresV2;

public class mainEngine {
	
		
	public static String  mainEngine(String[] probleme)
	{
		String mode = new String();
		mode = probleme[0];
		
		if(mode == "1")
	    {
	   		//Saisie du générateur
			String generateur_pb1_string = new String(); 
			generateur_pb1_string = probleme[1];
			int generateur_pb1 = Integer.parseInt(generateur_pb1_string);
			
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
		    return(sol_pb1.lire_solution_finale());
    	}
	    	
		else if(mode == "2")
    	{
			//Saisie du générateur
			String generateur_pb2_string = new String(); 
			generateur_pb2_string = probleme[1];
			int generateur_pb2 = Integer.parseInt(generateur_pb2_string);
			
		    //Saisie du nombre d'opérations
			String nombre_d_ope_string = new String(); 
			nombre_d_ope_string = probleme[2];
			int nombre_d_ope = Integer.parseInt(nombre_d_ope_string);
			
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
		    return(sol_pb2.lire_solution_finale());
    	}
	    
		else if (mode == "3")
	    {
	      
	    //Initialisation du pb 3
	    	
		    Solutions sol_pb3 = new Solutions();
		    
		  //Initialisation de Valeurs_trouvees
		    Valeurs_trouvees val_trouvees_pb3 = new Valeurs_trouvees();
		        
		  //Saisie du nombre cible
			String nb_trouve_string = new String(); 
			nb_trouve_string = probleme[1];
			int nb_trouve = Integer.parseInt(nb_trouve_string);
			
			//On initialise la liste de générateurs
	    	int nb_entier = 0;
	    	int [] liste_generateurs = {};
	    	Famille fam_pb3 = new Famille();
	    	fam_pb3.nb_operations = 0;
	    	
		  //Saisie des générateurs
			for(int i=0; i<probleme.length-2; i++)
			{
				String generateur_string = probleme[i+2];
				int generateur_pb3 = Integer.parseInt(generateur_string);  
			
				int [] liste_doublon = new int[liste_generateurs.length+1];
				for (int j=0; j<liste_generateurs.length;j++) 
				{
			    	liste_doublon[j] = liste_generateurs[j];
			    }
			    liste_doublon[liste_generateurs.length] = generateur_pb3;
			    liste_generateurs = liste_doublon;

			  //On ajoute l'arbre correspondant à la famille initiale
			    Nombre arbre_pb3 = new Nombre();
			    arbre_pb3.valeur = generateur_pb3;
			    int [] liste_gen_pb3 = {generateur_pb3};
			    arbre_pb3.liste_generateurs = liste_gen_pb3;
			    fam_pb3=fam_pb3.ajouter_arbre_famille(arbre_pb3);
			    
			    if (nb_trouve == generateur_pb3)
			    {
			    	sol_pb3.liste_solution[0] = arbre_pb3;
			    }
			    
			    if (val_trouvees_pb3.is_in(generateur_pb3))
			   	{
			    	val_trouvees_pb3.ajouter_valeur(generateur_pb3);
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
	    	return(sol_pb3.lire_solution_finale());
	    }
	
		else
			return("entrez des données valides");
	}
}

