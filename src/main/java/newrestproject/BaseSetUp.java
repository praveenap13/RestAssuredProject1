package newrestproject;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
public class BaseSetUp {
     @BeforeClass
	public void setUpFornewrestproject() {
		baseURI="https://gorest.co.in/public-api";
	}
}
