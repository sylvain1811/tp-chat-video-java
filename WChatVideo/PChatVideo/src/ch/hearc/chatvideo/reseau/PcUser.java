
package ch.hearc.chatvideo.reseau;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import org.junit.Assert;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcUser implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private PcUser()
		{
		// Rien
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		System.out.println("[PcUser]:run");
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

	public static synchronized PcUser getInstance()
		{
		Assert.assertTrue(serverName != null);
		if (INSTANCE == null)
			{
			INSTANCE = new PcUser();
			}
		return INSTANCE;
		}

	public static void init(String serverName)
		{
		PcUser.serverName = serverName;
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
			//this.panelChat = ;

			RmiURL rmiURL = new RmiURL(SettingsRMI.CHAT_ID, SettingsRMI.CHAT_PORT);
			RmiTools.shareObject(panelChat, rmiURL);
			}
		catch (RemoteException e)
			{
			System.err.println("Erreur shareObject");
			e.printStackTrace();
			}

		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		Chat_I chat = connect();
		work(chat);
		}

	private Chat_I connect()
		{
		try
			{
			long delayMs = 1000;
			int nbTentativeMax = 100;
			RmiURL rmiURL = new RmiURL(SettingsRMI.CHAT_ID, InetAddress.getByName(serverName), SettingsRMI.CHAT_PORT);
			Chat_I chat = (Chat_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);

			return chat;
			}
		catch (UnknownHostException e)
			{
			System.err.println("[PcUser]:fail to reach host: " + e);
			e.printStackTrace();
			return null;
			}
		catch (RemoteException e)
			{
			System.err.println("[PcUser]: " + e);
			e.printStackTrace();
			return null;
			}
		}

	private void work(Chat_I chat)
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static PcUser INSTANCE = null;
	private static String serverName = null;
	private JPanelChat panelChat;
	}
