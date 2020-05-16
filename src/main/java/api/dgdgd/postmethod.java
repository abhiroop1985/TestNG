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
				
			given().contentType(ContentType.JSON)
			
			.body(App.bodyJSON(Id,author,title))
			.log().all()
		
			.when()
			.post(baseURI)
			
			.then()
			.log().all()
			.assertThat().statusCode(201)
			//.body("id", equalTo(18))
			//.header("Location", "http://localhost:3000/posts//18")
			.extract().response().asString();
		
		
	JsonPath aName = new JsonPath(responseBody);
	String authorName = aName.getString("author");
	System.out.println(authorName);
		
		
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

	//@DataProvider(name="BooksData")

//	public Object[][][]  getData()

	{

	//array=collection of elements

	//multidimensional array= collection of arrays

	//return (Object[][][]) new Object[][] {‌{"21","Title21","Author 21"},{"22","Title 22","Author 22"}, {"23","Title 23","Author 23"} };

	}
}

