
package ch.hearc.chatvideo.tools;

import java.io.Serializable;
import java.security.PrivateKey;

import ch.hearc.chatvideo.video.ImageSerializable;

public class ImageCrypter implements Serializable
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Construis un objet avec un message
	 * @param message
	 * @return
	 */
	public ImageCrypter(ImageSerializable imageSerializable)
		{
		crypter(imageSerializable);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Décrypte le message contenu en attibut (byte[]) et le retourne en String.
	 * Demande une clé privé de en paramètres, on la trouve dans Application.
	 */
	public ImageSerializable decrypter(PrivateKey privateKey)
		{
		/*
		Cipher cipher;
		try
			{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decryptedImageAsByte = cipher.doFinal(encryptedImage);
			ByteArrayInputStream bis = new ByteArrayInputStream(decryptedImageAsByte);
			ObjectInputStream ois = new ObjectInputStream(bis);
			ImageSerializable imageSource = (ImageSerializable)ois.readObject();
			ois.close();
			bis.close();
			return imageSource;
			}
		catch (NoSuchAlgorithmException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (NoSuchPaddingException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (InvalidKeyException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IllegalBlockSizeException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (BadPaddingException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (ClassNotFoundException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return null;
		*/
		return this.imageSerializable;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Crypte le message reçu en paramètres et l'enregistre en attribut.
	 * Ce sera les seules données sérialisées.
	 * Le message sera un tableau de byte.
	 */
	private void crypter(ImageSerializable imageSerializable)
		{
		/*Cipher cipher;
		try
			{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, Application.getInstance().getPublicKey());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutput oos = new ObjectOutputStream(bos);
			oos.writeObject(imageSerializable);
			byte[] imageAsByte = bos.toByteArray();
			oos.close();
			bos.close();
			this.encryptedImage = cipher.doFinal(imageAsByte);
			}
		catch (NoSuchAlgorithmException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (NoSuchPaddingException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (InvalidKeyException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (IllegalBlockSizeException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (BadPaddingException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			*/
		this.imageSerializable = imageSerializable;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private byte[] encryptedImage;
	private ImageSerializable imageSerializable;
	}
