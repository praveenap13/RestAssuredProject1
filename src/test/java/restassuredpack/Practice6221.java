package restassuredpack;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;

public class Practice6221 {
	public static void main(String[] args) {
		String name="Vinit";
		String email="1223@gmail.com";
		String gender="Male";
		String status="Active";
		String updatedBody = String.format(ProvideData.addUser(), 
				name,email,gender,status);
				given()
				.contentType(ContentType.JSON)
				.body(updatedBody)
				.log().all()
				.when()
				.post("//https://gorest.co.in/public-api/users")
				.then().log().all();
				//.assertThat()
				//.body("gender", containsString("Male"));
	}

}
/*
 * {"id":3,"name":"Rajan Naik","email":"rajan_naik@parker.name","gender":"Male","status":"Active",
 * "created_at":"2021-02-06T03:50:04.321+05:30","updated_at":"2021-02-06T03:50:04.321+05:30"},
 * {"id":6,"name":"Sarala Jain MD","email":"md_jain_sarala@goodwin-adams.net","gender":"Male",
 * "status":"Inactive","created_at":"2021-02-06T03:50:04.402+05:30",
 * "updated_at":"2021-02-06T03:50:04.402+05:30"},
 * {"id":7,"name":"Ayushmati Mishra","email":"ayushmati_mishra@rohan-runolfsson.name","gender":"Male",
 * "status":"Active","created_at":"2021-02-06T03:50:04.412+05:30","updated_at":"2021-02-06T03:50:04.412+05:30"},

 */