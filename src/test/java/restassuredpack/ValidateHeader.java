package restassuredpack;

import static org.testng.Assert.assertEquals;

//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Test
public class ValidateHeader {
	
	public void validateHeaders() {
		RestAssured.baseURI="https://reqres.in/api/unknown";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.get("/2");
	    String contentType=	response.header("Content-Type");
		System.out.println("content type is : "+contentType);
		
	assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
		 String serverType=	response.header("Server");
		 System.out.println(serverType + "is a server Type");
		 assertEquals(serverType /* actual value */, "cloudflare" /* expected value */);
		 
		 String acceptLanguage = response.header("Content-Encoding");
		 System.out.println("Content-Encoding: " + acceptLanguage);
		 assertEquals(acceptLanguage /* actual value */, "gzip" /* expected value */);

		}
	public void IteratingOverHeaders()
	{
	 RestAssured.baseURI = "https://reqres.in/api/unknown";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/2");
	Headers allheaders= response.headers();
	for(Header header:allheaders) {
		System.out.println("key :  "+header.getName()+"value :  "+header.getValue());
	}
	
	}

}
