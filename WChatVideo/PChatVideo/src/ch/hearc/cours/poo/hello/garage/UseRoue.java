
package ch.hearc.cours.poo.hello.garage;

public class UseRoue
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
		System.out.println(Roue.getCompteur());
		Roue r1 = new Roue("Marque", 3);
		Roue r2 = new Roue("Marque2", 3);
		System.out.println(Roue.getCompteur());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
