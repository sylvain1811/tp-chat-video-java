
package ch.hearc.chatvideo.tools;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import ch.hearc.chatvideo.reseau.Application;

public class StringCrypter implements Serializable
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * Construis un objet avec un message
	 * @param message
	 */
	public StringCrypter(String message)
		{
		crypter(message);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Décrypte le message contenu en attibut (byte[]) et le retourne en String.
	 * Demande une clé privé de en paramètres, on la trouve dans Application.
	 */
	public String decrypter(PrivateKey privateKey)
		{
		Cipher cipher;
		try
			{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
			return new String(decryptedMessage, Charset.forName("UTF-8"));
			}
		catch (NoSuchAlgorithmException e)
			{
			e.printStackTrace();
			}
		catch (NoSuchPaddingException e)
			{
			e.printStackTrace();
			}
		catch (InvalidKeyException e)
			{
			e.printStackTrace();
			}
		catch (IllegalBlockSizeException e)
			{
			e.printStackTrace();
			}
		catch (BadPaddingException e)
			{
			e.printStackTrace();
			}
		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Crypte le message reçu en paramètres et l'enregistre en attribut.
	 * Ce sera les seules données sérialisées.
	 * Le message sera un tableau de byte.
	 */
	private void crypter(String message)
		{
		Cipher cipher;
		try
			{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, Application.getInstance().getPublicKey());
			byte[] messageAsByte = message.getBytes(Charset.forName("UTF-8"));
			this.encryptedMessage = cipher.doFinal(messageAsByte);
			}
		catch (NoSuchAlgorithmException e)
			{
			e.printStackTrace();
			}
		catch (NoSuchPaddingException e)
			{
			e.printStackTrace();
			}
		catch (InvalidKeyException e)
			{
			e.printStackTrace();
			}
		catch (IllegalBlockSizeException e)
			{
			e.printStackTrace();
			}
		catch (BadPaddingException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private byte[] encryptedMessage;
	}
