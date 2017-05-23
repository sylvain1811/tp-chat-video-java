
package ch.hearc.cours.poo.hello.die;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DieTest
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
	public void testDie()
		{
		int nbFaces = 6;
		int nbExperiences = Integer.MAX_VALUE / 10000;
		Die die = new Die(nbFaces, nbExperiences);
		die.run();

		int resultatEmpirique = die.getNbLancersMoyens();
		int resultatTheorique = 15;

		assertTrue(resultatEmpirique == resultatTheorique);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
