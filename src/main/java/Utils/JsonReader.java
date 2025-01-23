package Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonReader {

    public static Object[][] getJsonData(String filePath) throws IOException {
        // قراءة محتوى ملف JSON كـ String
        String jsonData = new String(Files.readAllBytes(new File(filePath).toPath()));

        // تحويل البيانات إلى JSONArray
        JSONArray jsonArray = new JSONArray(jsonData);

        // إعداد مصفوفة البيانات
        Object[][] data = new Object[jsonArray.length()][1];

        // التكرار على كل عنصر في JSON وتحويله إلى JSONObject
        for (int i = 0; i < jsonArray.length(); i++) {
            data[i][0] = jsonArray.getJSONObject(i).toMap();
        }

        return data;
    }
}




/*package Utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class JsonReader {

    public static Object[][] getJsonData(String filePath) throws IOException {
        // قراءة محتوى ملف JSON كـ String
        String jsonData = new String(Files.readAllBytes(new File(filePath).toPath()));

        // تحويل البيانات إلى JSONArray
        JSONArray jsonArray = new JSONArray(jsonData);

        // تحديد حجم البيانات
        Object[][] data = new Object[jsonArray.length()][];

        // التكرار على كل عنصر في JSONArray وتحويله إلى مصفوفة بيانات
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject row = jsonArray.getJSONObject(i);
            data[i] = new Object[]{
                    row.getString("name"),
                    row.getString("email"),
                    row.getString("password"),
                    row.getString("title"),
                    row.getString("birth_date"),
                    row.getString("birth_month"),
                    row.getString("birth_year"),
                    row.getString("firstname"),
                    row.getString("lastname"),
                    row.getString("company"),
                    row.getString("address1"),
                    row.getString("address2"),
                    row.getString("country"),
                    row.getString("zipcode"),
                    row.getString("state"),
                    row.getString("city"),
                    row.getString("mobile_number")
            };
        }

        return data;
    }
}


/*package Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonReader {

    public static Object[][] getJsonData(String filePath) throws IOException {
        // قراءة ملف JSON باستخدام Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> jsonData = objectMapper.readValue(
                new File(filePath),
                new TypeReference<List<Map<String, String>>>() {}
        );

        // تحويل البيانات إلى Object[][]
        Object[][] data = new Object[jsonData.size()][];
        for (int i = 0; i < jsonData.size(); i++) {
            Map<String, String> row = jsonData.get(i);
            data[i] = new Object[]{
                    row.get("name"),
                    row.get("email"),
                    row.get("password"),
                    row.get("title"),
                    row.get("birth_date"),
                    row.get("birth_month"),
                    row.get("birth_year"),
                    row.get("firstname"),
                    row.get("lastname"),
                    row.get("company"),
                    row.get("address1"),
                    row.get("address2"),
                    row.get("country"),
                    row.get("zipcode"),
                    row.get("state"),
                    row.get("city"),
                    row.get("mobile_number")
            };
        }

        return data;
    }
}*/

