package api.dgdgd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DelMet {
@Test (priority = 1,groups = {"DeleteMethod"})
	public static void delMethod() {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "http://localhost:3000/posts/1";
	

			given().log().all()
			
			.when().delete(baseURI)
			
			.then()
			
			.log().all()
			.assertThat().statusCode(200);
			//.extract().response().asString();
	
	}

@Test(priority = 2, groups = {"DeleteMethod"})

public static void getmet() {
	
	System.out.println("Entering Get Method");
	RestAssured.baseURI = "http://localhost:3000/posts/7";
	
	
	
			given().log().all()	
			
			.when().get(baseURI)
			
		.then()
		
		.log().all()
		.assertThat().statusCode(404);
		

}

@Test(priority = 3, groups = {"DeleteMethod"})

public static void getnegative() {
	
	System.out.println("Entering Get Method");
	//RestAssured.baseURI = "http://localhost:3000/posts/7";
	
	
	
			given().log().all()			
			
			.when().get(baseURI)
			
			.then()
			
			.log().all()
			.assertThat().statusCode(404);
		

}
}
