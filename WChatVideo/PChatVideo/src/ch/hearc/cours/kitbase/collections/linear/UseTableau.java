
package ch.hearc.cours.kitbase.collections.linear;

import java.util.Arrays;

public class UseTableau
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
		double[] tab = new double[n];
		work(tab);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void work(double[] tab)
		{
		fill(tab);
		print(tab);
		}

	private static void print(double[] tab)
		{
		//V1
			{
			int n = tab.length;
			for(int i = 0; i < n; i++)
				{
				System.out.println(tab[i]);
				}
			}

		System.out.println();

		//V2
			{
			for(double element:tab)
				{
				System.out.println(element);
				}
			}

		System.out.println();

		//V3: Pas de chance ne marche pas.
			{
			System.out.println(tab);
			}

		System.out.println();

		//V5: la meilleure
			{
			System.out.println(Arrays.toString(tab));
			}

		}

	private static void fill(double[] tab)
		{
		int n = tab.length;
		for(int i = 0; i < n; i++)
			{
			tab[i] = Math.PI * i;
			}
		}
	}
