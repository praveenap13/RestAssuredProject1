package restassuredpack;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class Tests_POST {

	
	public static void test_post() {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("\"name\"","Raghav");
		//"name"
		map.put("job","Teacher");
		System.out.println(map);
		//JSONObject req=new JSONObject(map);
		JSONObject req=new JSONObject();
		req.put("job", "teacher");
		System.out.println(req);
		System.out.println(req.toJSONString());
		given().
		      header("Content-Type","application/json").
		      contentType(ContentType.JSON).
		      body(req.toJSONString()).
		when().
		      post("https://reqres.in/api/users").
		then().
		      statusCode(201);
		   
	}
	
	public static void main(String[] args) {
		test_post();
	}

}
