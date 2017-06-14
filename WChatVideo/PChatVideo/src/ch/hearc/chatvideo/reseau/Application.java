
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
		// Générations de clés privée et publique
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

		// Démarre le serveur RMI
		serverSide();

		// Se connecte au serveur RMI du correspondant
		clientSide();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public synchronized void setConnected(boolean connected)
		{
		this.isConnected = connected;
		}

	/*------------------------------*\
	|*				RMI				*|
	\*------------------------------*/

	@Override
	public void setText(StringCrypter message)
		{
		// Appelée à distance. Il faut décrypter le message avec la clé privée.
		JPanelChat.getInstance().setText(message.decrypter(this.privateKey));
		}

	@Override
	public void setImage(ImageSerializable imageSerialisee)
		{
		// Appelée à distance. On va mettre à jour le panel de la webcam distante avec l'image reçue en paramètres.
		JPanelChat.getInstance().setImage(imageSerialisee.getImage());
		}

	@Override
	public void setKey(PublicKey key) throws RemoteException
		{
		// Appelée à distance. On utilisera cette clé pour crypter les messages à envoyer au correspondant.
		this.publicKeyDist = key;
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

	/**
	 * Retourne l'instance unique de la classe. Si elle n'est pas créée, appel le contructeur.
	 * Il est nécessaire d'appeler une fois init() avant cette méthode.
	 */
	public static synchronized Application getInstance()
		{
		Assert.assertTrue(serverName != null);
		if (INSTANCE == null)
			{
			INSTANCE = new Application();
			}
		return INSTANCE;
		}

	/**
	 * Initialise l'Application avec le serverName sur lequel on veut se connecter.
	 */
	public static synchronized void init(String serverName)
		{
		Application.serverName = serverName;
		}

	public static String getIp()
		{
		try
			{
			return NetworkTools.localhost("").get(0).toString();
			}
		catch (SocketException e)
			{
			e.printStackTrace();
			}
		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Server			*|
	\*------------------------------*/

	/**
	 * Crée et démarre un thread qui va partager l'Application avec RMI
	 * Pourquoi un thread ? Pour ne pas avoir une méthode bloquante, les actions réseau prennent parfois du temps.
	 */
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

	/**
	 * Crée et démarre un thread qui va se connecter à une Application distante avec RMI.
	 * Pourquoi un thread ? Pour ne pas avoir une méthode bloquante, les actions réseau prennent parfois du temps.
	 */
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
		}

	/**
	 * Tente de se connecter à une Application distante avec RMI
	 * @return
	 */
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
			System.err.println("[Application]: fail connection remote object");
			e.printStackTrace();
			return null;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private boolean isConnected = false;
	private PrivateKey privateKey;
	private PublicKey publicKeyLocal;
	private PublicKey publicKeyDist;
	private Application_I remote = null;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application INSTANCE = null;
	private static String serverName = null;
	}
