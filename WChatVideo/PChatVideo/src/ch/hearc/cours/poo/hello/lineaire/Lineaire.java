
package ch.hearc.cours.poo.hello.lineaire;

import org.junit.Assert;

public class Lineaire implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Lineaire(double a, double b)
		{
		Assert.assertTrue(a != 0);
		this.a = a;
		this.b = b;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		x = -b / this.a;
		}

	@Override
	public String toString()
		{
		//V1
		//return a + "x + " + b + " = 0 ssi x = " + x;

		//V2 optimiser moins d'objet String instanciés : optenu par eclipse quickfix sur V1
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(a);
		stringBuilder.append(ADD);
		stringBuilder.append(b);
		stringBuilder.append(EQUAL);
		stringBuilder.append(x);
		return stringBuilder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double getX()
		{
		return this.x;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private double a;
	private double b;

	//ouput
	private double x;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	//tools optimisation
	private static final String ADD = "x + "; // une seule instance même si k équations instanciées : optimisation
	private static final String EQUAL = " = 0 ssi x = "; // une seule instance même si k équations instanciées : optimisation
	}
