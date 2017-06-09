
package ch.hearc.chatvideo.video;

import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import com.github.sarxos.webcam.Webcam;

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
		this.webcam = CustomWebcam.createWebcam();

		while(true) // TODO Changer condition (style "tant que connecté")
			{
			if (webcam.isOpen())
				{
				// la première image sera forcement nouvelle
				if (webcam.isImageNew())
					{
					image = webcam.getImage();
					}
				}
			else
				{
				//ici on pourrait mettre une image d'erreur
				//image = ;
				}

			// Affichage de l'image sur le panel local, accès par Singleton
			JPanelChat.getInstance().setImageLocal(image);

			ImageSerializable serialImg = new ImageSerializable(image);
			try
				{
				// Envoi de l'image par le réseau
				Application.getInstance().getRemote().setImage(serialImg);
				}
			catch (RemoteException e1)
				{
				e1.printStackTrace();
				}
			try
				{
				Thread.sleep(1000 / 60);
				}
			catch (InterruptedException e)
				{
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
	}
