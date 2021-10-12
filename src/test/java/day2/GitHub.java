package day2;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GitHub {
	@BeforeTest
	public void beforeTest()
	{
		baseURI="https://api.github.com/user/repos";
		authentication= oauth2("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");
		
	}
  @Test(enabled=true)
  public void gettingAllRepositories() {
	  given()
	  .when()
	  .get()
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  
  @Test(enabled=true)
  public void createRepositories() {
	 JSONObject data =new JSONObject();
	 data.put("name", "RestAssuredCreations2");
	 data.put("description","I am Created By RestAssured Tool");
	 data.put("homepage","https://github.com/amitad1221");
	
	  given()
	  		.header("Content-Type","application/json")
	  		.body(data.toJSONString())
	  .when()
	  		.post()
	  .then()
	  		.log()
	  		.body()
	  		.statusCode(201)
	  		.time(Matchers.lessThan(6000L),TimeUnit.MILLISECONDS);
  }	
}