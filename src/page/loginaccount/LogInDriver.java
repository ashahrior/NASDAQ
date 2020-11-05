package page.loginaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInDriver{

    private WebDriver webDriver;
    private String user_name_xpath = "//*[@id='ctl00_two_column_main_content_NASDAQLogin1_UserName']";
    private String password_xpath = "//*[@id='ctl00_two_column_main_content_NASDAQLogin1_Password']";
    private String login_button_xpath = "//*[@id='ctl00_two_column_main_content_NASDAQLogin1_LoginButton']";

    public LogInDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void enterAccount(String target_link, String email, String password)
    {
        webDriver.get(target_link);
        //System.out.println(webDriver.getPageSource());

        webDriver.findElement(By.xpath(user_name_xpath)).sendKeys(email);
        webDriver.findElement(By.xpath(password_xpath)).sendKeys(password);
        webDriver.findElement(By.xpath(login_button_xpath)).click();
        try {
            Thread.sleep(5000L);
            webDriver.findElement(By.xpath("//*[@id='cookieConsentOK']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
 */

