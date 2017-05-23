
package ch.hearc.cours.poo.interfaces.hello.implementations;

import ch.hearc.cours.poo.interfaces.hello.specifications.A_I;

public class A implements A_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void a(String s)
		{
		System.out.println("a" + s);
		}

	public void specificA()
		{
		System.out.println("Specific A");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
