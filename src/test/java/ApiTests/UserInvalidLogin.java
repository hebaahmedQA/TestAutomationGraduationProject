package ApiTests;
import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserInvalidLogin {
    @Test(dataProvider = "invlaligLoginData", dataProviderClass = Utils.JsonDataProvider.class)
    public void invalidLogin (String email, String pass) {

    RestAssured.baseURI = ConfigReader.getProperty("baseURL");

    // Send POST request to verify login user hh

    given()

                .formParam("email", email )
                .formParam("password", pass)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(404) // Assert response code is 404
                .body(equalTo("{\"responseCode\": 200, \"message\": \"User exists!\"}"));





}
}
