package restassuredpack;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ExtractDemo {
	@Test(enabled=false)
	public static void addBookToLibrary(){
		String bookName    = "Secrets";
		String isbnNumber  = "Mira";
		String aisleNumber = "AAbb2266";
		String authorName  = "vicram";
		String updatedBody = String.format(TestData.addBookPayLoad(),bookName, isbnNumber, aisleNumber,authorName);
		System.out.println(updatedBody);
				String s= given()
				.contentType(ContentType.JSON)
				.body(updatedBody)
				.when()
				.post("http://216.10.245.166/Library/Addbook.php")
				.then().log().all()
				.assertThat().statusCode(200)
				.extract().path("ID");
				System.out.println(s);	
				
				JsonPath jp=new JsonPath(s);
			String bookId=	jp.getString("ID");
			Assert.assertEquals(bookId,isbnNumber+aisleNumber);
				
	}
	@Test(enabled=false)
	public static void deleteBookToLibrary(){
		String id="MiraAAbb2266";
		RestAssured.baseURI="http://216.10.245.166/Library/DeleteBook.php";
        RequestSpecification request= RestAssured.given();
	    Response response = request.param("ID", id).delete();
	  int responsecode=  response.getStatusCode();
	  Assert.assertEquals(responsecode, 200);
	  System.out.println(response.asString());
	}

@Test
public static void getBookfromLibrary(){
	RestAssured.baseURI="http://216.10.245.166/Library/DeleteBook.php";
String s=	given()
           .accept(ContentType.JSON)
           .param("ID", "MiraAA2266")
           .when()
           .get()
           .thenReturn()
           .asString();
           System.out.println(s);
}


}


