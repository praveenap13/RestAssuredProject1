package restassuredpack;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;




public class JsonRead {
	@Test
	public void jsonStringToFetchValue() {
		String  s="{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"name\" : \"Raghvendra Singh\",\r\n" + 
				"    \"purchaseAmount\": 90000,\r\n" + 
				"    \"website\": \"www.testingshastra.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": {\r\n" + 
				"    \"webautomation\": [\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Selenium\",\r\n" + 
				"        \"price\": 5000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Cypress\",\r\n" + 
				"        \"price\": 6000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Protractor\",\r\n" + 
				"        \"price\": 7000\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"api\": [\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Rest API\",\r\n" + 
				"        \"price\": 5000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Soap UI\",\r\n" + 
				"        \"price\": 6000\r\n" + 
				"      }\r\n" + 
				"    ],\r\n" + 
				"    \"MobileAutomation\": [\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"C-Test\",\r\n" + 
				"        \"price\": 5000\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"title\": \"Appium\",\r\n" + 
				"        \"price\": 6000\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"}";
		JsonPath jp=new JsonPath(s);
		int purchaseamt=jp.getInt("dashboard.purchaseAmount");
		/*
		HashMap hm=jp.getJsonObject("courses");
		System.out.println("Size"+hm.entrySet().size());
		Iterator hmitr=hm.entrySet().iterator();
		for( Map.Entry hmitr ;hmitr.hasNext()) {
			 Map.Entry mapElement = (Map.Entry)hmitr.next();
			System.out.println(mapElement.getKey());
			System.out.println(mapElement.getValue());
			    Map.Entry entry=(Map.Entry)mapElement.getValue();
			    {
			    }
			    }
		
		}
		
	*/
		
	List<String> corselist= jp.getList("courses.webautomation");
	System.out.println(corselist.size());
	int totalprize=0;
	/*
	for(int i=0;i<corselist.size();i++) {
		
		  for(int j=0;j<;j++) {
			  totalprize=
		  }
	}
	*/
	
	List<Integer> listprice=jp.getList("courses.webautomation.price");
	
	int webautomationcount=jp.getList("courses.webautomation.price").size();
	int total=0;
	for(Integer prize:listprice) {
		total=total+prize;
	}
	System.out.println(total);
	List<Integer> apiprice=jp.getList("courses.api.price");
	int total2=0;
	for(Integer prize:apiprice) {
		total2=total2+prize;
	}
	System.out.println(total2);
	List<Integer> MobileAutomation=jp.getList("courses.MobileAutomation.price");
	int total3=0;
	for(Integer prize:MobileAutomation) {
		total3=total3+prize;
	}
	System.out.println(total3);
	System.out.println(total+total2+total3);	
	//==========================================
	int prize=0;
	for(int i=0;i<webautomationcount;i++) {	
		prize=prize+jp.getInt("courses.webautomation["+i+"].price");
	}
	int apicnt=jp.getList("courses.api.price").size();
	for(int i=0;i<apicnt;i++) {	
		prize=prize+jp.getInt("courses.api["+i+"].price");
	}
	int mobilecnt=jp.getList("courses.MobileAutomation.price").size();
	for(int i=0;i<mobilecnt;i++) {	
		prize=prize+jp.getInt("courses.MobileAutomation["+i+"].price");
	}
	System.out.println(prize+"total prize");
		
	Assert.assertEquals(total+total2+total3,purchaseamt,"total not matched");
	
	
	}
	
	
	

}
