
package ch.hearc.cours.kitbase.collections.linear.training.equation;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.hearc.cours.kitbase.tools.MathTools;

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
	public void testQuadratique2Solutions()
		{
		double[] tabResultatEmpirique = Quadratique.solve(3, -9, 6);
		double[] tabResultatTheorique = { 2.0, 1.0 };
		assertTrue(tabResultatEmpirique.length == tabResultatTheorique.length);
		Arrays.sort(tabResultatEmpirique);
		Arrays.sort(tabResultatTheorique);
		int i = 0;
		for(double resultatEmpiriqueI:tabResultatEmpirique)
			{
			assertTrue(MathTools.isEquals(resultatEmpiriqueI, tabResultatTheorique[i]));
			i++;
			}
		}

	@Test
	public void testQuadratique1Solution()
		{
		double[] tabResultatEmpirique = Quadratique.solve(3, -6, 3);
		double[] tabResultatTheorique = { 1.0 };
		assertTrue(tabResultatEmpirique.length == tabResultatTheorique.length);
		assertTrue(MathTools.isEquals(tabResultatEmpirique[0], tabResultatTheorique[0]));
		}

	@Test
	public void testQuadratique0Solutions()
		{
		double[] resultatEmpirique = Quadratique.solve(1, 1, 1);
		assertTrue(resultatEmpirique.length == 0);
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
