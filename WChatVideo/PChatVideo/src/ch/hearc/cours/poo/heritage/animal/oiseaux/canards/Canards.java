
package ch.hearc.cours.poo.heritage.animal.oiseaux.canards;

import ch.hearc.cours.poo.heritage.animal.oiseaux.Oiseaux;

public class Canards extends Oiseaux
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Canards(String nom, int nbPlumes)
		{
		super(nom, nbPlumes);
		}

	public Canards(Canards source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public Canards cloneOf()
		{
		return new Canards(this);
		}

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Canards.class.getSimpleName();
		}

	@Override
	public String mange()
		{
		return "du pain";
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
