
package ch.hearc.chatvideo.reseau;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.PublicKey;

import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.ImageSerializable;

public interface Application_I extends Remote
	{

	/**
	 * Appel�e � distance. On re�oit le message (crypt�) du correspondant en param�tres.
	 */
	public void setText(StringCrypter message) throws RemoteException;

	/**
	 * Appel�e � distance. On re�oit la nouvelle image du correspondant en param�tres.
	 */
	public void setImage(ImageSerializable image) throws RemoteException;

	/**
	 * Appel�e � distance. On re�oit la cl� publique du correspondant en param�tres.
	 * On l'utilisera pour crypter les messages � envoyer
	 */
	public void setKey(PublicKey key) throws RemoteException;

	}
