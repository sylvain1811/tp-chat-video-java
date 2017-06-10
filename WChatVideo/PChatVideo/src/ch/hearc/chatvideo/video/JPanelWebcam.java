
package ch.hearc.chatvideo.video;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JPanelWebcam extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelWebcam()
		{
		isGrey = true;
		isCamDisplayed = false;
		IsFpsDiplayed = false;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//Attention , à l'avenir on passera l'image directement avec rmi
	public void setImage(BufferedImage lastImg)
		{
		//check if image something
		if (lastImg != null)
			{
			//if image is different from displayed image
			if (lastImg != image)
				{
				if (isGrey == true)
					{
					image = reversedGreyLevel(lastImg);
					}
				else
					{
					image = reverseImg(lastImg);
					}
				this.repaint();
				}
			}
		}

	/*------------------------------*\
	|*			  Toggle			*|
	\*------------------------------*/

	public void toggleGray()
		{
		isGrey = !isGrey;
		}

	public void toggleCamDisplayed()
		{
		isCamDisplayed = !isCamDisplayed;
		}

	public void toggleFPSDisplayed()
		{
		IsFpsDiplayed = !IsFpsDiplayed;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		drawImage(g2d);
		g2d.setTransform(transform);
		}

	private BufferedImage reversedGreyLevel(BufferedImage lastImg)
		{
		int width = lastImg.getWidth();
		int height = lastImg.getHeight();
		BufferedImage greyLevelImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for(int i = 0; i < lastImg.getWidth(); i++)
			{
			for(int j = 0; j < lastImg.getHeight(); j++)
				{
				Color color = new Color(lastImg.getRGB(width - i - 1, j));
				int colorRGB = color.getRGB();
				greyLevelImage.setRGB(i, j, colorRGB);
				}
			}
		return greyLevelImage;
		}

	private BufferedImage reverseImg(BufferedImage image)
		{
		int width = image.getWidth();
		int height = image.getHeight();
		BufferedImage reversedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		for(int i = 0; i < image.getWidth(); i++)
			{
			for(int j = 0; j < image.getHeight(); j++)
				{
				Color color = new Color(image.getRGB(width - i - 1, j));
				int colorRGB = color.getRGB();
				reversedImage.setRGB(i, j, colorRGB);
				}
			}
		return reversedImage;
		}

	private void drawImage(Graphics2D g2d)
		{
		if (image != null)
			{
			// TODO Scale image en fonction de la taille de la fenetre (remplacer 600, 350)
			// Idée : écouter les redimensionnement des panels, et adapter
			g2d.drawImage(this.image, 0, 0, 600, 350, null);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private BufferedImage image;
	private boolean isCamDisplayed;
	private boolean isGrey;
	private boolean IsFpsDiplayed;
	}
