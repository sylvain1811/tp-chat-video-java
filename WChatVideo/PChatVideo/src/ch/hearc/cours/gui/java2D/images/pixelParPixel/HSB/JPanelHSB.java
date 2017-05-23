
package ch.hearc.cours.gui.java2D.images.pixelParPixel.HSB;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.junit.Assert;


public class JPanelHSB extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelHSB()
		{

		control();

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		dessiner(g2d);
		g2d.setTransform(transform);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void control()
		{
		this.addComponentListener(new ComponentAdapter()
			{
			@Override
			public void componentResized(ComponentEvent e)
				{
				int h = Math.max(getSize().height,2);// max avec 2 pour eviter un plantage quand le panel a une dimmension de 0 apres resize
				int w = Math.max(getSize().width, 2);

				JPanelHSB.this.bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				remplirBufferedImage();
				}
			});

		}

	private void dessiner(Graphics2D g2d)
		{
		g2d.drawImage(this.bufferedImage, 0, 0, null);
		}

	private void remplirBufferedImage()
		{
		int h = this.bufferedImage.getHeight();
		int w = this.bufferedImage.getWidth();

		for(int i = 0; i < h; i++)
			{
			int colorRGB = colorLine(i);
			for(int j = 0; j < w; j++)
				{
				this.bufferedImage.setRGB(j, i, colorRGB);
				}
			}
		}

	private int colorLine(int i)
		{
		int h = this.bufferedImage.getHeight();
		double stepHue = 1/(double)(h-1);
		double hue01 = (i*stepHue);
		System.out.println(hue01);
		Assert.assertTrue(hue01>=0 && hue01<=1);
		int colorRGB = Color.HSBtoRGB((float)hue01, 1, 1);
		return colorRGB;
		}


	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private BufferedImage bufferedImage;

	}
