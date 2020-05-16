package api.dgdgd;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;

import io.restassured.RestAssured;


public class getmethod {
	@Test
	public static void getMethod_01() {
		// TODO Auto-generated method stub
		
		
		RestAssured.baseURI = "http://localhost:3000/posts/";
		
	
		String recordStr= 
				given().log().all()
				
				.when().get(baseURI)
				
				.then()
				
				.log().all()
				.assertThat().statusCode(200)
				.extract().response().asString();
		
System.out.println("recordStr");

	}	

}
