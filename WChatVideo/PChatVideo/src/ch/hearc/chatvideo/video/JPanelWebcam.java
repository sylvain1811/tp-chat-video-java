
package ch.hearc.chatvideo.video;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JPanelWebcam extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelWebcam() {
		isGrey = false;
		isCamDisplayed = false;
		isReversed = false;
		isFpsDiplayed = false;
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	// Attention , à l'avenir on passera l'image directement avec rmi
	public void setImage(BufferedImage lastImg) {
		// check if image something
		if (lastImg != null) {
			// if image is different from displayed image
			if (lastImg != image) {
				this.image = lastImg;
				this.repaint();
			}
		}
	}

	/*------------------------------*\
	|*			  Toggle			*|
	\*------------------------------*/

	public void toggleGray() {
		isGrey = !isGrey;
	}

	public void toggleCamDisplayed() {
		isCamDisplayed = !isCamDisplayed;
	}

	public void toggleReversed() {
		isReversed = !isReversed;
	}

	public void toggleFPSDisplayed() {
		isFpsDiplayed = !isFpsDiplayed;
	}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform transform = g2d.getTransform();
		drawImage(g2d);
		g2d.setTransform(transform);
	}

	private BufferedImage GreyLevel(BufferedImage lastImg) {
		int width = lastImg.getWidth();
		int height = lastImg.getHeight();
		BufferedImage greyLevelImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < lastImg.getWidth(); i++) {
			for (int j = 0; j < lastImg.getHeight(); j++) {
				Color color = new Color(lastImg.getRGB(i, j));
				int colorRGB = color.getRGB();
				greyLevelImage.setRGB(i, j, colorRGB);
			}
		}
		return greyLevelImage;
	}

	protected void drawImage(Graphics2D g2d) {
		if (image != null) {
			if (isGrey == true) {
				image = GreyLevel(image);
			}
			if (isReversed) {
				g2d.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), null);
			} else {
				g2d.drawImage(this.image, this.getWidth(), 0, -this.getWidth(), this.getHeight(), null);
			}

		}

	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	protected BufferedImage image;
	protected boolean isCamDisplayed;
	protected boolean isReversed;
	protected boolean isGrey;
	protected boolean isFpsDiplayed;
}
