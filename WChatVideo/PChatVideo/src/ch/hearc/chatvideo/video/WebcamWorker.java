
package ch.hearc.chatvideo.video;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamLockException;
import com.github.sarxos.webcam.WebcamResolution;

import ch.hearc.chatvideo.gui.JPanelChat;
import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.tools.ImageCrypter;

public class WebcamWorker implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public WebcamWorker()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		try
			{
			this.webcam = createWebcam();
			}
		catch (WebcamLockException e)
			{
			// TODO Afficher un message car la caméra est déjà utilisée
			System.err.println("Webcame déjà ouverte");
			}

		// 60 fois par secondes, on set l'image sur le panel local et sur le panel distant de l'autre avec RMI
		while(true) // TODO Changer condition (style "tant que connecté")
			{
			if (webcam != null)
				{
				if (webcam.isOpen())
					{
					// la première image sera forcement nouvelle
					if (webcam.isImageNew())
						{
						image = webcam.getImage();
						if (requestImage)
							{
							try
								{
								ImageIO.write(image, "PNG", new File("capture"+System.currentTimeMillis()+".png"));
								}
							catch (IOException e)
								{
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
							requestImage = false;
							}
						// Affichage de l'image sur le panel local, accès par Singleton
						JPanelChat.getInstance().setImageLocal(image);

						// Envoi de l'image par le réseau
						try
							{
							if (Application.getInstance().getRemote() != null && Application.getInstance().isConnected())
								{
								if (image != null)
									{
									imageSerializable = new ImageSerializable(image);
									}
								Application.getInstance().getRemote().setImage(new ImageCrypter(imageSerializable));
								}
							}
						catch (RemoteException e1)
							{
							JPanelChat.getInstance().traiterErreurReseau();
							e1.printStackTrace();
							}
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

	public void openWebcam()
		{
		webcam.open();
		}

	public void closeWebcam()
		{
		webcam.close();
		}
	public void setRequestImageTrue(){
		requestImage = true;
	}

	private static Webcam createWebcam()
		{
		Webcam webcam = Webcam.getDefault();
		if (webcam == null)
			{
			return null;
			}
		else
			{
			Dimension resolutionVoulue = new Dimension(1920, 1080);
			Dimension[] tabResolutionAlternative = new Dimension[] { resolutionVoulue, WebcamResolution.HD720.getSize(), WebcamResolution.VGA.getSize(), new Dimension(1680, 1050) };
			webcam.setCustomViewSizes(tabResolutionAlternative);
			webcam.setViewSize(resolutionVoulue);
			webcam.open();
			return webcam;
			}
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Webcam webcam;
	private boolean requestImage;
	private BufferedImage image;
	private ImageSerializable imageSerializable;
	}
