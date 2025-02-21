package Utils;

public class EmailGenerator {
    public static String stDynamicEmail;


    public String generateDynamicEmail() {
        stDynamicEmail = System.currentTimeMillis() + "@gmail.com";
        return stDynamicEmail;
    }


}


