
package ch.hearc.cours.poo.hello.quadratique;

import java.util.Arrays;

import org.junit.Assert;

public class Quadratique implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * @param a différent de 0
	 * @param b
	 * @param c
	 */
	public Quadratique(double a, double b, double c)
		{
		Assert.assertTrue(a != 0);
		this.a = a;
		this.b = b;
		this.c = c;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		discriminant();
		if (discriminant < 0)
			{
			tabX = new double[0];
			}
		else if (discriminant == 0)
			{
			//V1
			//				{
			//				tabX = new double[1];
			//				tabX[0] = -b / (2 * a);
			//				}

			//V2
				{
				tabX = new double[] { -b / (2 * a) };
				}
			}
		else
			{
			tabX = new double[2];
			tabX[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
			tabX[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
			}
		}

	@Override
	public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(a);
		stringBuilder.append(CHAINE1);
		stringBuilder.append(b);
		stringBuilder.append(CHAINE2);
		stringBuilder.append(c);
		stringBuilder.append(CHAINE3);
		stringBuilder.append(Arrays.toString(tabX));
		return stringBuilder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double[] getTabX()
		{
		return this.tabX;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void discriminant()
		{
		discriminant = b * b - 4 * a * c;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private double a;
	private double b;
	private double c;

	//output
	private double[] tabX;

	//tools
	private double discriminant;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/
	private static final String CHAINE1 = " x^2 + ";
	private static final String CHAINE2 = " x + ";
	private static final String CHAINE3 = " = 0 ssi x = ";

	}
