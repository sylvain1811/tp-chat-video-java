
package ch.hearc.cours.poo.template.pile.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.hearc.cours.poo.interfaces.entrainement.implementations.Banane;
import ch.hearc.cours.poo.template.pile.implementations.PileArrayList;
import ch.hearc.cours.poo.template.pile.implementations.PileLinkedList;
import ch.hearc.cours.poo.template.pile.specification.Pile_I;

public class TestPile
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

	/*-----------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*-----------------------------------------------------------------*/

	@Test
	public void testPile()
		{
		Pile_I<Banane> pileArray = new PileArrayList<Banane>();
		Pile_I<Banane> pileLinked = new PileLinkedList<Banane>();

		test(pileArray);
		test(pileLinked);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void test(Pile_I<Banane> maPile)
		{
		Banane b1 = new Banane("adsd", 12);
		Banane b2 = new Banane("adsd", 2);

		assertTrue(maPile.isEmpty());
		assertTrue(maPile.push(b1));
		assertTrue(maPile.push(b2));

		assertTrue(maPile.size() == 2);

		assertTrue(maPile.pop() == b2);
		assertTrue(maPile.pop() == b1);

		assertTrue(maPile.size() == 0);
		assertTrue(maPile.isEmpty());
		}

	}
