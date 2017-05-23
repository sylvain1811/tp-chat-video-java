
package ch.hearc.cours.poo.hello.garage;

import java.util.concurrent.atomic.AtomicInteger;

public class Roue
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Roue(String marque, int taille)
		{
		this.marque = marque;
		this.taille = taille;
		Roue.compteur.incrementAndGet();
		}

	/**
	 * Constructeur de copie obligatoire car roue est altérable
	 */
	public Roue(Roue source)
		{
		this(source.marque, source.taille);//Copie superficielle suffisante pour marque car string inaltérable
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Roue cloneOf()
		{
		return new Roue(this);
		}

	@Override
	protected Object clone() throws CloneNotSupportedException
		{
		return this.cloneOf();
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Roue [marque=");
		builder.append(this.marque);
		builder.append(", taille=");
		builder.append(this.taille);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setMarque(String marque)
		{
		this.marque = marque;
		}

	public void setTaille(int taille)
		{
		this.taille = taille;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getMarque()
		{
		return this.marque;
		}

	public int getTaille()
		{
		return this.taille;
		}

	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	public boolean isEquals(Roue r2)
		{
		return this.marque.equals(r2.marque) && this.taille == r2.taille;
		}

	@Override
	public boolean equals(Object obj)
		{
		if (obj instanceof Roue)
			{
			Roue r2 = (Roue)obj;
			return isEquals(r2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static AtomicInteger getCompteur()
		{
		return Roue.compteur;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input/output
	private String marque;
	private int taille;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static AtomicInteger compteur = new AtomicInteger(0);
	}
