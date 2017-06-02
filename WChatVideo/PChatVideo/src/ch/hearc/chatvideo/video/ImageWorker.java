
package ch.hearc.chatvideo.video;

import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import com.github.sarxos.webcam.Webcam;

import ch.hearc.chatvideo.reseau.Application_I;

public class ImageWorker implements Runnable
	{

	public ImageWorker(JPanelWebcam panel,Application_I remote,Webcam webcam)
		{
		this.panel = panel;
		this.remote  =remote;
		this.webcam = webcam;
		}

	@Override
	public void run()
		{
		image = webcam.getImage();
		panel.setImage(image);
		serialImg =  new ImageSerializable(image);
		try
			{
			remote.setImage(serialImg);
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

	private Webcam webcam;
	private BufferedImage image;
	private ImageSerializable serialImg;
	private JPanelWebcam panel;
	private Application_I remote;
	}
