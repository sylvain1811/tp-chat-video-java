
package ch.hearc.cours.poo.heritage.animal.oiseaux.rapaces;

import ch.hearc.cours.poo.heritage.animal.oiseaux.Oiseaux;

public class Rapaces extends Oiseaux
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Rapaces(String nom, int nbPlumes)
		{
		super(nom, nbPlumes);
		}

	public Rapaces(Rapaces source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public Rapaces cloneOf()
		{
		return new Rapaces(this);
		}

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Rapaces.class.getSimpleName();
		}

	@Override
	public String mange()
		{
		return "des marmottes";
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
