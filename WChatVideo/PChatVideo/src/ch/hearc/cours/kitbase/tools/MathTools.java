
package ch.hearc.cours.kitbase.tools;

public class MathTools
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static boolean isEquals(double a, double b, double epsilon)
		{
		if (a != 0 && b != 0)
			{
			return Math.abs((a - b) / a) <= epsilon;
			}
		else
			{
			return Math.abs(a - b) <= epsilon;
			}
		}

	public static boolean isEquals(double a, double b)
		{
		return isEquals(a, b, 1e-6);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
