

package ApiTests;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class userValidLogin {
    @Test
    public void validLogin() {


        RestAssured.baseURI = ConfigReader.getProperty("baseURL");

        // Test data: valid email and password

        String validEmail = "test.heba1986@gmail.com";
        String validPassword = "123456";

        // Send POST request to verify login

        given()

                .formParam("email", validEmail)
                .formParam("password", validPassword)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200) // Assert response code is 200
                .body(equalTo("{\"responseCode\": 200, \"message\": \"User exists!\"}"));





    }
}




