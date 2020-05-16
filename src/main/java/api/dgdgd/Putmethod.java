package api.dgdgd;
import api.dgdgd.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Putmethod {
	
	static int id = 4;												//Setting up a variable for id
	static String title2 = "Updated Title";							//Setting up a variable for title
	static String author2= "Updated Author";  						//Setting up a variable for author
	
	@Test(priority=1,groups = {"putMethod"})

	public static void putMet() {
		// TODO Auto-generated method stub
		
RestAssured.baseURI= "http://localhost:3000/posts/";
		
						
			given().contentType(ContentType.JSON)
			
			.body(App.bodyJSON(id, title2, author2))
			
		
			.when().log().all()
			
			.put(baseURI+id)
			
			.then()
			.log().all()										//Log a;; output in console 
			.assertThat().statusCode(200);						//Verify the status code is 200
			//.extract().response().toString();
				
	}
	
	@Test(priority=2,groups = {"GetMethod"})
	
	public static void getmet() {
		
		System.out.println("Entering Get Method");
				
		
		String recordStr= 
				given().			
				when().get(baseURI+id)
				
				.then()
				
				.log().all()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
		//System.out.println(recordStr);
		
	JsonPath js = new JsonPath(recordStr);
	
	String newAuthor = js.getString("author");
	String newTitle = js.getString("title");
	
	//System.out.println(newTitle);
	//System.out.println(newAuthor);
	
	Assert.assertEquals(author2, newAuthor);
	Assert.assertEquals(title2, newTitle);
	
	}
	

}
