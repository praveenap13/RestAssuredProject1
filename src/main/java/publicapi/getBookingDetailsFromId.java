package publicapi;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;
//import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
public class getBookingDetailsFromId{
	public static void main(String[] args){
		String s=given()
		.accept(ContentType.JSON)
		.get("https://gorest.co.in/public-api/users/15")
		.asString();
		System.out.println(s);
		
		given()
		.accept(ContentType.JSON)
		.get("https://gorest.co.in/public-api/users/23")
		.then()
		.body("data.email",containsString("udit_i_bandopadhyay"));
		
		JsonPath path=new JsonPath(s);
		Assert.assertEquals(15, path.getInt("data.id"),"id not matched-err msg");
		
	}
}

