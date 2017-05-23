
package ch.hearc.cours.poo.hello.chrono;

public class Chrono
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Chrono(long tempsDelta, long tempsStart, long tempsStop)
		{
		this.tempsDelta = tempsDelta;
		this.tempsStart = tempsStart;
		this.tempsStop = tempsStop;

		start();
		}

	public Chrono()
		{
		this(0, 0, 0);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void start()
		{
		tempsStart = System.currentTimeMillis();
		}

	public long stop()
		{
		tempsStop = System.currentTimeMillis();
		tempsDelta = tempsStop - tempsStart;
		return tempsDelta;
		}

	@Override
	public String toString()//rien n'empêche d'appeler cette méthode si l'on a pas fais start puis stop
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Chrono tempsDelta=");
		builder.append(this.tempsDelta);
		builder.append(" [ms]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public long getTempsDelta()
		{
		return this.tempsDelta;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//input

	//output
	private long tempsDelta;

	//tools
	private long tempsStart;
	private long tempsStop;

	}
