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
		
		//Retrieve Every record and Display 
		RestAssured.baseURI = "http://localhost:3000/posts/";
		
	
		String recordStr= 					 		//Storing the output in a string
				given().log().all()			 		//Log the input URI
				
				.when().get(baseURI)
				
				.then()
				
				.log().all() 						//Log the output
				.assertThat().statusCode(200)		//Validate if the Status code is 200
				.extract().response().asString();	//Extracting the output as string
		
System.out.println("recordStr");					//Print the string

	}	

}
