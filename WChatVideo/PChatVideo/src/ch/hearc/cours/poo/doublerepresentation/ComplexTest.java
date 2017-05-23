
package ch.hearc.cours.poo.doublerepresentation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComplexTest
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
	public void testAdd()
		{
		Complex z1 = new Complex(3, 4);
		Complex z2 = new Complex(7, 8);
		Complex resultatTheorique = new Complex(10, 12);
		Complex resultatEmpirique = z1.add(z2);
		//		Assert.assertTrue(resultatTheorique == resultatEmpirique);//Faux car comparaison de deux référence et pas comparaison de contenu l'assertion échouerait chaque fois
		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testSub()
		{
		Complex z1 = new Complex(3, 4);
		Complex z2 = new Complex(2, 8);

		Complex resultatTheorique = new Complex(1, -4);
		Complex resultatEmpirique = z1.sub(z2);

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testOpposit()
		{
		Complex z1 = new Complex(3, 4);

		Complex resultatTheorique = new Complex(-3, -4);
		Complex resultatEmpirique = z1.opposit();

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testMultScalar()
		{
		Complex z1 = new Complex(3, 2);
		double scalar = 2.5;

		Complex resultatTheorique = new Complex(7.5, 5);
		Complex resultatEmpirique = z1.mult(scalar);

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testMultComplex()
		{
		Complex z1 = Complex.createPolaire(3, 2);
		Complex z2 = Complex.createPolaire(5, 6);

		Complex resultatTheorique = Complex.createPolaire(15, 8);
		Complex resultatEmpirique = z1.mult(z2);

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testDivScalar()
		{
		Complex z1 = new Complex(3, 2);
		double scalar = 2;

		Complex resultatTheorique = new Complex(3 / (double)2, 1);
		Complex resultatEmpirique = z1.div(scalar);

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testDivComplex()
		{
		Complex z1 = Complex.createPolaire(3, 2);
		Complex z2 = Complex.createPolaire(5, 6);

		Complex resultatTheorique = Complex.createPolaire(3 / (double)5, -4);
		Complex resultatEmpirique = z1.div(z2);

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testPow()
		{
		Complex z1 = Complex.createPolaire(3, 2);
		int n = 3;

		Complex resultatTheorique = Complex.createPolaire(27, 6);
		Complex resultatEmpirique = z1.pow(n);

		Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
		}

	@Test
	public void testGravity()
		{
		int n = 1000;

		for(int nbPoints = 10; nbPoints < n; nbPoints++)
			{
			double mod = 5;
			double deltaArg = (2 * Math.PI / nbPoints);
			Complex[] tabComplex = new Complex[nbPoints];
			Complex centre = new Complex(12, 8);

			for(int i = 0; i < nbPoints; i++)
				{
				tabComplex[i] = Complex.createPolaire(mod, i * deltaArg).add(centre);
				}

			Complex resultatEmpirique = Complex.createGravity(tabComplex);
			Complex resultatTheorique = centre;

			Assert.assertTrue(resultatTheorique.isEquals(resultatEmpirique));
			}
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
