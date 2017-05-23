
package ch.hearc.cours.gui.java2D.hello;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class JPanelJava2DHello extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelJava2DHello()
		{
		ligne1 = new Line2D.Double(10, 10, 100, 100); // x1, y1, x2, y2
		ligne2 = new Line2D.Double(10, 10, 80, 40);
		ligne3 = new Line2D.Double(10, 10, 40, 80);

		rectangle1 = new Rectangle2D.Double(20, 100, 100, 100); // x1, y1, largeur, hauteur
		rectangle2 = new Rectangle2D.Double(200, 0, 100, 100);
		rectangle3 = new Rectangle2D.Double(50, 50, 150, 150);

		ellipse1 = new Ellipse2D.Double(400, 200, 100, 80); // x1, y1, diagonale horizontale, diagonale verticale

		arc1 = new Arc2D.Double(400, 10, 50, 60, 0, 270, Arc2D.PIE); // x1, y1, w, h, angle start, angle stop, type de fermeture

		stringBleu = new String("Bleu");
		stringRouge = "Rouge";

		font1 = new Font("Helvetica", Font.BOLD + Font.ITALIC, 40);

		stroke = new BasicStroke(10, BasicStroke.JOIN_MITER, BasicStroke.CAP_ROUND); //TODO Traitillé

		//Traitillé
			{
			float[] tabDesignTraitille = new float[] { 10, 20 };//10: longueur du trait plein 20: //longueur de l'espace
			strokeTraitille = new BasicStroke(15, BasicStroke.JOIN_MITER, BasicStroke.CAP_ROUND, 10, tabDesignTraitille, 0);
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		AffineTransform trasformInitial = g2d.getTransform(); // Concerne uniquement le repère de math
		dessiner(g2d);
		g2d.setTransform(trasformInitial);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Attention : Pour des raisons de performances, ne rien instancier dans dessiner().
	 */
	private void dessiner(Graphics2D g2d)
		{
		g2d.setColor(Color.BLUE);
		g2d.draw(ligne1);
		g2d.draw(ligne2);
		g2d.drawString(stringBleu, 200, 300);
		// g2d.draw(rectangle1);
		g2d.draw(ellipse1);

		g2d.setFont(font1);
		g2d.setColor(Color.RED);
		g2d.draw(ligne3);
		g2d.drawString(stringRouge, 200, 200);
		g2d.fill(rectangle2);
		g2d.draw(arc1);

		g2d.setStroke(stroke);
		g2d.draw(rectangle1);

		g2d.setStroke(strokeTraitille);
		g2d.draw(rectangle3);

		g2d.rotate(Math.PI / 2);
		g2d.translate(-50, -400);
		g2d.scale(2, 1);
		g2d.drawString(stringRouge, 200, 200);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Line2D ligne1;
	private Line2D ligne2;
	private Line2D ligne3;

	private Rectangle2D rectangle1;
	private Rectangle2D rectangle2;
	private Rectangle2D rectangle3;

	private Ellipse2D ellipse1;

	private Arc2D arc1;

	private String stringBleu;
	private String stringRouge;

	private Font font1;

	private Stroke stroke;
	private Stroke strokeTraitille;
	}
