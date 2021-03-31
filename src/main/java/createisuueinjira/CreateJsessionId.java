package createisuueinjira;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJsessionId {
	public static void main(String[] args) {
		JSONObject json=new JSONObject();
		json.put("username","praveena");
		json.put("password","praveena");
		SessionFilter  sessionfilter=new SessionFilter();
	     Response res=	RestAssured.given()
		.header("Content-Type","application/json")
		.filter(sessionfilter)
		.body(json)
		.post("	http://localhost:8080/rest/auth/1/session");
		//.then().log().all();
	     
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().jsonPath().prettify());
		String sessionId=res.getCookies().get("JSESSIONID");
		
		RestAssured.given().contentType(ContentType.JSON)
		.cookie("JSESSIONID",sessionId );
		
		
	}

}
