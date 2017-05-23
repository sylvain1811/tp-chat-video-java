
package ch.hearc.cours.kitbase.collections.linear;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class UseMap
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
		int n = 5;

		//v1
			{
			System.out.println("\nHashMap:\n");
			Map<String, String> mapIbanNom = new HashMap<String, String>(n); // n facultatif optimisation
			work(mapIbanNom, n);
			}

		//v2
			{
			System.out.println("\nTreemap:\n");
			Map<String, String> mapIbanNom = new TreeMap<String, String>(); // relation d'ordre
			work(mapIbanNom, n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void work(Map<String, String> mapIbanNom, int n)
		{
		fill(mapIbanNom, n);
		fill(mapIbanNom, n);
		print(mapIbanNom);
		}

	private static void fill(Map<String, String> mapIbanNom, int n)
		{
		for(int i = 0; i < n; i++)
			{
			String key = "ch" + i;
			String value = "nom" + i;
			mapIbanNom.put(key, value);
			}
		}

	private static void print(Map<String, String> mapIbanNom)
		{
		//v1
			{
			Set<String> set = mapIbanNom.keySet();
			for(String key:set)
				{
				String value = mapIbanNom.get(key);
				System.out.println(key + " " + value);
				}
			}

		System.out.println();

		//v2
			{
			Set<Entry<String, String>> setLigne = mapIbanNom.entrySet();
			for(Entry<String, String> ligne:setLigne)
				{
				//v2.1
					{
					System.out.println(ligne);
					}

				//				//v2.2
				//					{
				//					String key = ligne.getKey();
				//					String value = ligne.getValue();
				//					System.out.println(key + " " + value);
				//					}
				}
			}

		System.out.println();

		//v2bis avec iterateur
			{
			Set<Entry<String, String>> setLigne = mapIbanNom.entrySet();
			Iterator<Entry<String, String>> it = setLigne.iterator();
			while(it.hasNext())
				{
				Map.Entry<String, String> ligne = it.next();
				System.out.println(ligne);
				}
			}

		System.out.println();

		//V3
			{
			System.out.println(mapIbanNom.toString());
			}

		System.out.println();

		//V4
			{
			System.out.println(mapIbanNom);
			}
		}

	}
