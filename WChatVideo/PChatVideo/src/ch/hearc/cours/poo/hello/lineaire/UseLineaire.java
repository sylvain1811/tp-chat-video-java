
package ch.hearc.cours.poo.hello.lineaire;



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
		double a = 2;
		double b = 6;
		Lineaire lineaire = new Lineaire(a, b);
		lineaire.run();
		System.out.println(lineaire.getX());
		System.out.println(lineaire);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

