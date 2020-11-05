import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.loginaccount.LogInDriver;
import page.mostactivestocks.NasdaqMostActiveStocksMain;
import page.premarketactivity.PreMarketActivityMain;

import static utilities.StringData.*;

public class MainDriver {

    static String browser_driver;

    static String driver_path;

    static String target_link;

    static String email;

    static String password;

    static String pre_market_activity_url;

    static String nasdaq_most_active_url;

    public static void main(String[] args) throws InterruptedException {

        initializeValues();

        System.setProperty(browser_driver, driver_path);

        WebDriver webDriver = new ChromeDriver();

        LogInDriver logInDriver = new LogInDriver(webDriver);
        logInDriver.enterAccount(target_link, email, password);

        // pre-market activity page
        PreMarketActivityMain preMarketActivity = new PreMarketActivityMain(webDriver,pre_market_activity_url);
        preMarketActivity.loadPreMarketActivity();
		
		/*
        preMarketActivity.invokeMostActiveDataTable();
        preMarketActivity.invokeMostAdvancedDataTable();
        preMarketActivity.invokeMostDeclinedDataTable();*/

        // nasdaq most active stocks
        /*NasdaqMostActiveStocksMain nasdaqMostActiveStocksMain = new NasdaqMostActiveStocksMain(webDriver,nasdaq_most_active_url);
        nasdaqMostActiveStocksMain.loadMostActiveStocksPage();*/

    }

    static void initializeValues()
    {
        browser_driver = getBrowserDriver();

        driver_path = getDriverPath();

        target_link = getLoginLink();

        email = getUserEmail();

        password = getUserPassword();

        pre_market_activity_url = getPreMarketActivityURL();

        nasdaq_most_active_url = getNasdaqMostActiveURL();

        return;
    }
}
