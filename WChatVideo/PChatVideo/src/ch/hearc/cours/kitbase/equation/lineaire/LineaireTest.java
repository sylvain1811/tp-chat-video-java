package ch.hearc.cours.kitbase.equation.lineaire;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LineaireTest
{
/*------------------------------------------------------------------*\
	 |*							Constructeurs							*|
	 \*------------------------------------------------------------------*/

@Before public void before()
	{
	// rien
	}

@After public void after()
	{
	// rien
	}

/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

@Test public void testLineaire1()
	{
	double resultatEmpirique = Lineaire.solve(3, 6);
	double resultatTheorique = -2;
	assertTrue(resultatEmpirique==resultatTheorique);
	}

@Test public void testLineaire2()
	{
	double resultatEmpirique = Lineaire.solve(2, 4);
	double resultatTheorique = -2;
	assertTrue(resultatEmpirique==resultatTheorique);
	}

/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

}