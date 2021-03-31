package restassuredpack;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractPath {
	@Test
	public static void extractParamter() {
		//RestAssured.baseURI="https://gorest.co.in/public-api/users";
		String name=given()
		   .contentType(ContentType.JSON).log().all()
		   .get("https://gorest.co.in/public-api/users/1338")
		   .then()
		   .extract()
		   .path("name");
		System.out.println("Name is  :  "+name);
	}
}
