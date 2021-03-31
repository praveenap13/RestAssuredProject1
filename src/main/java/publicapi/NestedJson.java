package publicapi;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class NestedJson {

	@Test
	public void jsonNestedString() {
		String s= "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"address\": [\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"permanent\",\r\n" + 
				"      \"city\": \"Bengaluru\",\r\n" + 
				"      \"state\": \"KA\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"temp\",\r\n" + 
				"      \"city\": \"Bhopal\",\r\n" + 
				"      \"state\": \"MP\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		JsonPath jp=new JsonPath(s);
		String addr=jp.getString("address");
		System.out.println(addr);
		String city=jp.getString("address.city");
		System.out.println(city);
		
	Object fname=jp.get("firstName");
	System.out.println(fname);
	
	String fname1=jp.getString("firstName");
	System.out.println(fname1);
	
	String s1= "{\r\n" + 
			"  \"firstName\": \"Amod\",\r\n" + 
			"  \"lastName\": \"Mahajan\",\r\n" + 
			  
			"}";
	JsonPath path=new JsonPath(s1);
	String i=path.get("firstName");//ok
		//int i=path.get("firstName");//java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
		System.out.println("first nmae "+i);
		
		String s2= "{\r\n" + 
				"  \"firstName\": \"123\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				  
				"}";
		JsonPath path1=new JsonPath(s2);
		String fnm=path1.get("firstName");
		System.out.println(fnm);
		int fnm1=Integer.parseInt(path1.get("firstName"));
		System.out.println(fnm1);
		
		
		String str="amol";
		//System.out.println(Integer.parseInt(str));//java.lang.NumberFormatException: For input string: "amol"
		String firstname1=path1.getString("firstname1");//not exist in path1 : Null valid for String 
		System.out.println(firstname1);
		//int firstname2=path1.getInt("firstname1");	//nullpointerexception	
		//System.out.println(firstname2);
		System.out.println(path1.getString("$"));
		System.out.println((Object)path1.get());
		System.out.println(path1.getString(""));
	}
	
}
