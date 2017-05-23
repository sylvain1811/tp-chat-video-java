
package ch.hearc.cours.poo.hello.quadratique;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuadratiqueTest
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
	public void test2solution()
		{
		Quadratique quadratique = new Quadratique(3, -9, 6);
		quadratique.run();

		double[] tabResultatEmpirique = quadratique.getTabX();
		double[] tabResultatTheorique = { 1.0, 2.0 };

		assertTrue(tabResultatEmpirique.length == tabResultatTheorique.length);

		Arrays.sort(tabResultatTheorique);
		Arrays.sort(tabResultatEmpirique);

		assertTrue(Arrays.equals(tabResultatEmpirique, tabResultatTheorique));//serait plus safe d'employer le math tools et comparaison d'espilon
		}

	@Test
	public void test1solution()
		{
		Quadratique quadratique = new Quadratique(3, -6, 3);
		quadratique.run();

		double[] tabResultatEmpirique = quadratique.getTabX();
		double[] tabResultatTheorique = { 1.0 };

		assertTrue(tabResultatEmpirique.length == tabResultatTheorique.length);
		assertTrue(Arrays.equals(tabResultatEmpirique, tabResultatTheorique));//serait plus safe d'employer le math tools et comparaison d'espilon
		}

	@Test
	public void test0solution()
		{
		Quadratique quadratique = new Quadratique(1, 0, 1);
		quadratique.run();

		double[] tabResultatEmpirique = quadratique.getTabX();

		assertTrue(0 == tabResultatEmpirique.length);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
