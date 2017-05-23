
package ch.hearc.cours.advanced.io.file;

import java.io.IOException;

import ch.hearc.cours.advanced.io.file.tools.Equipe;
import ch.hearc.cours.advanced.io.file.tools.Homme;

public class UseSerialiseur
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		try
			{
			main();
			}
		catch (ClassNotFoundException e)
			{
			e.printStackTrace();
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	public static void main() throws ClassNotFoundException, IOException
		{
		Equipe equipe = createEquipe(5);
		Equipe equipeClone = (Equipe)Serialiseur.deepCopy(equipe);

		System.out.println(equipe);
		System.out.println(equipeClone);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Equipe createEquipe(int n)
		{
		Equipe equipe = new Equipe("Xamax");
		for(int i = 0; i < n; i++)
			{
			Homme homme = new Homme("nom" + i, i);
			equipe.add(homme);
			}

		return equipe;
		}
	}
