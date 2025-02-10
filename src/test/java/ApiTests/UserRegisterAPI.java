package ApiTests;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserRegisterAPI {

   @Test(dataProvider = "userRegisterApi", dataProviderClass = Utils.JsonDataProvider.class)
   public void userRegister(String title, String name, String email, String password,
                            String birth_date, String birth_month, String birth_year,
                            String firstname, String lastname, String company,
                            String address1, String address2, String country,
                            String state, String city, String zipcode, String mobile_number) {

      // Get Base URL from config file
      RestAssured.baseURI = ConfigReader.getProperty("baseURL");

      // Create request body using HashMap
      Map<String, String> requestBody = new HashMap<>();
      requestBody.put("name", name);
      requestBody.put("email", email);
      requestBody.put("password", password);
      requestBody.put("title", title);
      requestBody.put("birth_date", birth_date);
      requestBody.put("birth_month", birth_month);
      requestBody.put("birth_year", birth_year);
      requestBody.put("firstname", firstname);
      requestBody.put("lastname", lastname);
      requestBody.put("company", company);
      requestBody.put("address1", address1);
      requestBody.put("address2", address2);
      requestBody.put("country", country);
      requestBody.put("state", state);
      requestBody.put("city", city);
      requestBody.put("zipcode", zipcode);
      requestBody.put("mobile_number", mobile_number);

      // Send POST request
      given()
              .contentType("application/json")
              .body(requestBody)
              .when()
              .post("/api/createAccount")
              .then()
              .log().all()
              .statusCode(201)// Verify status code 201
              .body(equalTo("User created!"));
   }
}
