
package ch.hearc.cours.kitbase.collections.linear.tab2d;

import java.util.Random;

public class Tab2D
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Syntaxe manuel generalisable pour les tableau 2d triangulaire et heterogene
	 * Equivalent a create ci-dessous en terme de resultat
	 */
	public static double[][] createRectangulaireManuel(int n, int m)
		{
		double[][] tabExterne = new double[n][];
		for(int i = 0; i < n; i++)
			{
			double[] tabInterne = new double[m];
			tabExterne[i] = tabInterne;
			}
		return tabExterne;
		}

	public static double[][] create(int n, int m)
		{
		return new double[n][m];
		}

	public static double[][] createTriangulaire(int n)
		{
		double[][] tabExterne = new double[n][];
		for(int i = 0; i < n; i++)
			{
			double[] tabInterne = new double[i + 1];
			tabExterne[i] = tabInterne;
			}
		return tabExterne;
		}

	public static double[][] createHeterogene(int[] tabCologneParLigne)
		{
		int n = tabCologneParLigne.length;
		double[][] tabExterne = new double[n][];
		for(int i = 0; i < n; i++)
			{
			double[] tabInterne = new double[tabCologneParLigne[i]];
			tabExterne[i] = tabInterne;
			}
		return tabExterne;
		}

	public static void printV1(double[][] tab)
		{
		int n = tab.length;

		for(int i = 0; i < n; i++)
			{
			int mi = tab[i].length;
			for(int j = 0; j < mi; j++)
				{
				System.out.print(tab[i][j] + " ");
				}
			System.out.println("");
			}
		}

	public static void printV2(double[][] tab)
		{
		for(double[] ligne:tab)
			{
			for(double element:ligne)
				{
				System.out.print(element + " ");
				}
			System.out.println("");
			}
		}

	public static void fill(double[][] tab)
		{
		Random rand = new Random();
		for(double[] ligne:tab)
			{
			int mLine = ligne.length;
			for(int i = 0; i < mLine; i++)
				{
				ligne[i] = rand.nextDouble() * 100;
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
