
package ch.hearc.chatvideo.reseau;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
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
		KeyPairGenerator keyGen;
		try
			{
			keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(1024);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKey = pair.getPrivate();
			this.publicKeyLocal = pair.getPublic();
			}
		catch (NoSuchAlgorithmException e)
			{
			e.printStackTrace();
			}

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
		JPanelChat.getInstance().setText(message.decrypter(this.privateKey));
		}

	@Override
	public void setImage(ImageSerializable imageSerialisee)
		{
		JPanelChat.getInstance().setImage(imageSerialisee.getImage());
		}

	@Override
	public void setKey(PublicKey key) throws RemoteException
		{
		this.publicKeyDist = key;

		}

	public synchronized void setConnected(boolean connected)
		{
		this.isConnected = connected;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Application_I getRemote()
		{
		return this.remote;
		}

	public boolean isConnected()
		{
		return this.isConnected;
		}

	public PublicKey getPublicKey()
		{
		return this.publicKeyDist;
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
		Thread serverSide = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				try
					{
					//RmiURL rmiURL = new RmiURL(SettingsRMI.APPLICATION_ID, SettingsRMI.APPLICATION_PORT);

					//  On prend la première adresse ETH pour se partager
					List<InetAddress> adresses = NetworkTools.localhost("");
					System.out.println(adresses);
					System.out.println(adresses.get(0));
					RmiURL rmiURL = new RmiURL(SettingsRMI.APPLICATION_ID, adresses.get(0), SettingsRMI.APPLICATION_PORT);
					RmiTools.shareObject(Application.this, rmiURL);

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
			});
		serverSide.start();
		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		Thread clientSide = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				Application.this.remote = connect();
				}
			});
		clientSide.start();
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
			RmiURL rmiURL = new RmiURL(SettingsRMI.APPLICATION_ID, InetAddress.getByName(serverName), SettingsRMI.APPLICATION_PORT);
			Application_I applicationRemote = (Application_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);
			isConnected = true;

			// On envoie direct la clé publique
			applicationRemote.setKey(this.publicKeyLocal);
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

	private boolean isConnected = false;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application INSTANCE = null;
	private Application_I remote = null;
	private static String serverName = null;
	private PrivateKey privateKey;
	private PublicKey publicKeyLocal;
	private PublicKey publicKeyDist;
	}
