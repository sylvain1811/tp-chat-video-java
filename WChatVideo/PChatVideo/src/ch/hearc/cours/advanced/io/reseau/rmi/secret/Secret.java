
package ch.hearc.cours.advanced.io.reseau.rmi.secret;

import java.rmi.RemoteException;

public class Secret implements Secret_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Secret(String secret)
		{
		this.stringCrypter = new StringCrypter(secret);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return stringCrypter.toString();
		}

	@Override
	public StringCrypter getSecret() throws RemoteException
		{
		return this.stringCrypter;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private StringCrypter stringCrypter;

	}
