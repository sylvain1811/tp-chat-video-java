
package ch.hearc.cours.kitbase.importstatique;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AireCercleTest
	{
	/*------------------------------------------------------------------*\
		 |*							Constructeurs							*|
		 \*------------------------------------------------------------------*/

	@Before
	public void before()
		{
		// rien
		}

	@After
	public void after()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
		 |*							Methodes Public							*|
		 \*-----------------------------------------------------------------*/

	@Test
	public void testAireCercle()
		{
		double rayon = 10;
		double resultatEmpirique = AireCercle.aireCercle(rayon);
		double resultatTheorique = Math.PI * rayon * rayon;

		assertTrue(resultatEmpirique == resultatTheorique);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
