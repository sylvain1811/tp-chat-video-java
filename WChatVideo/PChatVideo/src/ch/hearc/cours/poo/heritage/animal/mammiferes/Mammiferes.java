
package ch.hearc.cours.poo.heritage.animal.mammiferes;

import ch.hearc.cours.poo.heritage.animal.Animal;

public abstract class Mammiferes extends Animal
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Mammiferes(String nom, int tempSang)
		{
		super(nom);
		this.tempSang = tempSang;
		}

	public Mammiferes(Mammiferes source)
		{
		//v1 : bad car lourd si beaucoup d'attribut dans la classe de base et KO si pas de get
		//this(source.getNom(), source.tempSang);
		//v2 : meilleur
		super(source);
		this.tempSang = source.tempSang;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(super.toString());
		stringBuilder.append(Animal.SPACE);
		stringBuilder.append(tempSang);
		return stringBuilder.toString();
		}

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Mammiferes.class.getSimpleName();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getTempSang()
		{
		return this.tempSang;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int tempSang;

	}
