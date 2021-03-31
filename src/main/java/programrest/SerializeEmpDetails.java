package programrest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SerializeEmpDetails {
	@Test
	public void details() {
		EmployeeDetails emp =new EmployeeDetails();
		emp.setFirstName("Amod");
		emp.setLastName("Mahajan");
		emp.setAge(29);
		emp.setGender("Male");
		emp.setSalary(12323.56);
		emp.setMarried(false);
		
	   	given().log().everything()
	    .contentType(ContentType.JSON)
	    .body(emp)
	    .when()
	    .post("")
	    .then().log().all();
		
		
	}
}
