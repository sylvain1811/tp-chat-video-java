
package ch.hearc.cours.poo.heritage.animal.oiseaux;

import ch.hearc.cours.poo.heritage.animal.Animal;

public abstract class Oiseaux extends Animal
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Oiseaux(String nom, int nbPlumes)
		{
		super(nom);
		this.nbPlumes = nbPlumes;
		}

	public Oiseaux(Oiseaux source)
		{
		super(source);
		this.nbPlumes = source.nbPlumes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Oiseaux.class.getSimpleName();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbPlumes()
		{
		return nbPlumes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	int nbPlumes;

	}
