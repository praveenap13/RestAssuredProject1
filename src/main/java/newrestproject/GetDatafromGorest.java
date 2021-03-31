package newrestproject;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetDatafromGorest {
	@Test
	public void GetfromGorest() {
		String s=given()
		.baseUri("https://gorest.co.in")
		.when()
		    .get("/public-api/users/")
		    .then()
		    .statusCode(200)
		    .body("email",Matchers.equalToIgnoringCase("narendra_iyengar_iv@keebler.org"))
		    .toString();
		
		    
		    
	}

}
