package restassuredpack;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataToTest {
/*
	public static void main(String[] args) {
		new DataToTest().GetData();
	}
	*/
	@Test
	public void GetData() {
		RestAssured.baseURI="https://reqres.in/api/unknown";
		RequestSpecification httprequest = RestAssured.given();
		Response response=httprequest.request(Method.GET,"/2");
		
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
		
		//Or
				Response response2=httprequest.get("/2");
				String responsebody2=response2.asString();
		
	//String s=	response.headers().toString();
	//System.out.println(s);
	
		
	}
}
