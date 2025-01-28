package data;

import java.util.Objects;

public class Credentials {

    public static String partnerAdminUsername = "Mostafa.hassan+pa@si-ware.com";
    public static String partnerAdminPassword = "Cqc@12345";

    public static String adminUsername = "Mostafa.hassan+A@si-ware.com";
    public static String adminPassword = "Cqc@12345";

    public static String userName = "Mostafa.hassan+U@si-ware.com";
    public static String userPassword = "Cqc@12345";

    public static String supportUsername="malek.ali@email.com";
    public static String supportPassword = "Qwer@1234";

    public static String partnerUserUsername="Mohamed.khaled+PU@si-ware.com";
    public static String partnerUserPassword="Cqc@12345";

    public static String superAdminUsername = "superadmin@si-ware.com";
    public static String superAdminPassword = "@SwS@2023$$!!";



    public static void SetCredentials(String s)
    {
        if(Objects.equals(s, "DEV"))
        {

        }
        else if (Objects.equals(s, "TEST"))
        {
        }
        else
        {
            System.out.println("Credentials Not Set Correctly!, Make Sure Credentials is Set to 'DEV' or 'TEST'.");
        }
    }
}
