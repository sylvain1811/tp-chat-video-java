
package ch.hearc.cours.kitbase.collections.linear.training.die;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;

public class Die
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static int moyenneur(int nbFace, int nbExperience)
		{
		Set<Integer> setFaceObtenue = new HashSet<Integer>(nbFace); // Optimisation : 1 seule instance

		long sum = 0;
		for(int i = 0; i < nbExperience; i++)
			{
			int b = experienceAleatoire(nbFace, setFaceObtenue);
			Assert.assertTrue(sum < Long.MAX_VALUE - b);
			sum += b;
			}
		double moyenne = sum / (double)nbExperience;

		return (int)Math.ceil(moyenne); // arrondi au plus petit entier superieur si necessaire (exemple : 14 reste 14, mais 14.01 devient 15)
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * @param nbFace
	 * @param setFaceObtenue doit être vide
	 * @return
	 */
	private static int experienceAleatoire(int nbFace, Set<Integer> setFaceObtenue)
		{
		Assert.assertTrue(setFaceObtenue.isEmpty());
		int nbLancer = 0;
		while(setFaceObtenue.size() < nbFace)
			{
			int faceTirer = faceAleatoire(nbFace);

			setFaceObtenue.add(faceTirer); // boxing automatique : int to Integer

			nbLancer++;
			}
		setFaceObtenue.clear();
		return nbLancer;
		}

	/**
	 * in [1,nbFace]
	 */
	private static int faceAleatoire(int nbFace)
		{
		int alea = random.nextInt(nbFace) + 1; //nextInt(nbFace) in [0,nbFace[, correction par +1 in [1,nbFace] car int

		Assert.assertTrue(alea >= 1 && alea <= nbFace);

		return alea;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Random random = new Random(); // optimisation : 1 seul instance

	}
