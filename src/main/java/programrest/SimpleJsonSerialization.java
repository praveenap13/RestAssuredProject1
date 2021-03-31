package programrest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SimpleJsonSerialization {
	@Test
	public void createSimpleJsonfromSimpleJsonPOJOClass() {
		SimpleJson sj=new SimpleJson();
		sj.setFirstname("praveena");
		sj.setLastname("parab");
		sj.setAge(35);
		sj.setGender("female");
		sj.setSalary(50000.00);
		sj.setMarried(false);
		
		given().log().everything()
	    .contentType(ContentType.JSON)
	    .body(sj)
	    .when()
	    .post()
	    .then().log().all();
		
	}

}
