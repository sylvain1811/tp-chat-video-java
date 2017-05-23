
package ch.hearc.cours.poo.thread.hello;

import java.util.Arrays;

public class UseAdd
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
		int n = 10;
		double[] v1 = createV1(n);
		double[] v2 = createV2(n);

		 AddVecteur addVecteur = new AddVecteur(v1, v2);
		 addVecteur.run();
		 double[] vResult = addVecteur.getvResult();
		 System.out.println(Arrays.toString(vResult));
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static double[] createV1(int n)
		{
		double[] v1 = new double[n];
		for(int i = 0; i < n; i++)
			{
			v1[i] = i+1;
			}
		return v1;
		}

	private static double[] createV2(int n)
		{
		double[] v2 = new double[n];
		for(int i = 0; i < n; i++)
			{
			v2[i] = (i+1)*100;
			}
		return v2;
		}

	}

