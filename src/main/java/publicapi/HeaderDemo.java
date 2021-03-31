package publicapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeaderDemo {
@Test
public void HeaderEx() {
	RestAssured.given()
	.log()
	.all()
	.header("Header1","val1")
	.when().get();
	
}
@Test
public void passHeader1() {
	Header header=new Header("Header1","val1");
	RestAssured.given().log().all().header(header).when().get();
}
@Test
public void passHeader2() {
	RestAssured.given().log().all().headers("h1","v1","h2","v2","h3","v3","h4","v4").when().get();
}
@Test
public void passHeader3() {
	Map<String,String> headerMap=new HashMap<>();
	headerMap.put("h1","v1");
	headerMap.put("h2","v2");.
	headerMap.put("h3","v3"); 
	headerMap.put("h4","v4");
	
	RestAssured.given().log().all().headers(headerMap).when().get();
	
}
@Test
public void passHeader4() {
	Header header=new Header("Header1","val1");
	Headers headers=new Headers(header);
	RestAssured.given().log().all().headers(headers).when().get();
}
@Test
public void passHeader5() {
List<Header> allHeaders=new ArrayList<>();
Header header=new Header("Header1","vla1");
Header header2=new Header("Header1","vla1");
allHeaders.add(header);
allHeaders.add(header2);
Headers headers=new Headers(allHeaders);
RestAssured.given().log().all().headers(headers);


}
}
