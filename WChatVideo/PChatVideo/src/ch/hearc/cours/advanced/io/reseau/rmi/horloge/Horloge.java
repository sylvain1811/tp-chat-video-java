
package ch.hearc.cours.advanced.io.reseau.rmi.horloge;

import java.rmi.RemoteException;
import java.util.Date;

public class Horloge implements Horloge_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public Date getTime() throws RemoteException
		{
		return new Date(System.currentTimeMillis());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
