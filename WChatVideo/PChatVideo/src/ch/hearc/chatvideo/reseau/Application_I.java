
package ch.hearc.chatvideo.reseau;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.PublicKey;

import ch.hearc.chatvideo.tools.ImageCrypter;
import ch.hearc.chatvideo.tools.StringCrypter;

public interface Application_I extends Remote
	{

	/**
	 * Appelée à distance. On reçoit le message (crypté) du correspondant en paramètres.
	 */
	public void setText(StringCrypter message) throws RemoteException;

	/**
	 * Appelée à distance. On reçoit la nouvelle image du correspondant en paramètres.
	 */
	public void setImage(ImageCrypter image) throws RemoteException;

	/**
	 * Appelée à distance. On reçoit la clé publique du correspondant en paramètres.
	 * On l'utilisera pour crypter les messages à envoyer
	 */
	public void setKey(PublicKey key) throws RemoteException;

	/**
	 * Envoi régulier de heartbeat. Permet de détecter les déconnexions.
	 */
	public void sendHeartbeat() throws RemoteException;

	}
