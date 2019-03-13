package jeux_des_nombresV2;
import java.util.Arrays;
import java.util.Scanner;
// debut class mainClassV2
public class mainClasseV2 {
	public static void main(String[] args)
	{
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
	   
		        //Vérifie que la rréponse est valide
		        if(mode != '1' && mode != '2' && mode != '3')

		        	System.out.println("Mode inconnu, veuillez réitérer votre choix.");


	    	}while (mode != '1' && mode != '2' && mode != '3');
	      
	    	if(mode == '1')
	    	{
	    		//Saisie du générateur

			    System.out.println("Entrer un entier générateur :");
			    
			    int generateur_pb1 = sc.nextInt();
			    //Pensez à vider la ligne lue
			    sc.nextLine();

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
			    	//Creation de la nouvelle famille
			    	Arbre [] init = {};
			    	Famille fam_nvlle_etape_pb1 = new Famille(etape, init);
			    	
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
			    			//On effectue les 4 opérations			    				
			    				Addition add_pb1 = new Addition();
			    				add_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    					
			    				Soustraction sous_pb1 = new Soustraction();
		    					sous_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    					
		    					Multiplication mult_pb1 = new Multiplication();
		    					mult_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    						
		    					Division div_pb1 = new Division();
		    					div_pb1.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    				
		    					//Regroupement des résultats dans la liste "nouv_arbres"
	    						Arbre [] nouv_arbres_pb1 = {add_pb1,sous_pb1,mult_pb1,div_pb1};
	    						
	    						//Ajout ou non des nouveaux arbres dans la solution
	    						for (Arbre arbres_pb1 : nouv_arbres_pb1)
	    						{
	    							//Regarde si la valeur n'a pas déjà été trouvée dans le passé
	    							if (!val_trouvees_pb1.is_in(arbres_pb1.valeur))
	    							{
	    								val_trouvees_pb1=val_trouvees_pb1.ajouter_valeur(arbres_pb1.valeur);
	    								
	    								//Regarde si la valeur est solution
	    								if (arbres_pb1.valeur <= generateur_pb1)
	    									sol_pb1=sol_pb1.ajouter_arbre_solution(arbres_pb1);//si oui, on l'ajoute à la liste des solutions
	    							}
	    							
	    							//Met à jour la famille pour les valeurs retenues
	    							fam_nvlle_etape_pb1=fam_nvlle_etape_pb1.ajouter_arbre_famille(arbres_pb1);
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
			    //sol_pb1=sol_pb1.tri_solutions();
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
			    Arbre [] liste_solution_pb2 = new Arbre[1];
			    liste_solution_pb2[0]=arbre_pb2;
			    Solutions sol_pb2 = new Solutions(liste_solution_pb2);
		//Debut de la boucle principale de calculs des arbres
			    int etape = 1;
			    while (etape <= nombre_d_ope)	    
			    {  	
			    	//Creation de la nouvelle famille
			    	Arbre [] init = {};
			    	Famille fam_nvlle_etape_pb2 = new Famille(etape, init);
			    	
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
			    				//if (etape == 1 || famillei.liste_famille_arbre[i1].valeur!=0)
			    				//{
			    					//if (etape == 1 || famillej.liste_famille_arbre[j1].valeur!=0)
			    				if (famillei.liste_famille_arbre[i1].valeur!=0 && famillej.liste_famille_arbre[j1].valeur!=0)	
			    					{
			    						Addition add_pb2 = new Addition();
					    				add_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
					    					
					    				Soustraction sous_pb2 = new Soustraction();
				    					sous_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
				    					
				    					Multiplication mult_pb2 = new Multiplication();
				    					mult_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
				    						
				    					Division div_pb2 = new Division();
				    					div_pb2.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
					    				
				    					//Regroupement des résultats dans la liste "nouv_arbres"
			    						Arbre [] nouv_arbres_pb2 = {add_pb2,sous_pb2,mult_pb2,div_pb2};
			    						
			    						//Ajout ou non des nouveaux arbres dans la solution
			    						for (Arbre arbres_pb2 : nouv_arbres_pb2)
			    						{
			    							//On rajoute ces valeurs à la famille en cours de remplissage
			    							fam_nvlle_etape_pb2=fam_nvlle_etape_pb2.ajouter_arbre_famille(arbres_pb2);
			    							
			    							//On n'ajoute ces valeurs à la solution que si elles ont le bon nombre d'opération
			    							if (nombre_d_ope == etape && arbres_pb2.valeur <= generateur_pb2)
			    							{    								
			    								//Et si on ne les a pas encore trouvées avant
			    								if (!val_trouvees_pb2.is_in(arbres_pb2.valeur))
			    								{
				    								//if (sol_pb2.liste_solution.length == 1 && sol_pb2.liste_solution[0].valeur==generateur_pb2) 
				    								//{
				    								//	sol_pb2.liste_solution[0]=arbre_pb2;
				    								//}
				    								//else
				    								//{
				    								sol_pb2=sol_pb2.ajouter_arbre_solution(arbres_pb2);
				    								//}
				    								val_trouvees_pb2 = val_trouvees_pb2.ajouter_valeur(arbres_pb2.valeur);	
				    						
			    								}
			    							}
			    						}
			    					//}
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
			    //sol_pb2=sol_pb2.tri_solutions();
			    
			    if (nombre_d_ope != 0)
			    {
			    	
			    	Solutions solution = new Solutions();
			    	Arbre [] sol = new Arbre[sol_pb2.liste_solution.length-1];
			    	solution.liste_solution=sol;
			    	for (int i=0; i<sol_pb2.liste_solution.length-1;i++)
			    	{
			    		solution.liste_solution[i]=sol_pb2.liste_solution[i+1];
			    	}
			    	sol_pb2 = solution;
			    }
			    System.out.println(sol_pb2.lire_solution_finale());
	    	}
	    
	    if (mode == '3')
	    {   	
	    	System.out.println("Combien d'entiers générateurs utiliserez-vous ?");
		    
		    int nb_entier = sc.nextInt();
		    //Pensez à vider la ligne lue
		    sc.nextLine();
		    
		    int [] liste_generateurs = new int[nb_entier];
		    int nb = 0;		   
		    
	    		while (nb < nb_entier)
	    		{
	    			System.out.println("Entrer un nouveau générateur");
				    
				    int generateur_pb3 = sc.nextInt();
				    //Pensez à vider la ligne lue
				    sc.nextLine();
				    
				    liste_generateurs[nb] = generateur_pb3;
				    				    
				    Nombre arbre_pb3 = new Nombre();
				    arbre_pb3.valeur = generateur_pb3;
				    int [] liste_gen_pb3 = {generateur_pb3};
				    arbre_pb3.liste_generateurs = liste_gen_pb3;
				    
				    nb+=1;
	    		}
	    		
		  //Initialisation du pb 3
	    		

			    //Initialisation de l'arbre générateur :
	    		Nombre arbre_pb3 = new Nombre();//Eviter l'erreur
			    arbre_pb3.valeur = 1;//Eviter l'erreur
	    		
			    //Initialisation de Famille
			    Arbre [] liste_arbre_pb3 = new Arbre[1];
			    liste_arbre_pb3[0] = arbre_pb3;
			    Famille fam_pb3 = new Famille(0,liste_arbre_pb3);
			    
			    //Initialisation de Foret
			    Famille [] liste_fam_pb3 = new Famille[1];
			    liste_fam_pb3[0] = fam_pb3;
			    Foret for_pb3 = new Foret(liste_fam_pb3);
			    
			    //Initialisation de Valeurs_trouvees
			    int [] liste_val_pb3 = new int[1];
			    liste_val_pb3[0] = arbre_pb3.valeur;
			    Valeurs_trouvees val_trouvees_pb3 = new Valeurs_trouvees(liste_val_pb3);
			    
			    //Initialisation de Solutions
			    Arbre [] liste_solution_pb3 = new Arbre[1];
			    liste_solution_pb3[0]=arbre_pb3;
			    Solutions sol_pb3 = new Solutions(liste_solution_pb3);
			    int taille = sol_pb3.liste_solution.length;
			    
		//Debut de la boucle principale de calculs des arbres
			    int etape = 1;
			    while (taille <= 1)//Eviter l'erreur	    
			    {  	
			    	//Creation de la nouvelle famille
			    	Arbre [] init = {};
			    	Famille fam_nvlle_etape_pb3 = new Famille(etape, init);
			    	
			    	//Preparation de la boucle principale
			    	int i = 0;
			    	int j = etape-1;
			    	while (i<=j)//Permet de donner les couples de familles à combiner par des opérations		
			    		{
			    	
			    	//Pacours des familles complémentaires
			    		
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
			    			//On effectue les 4 opérations			    				
			    				Addition add_pb3 = new Addition();
			    				add_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    					
			    				Soustraction sous_pb3 = new Soustraction();
		    					sous_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    					
		    					Multiplication mult_pb3 = new Multiplication();
		    					mult_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
		    						
		    					Division div_pb3 = new Division();
		    					div_pb3.operation(famillei.liste_famille_arbre[i1],famillej.liste_famille_arbre[j1]);
			    				
		    					//Regroupement des résultats dans la liste "nouv_arbres"
	    						Arbre [] nouv_arbres_pb3 = {add_pb3,sous_pb3,mult_pb3,div_pb3};
	    						
	    						//Ajout ou non des nouveaux arbres dans la solution
	    						for (Arbre arbres_pb3 : nouv_arbres_pb3)
	    						{
	    							//Regarde si la valeur n'a pas déjà été trouvée dans le passé
	    							if (!val_trouvees_pb3.is_in(arbres_pb3.valeur))
	    							{
	    								val_trouvees_pb3=val_trouvees_pb3.ajouter_valeur(arbres_pb3.valeur);
	    								
	    								//Regarde si la valeur est solution
	    								//if (arbres_pb3.valeur <= generateur_pb3)
	    								if (arbres_pb3.valeur <= 1)//Eviter l'erreur
	    									sol_pb3=sol_pb3.ajouter_arbre_solution(arbres_pb3);//si oui, on l'ajoute à la liste des solutions
	    							}
	    							
	    							//Met à jour la famille pour les valeurs retenues
	    							fam_nvlle_etape_pb3=fam_nvlle_etape_pb3.ajouter_arbre_famille(arbres_pb3);
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
			    	taille = sol_pb3.liste_solution.length;
			    }
			    
		//Une fois la solution trouvées, on la trie, puis on afficher le résultat
			    //sol_pb3=sol_pb3.tri_solutions();
			    System.out.println(sol_pb3.lire_solution_finale());
	      }
	
	     

	      //On invite l'utilisateur à recommencer ou à quitter

	      do{       

	        System.out.println("Souhaitez-vous rejouer ? (O/N)");
	        reponse = sc.nextLine().charAt(0);
	       

	      }while(reponse != 'O' && reponse != 'N');

	    

	    }while(reponse == 'O');

	    

	  System.out.println("Au revoir !");
	  sc.close();
	  

	  //Fin de programme

	  

	    

	 		
		
		
		
		
		
		
		
		
		
		
		Nombre sept = new Nombre();
		sept.valeur = 7;
		Nombre un = new Nombre();
		un.valeur = 1;
		Soustraction arbre0 = new Soustraction();
		arbre0.arbre1 = sept;
		arbre0.arbre2 = un;
		arbre0.valeur = 6;
		Addition arbre00 = new Addition();
		arbre00.arbre1 = sept;
		arbre00.arbre2 = un;
		arbre00.valeur = 8;
		//System.out.println(arbre0.toString());
		//System.out.println(un.lire_solution());
		//System.out.println(sept.lire_solution());
		//System.out.println(arbre0.lire_solution());
		Soustraction arbre3 = new Soustraction();
		Addition arbre4 = new Addition();
		arbre4 = arbre00;
		arbre3 = arbre0;
		//arbre4 = arbre00.operation(arbre0);
		//arbre3 = arbre0.operation(arbre0);
		//System.out.println(arbre3.arbre1 + "\n Suivi de : \n " + arbre3.arbre2 + "\n Puis de sa valeur : \n " + arbre3.valeur);
		//System.out.println(arbre3);
		//System.out.println(arbre3.lire_solution());
		
		Arbre [] liste = new Arbre[3];
		liste[0]=un;
		liste[1]=sept;
		liste[2]=arbre0;
		Arbre [] liste1 = new Arbre[1];
		liste1[0]=arbre3;		
		Arbre [] liste2 = new Arbre[4];
		Solutions nouvelle_liste = new Solutions(liste);
		Solutions nouvelle_liste1 = new Solutions(liste1);
		Solutions nouvelle_liste2 = new Solutions();
		nouvelle_liste2 = nouvelle_liste.ajouter_arbre_solution(arbre4);
		//nouvelle_liste.ajouter_arbre_solution(un);
		//nouvelle_liste.ajouter_arbre_solution(arbre0);
		//nouvelle_liste.ajouter_arbre_solution(arbre3);
		//nouvelle_liste.ajouter_arbre_solution(arbre4);
		//Arbre [] liste = new Arbre[5];
		//System.out.println(nouvelle_liste2.liste_solution[0].toString());
		//System.out.println(nouvelle_liste2.liste_solution[1].toString());
		//System.out.println(nouvelle_liste2.liste_solution[2].toString());
		//System.out.println(nouvelle_liste2.liste_solution[3].toString());
		//System.out.println(nouvelle_liste2.lire_solution_finale());
		
		Famille fam1 = new Famille(0,liste);
		Famille fam2 = new Famille(1,liste1);
		fam1.liste_famille_arbre[0]=sept;
		fam1.liste_famille_arbre[0]=un;
		fam1= fam1.ajouter_arbre_famille(un);
		fam1 = fam1.ajouter_arbre_famille(sept);
		Famille famtest []= new Famille[2];
		famtest[0]=fam1;
		famtest[1]=fam2;
		fam2 = fam2.ajouter_arbre_famille(arbre0);
		Foret for1 = new Foret(famtest);
		for1.ajouter_famille(fam2);
		//System.out.println(nouvelle_liste2.liste_solution[0].toString());
		Famille nouvelle_liste3 = new Famille(0,liste);
		Famille nouvelle_liste4 = new Famille(1,liste1);
		Famille nouvelle_liste5 = new Famille();
		//System.out.println(nouvelle_liste3.liste_famille_arbre[0].toString());
		//System.out.println(nouvelle_liste3.liste_famille_arbre[1].toString());
		
		
	}
	
}
