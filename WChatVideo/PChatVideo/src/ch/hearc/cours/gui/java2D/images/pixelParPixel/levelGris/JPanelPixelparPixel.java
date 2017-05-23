
package ch.hearc.cours.gui.java2D.images.pixelParPixel.levelGris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.junit.Assert;


public class JPanelPixelparPixel extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelPixelparPixel()
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

				JPanelPixelparPixel.this.bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				remplirBufferedImage();
				}
			});

		}

	private void dessiner(Graphics2D g2d)
		{
		g2d.drawImage(this.bufferedImage, 0, 0, null);

		while(true)
			{
				Thread t1 = new Thread(new Runnable()
					{
					@Override
					public void run()
						{
							start=(start+1)%256;

							JPanelPixelparPixel.this.repaint();
							try
								{
								Thread.sleep(3);
								}
							catch (InterruptedException e)
								{
								e.printStackTrace();
								}
						}
					});
				t1.start();
			}

		}

	private void remplirBufferedImage()
		{
		int h = this.bufferedImage.getHeight();
		int w = this.bufferedImage.getWidth();

		for(int i = start; i < h+start; i++)
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
		double step=255/(double)(h-1);
		int levelGris = (int)(i*step)%255;
		Assert.assertTrue(levelGris>=0 && levelGris<=255);
		Color color = new Color(levelGris, levelGris, levelGris);
		int colorRGB = color.getRGB();
		return colorRGB;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private BufferedImage bufferedImage;
	int start=0;

	}
