package createisuueinjira;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class FinalPayload {
public static void main(String[] args)  {
	
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
	
	
	IssueType issue=new IssueType("4");
	Projects pro=new Projects("10200");
	
	Payload pl=new Payload(pro,"No REST for the Wicked.","Creating of an issue using IDs",issue);
	Fields f=new Fields(pl);
	
	//ObjectMapper objmap=new ObjectMapper();
	//String s=objmap.writerWithDefaultPrettyPrinter().writeValueAsString(f);
	//System.out.println(s);
	given().log().everything()
	.contentType(ContentType.JSON)
	.filter(sessionfilter)
	.body(f)
	.when()
	.post("http://localhost:8080/rest/api/2/issue/")
	.then().log().all();
	
	
}
}
