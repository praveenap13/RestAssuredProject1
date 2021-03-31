package restassuredpack;

public class ProvideData {
	String name="Vinit";
	String email="1223@gmail.com";
	String gender="Male";
	String status="Active";

	
	public static String addUser() {
		
				return "{\r\n"+
	            "    \"name\": \"%s\",\r\n" +
	            "    \"email\": \"%s\",\r\n" +
	            "    \"gender\": \"%s\",\r\n" +
	            "    \"status\": \"%s\"\r\n" +
	            "}";
		
	}
}
