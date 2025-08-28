# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java-based web scraping application that uses Selenium WebDriver to extract real-time financial data from NASDAQ websites. The project automates login, page navigation, and data extraction from financial tables, storing the results in CSV files.

## Build and Run Commands

Since this is an Eclipse-based Java project, compile and run using:

```bash
# Compile the project (from project root)
javac -cp "rsrc/selenium-java-3.13.0/client-combined-3.13.0.jar:rsrc/selenium-java-3.13.0/libs/*" -d out/production/NASDAQ src/**/*.java

# Run the main application
java -cp "out/production/NASDAQ:rsrc/selenium-java-3.13.0/client-combined-3.13.0.jar:rsrc/selenium-java-3.13.0/libs/*" MainDriver
```

Note: ChromeDriver path in `StringData.java:9` uses Windows-style path separators and may need adjustment for different operating systems.

## Architecture

### Package Structure
- **MainDriver**: Entry point that coordinates the entire scraping workflow
- **page.loginaccount**: Handles NASDAQ community login authentication
- **page.premarketactivity**: Scrapes pre-market financial data tables
- **page.mostactivestokes**: Scrapes most active stocks data across multiple categories
- **utilities**: Common functionality for data extraction and configuration

### Core Workflow
1. **Initialization**: `MainDriver.initializeValues()` loads configuration from `StringData`
2. **Authentication**: `LogInDriver` handles community login via Selenium
3. **Page Navigation**: Main classes load specific NASDAQ pages
4. **Data Extraction**: `TableDataExtractor` base class extracts financial table data using XPath selectors
5. **Data Storage**: Results printed to console with CSV export capability (currently commented out)

### Key Components

**TableDataExtractor**: Base utility class that:
- Extracts table metadata (title, column headers, row counts)
- Scrapes financial data (symbols, companies, prices, changes, volumes)
- Provides CSV export functionality with configurable delimiters
- Uses XPath selectors to locate table elements by ID

**StringData**: Configuration class containing:
- WebDriver paths and browser settings
- Login credentials and target URLs
- Pre-market and most active stocks page URLs

### Data Sources
- Pre-market activity: `https://www.nasdaq.com/extended-trading/premarket-mostactive.aspx`
- Most active stocks: `https://www.nasdaq.com/markets/most-active.aspx`

## Dependencies

- Selenium WebDriver 3.13.0 (included in `rsrc/selenium-java-3.13.0/`)
- ChromeDriver (Windows executable in `rsrc/chromedriver_win32/`)
- All Selenium dependencies are bundled and referenced in `.classpath`

## Configuration Notes

- Login credentials are hardcoded as "xyz@gmail.com"/"xyz" in `StringData.java`
- File output paths are hardcoded to Windows paths in `TableDataExtractor.writeFile()`
- Most data extraction methods are currently commented out in main workflow
- Cookie consent handling is implemented for NASDAQ pages