

package ApiTests;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
/*
API 7: POST To Verify Login with valid details
API URL: https://automationexercise.com/api/verifyLogin
Request Method: POST
Request Parameters: email, password
Response Code: 200
Response Message: User exists!
*/

public class userValidLogin {
    @Test(dataProvider = "loginData", dataProviderClass = Utils.JsonDataProvider.class)
    public void validLogin( String email,String password ) {


        RestAssured.baseURI = ConfigReader.getProperty("baseURL");


        // Send POST request to verify login

          given()

                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200)
                  .log().all()
                  //.statusCode(200)
                  // .body("responseCode", equalTo(200))
                  //.body("message", equalTo("User exists!"));
                  // .body("responseCode", equalTo(200))
                  //.body("message", equalTo("User exists!"));
                  //.statusCode(200)
                  // .statusCode(200).body(equalTo("User exists!"));
                  .body(equalTo("{\"responseCode\": 200, \"message\": \"User exists!\"}"));





    }
}




