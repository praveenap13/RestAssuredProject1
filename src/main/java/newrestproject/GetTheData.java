package newrestproject;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;

public class GetTheData  extends BaseSetUp{
	
	@Test
	public void dataofUsers() {
		Map<String,String> headers=new HashMap<String,String>();
		headers.put("Accept", "application/xml");
		String body=given()
		.headers(headers)
		.when()
		.get("/users/18")
		//.thenReturn() //valid
		//.body()
		.asString();
		System.out.println(body);
	}
	@Test
	public void contentValidation() {
		 given()
		.accept(ContentType.XML)
		.get("/users/203")
		.then()
		.body("data.name",containsString("Bharadwaj Kaur") ,"data.status",equalTo("Inactive"));
		 
	}
	@Test
	public void contentvalidation2() {
	String data=	given()
		.accept(ContentType.XML)
		.get("/users/110")
	    .thenReturn()//cant use then() to save result in a variable so using thenreturn()
		.asString();
	System.out.println(data);
		
	}
	@Test
	public void contentvalidation3() {
	given()
		.accept(ContentType.XML)
		.get("/users/110")
	    .then()//cant uuse thenReturn
		.assertThat()
		.body("data.id",equalTo(110), "data.email",contains("bhaaswar"));
		//.and()
		//.assertThat()
		//.body("data.id",equalTo(110) );
	
		
	}
	@Test(enabled=false)
	public void testContentXmlpath() {
	String s=	given()
		.accept(ContentType.XML)
		.when()
		.get("/users/110")
		.thenReturn()
		.asString();
	XmlPath xml=new XmlPath(s);
	
	/*
	System.out.println(xml.getInt("data.id"));
	System.out.println(xml.getString("data.name"));
	List<String> list=xml.getList("data");
	System.out.println(list.size());
	for(String str:list) {
		System.out.println(str);
	}
	*/
	
	Assert.assertEquals(110,xml.getInt("data.id"));
	
	}
	@Test
	public void testContentJsonpath() {
		String s=	given()
			.accept(ContentType.JSON)
			.when()
			.get("/users/110")
			.thenReturn()
			.asString();
		JsonPath xml=new JsonPath(s);
		Assert.assertEquals(110,xml.getInt("data.id"));
		Assert.assertEquals("Bhaaswar Arora",xml.getString("data.name"));
		}
	@Test
	public void testQueryParameter() {
	String s=	given()
		.accept(ContentType.JSON)
		.param("id",110)
		.param("name","Bhaaswar Arora")
		.when()
		.get("/users/110")
		.thenReturn()
		.asString();
	System.out.println(s);
	}


}
