
package ch.hearc.chatvideo.reseau;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Application_I extends Remote
	{

	public void setText(String message) throws RemoteException;
	}
