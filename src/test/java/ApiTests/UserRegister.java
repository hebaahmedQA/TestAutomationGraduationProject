package ApiTests;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserRegister {

    @Test
    public void userRegister() {
        // Get Base URL from config file
        RestAssured.baseURI = ConfigReader.getProperty("baseURL");

        // user data
        Map<String, String> userData = new HashMap<>();
        userData.put("name", "heba");
        userData.put("email", "heba1@gmail.com");
        userData.put("password", "password123");
        userData.put("title", "Mr");
        userData.put("birth_date", "1");
        userData.put("birth_month", "January");
        userData.put("birth_year", "1995");
        userData.put("firstname", "User");
        userData.put("lastname", "One");
        userData.put("company", "Company A");
        userData.put("address1", "Address 1");
        userData.put("address2", "");
        userData.put("country", "India");
        userData.put("zipcode", "11111");
        userData.put("state", "Cairo");
        userData.put("city", "Heliopolis");
        userData.put("mobile_number", "01111111111");

        // send post request
        given()
                .contentType("application/json")
                .body(userData)
                .when()
                .post("/api/createAccount")
                .then()
                .log().all()
                .statusCode(201); // Verify status code 201
    }
}
