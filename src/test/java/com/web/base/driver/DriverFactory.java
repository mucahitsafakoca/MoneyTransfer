package com.web.base.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getDriverPath("geckodriver"));
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", getDriverPath("msedgedriver"));
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static String getDriverPath(String driverName) {
        String os = System.getProperty("os.name").toLowerCase();
        String basePath = "drivers/";

        if (os.contains("win")) {
            return basePath + driverName + ".exe"; // Windows
        } else if (os.contains("mac")) {
            return basePath + driverName;
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + os);
        }
    }
}