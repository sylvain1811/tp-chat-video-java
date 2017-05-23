
package ch.hearc.cours.poo.hello.garage;

import java.util.Arrays;
import java.util.Iterator;

public class Voiture implements Iterable<Roue>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Voiture(Roue[] tabRoues, StringBuilder marque)
		{
		this.tabRoues = tabRoues;
		this.marque = marque;
		}

	public Voiture(String marqueVoiture, String marqueRoue)
		{
		this(createTabRoues(marqueRoue), new StringBuilder(marqueVoiture));
		//Attention, createTabRoues doit être static car on ne peut pas manipuler
		//un objet avec des méthodes avant que celui-ci ne soit crée.
		}

	public Voiture(Voiture source)
		{
		this(cloneRoues(source.tabRoues), new StringBuilder(source.marque));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public Voiture cloneOf()
		{
		return new Voiture(this);
		}

	@Override
	protected Object clone() throws CloneNotSupportedException
		{
		return this.cloneOf();
		}

	public int nbRoue()
		{
		return this.tabRoues.length;
		}

	@Override
	public Iterator<Roue> iterator()
		{
		return Arrays.asList(tabRoues).iterator();
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Voiture [tabRoues=");
		builder.append(Arrays.toString(this.tabRoues));
		builder.append(", marque=");
		builder.append(this.marque);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setTabRoues(Roue[] tabRoues)
		{
		this.tabRoues = tabRoues;
		}

	public void setMarque(StringBuilder marque)
		{
		this.marque = marque;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Roue[] getTabRoues()
		{
		return this.tabRoues;
		}

	public StringBuilder getMarque()
		{
		return this.marque;
		}

	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	public boolean isEquals(Voiture v2)
		{
		if (!this.marque.equals(v2.marque))
			{
			return false;
			}
		else if (this.nbRoue() != v2.nbRoue())
			{
			return false;
			}
		else
			{
			int i = 0;
			for(Roue roue2:v2)
				{
				Roue roue1 = this.tabRoues[i];
				if (!roue1.isEquals(roue2)) { return false; }
				}
			return true;
			}
		}

	@Override
	public boolean equals(Object obj)
		{
		if (obj instanceof Voiture)
			{
			Voiture v2 = (Voiture)obj;
			return this.isEquals(v2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	/**
	 * static car on manipule pas d'attributs de Voiture, plus de relation avec l'instance de Voiture
	 * @param marqueRoue
	 * @return
	 */
	private static Roue[] createTabRoues(String marqueRoue)
		{
		int n = 4;
		Roue[] tabRoues = new Roue[n];

		for(int i = 0; i < n; i++)
			{
			int taille = 4;
			tabRoues[i] = new Roue(marqueRoue + i, taille);
			}
		return tabRoues;
		}

	private static Roue[] cloneRoues(Roue[] tabRouesSource)
		{
		int n = tabRouesSource.length;
		Roue[] tabRoueCopie = new Roue[n];

		for(int i = 0; i < n; i++)
			{
			tabRoueCopie[i] = new Roue(tabRouesSource[i]);
			}

		return tabRoueCopie;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input/output
	private Roue[] tabRoues;

	private StringBuilder marque;

	}
