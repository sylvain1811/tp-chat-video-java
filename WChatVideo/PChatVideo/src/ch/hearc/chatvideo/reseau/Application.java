
package ch.hearc.chatvideo.reseau;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.List;

import org.junit.Assert;

import ch.hearc.chatvideo.gui.JPanelChat;
import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.ImageSerializable;

import com.bilat.tools.reseau.rmi.NetworkTools;
import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

/*---------------------------------------------------------------*\
|*							SINGLETON							 *|
\*---------------------------------------------------------------*/

public class Application implements Application_I ,Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Application()
		{
		// Vide
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		System.out.println("[Application]:run");
		serverSide();
		clientSide();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	@Override
	public void setText(StringCrypter message)
		{
		JPanelChat.getInstance().setText(message.decrypter());
		}

	@Override
	public void setImage(ImageSerializable imageSerialisee)
		{
		JPanelChat.getInstance().setImage(imageSerialisee.getImage());
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Application_I getRemote()
		{
		return this.remote;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized Application getInstance()
		{
		Assert.assertTrue(serverName != null);
		if (INSTANCE == null)
			{
			INSTANCE = new Application();
			}
		return INSTANCE;
		}

	public static synchronized void init(String serverName)
		{
		Application.serverName = serverName;
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
			//RmiURL rmiURL = new RmiURL(SettingsRMI.APPLICATION_ID, SettingsRMI.APPLICATION_PORT);

			//  On prend la première adresse ETH pour se partager
			List<InetAddress> adresses = NetworkTools.localhost("");
			System.out.println(adresses);
			System.out.println(adresses.get(0));
			String id = "";
			if (JPanelChat.pseudo.contains("syl"))
				{
				id = SettingsRMI.APPLICATION_ID + 1;
				}
			else
				{
				id = SettingsRMI.APPLICATION_ID + 2;
				}
			RmiURL rmiURL = new RmiURL(id, adresses.get(0), SettingsRMI.APPLICATION_PORT);
			RmiTools.shareObject(this, rmiURL);

			}
		catch (RemoteException e)
			{
			System.err.println("Erreur shareObject");
			e.printStackTrace();
			}
		catch (MalformedURLException e)
			{
			// TODO Traiter URL mal formée
			e.printStackTrace();
			}
		catch (SocketException e)
			{
			// TODO Gérer erreur localhostEth()
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		this.remote = connect();
		// work();
		}

	private Application_I connect()
		{
		try
			{
			long delayMs = 1000;
			int nbTentativeMax = 100;

			// On récupère l'adresse depuis le nom entré par le user
			System.out.println("Try connect");
			String id = "";
			// Inversion de la condition
			if (!JPanelChat.pseudo.contains("syl"))
				{
				id = SettingsRMI.APPLICATION_ID + 1;
				}
			else
				{
				id = SettingsRMI.APPLICATION_ID + 2;
				}
			RmiURL rmiURL = new RmiURL(id, InetAddress.getByName(serverName), SettingsRMI.APPLICATION_PORT);
			Application_I applicationRemote = (Application_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);

			return applicationRemote;
			}

		catch (UnknownHostException e)
			{
			System.err.println("[Application]:fail to reach host: " + e);
			e.printStackTrace();
			return null;
			}

		catch (RemoteException e)
			{
			System.err.println("[Application]: " + e);
			e.printStackTrace();
			return null;
			}

		catch (MalformedURLException e)
			{
			System.err.println("[Application]:fail connection remote object");
			e.printStackTrace();
			return null;
			}
		}

	// Pas utile, pour tests seulement
	//	private void work()
	//		{
	//		try
	//			{
	//			// TODO envoyer les messages
	//			this.remote.setText(new StringCrypter("Init"));
	//
	//			}
	//		catch (RemoteException e)
	//			{
	//			System.err.println("[Application]: setText() error in work method");
	//			e.printStackTrace();
	//			}
	//		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application INSTANCE = null;
	private Application_I remote;
	private static String serverName = null;
	}
