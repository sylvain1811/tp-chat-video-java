
package ch.hearc.cours.gui.java2D.affineTransformMieu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JPanel;

public class JPanelSalleConf extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelSalleConf(int nbTable)
		{
		this.nbTable = nbTable;
		this.rectangle = new Rectangle2D.Double(-50, -25, 100, 50);
		this.alphaAnimation = 0;
		this.isFini = new AtomicBoolean(true);
		this.isRunning = new AtomicBoolean(false);
		this.dAlphaAnimation = 0;
		this.sleep_ms = 500;
		this.sensRotation = RotationSens.HORAIRE;
		this.tabColor = new Color[] { Color.BLUE, Color.RED };
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g); // en premier !!!
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform trasformInitial = g2d.getTransform(); // Concerne uniquement le repère de math
		dessiner(g2d);
		g2d.setTransform(trasformInitial);
		//System.out.println(Thread.currentThread().getName());
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	protected void setDAlphaAnimation(double value)
		{
		this.dAlphaAnimation = value;
		}

	protected void setSleepTime(long value)
		{
		this.sleep_ms = value;
		}

	protected void setRotateSens(RotationSens rotationSens) //remplacer int
		{
		this.sensRotation = rotationSens;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void dessiner(Graphics2D g2d)
		{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		originToCenter(g2d);
		startAngel(g2d);
		salle(g2d);
		}

	private void startAngel(Graphics2D g2d)
		{
		g2d.rotate(this.alphaAnimation);
		}

	private void AnimationStep()
		{
		this.alphaAnimation += (this.sensRotation.getSensRotation() * this.dAlphaAnimation);
		}

	public synchronized void start()
		{
		if (!JPanelSalleConf.this.isRunning.get())
			{
			this.isRunning.set(true);
			Thread t1 = new Thread(new Runnable()
				{

				@Override
				public void run()
					{
					JPanelSalleConf.this.isFini.set(false);
					while(!JPanelSalleConf.this.isFini.get())
						{
						AnimationStep();
						JPanelSalleConf.this.repaint(); //poste une requete de refresh dans le awt-queue-event,on ne contrôle pas le moment ou elle sera exécutée. apelle asyncrone. sera honoré au bon vouleur de awt-queue-event. rend la main immédiatement !
						dodo(JPanelSalleConf.this.sleep_ms);
						}
					JPanelSalleConf.this.isRunning.set(false);
					}
				});
			t1.start();
			}
		}

	public synchronized void stop()
		{
		this.isFini.set(true); // on poste une requete d'arret, qui ne sera peut-etre pas exécuter immédiatement!
		}

	private void salle(Graphics2D g2d)
		{
		double rayon = rayonCalc();
		double theta = 2 * Math.PI / this.nbTable;

		for(int i = 1; i <= this.nbTable; i++)
			{
			g2d.setColor(this.tabColor[i % this.tabColor.length]);
			g2d.translate(0, rayon);
			g2d.fill(rectangle);
			g2d.translate(0, -rayon);
			g2d.rotate(theta);
			}

		}

	/**
	 * le quart de la surface disponible
	 */
	private double rayonCalc()
		{
		return Math.min(this.getSize().getWidth(), this.getSize().getHeight()) / 4;
		}

	private void originToCenter(Graphics2D g2d)
		{
		g2d.translate(this.getSize().getWidth() / 2, this.getSize().getHeight() / 2);
		g2d.scale(1, -1);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static void dodo(long ms)
		{
		try
			{
			Thread.sleep(ms);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	private int nbTable;

	//Tools
	private Rectangle2D rectangle;
	private double alphaAnimation;
	private double dAlphaAnimation;
	private AtomicBoolean isFini;
	private AtomicBoolean isRunning;
	private long sleep_ms;
	private RotationSens sensRotation;
	private Color[] tabColor;

	}
