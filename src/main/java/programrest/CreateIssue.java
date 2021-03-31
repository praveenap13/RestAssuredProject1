package programrest;
import static io.restassured.RestAssured.given;

import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class CreateIssue {
	public static void main(String[] args) {
		UserAuth auth=new UserAuth();
		UserAuth  user=new UserAuth();
		user.setUsername("praveena");
		user.setPassword("praveena");
		SessionFilter  sessionfilter=new SessionFilter();
		String value=given().log().everything()
	    .contentType(ContentType.JSON)
	    .filter(sessionfilter)
	    .body(user)
	    .when()
	    .post("http://localhost:8080/rest/auth/1/session")
	    .then().log().all()
	    .extract().asString();
		JsonPath js=new JsonPath(value);
		String s=js.getString("session.value");
		
		IssueType issue=new IssueType("Task");
		Project p=new Project("BHIM");
		Fields f=new Fields("Creating a new bug false ceiling for me ",
				"repeated bug false ceiling for me",p,issue);	
		
		PayLoad payload=new PayLoad(f);
		//SessionFilter  sessionfilter=new SessionFilter();
		given().log().everything()
		.filter(sessionfilter)
	    .contentType(ContentType.JSON)
	   // .header("Cookies",s)
	    .body(payload)
	    .when()
	    .post("http://localhost:8080/rest/api/2/issue/")
	    .then().log().all(); 
	}
}
