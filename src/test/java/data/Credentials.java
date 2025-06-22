package data;

import java.util.Objects;

public class Credentials {


    public static String partnerAdminUsername = "ahmed.maher+pa_1@si-ware.com";
    public static String partnerAdminPassword = "Abcd@123";

    public static String adminUsername = "Admin@email.com";
    public static String adminPassword = "Cqc@12345";

    public static String userName = "Mostafa.hassan+U@si-ware.com";
    public static String userPassword = "Cqc@12345";

    public static String supportUsername="malek.ali@email.com";
    public static String supportUsernameTwo="supportUser@email.com";

    public static String supportPassword = "Qwer@1234";

    public static String partnerUserUsername="Mohamed.khaled+PU@si-ware.com";
    public static String partnerUserPassword="Cqc@1234";

    public static String superAdminUsername = "superadmin@si-ware.com";
    public static String superAdminPassword = "@SwS@2025$$!!";



    public static void SetCredentials(String s)
    {
        if(Objects.equals(s, "DEV"))
        {

        }
        else if (Objects.equals(s, "TEST"))
        {
        }

        else if(Objects.equals(s,"STAGE")){
            partnerAdminUsername="mohamed.khaled+PA@si-ware.com";
            partnerAdminPassword="Cqc@12345";

            supportUsername="ahmed.maher+PA+test@si-ware.com";
            supportPassword="Admin@1234";

            adminUsername="ahmed.maher+stage1@si-ware.com";
            adminPassword="Abcd@123";
        }
        else
        {
            System.out.println("Credentials Not Set Correctly!, Make Sure Credentials is Set to 'DEV' or 'TEST'.");
        }
    }
}
