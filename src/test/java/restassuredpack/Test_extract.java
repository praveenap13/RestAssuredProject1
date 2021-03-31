package restassuredpack;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Test_extract {

	public static void main(String[] args) {
		/*
		 * Map<String,String> map=new HashMap<String,String>();
		 * 	map.put("name","Raghav");
		map.put("job","Teacher");
		//map.put("ID", "123");
		System.out.println(map);
		//System.out.println(req.toJSONString());
		 */
	String body="{\r\n" + 
			"    \"name\": \"philips\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}";
		String s=given().
		      header("Content-Type","application/json").
		      contentType(ContentType.JSON).
		      body(body).
		when().
		      post("https://reqres.in/api/users").
		then().
		      statusCode(201)
		      .extract().asString();
		System.out.println(s);
		JsonPath  path=new JsonPath(s);
		
		String s1=path.getString("job");
		System.out.println(s1);
      
	}

}
