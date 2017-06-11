
package ch.hearc.chatvideo.video;

import java.awt.Dimension;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class CustomWebcam
	{

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Webcam INSTANCE = null;

	public static Webcam getInstance()
		{
		if (INSTANCE == null)
			{
			INSTANCE = createWebcam();
			}
		return INSTANCE;
		}

	private static Webcam createWebcam()
		{
		Webcam webcam = Webcam.getDefault();
		Dimension resolutionVoulue = new Dimension(1920, 1080);
		Dimension[] tabResolutionAlternative = new Dimension[] { resolutionVoulue, WebcamResolution.HD720.getSize(), WebcamResolution.VGA.getSize(), new Dimension(1680, 1050) };
		webcam.setCustomViewSizes(tabResolutionAlternative);
		webcam.setViewSize(resolutionVoulue);
		webcam.open();
		return webcam;
		}

	public static JPanelWebcam createWebcamPanel()
		{
		JPanelWebcam webcamPanel = new JPanelWebcam();
		return webcamPanel;
		}

	}
