
package ch.hearc.cours.advanced.io.reseau.rmi.secret;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import org.junit.Assert;

import ch.hearc.cours.advanced.io.reseau.rmi.SettingsRMI;
import ch.hearc.cours.advanced.io.reseau.rmi.gui.JFrameSecret;
import ch.hearc.cours.advanced.io.reseau.rmi.horloge.Horloge_I;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcSecret implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private PcSecret()
		{
		// Rien
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		System.out.println("[PcSecret]:run");

		serverSide();
		clientSide();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized PcSecret getInstance()
		{
		Assert.assertTrue(serverName != null);
		if (INSTANCE == null)
			{
			INSTANCE = new PcSecret();
			}
		return INSTANCE;
		}

	/**
	 * Call once before getInstance
	 */
	public static void init(String serverName)
		{
		PcSecret.serverName = serverName;
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
			this.secret = new Secret("Simba");

			RmiURL rmiURL = new RmiURL(SettingsRMI.SECRET_ID, SettingsRMI.SECRET_PORT);

			RmiTools.shareObject(secret, rmiURL);
			RmiTools.afficherAllShareObject(SettingsRMI.SECRET_PORT);
			}
		catch (RemoteException e)
			{
			System.err.println("[PcSecret]:serverSide:share failed");
			e.printStackTrace();
			}
		}
	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		Horloge_I horloge = connect();
		work(horloge);
		}

	private Horloge_I connect()
		{
		try
			{
			long delayMs = 1000;
			int nbTentativeMax = 100;
			RmiURL rmiURL = new RmiURL(SettingsRMI.HORLOGE_ID, InetAddress.getByName(serverName), SettingsRMI.HORLOGE_PORT);
			Horloge_I horloge = (Horloge_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);

			//System.out.println("[PcHorloge]:DEGUB" + horloge);
			return horloge;
			}
		catch (UnknownHostException e)
			{
			System.err.println("[PcSecret]:fail to reach host: " + e);
			e.printStackTrace();
			return null;
			}
		catch (RemoteException e)
			{
			System.err.println("[PcSecret]: " + e);
			e.printStackTrace();
			return null;
			}
		}

	private void work(Horloge_I horloge)
		{
		try
			{
			JFrame frame = new JFrameSecret(horloge);

			System.out.println("[PcSecret]:" + horloge.getTime());
			}
		catch (RemoteException e)
			{
			System.err.println("[PcSecret]: erreur rmi getTime" + e);
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Output RMI
	private Secret secret;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static PcSecret INSTANCE = null;
	private static String serverName = null;

	}
