
package ch.hearc.cours.poo.template.pile.implementations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ch.hearc.cours.poo.interfaces.entrainement.specifications.Objet_I;
import ch.hearc.cours.poo.template.pile.specification.Pile_I;

public class PileLinkedList<T extends Objet_I<T>> implements Pile_I<T> // classe thread safe
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public PileLinkedList()
		{
		this.list = new LinkedList<T>();
		}

	public PileLinkedList(PileLinkedList<T> source)
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
	public PileLinkedList<T> cloneOf()
		{
		return new PileLinkedList<T>(this);
		}

	public boolean isEquals(PileLinkedList<T> pile2)
		{
		if (this.size() != pile2.size())
			{
			return false;
			}
		else
			{
			Iterator<T> it = pile2.list.iterator();

			for(T element1:this.list)
				{
				T elem2 = it.next();
				if (!element1.isEquals(elem2)) { return false; }
				}
			return true;
			}
		}

	@Override
	public synchronized String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Pile [list=");
		builder.append(this.list);
		builder.append("]");
		return builder.toString();
		}

	@Override
	public synchronized int size()
		{
		return this.list.size();
		}

	@Override
	public synchronized boolean isEmpty()
		{
		return this.list.isEmpty();
		}

	@Override
	public synchronized boolean push(T element)
		{
		return this.list.add(element);
		}

	@Override
	public synchronized T pop()
		{
		return this.list.remove(size() - 1);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private List<T> list;

	}
