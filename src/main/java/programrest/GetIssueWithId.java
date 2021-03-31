package programrest;
/*
 * GET /rest/agile/1.0/issue/{issueIdOrKey}
 *  http://localhost:8080
 */

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

public class GetIssueWithId {

	public static void main(String[] args) {
		String s=given()
				.baseUri("http://localhost:8080")
				.when()
				    .get("/rest/agile/1.0/issue/BHIM-1")
				    .then()
				    .statusCode(200)
				    
				    .toString();
		
	}
}
