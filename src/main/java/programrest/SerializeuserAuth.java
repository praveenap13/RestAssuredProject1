package programrest;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class SerializeuserAuth {
	public static String value;
	public static void main(String[] args) {

		UserAuth  user=new UserAuth();
		user.setUsername("praveena");
		user.setPassword("praveena");
		
		  value=given().log().everything()
	    .contentType(ContentType.JSON)
	    .body(user)
	    .when()
	    .post("http://localhost:8080/rest/auth/1/session")
	    .then().log().all()
	    .extract().asString();
		JsonPath js=new JsonPath(value);
		String s=js.getString("session.value");
		System.out.println(s);
	}

}
