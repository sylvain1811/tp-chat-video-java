
package ch.hearc.cours.gui.java2D.affineTransform;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelJava2DSalleConference extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelJava2DSalleConference(int nbTables)
		{
		//Inputs
			{
			this.nbTables = nbTables;
			}

		//Tools
			{
			this.alphaAnimation = 0;
			this.dAlphaAnimation = 2 * Math.PI / 1000;
			this.animationSleep = 50;
			isFini = new AtomicBoolean(false);
			isRunning = new AtomicBoolean(false);

			rectangle = new Rectangle2D.Double(-50, -25, 100, 50); // x1, y1, largeur, hauteur
			}

		geometry();
		control();
		apparence();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		//System.out.println(Thread.currentThread().getName());
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		dessiner(g2d);
		g2d.setTransform(transform);
		}

	private void dessiner(Graphics2D g2d)
		{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		centrer(g2d);
		gestionStartAngle(g2d);
		salle(g2d);
		}

	private void gestionStartAngle(Graphics2D g2d)
		{
		g2d.rotate(alphaAnimation);
		}

	private void animationStep()
		{
		alphaAnimation += dAlphaAnimation;
		}

	private synchronized void start()
		{
		if (!isRunning.get())
			{
			isRunning.set(true);
			Thread thread = new Thread(new Runnable()
				{

				@Override
				public void run()
					{
					isFini.set(false);
					while(!isFini.get())
						{
						animationStep();
						JPanelJava2DSalleConference.this.repaint();//Poste une requete de rafraichissement au thread awt-queue-event. Appel asynchrone. Sera honoré au bon vouloir de awt-queue-event. Rend la main immédiatement !
						dormirMS(animationSleep);
						}
					isRunning.set(false);
					}
				});

			thread.start();
			}
		}

	private synchronized void stop()
		{
		isFini.set(true); //On poste au thread une demande d'arrêt. Elle ne sera pas forcément réalisée immédiatement !
		}

	private void salle(Graphics2D g2d)
		{
		double rayon = rayon();
		double theta = 2 * Math.PI / nbTables;

		for(int i = 1; i <= nbTables; i++)
			{
			g2d.translate(0, rayon);
			g2d.draw(rectangle);
			g2d.translate(0, -rayon);
			g2d.rotate(theta);
			}
		}

	private void centrer(Graphics2D g2d)
		{
		double dx = getSize().getWidth() / 2;
		double dy = getSize().getHeight() / 2;
		g2d.translate(dx, dy);
		g2d.scale(1, -1);
		}

	/**
	 * quart de la surface disponible
	 */
	private double rayon()
		{
		return Math.min(getSize().getHeight(), getSize().getWidth()) / 4;
		}

	private void control()
		{
		buttonStart.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				switchEtat();
				start();
				//JPanelJava2DSalleConference.this.start();
				}
			});

		buttonStop.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				switchEtat();
				stop();
				}
			});

		}

	private void geometry()
		{
		buttonStart = new JButton("Start");
		buttonStop = new JButton("Stop");

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		JPanel jPanelControl = new JPanel();
		jPanelControl.add(buttonStart);
		jPanelControl.add(buttonStop);

		add(jPanelControl, BorderLayout.SOUTH);
		}

	private void apparence()
		{
		//		buttonStart.setEnabled(true);
		//		buttonStop.setEnabled(false);
		}

	private void switchEtat()
		{
		//		buttonStart.setEnabled(!buttonStart.isEnabled());
		//		buttonStop.setEnabled(!buttonStop.isEnabled());
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static void dormirMS(long delayMS)
		{
		try
			{
			Thread.sleep(delayMS);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private double nbTables;

	// Tools
	private Rectangle2D rectangle;
	private double alphaAnimation;
	private double dAlphaAnimation;
	private long animationSleep;
	private AtomicBoolean isFini;
	private AtomicBoolean isRunning;

	private JButton buttonStart;
	private JButton buttonStop;

	}
