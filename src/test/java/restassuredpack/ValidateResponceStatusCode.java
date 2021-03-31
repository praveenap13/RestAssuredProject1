package restassuredpack;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponceStatusCode {
@Test
	public static void validateStatusCode() {
		RestAssured.baseURI="https://reqres.in/api/unknown";
		 RequestSpecification httprequest=RestAssured.given();
    Response resonse=  httprequest.get("/2");
  int statuscode=  resonse.getStatusCode();
  System.out.println(statuscode);
  Assert.assertEquals(statuscode, 201,"Correct status code returned");
	}


}
