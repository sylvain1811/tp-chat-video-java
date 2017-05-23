
package ch.hearc.cours.poo.thread.hello;

import org.junit.Assert;

public class AddPortion implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Hypothese vecteurs de meme taille
	 */
	public AddPortion(double[] v1, double[] v2, double[] vResult, Intervale intervale)
		{
		//inputs
			{
			Assert.assertTrue(v1.length == v2.length);
			this.v1 = v1;
			this.v2 = v2;
			this.intervale = intervale;
			this.vResult = vResult;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		for(int i = intervale.getiStart(); i <= intervale.getiStop(); i++)
			{
			vResult[i] = v1[i] + v2[i];
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private double[] v1;
	private double[] v2;
	private Intervale intervale;
	private double[] vResult;
	}
