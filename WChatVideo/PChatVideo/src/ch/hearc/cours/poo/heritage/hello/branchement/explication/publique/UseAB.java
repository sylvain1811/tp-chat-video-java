
package ch.hearc.cours.poo.heritage.hello.branchement.explication.publique;



public class UseAB
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
		B b = new B();
		b.mm(); // affiche mb car le type effectif (sur m) gagne

		A a = b; // autoriser car b est un A
		a.mm(); // affiche mb car le type effectif (sur m) gagne
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

