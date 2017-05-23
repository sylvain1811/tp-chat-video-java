
package ch.hearc.cours.poo.hello.garage;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Garage implements Iterable<Voiture>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Garage(String nom)
		{
		//input
			{
			this.nom = nom;
			}

		//tools
			{
			listeVoitures = new LinkedList<Voiture>();
			}
		}

	public Garage(Garage source)
		{
		this(source.nom);
		//V1
		//			{
		//			for(Voiture voiture:source.listeVoitures)
		//				{
		//				this.listeVoitures.add(new Voiture(voiture));
		//				}
		//			}

		//V2
			{
			for(Voiture voiture:source)
				{
				this.listeVoitures.add(new Voiture(voiture));
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public synchronized Garage cloneOf()
		{
		return new Garage(this);
		}

	@Override
	protected synchronized Object clone() throws CloneNotSupportedException
		{
		return this.cloneOf();
		}

	@Override
	public synchronized String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Garage [nom=");
		builder.append(this.nom);
		builder.append(", listeVoitures=");
		builder.append(this.listeVoitures);
		builder.append("]");
		return builder.toString();
		}

	@Override
	public Iterator<Voiture> iterator()
		{
		return listeVoitures.iterator();
		}

	public synchronized boolean add(Voiture voiture)
		{
		return listeVoitures.add(voiture);
		}

	public synchronized boolean remove(Voiture voiture)
		{
		return listeVoitures.remove(voiture);
		}

	public synchronized int size()
		{
		return listeVoitures.size();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Is				*|
	\*------------------------------*/

	public boolean isEquals(Garage g2)
		{
		if (!this.nom.equals(g2.nom))
			{
			return false;
			}
		else if (this.listeVoitures.size() != g2.listeVoitures.size())
			{
			return false;
			}
		else
			{
			Garage g1Clone = this.cloneOf();
			Garage g2Clone = g2.cloneOf();
			sort(g1Clone.listeVoitures);
			sort(g2Clone.listeVoitures);

			Iterator<Voiture> it1 = g1Clone.listeVoitures.iterator();
			for(Voiture voiture2:g2Clone)
				{
				Voiture voiture1 = it1.next();
				if (!voiture1.isEquals(voiture2)) { return false; }
				}
			return true;
			}
		}

	@Override
	public boolean equals(Object obj)
		{
		if (obj instanceof Garage)
			{
			Garage g2 = (Garage)obj;
			return this.isEquals(g2);
			}
		else
			{
			return false;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void sort(List<Voiture> list)
		{
		Comparator<Voiture> comparator = new Comparator<Voiture>()
			{

			@Override
			public int compare(Voiture o1, Voiture o2)
				{
				if (o1.getMarque().equals(o2.getMarque()))
					{
					return Integer.compare(o1.getTabRoues().length, o2.getTabRoues().length);
					//Pas suffisant mais on s'en contente
					}
				else
					{
					return o1.getMarque().toString().compareTo(o2.getMarque().toString());
					}
				}
			};

		Collections.sort(list, comparator);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private String nom;

	//tools
	private List<Voiture> listeVoitures;

	}
