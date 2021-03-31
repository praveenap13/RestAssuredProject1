package restassuredpack;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEnd {
	@Test(enabled=true)
    public static void  endToendTest() {
    	String userId="12335";
    	String username="Teeelecon";
    	String password="Test2@123";
    	String baseUrl = "https://bookstore.toolsqa.com";
    	
    	  RestAssured.baseURI = baseUrl;
          RequestSpecification request = RestAssured.given();
          request.header("Content-Type", "application/json");
          Response response = request.body("{ \"userName\":\"" + username + "\", \"password\":\"" + password + "\"}")
                  .post("https://bookstore.toolsqa.com/swagger/#/Account/AccountV1GenerateTokenPost");
          Assert.assertEquals(response.getStatusCode(), 200);
          String jsonString = response.asString();
          Assert.assertTrue(jsonString.contains("token"));
          //This token will be used in later requests
          //JsonPath  is a class 
          //static JsonPath from(String text)-	Instantiate a new JsonPath instance.
          
          String token = JsonPath.from(jsonString).get("token");	
          System.out.println(token);
    }
	@Test
	public void getBook() {

		  String baseUrl = "https://bookstore.toolsqa.com";
	      RestAssured.baseURI = baseUrl;
		  RequestSpecification request=RestAssured.given();
		  Response response = request.get("/BookStore/v1/Books");
		  String responseString=response.asString();
			  
		 List<Map<String, String>> books= JsonPath.from(responseString).get("books");
		        
		
		

		
	}
}