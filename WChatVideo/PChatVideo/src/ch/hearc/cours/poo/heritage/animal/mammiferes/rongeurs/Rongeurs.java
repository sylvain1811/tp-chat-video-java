
package ch.hearc.cours.poo.heritage.animal.mammiferes.rongeurs;

import ch.hearc.cours.poo.heritage.animal.mammiferes.Mammiferes;

public abstract class Rongeurs extends Mammiferes
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Rongeurs(String nom)
		{
		super(nom, TEMP_SANG);

		}

	public Rongeurs(Rongeurs source)
		{

		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Rongeurs.class.getSimpleName();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private static final int TEMP_SANG = 33;

	}
