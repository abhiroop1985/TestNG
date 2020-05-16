package api.dgdgd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String main()
    {
        System.out.println( "Hello World!" );
		return null;
    }

public static String bodyJSON(int inid, String ttle, String auth)
{ 
	return "{\"id\":\""+inid+"\","
			+ " \"title\": \""+ttle+"\","
			+ " \"author\": \""+auth+"\" "
			+ "}";
}}