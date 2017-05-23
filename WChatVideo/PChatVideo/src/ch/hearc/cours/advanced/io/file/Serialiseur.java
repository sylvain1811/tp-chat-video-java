
package ch.hearc.cours.advanced.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialiseur
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static byte[] serialiser(Serializable serializable) throws IOException
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(baos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(serializable);

		oos.close();
		bos.close();
		baos.close();

		return baos.toByteArray();
		}

	public static Serializable deserialiser(byte[] tab) throws IOException, ClassNotFoundException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tab);
		BufferedInputStream bis = new BufferedInputStream(bais);
		ObjectInputStream ois = new ObjectInputStream(bis);

		Serializable serializable = (Serializable)ois.readObject();

		ois.close();
		bis.close();
		bais.close();

		return serializable;
		}

	public static Serializable deepCopy(Serializable source) throws IOException, ClassNotFoundException
		{
		return deserialiser(serialiser(source));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
