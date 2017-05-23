
package ch.hearc.cours.kitbase.collections.linear.training.equation;

import com.bilat.tools.io.console.Clavier;

public class UseQuadratiqueClavier
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void main()
		{
		double a;
		do
			{
			a = Clavier.lireDouble("a=");
			} while(a == 0);

		double b = Clavier.lireDouble("b=");
		double c = Clavier.lireDouble("c=");

		double[] tabX = Quadratique.solve(a, b, c);
		Quadratique.printSolution(a, b, c, tabX);
		}

	}
