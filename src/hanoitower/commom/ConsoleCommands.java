package hanoitower.commom;

public class ConsoleCommands {

	public final static String clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	        return os;
	    }
	    catch (final Exception e)
	    {
	        return "Não funcionou";
	    }
	}
}
