
package ch.hearc.cours.poo.heritage.animal.mammiferes.felins.tigres;

import ch.hearc.cours.poo.heritage.animal.mammiferes.felins.Felins;

public class Tigre extends Felins
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Tigre(String nom)
		{
		super(nom);
		}

	public Tigre(Tigre source)
		{
		super(source);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//pas nécessaire mais évite un cast
	@Override
	public Tigre cloneOf()
		{
		return new Tigre(this);
		}

	@Override
	public String nameHierarchie()
		{
		return super.nameHierarchie()+Tigre.class.getSimpleName();
		}

	@Override
	public String mange()
		{
		return "des gazelles";
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
