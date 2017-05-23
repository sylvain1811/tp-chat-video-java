
package ch.hearc.cours.poo.interfaces.hello.implementations;

import ch.hearc.cours.poo.interfaces.hello.specifications.AB_I;

public class AB implements AB_I
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

	@Override
	public void b(String s)
		{
		System.out.println("b" + s);
		}

	@Override
	public void ab(String s)
		{
		System.out.println("ab" + s);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
