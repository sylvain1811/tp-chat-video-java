
package ch.hearc.cours.advanced.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ch.hearc.cours.advanced.io.file.tools.Equipe;
import ch.hearc.cours.advanced.io.file.tools.Homme;

public class UseFileObjectFichier
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
		catch (IOException e)
			{
			e.printStackTrace();
			}
		catch (ClassNotFoundException e)
			{
			e.printStackTrace();
			}
		}

	public static void main() throws IOException, ClassNotFoundException
		{
		String filename = "data.bin";
		int n = 10;
		Equipe equipe = createEquipe(n);

		save(equipe, filename);
		Equipe equipeCopie = (Equipe)load(filename);

		System.out.println(equipe);
		System.out.println(equipeCopie);

		System.out.println(new File(filename).delete());
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

	private static Serializable load(String filename) throws IOException, ClassNotFoundException
		{
		FileInputStream fis = new FileInputStream(filename);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);

		Serializable serializable = (Serializable)ois.readObject();

		ois.close();
		bis.close();
		fis.close();

		return serializable;
		}

	private static void save(Serializable serializable, String filename) throws IOException
		{
		FileOutputStream fos = new FileOutputStream(filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(serializable);

		oos.close();
		bos.close();
		fos.close();

		}

	}
