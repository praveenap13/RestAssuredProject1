package restassuredpack;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
   public class Tests_GET {
	   
	    public static void test_1() {
	    	given().
	    	header("Content-Type","application/json").
	    	
	    	get("https://reqres.in/api/users?page=2").
	    	then().statusCode(200).
	    	body("data.id[1]",equalTo(8)).
	    	body("data.first_name",hasItems("Michael","Lindsay")).
	    	log().all();
	    }
	    public static void main(String[] args) {
	    	test_1();
	    }
}
