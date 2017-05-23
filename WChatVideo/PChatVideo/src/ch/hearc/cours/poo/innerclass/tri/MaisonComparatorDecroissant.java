
package ch.hearc.cours.poo.innerclass.tri;

import java.util.Comparator;


public class MaisonComparatorDecroissant implements Comparator<Maison>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public int compare(Maison maison1, Maison maison2)
		{
		if (Integer.compare(maison1.getPrix(), maison2.getPrix()) == 0)
			{
			return Float.compare(maison1.getSurface(), maison2.getSurface())*-1;
			}
		else
			{
			return Integer.compare(maison1.getPrix(), maison2.getPrix())*-1;
			}
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
	}

