
package ch.hearc.cours.poo.hello.garage;

public class UseGarage
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
		useRoue();
		useVoiture();
		useGarage();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useRoue()
		{
		String marque = "patate";
		int taille = 4;
		Roue roue = new Roue(marque, taille);
		System.out.println(roue);
		}

	private static void useVoiture()
		{
		System.out.println(new Voiture("Renaud", "Pireli"));
		}

	private static void useGarage()
		{
		Garage garage = new Garage("Garage");
		System.out.println(garage);
		Voiture voiture = new Voiture("BMW", "Michelin");
		garage.add(voiture);
		System.out.println(garage);
		garage.remove(voiture);
		System.out.println(garage);

		Voiture voiture1 = new Voiture("BMW", "Michelin");
		Voiture voiture2 = new Voiture("BMW", "Michelin");
		garage.add(voiture1);
		garage.add(voiture2);

		for(Voiture voiturei:garage)
			{
			for(Roue rouei:voiturei)
				{
				rouei.setTaille(100);
				}
			}
		System.out.println(garage);
		}

	}
