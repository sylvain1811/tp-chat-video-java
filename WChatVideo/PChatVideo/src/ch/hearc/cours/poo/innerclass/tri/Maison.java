
package ch.hearc.cours.poo.innerclass.tri;

public class Maison implements Comparable<Maison>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Maison(int prix, float surface)
		{
		this.prix = prix;
		this.surface = surface;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Maison [prix=");
		builder.append(this.prix);
		builder.append(", surface=");
		builder.append(this.surface);
		builder.append("]");
		return builder.toString();
		}
	/**
	 * Compare par rapport au prix, et si prix est égale on compare avec la surface
	 */
	@Override
	public int compareTo(Maison maison2)
		{
		if (Integer.compare(prix, maison2.prix) == 0)
			{
			return Float.compare(surface, maison2.surface)*-1;
			}
		else
			{
			return Integer.compare(prix, maison2.prix)*-1;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getPrix()
		{
		return this.prix;
		}

	public float getSurface()
		{
		return this.surface;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int prix;

	private float surface;

	}
