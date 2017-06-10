
package ch.hearc.chatvideo.reseau;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.ImageSerializable;

public interface Application_I extends Remote
	{

	public void setText(StringCrypter message) throws RemoteException;

	public void setImage(ImageSerializable image) throws RemoteException;

	}
