package restassuredpack;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Test_01Get{
  @Test
   static void test_01(){
	 Response response = RestAssured.get("https://reqres.in/api/users/3");
	 System.out.println(response.asString());
	 System.out.println(response.getBody());
	 int code=response.getStatusCode(); 
	  //Assert.assertEquals(code,200);
   }
  /* public static void main(String[] args) {
	   test_01();
	   
   }
   */
}
