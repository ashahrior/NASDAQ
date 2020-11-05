package utilities;

public class StringData {
    public static String getBrowserDriver() {
        return "webdriver.chrome.driver";
    }

    public static String getDriverPath() {
        return ".\\rsrc\\chromedriver_win32\\chromedriver.exe";
    }

    public static String getLoginLink() {
        return "https://community.nasdaq.com/login.aspx";
    }

    public static String getUserEmail() {
        return "xyz@gmail.com";
    }

    public static String getUserPassword() {
        return "xyz";
    }

    public static String getPreMarketActivityURL() {
        return "https://www.nasdaq.com/extended-trading/premarket-mostactive.aspx";
    }

    public static String getNasdaqMostActiveURL() {
        return "https://www.nasdaq.com/markets/most-active.aspx";
    }
}