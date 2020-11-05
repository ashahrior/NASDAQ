package page.premarketactivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PreMarketActivityMain {
    private WebDriver webDriver;
    private String pre_market_activity_url;
    private String pre_market_most_active_table_id = "_active";
    private String pre_market_most_advanced_table_id = "_advanced";
    private String pre_market_most_declined_table_id = "_declined";

    public PreMarketActivityMain(WebDriver webDriver, String pre_market_activity_url) {
        this.webDriver = webDriver;
        this.pre_market_activity_url = pre_market_activity_url;
    }
    public void loadPreMarketActivity()
    {
        webDriver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        try {
            webDriver.get(pre_market_activity_url);
            Thread.sleep(5000L);
            webDriver.findElement(By.xpath("//*[@id='cookieConsentOK']")).click();
        } catch (Exception ex) {
        }
    }

    public void invokeMostActiveDataTable()
    {
        MostActiveDataTable mostActiveDataTable = new MostActiveDataTable(webDriver,pre_market_most_active_table_id);
        mostActiveDataTable.createTable();
        mostActiveDataTable.printTableData();
        //mostActiveDataTable.writeFile("pm_most_active.csv");
    }
    public void invokeMostAdvancedDataTable()
    {
        MostAdvancedDataTable mostAdvancedDataTable = new MostAdvancedDataTable(webDriver,pre_market_most_advanced_table_id);
        mostAdvancedDataTable.createTable();
        mostAdvancedDataTable.printTableData();
        //mostAdvancedDataTable.writeFile("pm_most_advanced.csv");
    }
    public void invokeMostDeclinedDataTable()
    {
        MostDeclinedDataTable mostDeclinedDataTable = new MostDeclinedDataTable(webDriver,pre_market_most_declined_table_id);
        mostDeclinedDataTable.createTable();
        mostDeclinedDataTable.printTableData();
        //mostDeclinedDataTable.writeFile("pm_most_declined.csv");
    }
}

/*$x("//*[@id='show-all']/span")*/