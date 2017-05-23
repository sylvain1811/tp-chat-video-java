
package ch.hearc.cours.poo.enums.stades;

public class UseBresilStade
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		useConversion();
		useComplet();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Conversion
	 * 	enum to String
	 * String to enum
	 */
	private static void useConversion()
		{
		enumToString();
		stringToEnum();
		}

	/**
	 * Récupère un stade depuis son nom
	 */
	private static void stringToEnum()
		{
		String stade = "MANAOS";
		String stade2 = "maNaos";
		System.out.println(from(stade));
		System.out.println(from(stade2.toUpperCase()));
		}

	/**
	 * Affiche le nom de tous les stades
	 */
	private static void enumToString()
		{
		for(BresilStades stade:BresilStades.values())
			{
			System.out.println(stade.name());
			}
		}

	private static BresilStades from(String stade)
		{
		return BresilStades.valueOf(stade);
		}

	private static void useComplet()
		{
		// Combien gagne-t-on d'argent si chaque place des places de BresilStade sont vendues ?
		// V1
			{
			double somme = 0;
			somme += gainParStade(BresilStades.BRESILIA);
			somme += gainParStade(BresilStades.MANAOS);
			somme += gainParStade(BresilStades.MARAKANA);

			System.out.println(somme);
			}

		// V2
			{
			double somme = 0;
			somme += BresilStades.BRESILIA.gain();
			somme += BresilStades.MANAOS.gain();
			somme += BresilStades.MARAKANA.gain();

			System.out.println(somme);
			}

		// V3 la meilleure !!!
			{
			double somme = 0;
			for(BresilStades stade:BresilStades.values())
				{
				somme += stade.gain();
				}

			System.out.println(somme);
			}
		}

	private static double gainParStade(BresilStades stade)

		{
		return stade.getPrix() * stade.getNbPlaces();
		}

	}
