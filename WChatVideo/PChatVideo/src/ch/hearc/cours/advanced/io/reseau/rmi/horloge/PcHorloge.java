
package ch.hearc.cours.advanced.io.reseau.rmi.horloge;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import org.junit.Assert;

import ch.hearc.cours.advanced.io.reseau.rmi.SettingsRMI;
import ch.hearc.cours.advanced.io.reseau.rmi.secret.Secret_I;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcHorloge implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private PcHorloge()
		{
		// Rien
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void run()
		{
		System.out.println("[PcHorloge]:run");

		serverSide();
		clientSide();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized PcHorloge getInstance()
		{
		Assert.assertTrue(serverName != null);
		if (INSTANCE == null)
			{
			INSTANCE = new PcHorloge();
			}
		return INSTANCE;
		}

	/**
	 * Call once before getInstance
	 */
	public static void init(String serverName)
		{
		PcHorloge.serverName = serverName;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Server			*|
	\*------------------------------*/

	private void serverSide()
		{
		try
			{
			this.horloge = new Horloge();

			RmiURL rmiURL = new RmiURL(SettingsRMI.HORLOGE_ID, SettingsRMI.HORLOGE_PORT);

			RmiTools.shareObject(horloge, rmiURL);
			RmiTools.afficherAllShareObject(SettingsRMI.HORLOGE_PORT);
			}
		catch (RemoteException e)
			{
			System.err.println("[PcHorloge]:serverSide:share failed");
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		Secret_I secret = connect();
		work(secret);
		}

	private Secret_I connect()
		{
		try
			{
			long delayMs = 1000;
			int nbTentativeMax = 100;
			RmiURL rmiURL = new RmiURL(SettingsRMI.SECRET_ID, InetAddress.getByName(serverName), SettingsRMI.SECRET_PORT);
			Secret_I secret = (Secret_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);
			//System.out.println("[PcHorloge]:DEGUB " + secret);
			return secret;
			}
		catch (UnknownHostException e)
			{
			System.err.println("[PcHorloge]:fail to reach host: " + e);
			e.printStackTrace();
			return null;
			}
		catch (RemoteException e)
			{
			System.err.println("[PcHorloge]: " + e);
			e.printStackTrace();
			return null;
			}
		}

	private void work(Secret_I secret)
		{
		try
			{
			System.out.println("[PcHorloge]:" + secret.getSecret());
			}
		catch (RemoteException e)
			{
			System.err.println("[PcHorloge]:fail to call remote method. Exception: \n" + e);
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Output RMI
	private Horloge horloge;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static PcHorloge INSTANCE = null;
	private static String serverName = null;

	}
