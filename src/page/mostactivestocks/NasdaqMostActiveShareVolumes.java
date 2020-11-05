package page.mostactivestocks;

import org.openqa.selenium.WebDriver;
import utilities.TableDataExtractor;

public class NasdaqMostActiveShareVolumes extends TableDataExtractor {

    public NasdaqMostActiveShareVolumes(WebDriver webDriver, String table_id) {
        super(webDriver, table_id);
    }
}
