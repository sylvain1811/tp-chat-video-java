
package ch.hearc.cours.gui.java2D.affineTransformMieu;

public enum RotationSens
	{
	HORAIRE(-1), ANTIHORAIRE(1);

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private RotationSens(int sensRotations)
		{
		this.sensRotations = sensRotations;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/


	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getSensRotation()
		{
		return sensRotations;
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private int sensRotations;
	}
