
package ch.hearc.cours.kitbase.equation.lineaire;

public class Lineaire
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static double solve(double a, double b)
		{
		return -b / a;
		}

	public static void printSolution(double a, double b, double x)
		{
		System.out.println(a + "x+" + b + " = 0 ssi x=" + x);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
