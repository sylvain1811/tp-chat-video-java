
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

	public StringCrypter(String message)
		{
		this.message = message;
		crypter();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public String decrypter(PrivateKey privateKey)
		{
		// TODO : Decrypter message
		Cipher cipher;
		try
			{
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
			this.message = new String(decryptedMessage, Charset.forName("UTF-8"));
			return this.message;
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
		return null;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void crypter()
		{
		// TODO : Crypter message
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
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private String message;
	private byte[] encryptedMessage;
	}
