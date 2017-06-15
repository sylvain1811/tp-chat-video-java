
package ch.hearc.chatvideo.video;

import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamLockException;

import ch.hearc.chatvideo.gui.JPanelChat;
import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.tools.ImageCrypter;

public class ImageWorker implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageWorker()
		{
		// Vide
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override public void run()
		{
		try
			{
			this.webcam = CustomWebcam.getInstance();
			}
		catch (WebcamLockException e)
			{
			// TODO Afficher un message car la caméra est déjà utilisée
			System.err.println("Webcame déjà ouverte");
			}

		// 60 fois par secondes, on set l'image sur le panel local et sur le panel distant de l'autre avec RMI
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
					try
						{
						if (Application.getInstance().getRemote() != null)
							{
							imageSerializable = new ImageSerializable(image);
							Application.getInstance().getRemote().setImage(new ImageCrypter(imageSerializable));
							}
						}
					catch (RemoteException e1)
						{
						System.out.println("Erreur remote");
						e1.printStackTrace();
						}
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
