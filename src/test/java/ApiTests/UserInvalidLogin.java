package ApiTests;
import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
/*
API 10: POST To Verify Login with invalid details
API URL: https://automationexercise.com/api/verifyLogin
Request Method: POST
Request Parameters: email, password (invalid values)
Response Code: 404
Response Message: User not found!
*/
public class UserInvalidLogin {
    @Test(dataProvider = "invlaligLoginData", dataProviderClass = Utils.JsonDataProvider.class)
    public void invalidLogin (String email, String pass) {

    RestAssured.baseURI = ConfigReader.getProperty("baseURL");

    // Send POST request to verify login user

    given()

                .formParam("email", email )
                .formParam("password", pass)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(404) // Assert response code is 404
                .body(equalTo("{\"responseCode\": 404, \"message\": \"User not found!\"}"));





}
}
