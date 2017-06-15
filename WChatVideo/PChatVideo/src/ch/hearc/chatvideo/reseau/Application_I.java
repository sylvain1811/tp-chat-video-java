
package ch.hearc.chatvideo.reseau;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.PublicKey;

import ch.hearc.chatvideo.tools.ImageCrypter;
import ch.hearc.chatvideo.tools.StringCrypter;

public interface Application_I extends Remote
	{

	/**
	 * Appel�e � distance. On re�oit le message (crypt�) du correspondant en param�tres.
	 */
	public void setText(StringCrypter message) throws RemoteException;

	/**
	 * Appel�e � distance. On re�oit la nouvelle image du correspondant en param�tres.
	 */
	public void setImage(ImageCrypter image) throws RemoteException;

	/**
	 * Appel�e � distance. On re�oit la cl� publique du correspondant en param�tres.
	 * On l'utilisera pour crypter les messages � envoyer
	 */
	public void setKey(PublicKey key) throws RemoteException;

	/**
	 * Envoi r�gulier de heartbeat. Permet de d�tecter les d�connexions.
	 */
	public void sendHeartbeat() throws RemoteException;

	}
