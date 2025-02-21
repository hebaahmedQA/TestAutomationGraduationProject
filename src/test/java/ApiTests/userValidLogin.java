

package ApiTests;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class userValidLogin {
    @Test(dataProvider = "loginData", dataProviderClass = Utils.JsonDataProvider.class)
    public  void userValidLogin(String email, String password) {


        RestAssured.baseURI = ConfigReader.getProperty("baseURL");






          given()

                  .formParam("email", email)
                  .formParam("password", password)
                  .when()
                  .post("/api/verifyLogin")
                  .then()
                  .statusCode(200)
                  .body(equalTo("{\"responseCode\": 200, \"message\": \"User exists!\"}"));







    }
}




