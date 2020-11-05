package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TableDataExtractor {

    WebDriver webDriver;
    String table_id;

    String table_title;
    int no_of_column_heads;
    int no_of_table_rows;
    ArrayList<String> columnHeaders = new ArrayList<String>();
    ArrayList<String> symbols = new ArrayList<String>();
    ArrayList<String> companies = new ArrayList<String>();
    ArrayList<String> last_sales = new ArrayList<String>();
    ArrayList<String> change_net_percentages = new ArrayList<String>();
    ArrayList<String> color_labels = new ArrayList<String>();
    ArrayList<String> share_volumes = new ArrayList<String>();

    public TableDataExtractor(WebDriver webDriver, String table_id) {
        this.webDriver = webDriver;
        this.table_id = table_id;
    }

    public void createTable() {
        this.table_title = getTableTitle();
        this.no_of_column_heads = getColumnHeadsCount();
        this.columnHeaders.addAll(getColumnHeads());
        this.no_of_table_rows = getTableRowsCount();
        this.symbols = getSymbols();
        this.companies = getCompanies();
        this.last_sales = getLastSales();
        this.change_net_percentages = getChangeNets();
        this.share_volumes = getShareVolumes();
    }

    public void printTableData() {
        System.out.println(table_title);
        for (int i = 0; i < no_of_column_heads; i++) {
            System.out.print(columnHeaders.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < no_of_table_rows; i++) {
            System.out.println(symbols.get(i) + " " + companies.get(i) + " " + last_sales.get(i) + " " + change_net_percentages.get(i) + " " + share_volumes.get(i));
        }
        System.out.println();
        System.out.println();
    }

    public void writeFile(String fileName) {
        try {
            String path = "E:\\MATS\\selenium-java\\NASDAQ\\datafiles\\";
            String delimiter = "#";
            File file = new File(path + fileName);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < no_of_column_heads; i++) {
                bWriter.write(columnHeaders.get(i) + delimiter);
            }
            bWriter.newLine();
            for (int i = 0; i < no_of_table_rows; i++) {

                bWriter.write(symbols.get(i) + delimiter + companies.get(i) + delimiter + last_sales.get(i) + delimiter + change_net_percentages.get(i) + delimiter + share_volumes.get(i));
                bWriter.newLine();
            }
            System.out.println("File write complete: " + path + fileName);
            bWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTableTitle() {
        return webDriver.findElement(By.xpath("//div[@id='" + table_id + "']/*[1]")).getText();
    }

    public int getColumnHeadsCount()
    {
        return webDriver.findElements(By.xpath("//div[@id='"+table_id+"']//th")).size();
    }

    public ArrayList<String> getColumnHeads() {
        ArrayList<String> headers = new ArrayList<String>();

        for (int i = 1; i <= no_of_column_heads; i++) {
            headers.add(webDriver.findElement(By.xpath("//div[@id='" + table_id + "']/table/thead//th[" + i + "]")).getText());
        }

        return headers;
    }

    public int getTableRowsCount() {
        return webDriver.findElements(By.xpath("//div[@id='"+table_id+"']//tbody/tr")).size();
    }

    public ArrayList<String> getSymbols() {
        ArrayList<String> symbols = new ArrayList<String>();
        for (int i = 1; i <= no_of_table_rows; i++) {
            symbols.add(webDriver.findElement(By.xpath("//div[@id='" + table_id + "']//tbody//tr[" + i + "]/td[1]")).getText());
        }
        return symbols;
    }

    public ArrayList<String> getCompanies() {
        ArrayList<String> companies = new ArrayList<String>();
        for (int i = 1; i <= no_of_table_rows; i++) {
            companies.add(webDriver.findElement(By.xpath("//div[@id='" + table_id + "']//tbody//tr[" + i + "]/td[2]")).getText());
        }
        return companies;
    }

    public ArrayList<String> getLastSales() {
        ArrayList<String> lastSales = new ArrayList<String>();
        for (int i = 1; i <= no_of_table_rows; i++) {
            lastSales.add(webDriver.findElement(By.xpath("//div[@id='" + table_id + "']//tbody//tr[" + i + "]/td[4]")).getText());
        }
        return lastSales;
    }

    public ArrayList<String> getChangeNets() {
        ArrayList<String> changeNets = new ArrayList<String>();
        for (int i = 1; i <= no_of_table_rows; i++) {
            changeNets.add(webDriver.findElement(By.xpath("//div[@id='" + table_id + "']//tbody//tr[" + i + "]/td[5]")).getText());
        }
        return changeNets;
    }

    public ArrayList<String> getShareVolumes() {
        ArrayList<String> shareVolumes = new ArrayList<String>();
        for (int i = 1; i <= no_of_table_rows; i++) {
            shareVolumes.add(webDriver.findElement(By.xpath("//div[@id='" + table_id + "']//tbody//tr[" + i + "]/td[6]")).getText());
        }
        return shareVolumes;
    }


}
