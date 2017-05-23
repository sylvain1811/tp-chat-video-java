
package ch.hearc.cours.poo.interfaces.entrainement.implementations;

import ch.hearc.cours.poo.interfaces.entrainement.specifications.Objet_I;

public class Banane implements Objet_I<Banane>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Banane(String marque, int poids)
		{
		this.marque = marque;
		this.poids = poids;
		}

	public Banane(Banane source)
		{
		this(source.marque, source.poids); //Copie superficielle autorisée de l'attribut marque car String est inaltérable
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Banane [marque=");
		builder.append(this.marque);
		builder.append(", poids=");
		builder.append(this.poids);
		builder.append("]");
		return builder.toString();
		}

	@Override
	public Banane cloneOf()
		{
		return new Banane(this);
		}

	@Override
	public boolean isEquals(Banane banane2)
		{
		return this.marque.equals(banane2.marque) && this.poids == banane2.poids;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getMarque()
		{
		return this.marque;
		}

	public int getPoids()
		{
		return this.poids;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	private String marque;
	private int poids;

	}
