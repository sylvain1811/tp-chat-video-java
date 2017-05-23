
package ch.hearc.cours.poo.template.pile.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch.hearc.cours.poo.interfaces.entrainement.specifications.Objet_I;
import ch.hearc.cours.poo.template.pile.specification.Pile_I;

public class PileArrayList<T extends Objet_I<T>> implements Pile_I<T>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PileArrayList()
		{
		this.list = new ArrayList<T>();
		}

	public PileArrayList(PileArrayList<T> source)
		{
		this();
		for(T element:source.list)
			{
			this.list.add(element.cloneOf());
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public PileArrayList<T> cloneOf()
		{
		return new PileArrayList<T>(this);
		}

	public boolean isEquals(PileArrayList<T> pile2)
	{
	if(this.size()!=pile2.size())
		{
		return false;
		}
	else
		{
		Iterator<T> it = pile2.list.iterator();

		for(T element1:this.list)
			{
			T elem2 = it.next();
			if(!element1.isEquals(elem2)) {
				return false;
				}
			}
		return true;
		}
	}

	@Override
	public boolean push(T t)
		{
		return list.add(t);
		}

	@Override
	public T pop()
		{
		return list.remove(list.size() - 1);
		}

	@Override
	public int size()
		{
		return list.size();
		}

	@Override
	public boolean isEmpty()
		{
		return list.isEmpty();
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("PileArray [list=");
		builder.append(this.list);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// tools
	private List<T> list;
	}
