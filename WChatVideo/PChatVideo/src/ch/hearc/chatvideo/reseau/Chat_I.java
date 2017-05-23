
package ch.hearc.chatvideo.reseau;

import java.rmi.Remote;

public interface Chat_I extends Remote
	{

	public void setText(String message);
	}
