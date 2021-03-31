package newrestproject;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class AddBookJson {
	/*
	 * [10:16 PM, 2/26/2021] +91 87936 11009: http://216.10.245.166/Library/Addbook.php
[10:16 PM, 2/26/2021] +91 87936 11009: {
    "name": "Harry Potter and the Chamber of Secrets",
    "isbn": "HPB12111129",
    "aisle": "090009010",
    "author": "Vinita"
}
	 */
	
	private String name;
	private String isbn;
	private String aisle;
	private String author;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public static void main(String[] args) {
		AddBookJson obj=new AddBookJson();
		obj.setName("Harry Potter");
		obj.setAisle("09000910");
		obj.setAuthor("praveena");
		obj.setIsbn("HPB12111129");
		given().log().everything()
	    .contentType(ContentType.JSON)
	    .body(obj)
	    .when()
	    .post("http://216.10.245.166/Library/Addbook.php")
	    .then().log().all();		
	}
}
