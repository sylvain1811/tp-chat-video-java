
package ch.hearc.cours.advanced.io.reseau.rmi.secret;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Secret_I extends Remote
	{
	public StringCrypter getSecret() throws RemoteException;
	}
