
package ch.hearc.cours.poo.hello.die;

public class UseDie
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
		int nbFaces = 6;
		int nbExperiences = Integer.MAX_VALUE / 10000;
		Die die = new Die(nbFaces, nbExperiences);
		die.run();
		System.out.println(die);
		}

	}
