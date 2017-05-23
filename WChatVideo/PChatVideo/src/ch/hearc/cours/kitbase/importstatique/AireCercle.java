
package ch.hearc.cours.kitbase.importstatique;

import static java.lang.Math.PI;

import org.junit.Assert;

public class AireCercle
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static double aireCercle(double rayon)
		{
		Assert.assertTrue(rayon >= 0);
		//v1
			{
			//return Math.PI * rayon * rayon;
			}
		//v2
			{
			return PI * rayon * rayon;
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
