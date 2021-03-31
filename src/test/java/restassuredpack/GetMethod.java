package restassuredpack;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetMethod {
	@Test
	public void getData() throws URISyntaxException {
	   //URI uri=new URI("http://216.10.245.166/Library/GetBook.php");
		//RestAssured.when().get(uri);
		//static import of restassured
		
		/*
		 * given accept the response in JSon
		 */
		Response response =given()
		.accept(ContentType.JSON).
		when()
		.get(new URI("https://gorest.co.in/public-api/users/18"));
		System.out.println(response.asString());
		
	
	}
	
	public void testStatusCode() {
		/*
		 * Given accept the response in json format
		 * when i perform the get request
		 * then status code 200 ok shoyld be returned
		 */
	int code=	given()
		.accept(ContentType.JSON)
		.when().get("https://gorest.co.in/public-api/users/18")
		.thenReturn()
		.statusCode();
	System.out.println(code);
	Assert.assertEquals(HttpStatus.SC_OK, code);
	}
	public void assertInSameUsingthen(){
				given()
				.accept(ContentType.JSON)
				.when()
				.get("https://gorest.co.in/public-api/users/18")
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_OK);
				/*
			       capture the status code or any other info in that  
			       use method thenreturns
			   */
	}
	@Test
	public void testGetWithId() throws URISyntaxException {
		/**
		 * Given accept the content in json format
		 * when I perform the GET request with 203
		 * Then Status code 200 ok should be returned.
		 */
	given()
	.accept(ContentType.JSON)
	.when()
	.get(new URI("https://gorest.co.in/public-api/users/203"))
	.then()
	.assertThat()
	.statusCode(HttpStatus.SC_OK);
	
			
		
	}
	@Test
	public void testGetWithNonexistId() throws URISyntaxException {
		/**
		 * Given Accept the content in JSON format 
		 * When I Perform the GET re
		 */
		given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("https://gorest.co.in/public-api/users/121"))
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK);
		
			
	}

}
