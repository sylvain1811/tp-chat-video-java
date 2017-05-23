
package ch.hearc.cours.advanced.io.reseau.rmi.horloge;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UsePcHorloge
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		try
			{
			String serverName = InetAddress.getLocalHost().getHostName();

			PcHorloge.init(serverName);
			PcHorloge.getInstance().run();
			}
		catch (UnknownHostException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
