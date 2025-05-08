package utils;

import data.Credentials;

import java.util.Objects;

public class EnvironmentSelector {

    public static String PortaMainlUrl = "";
    public static String OverviewUrl = "";
    public static String AnalyticsUrl = "";
    public static String LablakeAnalyticsUrl = "";
    public static String LablakeInstrumentsUrl = "";
    public static String LablakeMaterialsUrl = "";
    public static String LablakeScansUrl = "";
    public static String LablakeAlertsUrl = "";
    public static String LablakeFileUploadsUrl = "";
    public static String MaterialGroupsUrl = "";
    public static String LotManagementUrl = "";
    public static String MaterialSuppliersUrl = "";
    public static String ScansUrl = "";
    public static String AlertsUrl = "";
    public static String BatchesUrl = "";
    public static String LabStoreUrl = "";
    public static String PublishedProductsUrl = "";
    public static String SubscribedProductsUrl = "";
    public static String CouponsUrl = "";
    public static String MeasurementsUrl = "";
    public static String ModelsUrl = "";
    public static String AffiliatesUrl = "";
    public static String UsersUrl = "";
    public static String ModelTransferUrl = "";
    public static String ClassifiersManagementUrl = "";
    public static String DeviceManagementUrl = "";
    public static String ActivityFeedUrl = "";
    public static String SupportUrl = "";
    public static String NotificationUrl = "";
    public static String UserProfileUrl = "";
    public static String AffiliateProfileUrl = "";


    public static void SetEnvironment(String s)
    {
        if(Objects.equals(s, "DEV"))
        {
            Credentials.SetCredentials("DEV");

            PortaMainlUrl = "http://nir-online-dev.neospectra.cloud/";

        }
        else if (Objects.equals(s, "TEST"))
        {
            Credentials.SetCredentials("TEST");
        }
        else
        {
            System.out.println("Environment Not Set Correctly!, Make Sure Environment is Set to 'DEV' or 'TEST'.");
        }
    }



}