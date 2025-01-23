package Utils;

public class EmailGenerator {
    public static String stDynamicEmail;


    //  generate a dynamic email
    public String generateDynamicEmail() {
        stDynamicEmail = System.currentTimeMillis() + "@gmail.com";
        return stDynamicEmail;
    }


}


