package api.dgdgd;

import api.dgdgd.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import java.net.URI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class postmethod {

	static int Id=37;
	static String author = "New Author";
	static String title = "New Title";
	
	@Test(priority=1, groups="Post Method")
	
	public void test_post() {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "http://localhost:3000/posts/";
		
		String responseBody =
				
			given().contentType(ContentType.JSON)						//Set the content type ( which was not required)
			
			.body(App.bodyJSON(Id,author,title))						//Posting parameters
			.log().all()												// log the input
		
			.when()
			.post(App.uri())
			
			.then()
			.log().all()												//log the output
			.assertThat().statusCode(201)								// Verify if the status code 201
			//.body("id", equalTo(18))
			//.header("Location", "http://localhost:3000/posts//18")
			.extract().response().asString();							//saving and storing the output as string
		
		
	JsonPath aName = new JsonPath(responseBody);						//Converting the string into JSON
	String authorName = aName.getString("author");						// Extracting the Author
	System.out.println(authorName);										// Printing the Author
		
		
	}
	
	@Test(priority=2, groups =("Post Method"))
	
	public void verifyPost() {
		
		given()
		
		.when().log().all()
		
		.get(baseURI+Id)
		
		.then()
		.log().all()
		.assertThat().statusCode(200);
	}


	}
