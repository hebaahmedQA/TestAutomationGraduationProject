package ApiTests;
import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserInvalidLogin {
    @Test
    public void invalidLogin () {

    RestAssured.baseURI = ConfigReader.getProperty("baseURL");

    // Test data: valid email and password
    String inValidEmail = "testheba1rr8@gmail.com";
    String inValidPassword = "12345ff6";

    // Send POST request to verify login ىىى

    given()

                .formParam("email", inValidEmail )
                .formParam("password", inValidPassword)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(404) // Assert response code is 404
                .body(equalTo("{\"responseCode\": 200, \"message\": \"User exists!\"}"));





}
}
