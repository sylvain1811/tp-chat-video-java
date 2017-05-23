
package ch.hearc.cours.poo.innerclass.tri;

import java.util.Arrays;
import java.util.Comparator;

public class UseTriMaison
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		int n = 5;
		Maison[] tabMaison = new Maison[n];
		fill(tabMaison);
		//sortV1(tabMaison);
		//sortV2(tabMaison);
		//sortV3(tabMaison);
		sortV4(tabMaison);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Version nulle!
	 */
	private static void sortV1(Maison[] tabMaison)
		{
		//Méthode non satisfaisante car le critère de tri est figer dans le marbre dans la classe Maison
		//On ne peut pas faire varier le critère de tri
		Arrays.sort(tabMaison); // tri sur place,:nécessite que Maison implemente Comparable
		//Autre inconvénient: Technique qui polue la classe maison

		System.out.println(Arrays.toString(tabMaison));
		}

	/**
	 * Version local fléxible, mais lourde car nécessite des classes séparées (MaisonComparator),
	 * qui sont des classes spéciales sans constructeurs et sans attributs
	 *
	 * Mieux que V1, mais trop lourd!
	 */
	private static void sortV2(Maison[] tabMaison)
		{
		//Objectif: Contrairement à V1, on aimerait pouvoir changer facilement le critère de tri et ceci indépendamment du code de la classe Maison
		Arrays.sort(tabMaison, new MaisonComparatorDecroissant());
		System.out.println(Arrays.toString(tabMaison));
		Arrays.sort(tabMaison, new MaisonComparatorCroissant());
		System.out.println(Arrays.toString(tabMaison));
		}

	/**
	 * Version avec classe interne anonyme
	 * Idem que V2, mais avec une syntaxe plus light
	 * Ce qu'on écrit pas ici, c'est le compilateur qui le fait automatiquement pour retomber sur la version V2
	 */
	private static void sortV3(Maison[] tabMaison)
		{
		final int croissant = -1;
		Arrays.sort(tabMaison,new Comparator<Maison>() //On instancie une classe qui n'as pas de nom, mais qui implémente l'interface Comparator
			{
				@Override
				public int compare(Maison maison1, Maison maison2)
					{
					if (Integer.compare(maison1.getPrix(), maison2.getPrix()) == 0)
						{
						return Float.compare(maison1.getSurface(), maison2.getSurface())*croissant;
						}
					else
						{
						return Integer.compare(maison1.getPrix(), maison2.getPrix())*croissant;
						}
					}
			});

		System.out.println(Arrays.toString(tabMaison));
		}

	/**
	 * Variation de V3: réutilisabilité de la classe interne anonyme
	 */
	private static void sortV4(Maison[] tabMaison)
		{
		Comparator<Maison> comparateurDecroissant = new Comparator<Maison>() // A gauche on a une interface et à droite on a une classe interne anonyme qui implémente l'interface
			{
			@Override
			public int compare(Maison maison1, Maison maison2)
				{
				if (Integer.compare(maison1.getPrix(), maison2.getPrix()) == 0)
					{
					return Float.compare(maison1.getSurface(), maison2.getSurface())*croissant;
					}
				else
					{
					return Integer.compare(maison1.getPrix(), maison2.getPrix())*croissant;
					}
				}

			private int croissant = -1; // on peut mettre des attributs dans une classe interne anonyme... même un constructeur mais c'est rare
			};

			Arrays.sort(tabMaison,comparateurDecroissant);
		}

	private static void fill(Maison[] tabMaison)
		{
		int n = tabMaison.length;
		for(int i = 0; i < n - 1; i++)
			{
			tabMaison[i] = new Maison(i + 1, i * 10);
			}
		tabMaison[n - 1] = new Maison(1, 100);
		}
	}
