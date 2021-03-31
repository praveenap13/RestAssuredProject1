package restassuredpack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterRequest {
	@Test
	public void queryParameter() {
	 RestAssured.baseURI = "https://reqres.in/api/unknown";
	 RequestSpecification httpRequest = RestAssured.given();
	 System.out.println(httpRequest);
	 //Response response = httpRequest.get("/2");
	}
}
