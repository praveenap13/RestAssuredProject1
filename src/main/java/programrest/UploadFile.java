package programrest;

import java.io.File;

import org.apache.http.HttpHeaders;

import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class UploadFile {
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
		
		
		
		File file =new File("D:\\eclipse workspace\\RestAssuredProject\\src\\test\\resources\\testfile.docx");
		
		
		given().log().all()
		
       // .pathParam("key","BHIM-3")
        .header("content-Type","multipart/form-data")
		
        .header("X-Atlassian-Token", "nocheck")
        //.header("Cookie",s)
        .filter(sessionfilter)
        .multiPart("file",file)
        .when().post("http://localhost:8080/rest/api/2/issue/BHIM-4/attachments")
        .then().log().all().assertThat().statusCode(200).log().all();
		
	}
}
