package api.dgdgd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;




public class DelMet {
	
	static int id = 2;											//Set a integer variable 
	
@Test (priority = 1,groups = {"DeleteMethod"})


	public static void delMethod() {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "http://localhost:3000/posts/";
	

			given().log().all()
			
			.when().delete(baseURI+id)							// sending URI
			
			.then()
			
			.log().all()
			.assertThat().statusCode(200);						//Verify the Status Code
			
	
	}

@Test(priority = 2, groups = {"DeleteMethod"})

public static void getmet() {
	
	System.out.println("Entering Get Method");
	
		
			given().log().all()	
			
			.when().get(baseURI+id)								//Verify if the ID has been deleted
			
		.then()
		
		.log().all()
		.assertThat().statusCode(404);							//Verify the status code
		

}

//@Test(priority = 3, groups = {"DeleteMethod"})

/*public static void getnegative() {
	
	System.out.println("Entering Get Method");
	//RestAssured.baseURI = "http://localhost:3000/posts/7";
	
	
	
			given().log().all()			
			
			.when().get(baseURI)
			
			.then()
			
			.log().all()
			.assertThat().statusCode(404);
		

}*/
}
