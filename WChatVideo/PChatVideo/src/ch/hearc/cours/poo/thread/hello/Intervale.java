
package ch.hearc.cours.poo.thread.hello;

import org.junit.Assert;

public class Intervale
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Intervale(int iStart, int iStop)
		{
		Assert.assertTrue(iStart <= iStop);
		this.iStart = iStart;
		this.iStop = iStop;
		}

	public Intervale(Intervale source)
		{
		this(source.iStart, source.iStop);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Intervale [iStop=");
		builder.append(this.iStop);
		builder.append(", iStart=");
		builder.append(this.iStart);
		builder.append("]");
		return builder.toString();
		}

	public Intervale cloneOf()
		{
		return new Intervale(this);
		}

	@Override
	protected Intervale clone() throws CloneNotSupportedException //le type de retour ne modifie pas la signature
		{
		return this.cloneOf();
		}
	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	public boolean isEquals(Intervale i2)
		{
		return this.iStart == i2.iStart && this.iStop == i2.iStop;
		}

	@Override
	public boolean equals(Object o2)
		{
		if (o2 instanceof Intervale)
			{
			return this.isEquals((Intervale)o2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getiStop()
		{
		return this.iStop;
		}

	public int getiStart()
		{
		return this.iStart;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs-outputs
	private int iStop;
	private int iStart;

	}
