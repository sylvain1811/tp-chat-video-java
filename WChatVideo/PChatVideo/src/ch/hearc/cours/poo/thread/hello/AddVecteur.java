
package ch.hearc.cours.poo.thread.hello;

import java.util.Arrays;

import org.junit.Assert;

public class AddVecteur implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public AddVecteur(double[] v1, double[] v2)
		{
		//inputs
			{
			Assert.assertTrue(v1.length == v2.length);
			this.v1 = v1;
			this.v2 = v2;
			}

		//outputs
			{
			vResult = new double[v1.length];
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("AddVecteur [v1=");
		builder.append(Arrays.toString(this.v1));
		builder.append(", v2=");
		builder.append(Arrays.toString(this.v2));
		builder.append(", vResult=");
		builder.append(Arrays.toString(this.vResult));
		builder.append("]");
		return builder.toString();
		}

	@Override
	public void run()
		{
		int middle = vResult.length / 2;

		Intervale interval1 = new Intervale(0, middle);
		Intervale interval2 = new Intervale(middle + 1, vResult.length - 1);

		AddPortion addPortion1 = new AddPortion(v1, v2, vResult, interval1);
		AddPortion addPortion2 = new AddPortion(v1, v2, vResult, interval2);

		//versionSequentiel(addPortion1, addPortion2);
		versionParallel(addPortion1, addPortion2);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public double[] getvResult()
		{
		return this.vResult;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void versionSequentiel(AddPortion addPortion1, AddPortion addPortion2)
		{
		addPortion1.run();
		addPortion2.run();
		}

	private void versionParallel(AddPortion addPortion1, AddPortion addPortion2)
		{
		Thread thread1 = new Thread(addPortion1);
		Thread thread2 = new Thread(addPortion2);

		thread1.start();
		thread2.start();

		try
			{
			thread1.join(); //le thread courrant qui execute cette ligne attend que le thread1 ait fini puis, passe à la ligne suivante
			thread2.join(); //le thread courrant qui execute cette ligne(le meme thread courrant que ci-dessus), attend que le thread2 ait fini et passe à la ligne suivante

			//si le thread1 a besoin de 10 secondes pour faire son travail le trhead courrant sera bloqué 10 seconde sur le premier join, et quasi rien sur le 2eme join.
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private double[] v1;
	private double[] v2;

	//outputs
	private double[] vResult;
	}
