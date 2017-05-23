
package ch.hearc.cours.poo.interfaces.hello.use;

import ch.hearc.cours.poo.interfaces.hello.implementations.A;
import ch.hearc.cours.poo.interfaces.hello.implementations.AB;
import ch.hearc.cours.poo.interfaces.hello.implementations.B;
import ch.hearc.cours.poo.interfaces.hello.specifications.AB_I;
import ch.hearc.cours.poo.interfaces.hello.specifications.A_I;
import ch.hearc.cours.poo.interfaces.hello.specifications.B_I;

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
		useSimple();
		usePolymorphisme();
		}

	private static void usePolymorphisme()
		{
		A_I a = new A();
		B_I b = new B();
		AB_I ab = new AB();

		a.a("aa");
		// a.specificA(); Impossible car specificA n'appartient pas à A_I (bien que specificA appartient à A)
		b.b("bb");

		ab.ab("abab");
		ab.a("aba");
		ab.b("abb");
		}

	private static void useSimple()
		{
		A a = new A();
		B b = new B();
		AB ab = new AB();

		a.a("aa");
		a.specificA();
		b.b("bb");

		ab.ab("abab");
		ab.a("aba");
		ab.b("abb");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
