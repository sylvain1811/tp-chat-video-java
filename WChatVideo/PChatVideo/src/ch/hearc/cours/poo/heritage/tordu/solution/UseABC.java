
package ch.hearc.cours.poo.heritage.tordu.solution;

public class UseABC
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
		System.out.println("solution");
		useA();
		useB();
		useC();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useA()
		{

		A a = new A();


		//Partie tordu
		System.out.println(a.nameHierarchie());//A
		}

	private static void useB()
		{
		B b = new B();

		//Partie tordu
		System.out.println(b.nameHierarchie());//BB au lieu de AB
		}

	private static void useC()
		{
		C c = new C();

		//Partie tordu
		System.out.println(c.nameHierarchie());//CCC au lieu de ABC
		}

	}
