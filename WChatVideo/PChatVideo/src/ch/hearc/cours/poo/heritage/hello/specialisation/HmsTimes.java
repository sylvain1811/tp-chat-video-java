
package ch.hearc.cours.poo.heritage.hello.specialisation;

import ch.hearc.coursjava.moo.heritage.simple.HmTimes;

public class HmsTimes extends HmTimes
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public HmsTimes(int heures, int minutes, int secondes)
		{
		//appel du constructeur de la classe parente
		super(heures, minutes);

		//construction des attributs propres à la classe dérivée
		this.secondes = secondes;
		}

	public HmsTimes()
		{
		//V1
		//this(0, 0, 0);

		//V2
		super();
		this.secondes = 0;
		}

	public HmsTimes(HmsTimes source)
		{
		super(source); //marche car HmsTimes "EST UN" HmTimes, et rappelons que le constructeur de la classe parente n'accepte seuleuemnt que un HmTimes
		this.secondes = source.secondes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		//V1
		//		{
		//		String stringParent=super.toString(); //super et ni this, ni rien pour éviter la récursivité
		//		String stringEnfant=secondes+"s";
		//
		//		return stringParent + " "+stringEnfant;
		//		}
		//
		//V2
			{
			return super.toString() + " " + secondes + "s";
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void set(int heures, int minutes, int secondes)
		{
		//construction classe parente
		set(heures, minutes); //variation syntaxique: this.set(int,int);

		//construction classe dérivée
		this.secondes = secondes;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int secondes;
	}
