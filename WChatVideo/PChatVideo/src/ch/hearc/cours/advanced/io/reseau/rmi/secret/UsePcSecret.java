
package ch.hearc.cours.advanced.io.reseau.rmi.secret;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UsePcSecret
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

			PcSecret.init(serverName);
			PcSecret.getInstance().run();
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
