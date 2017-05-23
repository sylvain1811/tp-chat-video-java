
package ch.hearc.cours.poo.heritage.hello.specialisation;

import ch.hearc.coursjava.moo.heritage.simple.HmTimes;

public class UseHmsTimes
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
		use2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void use1()
		{
		HmsTimes hms = new HmsTimes(1, 2, 3);
		System.out.println(hms);
		hms.set(10, 20); //possible, car hérité de hm et public
		System.out.println(hms);
		hms.set(100, 200, 300);
		System.out.println(hms);
		}

	private static void use2()
		{
		HmsTimes hms = new HmsTimes(1, 2, 3);
		HmTimes hm = hms;

		System.out.println(hms); // affiche 1,2,3
		System.out.println(hm); //affiche type effectif, car c'est le seul qui existe en mémoire
		}

	}
