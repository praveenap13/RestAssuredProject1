package newrestproject;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class FamilyJson {
	public static void main(String[] args) {
		Address ob2=new Address();
		ob2.setCity("mumbai");
	    ob2.setState("maharashtra");
	    
	    FamilyMemberAge ob=new FamilyMemberAge();
		ob.setfatherage(42);
		ob.setmotherage(32);
		ob.setsiblingage(12);
	    
		Family f=new Family();
		f.setfamilyHead("praveena");
		f.setfamilyIncome("4000000");
		f.setAddress(ob2);
		f.setFamilyMemberAge(ob);
		
	
		
		given().log().everything()
        .contentType(ContentType.JSON)
        .body(f);
       // .when()
        //.post("http://216.10.245.166/Library/Addbook.php")
       // .then().log().all();
	
	}
	
	
	
	

}
