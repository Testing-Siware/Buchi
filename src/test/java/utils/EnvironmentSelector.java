package utils;

import data.Credentials;

import java.util.Objects;

public class EnvironmentSelector {

    public static String PortalMainlUrl = "";
    public static String OverviewUrl = "";
    public static String dashboardUrl = "";
    public static String parametersDashboardUrl = "";
    public static String licenseUrl ="";
    public static String generateLicenseUrl="";
    public static String editLicenseUrl="";
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
    public static String NewAlertUrl = "";
    public static String EditAlertUrl = "";
    public static String BatchesUrl = "";
    public static String LabStoreUrl = "";
    public static String PublishedProductsUrl = "";
    public static String SubscribedProductsUrl = "";
    public static String CouponsUrl = "";
    public static String MeasurementsUrl = "";
    public static String ModelsUrl = "";
    public static String affiliatesUrl = "";
    public static String UsersUrl = "";
    public static String ModelTransferUrl = "";
    public static String ClassifiersManagementUrl = "";
    public static String DeviceManagementUrl = "";
    public static String ActivityFeedUrl = "";
    public static String SupportUrl = "";
    public static String NotificationUrl = "";
    public static String UserProfileUrl = "";
    public static String AffiliateProfileUrl = "";
    public static String journalsUrl="";


    public static void SetEnvironment(String s)
    {
        if(Objects.equals(s, "DEV"))
        {
            Credentials.SetCredentials("DEV");

            PortalMainlUrl = "http://nir-online-dev.neospectra.cloud/";
            AlertsUrl="https://nir-online-dev.neospectra.cloud/fleet-management/alerts";
            NewAlertUrl="https://nir-online-dev.neospectra.cloud/fleet-management/alert/add";
            EditAlertUrl="https://nir-online-dev.neospectra.cloud/fleet-management/alert/edit";
            journalsUrl="https://nir-online-dev.neospectra.cloud/fleet-management/journals";
            dashboardUrl="https://nir-online-dev.neospectra.cloud/dashboard";
            parametersDashboardUrl="https://nir-online-dev.neospectra.cloud/dashboard/parameters";
            licenseUrl ="https://nir-online-dev.neospectra.cloud/access-management/licenses";
            generateLicenseUrl="https://nir-online-dev.neospectra.cloud/access-management/license/generate";
            editLicenseUrl="https://nir-online-dev.neospectra.cloud/access-management/license/edit";
            affiliatesUrl="https://nir-online-dev.neospectra.cloud/access-management/affiliates";
        }
        else if (Objects.equals(s, "TEST"))
        {
            Credentials.SetCredentials("TEST");
        }
        else if(Objects.equals(s,"STAGE")){
            Credentials.SetCredentials("STAGE");
            PortalMainlUrl="https://nir-online-stage.neospectra.cloud/";
            NewAlertUrl="https://nir-online-stage.neospectra.cloud/fleet-management/alert/add";
            EditAlertUrl="https://nir-online-stage.neospectra.cloud/fleet-management/alert/edit";
            AlertsUrl="https://nir-online-stage.neospectra.cloud/fleet-management/alerts";
            journalsUrl="https://nir-online-stage.neospectra.cloud/fleet-management/journals";
            dashboardUrl="https://nir-online-stage.neospectra.cloud/dashboard";
            parametersDashboardUrl="https://nir-online-stage.neospectra.cloud/dashboard/parameters";
            licenseUrl ="https://nir-online-stage.neospectra.cloud/access-management/licenses";
            generateLicenseUrl="https://nir-online-stage.neospectra.cloud/access-management/license/generate";
            editLicenseUrl="https://nir-online-stage.neospectra.cloud/access-management/license/edit";
            affiliatesUrl="https://nir-online-stage.neospectra.cloud/access-management/affiliates";
        }
        else
        {
            System.out.println("Environment Not Set Correctly!, Make Sure Environment is Set to 'DEV' or 'TEST'.");
        }
    }



}