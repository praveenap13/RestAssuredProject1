package restassuredpack;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;

public class CreateUserGorest {
	public static void main(String[] args){
		int Id    = 001;
		String name  = "Miraj";
		String email  = "miraj@gmail.com";
		String gender  = "Male";
		String status="Active";
		String updatedBody = String.format(TestData.addUser(),Id, name, email,gender,status);
		System.out.println(updatedBody);
			String response=given()
				.contentType(ContentType.JSON)
				.body(updatedBody)
				.log().all()
				.when()
				.post("https://gorest.co.in/public-api/users")
				.then().log().all().extract().asString();
				;
	}
//id":15,"name":"Soma Rana","email":"soma_rana@hudson-windler.info","gender":"Female","status":"Inactive","created_at":"2021-02-07T03:50:03.906+05:
}
