
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
		//M�thode non satisfaisante car le crit�re de tri est figer dans le marbre dans la classe Maison
		//On ne peut pas faire varier le crit�re de tri
		Arrays.sort(tabMaison); // tri sur place,:n�cessite que Maison implemente Comparable
		//Autre inconv�nient: Technique qui polue la classe maison

		System.out.println(Arrays.toString(tabMaison));
		}

	/**
	 * Version local fl�xible, mais lourde car n�cessite des classes s�par�es (MaisonComparator),
	 * qui sont des classes sp�ciales sans constructeurs et sans attributs
	 *
	 * Mieux que V1, mais trop lourd!
	 */
	private static void sortV2(Maison[] tabMaison)
		{
		//Objectif: Contrairement � V1, on aimerait pouvoir changer facilement le crit�re de tri et ceci ind�pendamment du code de la classe Maison
		Arrays.sort(tabMaison, new MaisonComparatorDecroissant());
		System.out.println(Arrays.toString(tabMaison));
		Arrays.sort(tabMaison, new MaisonComparatorCroissant());
		System.out.println(Arrays.toString(tabMaison));
		}

	/**
	 * Version avec classe interne anonyme
	 * Idem que V2, mais avec une syntaxe plus light
	 * Ce qu'on �crit pas ici, c'est le compilateur qui le fait automatiquement pour retomber sur la version V2
	 */
	private static void sortV3(Maison[] tabMaison)
		{
		final int croissant = -1;
		Arrays.sort(tabMaison,new Comparator<Maison>() //On instancie une classe qui n'as pas de nom, mais qui impl�mente l'interface Comparator
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
	 * Variation de V3: r�utilisabilit� de la classe interne anonyme
	 */
	private static void sortV4(Maison[] tabMaison)
		{
		Comparator<Maison> comparateurDecroissant = new Comparator<Maison>() // A gauche on a une interface et � droite on a une classe interne anonyme qui impl�mente l'interface
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

			private int croissant = -1; // on peut mettre des attributs dans une classe interne anonyme... m�me un constructeur mais c'est rare
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
