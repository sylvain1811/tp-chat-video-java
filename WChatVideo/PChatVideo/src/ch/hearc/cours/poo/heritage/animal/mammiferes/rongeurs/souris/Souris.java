
package ch.hearc.cours.poo.heritage.animal.mammiferes.rongeurs.souris;

import ch.hearc.cours.poo.heritage.animal.mammiferes.rongeurs.Rongeurs;

public class Souris extends Rongeurs
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Souris(String nom)
		{
		super(nom);
		}

	public Souris(Souris source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public Souris cloneOf()
		{
		return new Souris(this);
		}

	@Override
	public String nameHierarchie(){
	return super.nameHierarchie() + Souris.class.getSimpleName();
	}

	@Override
	public String mange()
		{
		return "du fromage";
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
