
package ch.hearc.cours.advanced.io.file.tools;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Equipe implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Equipe(String nom)
		{
		this.nom = nom;
		list = new LinkedList<Homme>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Equipe [list=");
		builder.append(this.list);
		builder.append(", nom=");
		builder.append(this.nom);
		builder.append("]");
		return builder.toString();
		}

	public void add(Homme h)
		{
		list.add(h);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private List<Homme> list;

	//input
	private String nom;
	}
