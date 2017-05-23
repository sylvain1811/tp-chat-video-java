
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
			//On voit ici que la méthode cloneOf n'est pas un luxe mais une nécessité
			//Derrière animal se cache un objet qui a pu être instancié, donc qui est concret, donc qui possède une méthode mange et cloneOf implémentée
			//C'est la méthode cloneOf du type effectif qui est utilisée ici
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
