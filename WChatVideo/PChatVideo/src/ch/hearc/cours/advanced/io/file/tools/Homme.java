
package ch.hearc.cours.advanced.io.file.tools;

import java.io.Serializable;

public class Homme implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Homme(String nom, int poids)
		{
		this.nom = nom;
		this.poids = poids;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Homme [nom=");
		builder.append(this.nom);
		builder.append(", poids=");
		builder.append(this.poids);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private String nom;
	private int poids;

	}
