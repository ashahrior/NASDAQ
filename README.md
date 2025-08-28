# NASDAQ Web Scraper

A Java-based web scraping application that automates the extraction of real-time financial data from NASDAQ websites using Selenium WebDriver.

## Features

* Automated account login and web-page traversal
* Scraping real-time financial data from NASDAQ tables
* Pre-market activity data extraction
* Most active stocks data collection
* Data export to CSV files with organized structure

## Technical Stack

* **Java** - Core programming language
* **Selenium WebDriver 3.13.0** - Web automation framework
* **ChromeDriver** - Browser automation

## Project Structure

```
src/
├── MainDriver.java                    # Application entry point
├── page/
│   ├── loginaccount/                  # Authentication handling
│   ├── mostactivestocks/              # Most active stocks scraping
│   └── premarketactivity/             # Pre-market data extraction
└── utilities/
    ├── StringData.java                # Configuration constants
    └── TableDataExtractor.java       # Base table scraping utility
```

## Build and Run

### Prerequisites
- Java JDK installed
- ChromeDriver available in `rsrc/chromedriver_win32/`

### Compilation
```bash
javac -cp "rsrc/selenium-java-3.13.0/client-combined-3.13.0.jar:rsrc/selenium-java-3.13.0/libs/*" -d out/production/NASDAQ src/**/*.java
```

### Execution
```bash
java -cp "out/production/NASDAQ:rsrc/selenium-java-3.13.0/client-combined-3.13.0.jar:rsrc/selenium-java-3.13.0/libs/*" MainDriver
```

## Data Sources

* **Pre-market Activity**: `https://www.nasdaq.com/extended-trading/premarket-mostactive.aspx`
* **Most Active Stocks**: `https://www.nasdaq.com/markets/most-active.aspx`

## Configuration

Update credentials and paths in `src/utilities/StringData.java`:
- Login credentials (currently placeholder values)
- ChromeDriver path for your operating system
- Output file paths for CSV exports

## Output

The application extracts and organizes the following financial data:
- Stock symbols and company names
- Last sale prices
- Net change and percentage change
- Share volumes
- Color-coded indicators for market movement
