
package ch.hearc.cours.gui.java2D.images.hello;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.cours.gui.java2D.images.tools.MagasinImage;

public class JPanelHelloImage extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelHelloImage()
		{
		geometry();
		control();
		appearance();
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

	private void dessiner(Graphics2D g2d)
		{
		g2d.scale(2, 1); //etire l'image horizontalement de 2
		g2d.drawImage(MagasinImage.COFFEE.getImage(),20,20,this); // px,py,observer: tout JComponent est un observeur. Nécéssaire si image chargé de manière asynchrone, sinon, utiliser null
		}

	private void geometry()
		{
		// JComponent : Instanciation
		this.bouton = new JButton("Bouton");

		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		this.add(this.bouton);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		this.bouton.setIcon(MagasinImage.WARNING);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton bouton;

	}
