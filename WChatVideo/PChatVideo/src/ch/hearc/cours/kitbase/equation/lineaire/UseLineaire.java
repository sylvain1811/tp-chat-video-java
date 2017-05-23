
package ch.hearc.cours.kitbase.equation.lineaire;

public class UseLineaire
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
		use1();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void use1()
		{
		double a = 3;
		double b = 6;

		double x = Lineaire.solve(a, b);
		Lineaire.printSolution(a, b, x);
		}
	}
