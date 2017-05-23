
package ch.hearc.cours.kitbase.equation.lineaire;

import com.bilat.tools.io.console.Clavier;

public class UseLineaireClavier
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
		double a;
		do
			{
			a = Clavier.lireDouble("a=");
			} while(a == 0);

		double b = Clavier.lireDouble("b=");

		double x = Lineaire.solve(a, b);
		Lineaire.printSolution(a, b, x);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
