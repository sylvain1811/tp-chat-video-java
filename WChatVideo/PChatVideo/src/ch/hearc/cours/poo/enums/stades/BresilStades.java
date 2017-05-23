
package ch.hearc.cours.poo.enums.stades;

public enum BresilStades
	{
	MANAOS(30000, 100), MARAKANA(25000, 125), BRESILIA(35000, 150);

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private BresilStades(int nbPlaces, double prix)
		{
		this.nbPlaces = nbPlaces;
		this.prix = prix;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public double gain()
		{
		return nbPlaces * prix;
		}
	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbPlaces()
		{
		return this.nbPlaces;
		}

	public double getPrix()
		{
		return this.prix;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setNbPlaces(int nbPlaces)
		{
		this.nbPlaces = nbPlaces;
		}

	public void setPrix(double prix)
		{
		this.prix = prix;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private int nbPlaces;
	private double prix;
	}
