
package ch.hearc.cours.poo.heritage.tordu.naif;

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
		useA();
		useB();
		useC();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useA()
		{
		//Partie non-tordu
		A a = new A();
		System.out.println(a.nameClass());//A

		//Partie tordu
		System.out.println(a.nameHierarchie());//A
		}

	private static void useB()
		{
		//Partie non-tordu
		B b = new B();
		System.out.println(b.nameClass());//B

		//Partie tordu
		System.out.println(b.nameHierarchie());//BB au lieu de AB
		}

	private static void useC()
		{
		//Partie non-tordu
		C c = new C();
		System.out.println(c.nameClass());//C

		//Partie tordu
		System.out.println(c.nameHierarchie());//CCC au lieu de ABC
		}

	}
