package ch.hearc.chatvideo.video;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;

// exemple repris de : https://github.com/sarxos/webcam-capture/blob/master/webcam-capture/src/example/java/WebcamDiscoveryListenerExample.java
public class WebcamCustomDiscoveryListener implements WebcamDiscoveryListener {

	public WebcamCustomDiscoveryListener(ImageWorker worker) {
		for (Webcam webcam : Webcam.getWebcams()) {
			System.out.println("Webcam detected: " + webcam.getName());
		}
		Webcam.addDiscoveryListener(this);
		System.out.println("\n\nPlease connect additional webcams, or disconnect already connected ones. Listening for events...");
	}

	@Override
	public void webcamFound(WebcamDiscoveryEvent event) {
		System.out.format("Webcam connected: %s \n", event.getWebcam().getName());
	}

	@Override
	public void webcamGone(WebcamDiscoveryEvent event) {
		System.out.format("Webcam disconnected: %s \n", event.getWebcam().getName());
	}

	public static void main(String[] args) throws InterruptedException {
		//new WebcamCustomDiscoveryListener();
		Thread.sleep(120000);
		System.out.println("Bye!");
	}
}