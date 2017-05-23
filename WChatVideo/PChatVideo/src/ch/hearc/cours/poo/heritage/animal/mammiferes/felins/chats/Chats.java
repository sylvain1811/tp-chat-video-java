
package ch.hearc.cours.poo.heritage.animal.mammiferes.felins.chats;

import ch.hearc.cours.poo.heritage.animal.mammiferes.felins.Felins;

public class Chats extends Felins
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Chats(String nom)
		{
		super(nom);
		}

	public Chats(Chats source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public Chats cloneOf()
		{
		return new Chats(this);
		}

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie() + Chats.class.getSimpleName();
		}

	@Override
	public String mange()
		{
		return "des souris";
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
