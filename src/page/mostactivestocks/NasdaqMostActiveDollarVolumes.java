package page.mostactivestocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TableDataExtractor;

public class NasdaqMostActiveDollarVolumes extends TableDataExtractor {

    public NasdaqMostActiveDollarVolumes(WebDriver webDriver, String table_id) {
        super(webDriver, table_id);
        webDriver.findElement(By.xpath("//a[@id='dollar-volume']/span")).click();
    }

}
