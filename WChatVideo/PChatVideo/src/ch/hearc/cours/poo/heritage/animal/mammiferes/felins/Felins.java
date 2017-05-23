
package ch.hearc.cours.poo.heritage.animal.mammiferes.felins;

import ch.hearc.cours.poo.heritage.animal.mammiferes.Mammiferes;

public abstract class Felins extends Mammiferes
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Felins(String nom)
		{
		super(nom, TEMP_SANG);
		}

	public Felins(Felins source)
		{
		super(source);

		//aucun attribut � copier enplus car la classe f�lin n'a pas d'attribut en plus
		//la temp�rature de sang est un attribut de la classe mammifere qui sera copi�e par le constructeur de copie de la classe mammif�re, constructeur appel� par le super ci-dessus
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Felins.class.getSimpleName();
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

	private static final int TEMP_SANG = 36;

	}
