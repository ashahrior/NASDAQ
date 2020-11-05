package page.premarketactivity;

import org.openqa.selenium.WebDriver;
import utilities.TableDataExtractor;

public class MostActiveDataTable extends TableDataExtractor {

    public MostActiveDataTable(WebDriver webDriver, String table_id) {
        super(webDriver,table_id);
    }
}
