

package ApiTests;

import Utils.ConfigReader;
import Utils.JsonDataProvider;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
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
                .statusCode(200) // Assert response code is 200
                .body(equalTo("{\"responseCode\": 200, \"message\": \"User exists!\"}"));





    }
}




