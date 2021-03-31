package restassuredpack;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.Matchers.*;

public class PostUser {
	@Test
	public static void user() {
	RestAssured.baseURI="http://ergast.com/api/f1/2017/circuits.json";
	String circuitId= "central park";
	String circuitName="circuit-west";
	String url="https://www.softwaretestinghelp.com/xpath-axes-tutorial/";
	String.format(TestData.addCircuit(),circuitId,circuitName,url );
	
	String circuiteId= given()
		.contentType(ContentType.JSON)
		.body(String.format(TestData.addCircuit(),circuitId,circuitName,url ))
		.log().all()
		.when()
		.post("http://ergast.com/api/f1/2017/circuits.json")
		.then().extract().path("MRData.CircuitTable.Circuits.circuitId[0]");
	
	
	given()
	.pathParam("circuiteId",circuiteId)
	.when()
	.get("http://ergast.com/api/f1/2017/circuits/{circuiteId}.json")
	.then()
	.assertThat()
	.body("MRData.CircuitTable.Circuits.Location[0].country",equalTo("Australia"))
	.statusCode(200);
	}
	@Test
	public void NumberofcircuitFor2017Season_shouldbe20() {
		given()
		.when()
		.get("http://ergast.com/api/f1/2017/circuits.json")
		.then()
		.assertThat()
		.body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
   @Test
   public void responseHeaderdata_shouldbecorrect() {
	given()
	.when()
	.get("http://ergast.com/api/f1/2017/circuits.json")
	.then()
	.assertThat()
	.statusCode(200)
	.header("Content-Length", equalTo("4551"));
    }
   
   public void testBody() {
	   String season="2016";
	     given().
       pathParam("raceSeason",season).
   when().
       get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
   then().
       assertThat().
       body("circuitId",equalTo("BAK"));
   }
   public void whenTest() {
	  
			 Response  response=RestAssured.get("http://ergast.com/api/f1/2017/circuits.json");
	         ResponseBody body=    response.body();
	         body.jsonPath();
   }
}
