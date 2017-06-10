
package ch.hearc.chatvideo.video;

import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamLockException;

import ch.hearc.chatvideo.gui.JPanelChat;
import ch.hearc.chatvideo.reseau.Application;

public class ImageWorker implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*public ImageWorker(JPanelWebcam panel,Application_I remote,Webcam webcam)
		{
		this.panel = panel;
		this.remote =remote;
		this.webcam = webcam;
		}
	 */

	public ImageWorker()
		{
		// Vide
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		try
			{
			this.webcam = CustomWebcam.createWebcam();
			}
		catch (WebcamLockException e)
			{
			// TODO Afficher un message car la caméra est déjà utilisée
			}
		while(true) // TODO Changer condition (style "tant que connecté")
			{
			if (webcam.isOpen())
				{
				// la première image sera forcement nouvelle
				if (webcam.isImageNew())
					{
					image = webcam.getImage();
					// Affichage de l'image sur le panel local, accès par Singleton
					JPanelChat.getInstance().setImageLocal(image);

					// Envoi de l'image par le réseau
					imageSerializable = new ImageSerializable(image);
					try
						{
						if (Application.getInstance().getRemote() != null)
							{
							Application.getInstance().getRemote().setImage(imageSerializable);
							}
						}
					catch (RemoteException e1)
						{
						System.out.println("Erreur remote");
						e1.printStackTrace();
						}
					//			Thread sendImage = new Thread(new Runnable()
					//				{
					//
					//				@Override
					//				public void run()
					//					{
					//					if (Application.getInstance().isConnected())
					//						{
					//						ImageSerializable serialImg = new ImageSerializable(image);
					//						try
					//							{
					//							if (Application.getInstance().getRemote() != null)
					//								{
					//								Application.getInstance().getRemote().setImage(serialImg);
					//								}
					//
					//							}
					//						catch (RemoteException e1)
					//							{
					//							e1.printStackTrace();
					//							JPanelChat.getInstance().traiterErreurReseau();
					//							}
					//						}
					//					}
					//				});
					//
					//			sendImage.start();
					}
				}
			else
				{
				//ici on pourrait mettre une image d'erreur
				//image = ;
				}

			try
				{
				// On attend 1/60 secondes avant la prochaine caputre d'image
				Thread.sleep(1000 / 60);
				}
			catch (InterruptedException e)
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Webcam webcam;
	private BufferedImage image;
	private ImageSerializable imageSerializable;
	}
