package restassuredpack;

public class TestData {

	public static String addBookPayLoad() {
		return "{\r\n"+
	            "    \"name\": \"%s\",\r\n" +
	            "    \"isbn\": \"%s\",\r\n" +
	            "    \"aisle\": \"%s\",\r\n" +
	            "    \"author\": \"%s\"\r\n" +
	            "}";
				
	}
	public static String addCircuit() {
		return "{\r\n"+
	            "    \"circuitId\": \"%s\",\r\n" +
	            "    \"circuitName\": \"%s\",\r\n" +
	            "    \"url\": \"%s\",\r\n" +
	         
	            "}";
	}
	public static String addUser() {
		return "{\r\n"+
	            "    \"id\": \"%s\",\r\n" +
	            "    \"name\": \"%s\",\r\n" +
	            "    \"email\": \"%s\",\r\n" +
	            "    \"gender\": \"%s\"\r\n" +
	            "    \"status\": \"%s\"\r\n" +
	            "}";
				
	}
	

}
