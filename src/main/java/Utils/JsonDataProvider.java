package Utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataProvider {


@DataProvider(name = "registerData")
public Object[][] getRegisterData() throws IOException {
    // مسار ملف JSON
    String filePath = "src/main/java/Utils/RegisterData.json";

    // قراءة ملف JSON
    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object>[] data = objectMapper.readValue(new File(filePath), Map[].class);

    // تحويل البيانات إلى Object[][]
    Object[][] testData = new Object[data.length][15]; // لتتناسب مع عدد المعلمات في دالة الاختبار

    for (int i = 0; i < data.length; i++) {
        Map<String, Object> userData = data[i];

        testData[i][0] = userData.get("password");
        testData[i][1] = userData.get("title");
        testData[i][2] = userData.get("birth_date");
        testData[i][3] = userData.get("birth_month");
        testData[i][4] = userData.get("birth_year");
        testData[i][5] = userData.get("firstname");
        testData[i][6] = userData.get("lastname");
        testData[i][7] = userData.get("company");
        testData[i][8] = userData.get("address1");
        testData[i][9] = userData.get("address2");
        testData[i][10] = userData.get("country");
        testData[i][11] = userData.get("state");
        testData[i][12] = userData.get("city");
        testData[i][13] = userData.get("zipcode");
        testData[i][14] = userData.get("mobile_number");
        ;

        // إضافة المزيد من المعلمات إذا لزم الأمر
    }

    return testData;
}}





