
package ch.hearc.cours.poo.hello.chrono;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChronoTest
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
	public void testChrono()
		{
		Chrono chrono = new Chrono();
		long tempsAttente = 1000;

		try
			{
			Thread.sleep(tempsAttente);
			}
		catch (Exception e)
			{
			e.printStackTrace();//permet de retrouver l'erreur dans la console
			}

		long deltaTime = chrono.stop();

		assertTrue(Math.abs(deltaTime - tempsAttente) < 10);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
