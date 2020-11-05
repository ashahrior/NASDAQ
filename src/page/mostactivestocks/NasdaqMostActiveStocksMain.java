package page.mostactivestocks;

import org.openqa.selenium.WebDriver;

public class NasdaqMostActiveStocksMain {
    private WebDriver webDriver;
    private String most_active_url;
    private String nasdaq_most_active_share_volume_table_id = "_active";
    private String nasdaq_most_advanced_table_id = "_advanced";
    private String nasdaq_most_declined_table_id = "_declined";
    private String nasdaq_most_active_dollar_volume_table_id = "_dollar";

    public NasdaqMostActiveStocksMain(WebDriver webDriver, String most_active_url) {
        this.webDriver = webDriver;
        this.most_active_url = most_active_url;
    }

    public void loadMostActiveStocksPage(){
        //webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        try {
            webDriver.get(most_active_url);
        } catch (Exception ex) {
        }
    }

    public void invokeNasdaqMostActiveShareVolumeTable()
    {
        NasdaqMostActiveShareVolumes nasdaqMostActiveShareVolumes = new NasdaqMostActiveShareVolumes(webDriver,nasdaq_most_active_share_volume_table_id);
        nasdaqMostActiveShareVolumes.createTable();
        nasdaqMostActiveShareVolumes.printTableData();
        //mostActiveDataTable.writeFile("pm_most_active.csv");
    }
    public void invokeNasdaqMostAdvancedDataTable()
    {
        NasdaqMostAdvanced nasdaqMostAdvanced = new NasdaqMostAdvanced(webDriver,nasdaq_most_advanced_table_id);
        nasdaqMostAdvanced.createTable();
        nasdaqMostAdvanced.printTableData();
        //mostAdvancedDataTable.writeFile("pm_most_advanced.csv");
    }
    public void invokeNasdaqMostDeclinedDataTable()
    {
         NasdaqMostDeclined nasdaqMostDeclined = new NasdaqMostDeclined(webDriver,nasdaq_most_declined_table_id);
        nasdaqMostDeclined.createTable();
        nasdaqMostDeclined.printTableData();
        //mostDeclinedDataTable.writeFile("pm_most_declined.csv");
    }

    public void invokeNasdaqMostActiveDollarVolume()
    {
        NasdaqMostActiveDollarVolumes nasdaqMostActiveDollarVolumes = new NasdaqMostActiveDollarVolumes(webDriver,nasdaq_most_active_dollar_volume_table_id);
        nasdaqMostActiveDollarVolumes.createTable();
        nasdaqMostActiveDollarVolumes.printTableData();
    }

}
