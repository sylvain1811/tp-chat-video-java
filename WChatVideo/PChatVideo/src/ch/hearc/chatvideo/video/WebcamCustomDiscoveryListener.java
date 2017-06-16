
package ch.hearc.chatvideo.video;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;

// exemple repris de : https://github.com/sarxos/webcam-capture/blob/master/webcam-capture/src/example/java/WebcamDiscoveryListenerExample.java
public class WebcamCustomDiscoveryListener implements WebcamDiscoveryListener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public WebcamCustomDiscoveryListener(WebcamWorker worker)
		{
		this.worker = worker;
		for(Webcam webcam:Webcam.getWebcams())
			{
			System.out.println("Webcam detected: " + webcam.getName());
			}
		Webcam.addDiscoveryListener(this);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void webcamFound(WebcamDiscoveryEvent event)
		{
		System.out.format("Webcam connected: %s \n", event.getWebcam().getName());
		worker.renewWebcam();
		}

	@Override
	public void webcamGone(WebcamDiscoveryEvent event)
		{
		worker.closeWebcam();
		System.out.format("Webcam disconnected: %s \n", event.getWebcam().getName());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private WebcamWorker worker;
	}
