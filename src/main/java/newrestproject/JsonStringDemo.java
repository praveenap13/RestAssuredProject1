package newrestproject;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

public class JsonStringDemo {
	
	/*
	 * {
	"id": "0001",
	"type": "donut",
	"name": "Cake",
	"image":
		{
			"url": "images/0001.jpg",
			"width": 200,
			"height": 200,

"thumbnail":
		{
			"url": "images/thumbnails/0001.jpg",
			"width": 32,
			"height": 32
		}
		}
	;
}

	 */
	public static void main(String[] args) {
		Image  img=new Image();
		img.setHeight("200");
		img.setUrl("images/0001.jpg");
		img.setWidth("200");
		
		Thumbnail thumb=new Thumbnail();
		thumb.setUrl("images/thumbnails/0001.jpg");
		thumb.setHeight("32");
        thumb.setWidth("33");
        
		Item i=new Item();
		i.setId("0001");
		i.setImage(img);
		i.setName("cake");
		//i.setThumb(thumb);
		i.setType("Donut");
		
		given().log().everything()
	    .contentType(ContentType.JSON)
	    .body(i);
	}
	

}
