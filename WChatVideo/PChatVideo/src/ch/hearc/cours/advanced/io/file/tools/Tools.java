
package ch.hearc.cours.advanced.io.file.tools;

import java.util.Arrays;

public class Tools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static double[] create(int n)
		{
		double[] tableau = new double[n];
		for(int i = 0; i < n; i++)
			{
			tableau[i] = i + 0.1;
			}

		return tableau;
		}

	public static void print(double[] tab)
		{
		System.out.println(Arrays.toString(tab));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
