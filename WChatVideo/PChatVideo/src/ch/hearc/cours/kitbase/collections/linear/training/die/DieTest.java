
package ch.hearc.cours.kitbase.collections.linear.training.die;

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
		int resultatEmpirique = Die.moyenneur(6, Integer.MAX_VALUE / 10000);
		int resultatTheorique = 15;
		assertTrue(resultatEmpirique == resultatTheorique);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
