
package ch.hearc.chatvideo.tools;

import java.io.Serializable;

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

	public String decrypter()
		{
		// TODO : Decrypter message
		return this.message;
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
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private String message;
	}
