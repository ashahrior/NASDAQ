package page.premarketactivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TableDataExtractor;

public class MostDeclinedDataTable extends TableDataExtractor {

    public MostDeclinedDataTable(WebDriver webDriver, String table_id) {
        super(webDriver,table_id);
        webDriver.findElement(By.xpath("//a[@id='most-declined']/span")).click();
    }
}
