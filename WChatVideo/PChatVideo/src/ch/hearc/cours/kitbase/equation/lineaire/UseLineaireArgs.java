
package ch.hearc.cours.kitbase.equation.lineaire;

public class UseLineaireArgs
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * 2 6
	 * Separateur ESPACE
	 * Le premier est a, le second est b
	 * ax+b=0
	 */
	public static void main(String[] args)
		{
		int n = args.length;
		if (n == 2)
			{
			double a = Double.valueOf(args[0]);
			double b = Double.valueOf(args[1]);
			double x = Lineaire.solve(a, b);
			Lineaire.printSolution(a, b, x);
			}
		else
			{
			System.err.println("Arg invalide");
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
