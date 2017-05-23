
package ch.hearc.cours.poo.hello.die;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;

public class Die implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Die(int nbFaces, int nbExperiences)
		{
		//inputs
			{
			this.nbFaces = nbFaces;
			this.nbExperiences = nbExperiences;
			}

		//tools
			{
			this.setFacesObtenues = new HashSet<Integer>(nbFaces);
			this.random = new Random();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		long somme = 0;
		for(int i = 0; i < nbExperiences; i++)
			{
			int nbLancers = experience();
			Assert.assertTrue(somme < Long.MAX_VALUE - nbLancers); // on check le débordement de type
			somme += nbLancers;
			}
		double moyenne = somme / (double)nbExperiences;
		nbLancersMoyens = (int)Math.ceil(moyenne);
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Die [nbFaces=");
		builder.append(this.nbFaces);
		builder.append(", nbExperiences=");
		builder.append(this.nbExperiences);
		builder.append(", nbLancersMoyens=");
		builder.append(this.nbLancersMoyens);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbLancersMoyens()
		{
		return this.nbLancersMoyens;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private int experience()
		{
		Assert.assertTrue(setFacesObtenues.isEmpty());
		int nbLancers = 0;
		while(setFacesObtenues.size() < nbFaces)
			{
			int face = alea1nbFaces();
			Assert.assertTrue(face > 0 && face <= nbFaces);
			setFacesObtenues.add(face);
			nbLancers++;
			}
		setFacesObtenues.clear();
		return nbLancers;
		}

	/**
	 *
	 * @return alea in [1,nbFaces]
	 */
	private int alea1nbFaces()
		{
		return random.nextInt(nbFaces) + 1;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int nbFaces;
	private int nbExperiences;

	//output
	private int nbLancersMoyens;

	//tools
	private Set<Integer> setFacesObtenues;
	private Random random;

	}
