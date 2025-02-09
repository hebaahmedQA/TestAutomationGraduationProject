
package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonDataProvider {

    private Object[][] getDataFromFile(String filePath) throws IOException {
        //  use objectmapper to read jsondata
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file into a List of Maps
        List<Map<String, Object>>
                data = objectMapper.readValue(new File(filePath), List.class);

        // Convert the List of Maps into a [][] Object array
        Object[][] testData = new Object[data.size()][];

        for (int i = 0; i < data.size(); i++) {
            testData[i] = data.get(i).values().toArray();
        }

        return testData;
    }

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() throws IOException {
        return getDataFromFile("src/main/resources/data/RegisterData.json");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        return getDataFromFile("src/main/resources/data/LoginData.json");
    }

    @DataProvider(name = "SignUpData")
    public Object[][] getInvalidSignUpData() throws IOException {
        return getDataFromFile("src/main/resources/data/ExistingData.json");
    }

    @DataProvider(name = "userRegisterApi")
    public Object[][] getUserRegisterApi() throws IOException {
        return getDataFromFile("src/main/resources/data/UserRegisterAPI.json");
    }

    @DataProvider(name = "invlaligLoginData")
    public Object[][] getInvalidLoginDataApi() throws IOException {
        return getDataFromFile("src/main/resources/data/InvalidLoginDataAPI.json");

    }

    @DataProvider(name = "logoutData")
    public Object[][] getLogoutData() throws  IOException  {
        return getDataFromFile("src/main/resources/data/LogoutData.json");



    }
}











