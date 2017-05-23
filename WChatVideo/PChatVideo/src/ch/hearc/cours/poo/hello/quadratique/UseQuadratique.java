
package ch.hearc.cours.poo.hello.quadratique;

public class UseQuadratique
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
		double a = -2;
		double b = 6;
		double c = -4;
		Quadratique quadratique = new Quadratique(a, b, c);
		quadratique.run();
		System.out.println(quadratique);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
