
package ch.hearc.cours.poo.heritage.animal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Zoo implements Iterable<Animal>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Zoo(String nom)
		{
		this.nom = nom;
		this.listAnimal = new LinkedList<Animal>();
		}

	public Zoo(Zoo source)
		{
		this(source.nom);
		for(Animal animal:source)
			{
			//this.listAnimal.add(new Animal(animal));//Interdit car animal est abstrait
			this.listAnimal.add(animal.cloneOf());
			//On voit ici que la m�thode cloneOf n'est pas un luxe mais une n�cessit�
			//Derri�re animal se cache un objet qui a pu �tre instanci�, donc qui est concret, donc qui poss�de une m�thode mange et cloneOf impl�ment�e
			//C'est la m�thode cloneOf du type effectif qui est utilis�e ici
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public boolean add(Animal a)
		{
		return listAnimal.add(a);
		}

	public boolean remove(Animal a)
		{
		return listAnimal.remove(a);
		}

	public int size()
		{
		return listAnimal.size();
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Zoo [listAnimal=");
		builder.append(this.listAnimal);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append("]");
		return builder.toString();
		}

	@Override
	public Iterator<Animal> iterator()
		{
		return listAnimal.iterator();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getNom()
		{
		return this.nom;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private List<Animal> listAnimal;

	//Input
	private String nom;

	}
