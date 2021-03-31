package restassuredpack;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {
	@Test
	public void createUserSuccessfully() {
	RestAssured.baseURI="https://gorest.co.in/public-api/users";
	RequestSpecification request=RestAssured.given();
	
	JSONObject requestparams=new JSONObject();
	requestparams.put("id","4");
	requestparams.put("name","Ram");
	requestparams.put("email","Ram@gmail.com");
	requestparams.put("gender","Female");
	requestparams.put("status","Active");
	
	//"id":3,"name":"Nagabhushanam Verma","email":"mohit1@gmail.com","gender":"Female","status":"Active",
	  request.body(requestparams.toJSONString());
	  Response response=request.post("https://gorest.co.in/public-api/users");
	  Assert.assertEquals(response.getStatusCode(), 200);
	  String userID = response.getBody().jsonPath().getString("userID");
	  
	}

}
