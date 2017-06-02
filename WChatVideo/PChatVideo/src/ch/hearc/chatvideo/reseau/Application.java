
package ch.hearc.chatvideo.reseau;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import org.junit.Assert;

import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.ImageSerializable;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class Application implements Application_I ,Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Application()
		{
		// Rien
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
		// TODO Ajouter pseudo
		Application.jPanelChat.setText(message.decrypter());

		}

	@Override
	public void setImage(ImageSerializable image) throws RemoteException
		{
		// TODO Afficher l'image sur le panel webcam
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

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

	public static void init(String serverName, JPanelChat chat)
		{
		Application.jPanelChat = chat;
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
			RmiURL rmiURL = new RmiURL(SettingsRMI.APPLICATION_ID, SettingsRMI.APPLICATION_PORT);
			RmiTools.shareObject(this, rmiURL);
			}
		catch (RemoteException e)
			{
			System.err.println("Erreur shareObject");
			e.printStackTrace();
			}
		catch (MalformedURLException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		Application_I applicationRemote = connect();
		work(applicationRemote);
		}

	private Application_I connect()
		{
		try
			{
			long delayMs = 1000;
			int nbTentativeMax = 100;
			RmiURL rmiURL = new RmiURL(SettingsRMI.APPLICATION_ID, InetAddress.getByName(serverName), SettingsRMI.APPLICATION_PORT);
			Application_I application = (Application_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);

			return application;
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

	private void work(Application_I applicationRemote)
		{
		try
			{
			// TODO envoyer les messages
			applicationRemote.setText(new StringCrypter("Init"));

			}
		catch (RemoteException e)
			{
			System.err.println("[Application]: setText() error in work method");
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application INSTANCE = null;
	private static String serverName = null;
	private static JPanelChat jPanelChat;
	}
