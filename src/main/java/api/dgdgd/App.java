package api.dgdgd;

import io.restassured.RestAssured;



public class App 
{
    public static String uri()
    {
    	return RestAssured.baseURI= "http://localhost:3000/posts/";
    }

public static String bodyJSON(int inid, String ttle, String auth)
{ 
	return "{\"id\":\""+inid+"\","
			+ " \"title\": \""+ttle+"\","
			+ " \"author\": \""+auth+"\" "
			+ "}";
}}