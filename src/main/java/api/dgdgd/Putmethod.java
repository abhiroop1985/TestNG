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
	
	@Test(priority=1,groups = {"putMethod"})

	public static void putMet() {
		// TODO Auto-generated method stub
		
RestAssured.baseURI= "http://localhost:3000/posts/2";
		
						
			given().contentType(ContentType.JSON)
			
			.body(App.bodyJSON(3, "New Title", "New Author"))
			
		
			.when().log().all()
			
			.put(baseURI)
			
			.then()
			.log().all()
			.assertThat().statusCode(200)
			.extract().response().toString();
		
		
		
	}
	
	@Test(priority=2,groups = {"GetMethod"})
	
	public static void getmet() {
		
		System.out.println("Entering Get Method");
		
		//RestAssured.baseURI = "http://localhost:3000/posts/2";
		
		
		String recordStr= 
				given().			
				when().get(baseURI)
				
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
	
	Assert.assertEquals("New Author", newAuthor);
	Assert.assertEquals("New Title", newTitle);
	
	}
	

}
