import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestDemo {
    //https://www.nasdaq.com/extended-trading/premarket-mostactive.aspx
    public static void main(String[] args) {

        String browser_driver = "webdriver.chrome.driver";
        String driver_path = "E:\\MATS\\selenium-java\\NASDAQ\\rsrc\\chromedriver_win32\\chromedriver.exe";
        String target_link = "https://community.nasdaq.com/login.aspx";
        String email = "xandercage80386@gmail.com";
        String password = "exmachina";
        String pre_market_activity_url = "https://www.nasdaq.com/extended-trading/premarket-mostactive.aspx";
        //String demo = "https://www.google.com";

        System.setProperty(browser_driver, driver_path);

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

        try {
            webDriver.get(pre_market_activity_url);
        } catch (Exception ex) {
            //System.out.println(ex);
        }

        System.out.println(webDriver.findElements(By.xpath("//div[@id='_active']//th")).size());



    }
}