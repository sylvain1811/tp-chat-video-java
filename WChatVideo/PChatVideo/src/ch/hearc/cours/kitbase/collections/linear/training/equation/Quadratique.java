
package ch.hearc.cours.kitbase.collections.linear.training.equation;

import org.junit.Assert;

public class Quadratique
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void printSolution(double a, double b, double c, double[] tabX)
		{
		int n = tabX.length;
		System.out.println(a + "xx + " + b + "x + " + c + " = 0 ssi ");
		for(int i = 0; i < n; i++)
			{
			System.out.println("x" + i + " = " + tabX[i]);
			}
		// sans if!
		}

	public static void printSolution(double[] tabABC, double[] tabX)
		{
		Quadratique.printSolution(tabABC[0], tabABC[1], tabABC[2], tabX); // pas de copier/coller appelle la methode ci-dessus
		}

	/**
	 * la taille du <i>tableau</i> retourné corespond aux nombres de <b>solutions</b>.
	 * taille 0 si pas de solution
	 */
	public static double[] solve(double a, double b, double c)
		{
		Assert.assertTrue(a!=0);
		double discriminant = discriminant(a, b, c);

		if (discriminant < 0)
			{
			return new double[0];
			}
		else if (discriminant == 0)
			{
			// v1
			//				{
			//				double[] tabX = new double[1];
			//				tabX[0] = -b / (2 * a);
			//
			//				return tabX;
			//				}

			// v2 : syntaxe simplifie
				{
				return new double[] { -b / (2 * a) };
				}
			}
		else
			{
			double[] tabX = new double[2];

			tabX[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
			tabX[1] = (-b - Math.sqrt(discriminant)) / (2 * a);

			return tabX;
			}
		}

	public static double[] solve(double[] tabABC)
		{
		return Quadratique.solve(tabABC[0], tabABC[1], tabABC[2]); // pas de copier/coller appelle la methode ci-dessus
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static double discriminant(double a, double b, double c)
		{
		return b * b - 4 * a * c;
		}
	}
