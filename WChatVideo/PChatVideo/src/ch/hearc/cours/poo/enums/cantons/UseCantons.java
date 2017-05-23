
package ch.hearc.cours.poo.enums.cantons;

import java.util.Arrays;

import org.junit.Assert;

public class UseCantons
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 *NE ou VD ou FR en minuscule, en majuscule ou mixte
	 **/
	public static void main(String[] args)
		{
		afficherSuperficie(args);
		main();
		}

	public static void main()
		{
		superficieSuisse();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void superficieSuisse()
		{
		int superficieSuisse = 0;
		for(Cantons canton:Cantons.values())
			{
			superficieSuisse += canton.getSuperficie();
			}
		System.out.println(superficieSuisse);
		}

	private static void afficherSuperficie(String[] args)
		{
		Assert.assertTrue(args.length == 1);
		String input = args[0];
		try
			{
			Cantons canton = Cantons.valueOf(input.toUpperCase());
			System.out.println(canton.getSuperficie());
			}
		catch (Exception e)
			{
			System.err.println("Veuillez entre une valeur valable comprise dans la liste suivante : ");
			System.err.println(Arrays.toString(Cantons.values()));
			}
		}
	}
