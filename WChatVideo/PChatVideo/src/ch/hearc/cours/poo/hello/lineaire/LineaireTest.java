package ch.hearc.cours.poo.hello.lineaire;

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
	Lineaire lineaire=new Lineaire(2, -1);
	lineaire.run();

	double resultatEmpirique=lineaire.getX();
	double resultatTheorique=0.5;

	assertTrue(resultatEmpirique==resultatTheorique);
	}

@Test public void testLineaire2()
	{
	Lineaire lineaire=new Lineaire(-3, 3);
	lineaire.run();

	double resultatEmpirique=lineaire.getX();
	double resultatTheorique=1;

	assertTrue(resultatEmpirique==resultatTheorique);
	}

/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

}