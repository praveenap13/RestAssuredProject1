package newrestproject;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class ProductResult {
	public static void main(String[] args) {
		Specification spec=new Specification();
		spec.setColor("black");
		spec.setAvailable("amazon");
		
		Pricing price=new Pricing();
		price.setPrice("10000");
		price.setState("maharashtra");
		
		Pricing price2=new Pricing();
		price2.setPrice("11000");
		price2.setState("delhi");
		
		ArrayList<Pricing> list=new ArrayList<>();
		list.add(price);
		list.add(price2);
		
		Products  prod=new Products();
		prod.setBrand("godrej");
		prod.setType("hind");
		prod.setSpecs(spec);
		prod.setPricing(list);
		
		String value=given().log().everything()
	    .contentType(ContentType.JSON)
	   
	    .body(prod)
	    .when()
	    .post()
	    .then().log().all().extract().asString();
		JsonPath js=new JsonPath(value);
		
	}
}
