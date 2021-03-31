package newrestproject;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateuserAuth {
/*	{
		"username": "praveena",
		"password":"praveena"
	}
	
	http://localhost:8080/rest/auth/1/session
	*/
	@Test
	public void passUserPass() {
		Map<String,String> authpayload=new HashMap<String,String>();
		authpayload.put("username","praveena");
		authpayload.put("password","praveena");
		
		String userpasstoken=RestAssured.given()
		.baseUri("http://localhost:8080/rest/auth/1/session")
		.contentType(ContentType.JSON)
		.body(authpayload)
		.log()
		.all()
		.when()
		   .post()
	   .then()
		   .assertThat()
		   .statusCode(200)
		   .log()
		   .all().extract().asString();
		
	}
}


