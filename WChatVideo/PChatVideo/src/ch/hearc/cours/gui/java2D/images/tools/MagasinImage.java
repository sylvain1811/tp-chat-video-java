
package ch.hearc.cours.gui.java2D.images.tools;

import javax.swing.ImageIcon;

/**
* Les images doivent se trouver dans un jar, et le jar dans le classpth!
* Le jar doit contenir le folder ressources. A l'interieur du folder ressource doit se trouver les images aux formats (jpg, voir mieux png pour la transparance)
*/
public class MagasinImage
	{

	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/

	public static final ImageIcon WARNING = ImageLoader.loadSynchroneJar("ressources/warning.png");
	public static final ImageIcon COFFEE = ImageLoader.loadSynchroneJar("ressources/coffee_logo.png");

	/*------------------------------------------------------------------*\
	|*		Version Assynchrone	(non bloquant)							*|
	\*------------------------------------------------------------------*/

	//public static final ImageIcon WARNING = ImageLoader.loadAsynchroneJar("ressources/warning.png");
	//public static final ImageIcon COFFEE = ImageLoader.loadAsynchroneJar("ressources/coffee_logo.png");

	}
