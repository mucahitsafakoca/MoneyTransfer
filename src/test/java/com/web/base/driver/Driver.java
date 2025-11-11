package com.web.base.driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class Driver {

    public static WebDriver webDriver;
    private static WebDriverWait webDriverWait;

    @BeforeScenario
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Headless mod
        options.addArguments("--no-sandbox"); // Sandbox engelini kaldırır
        options.addArguments("--disable-dev-shm-usage"); // CI ortamlarında memory sorunu için
        options.addArguments("--disable-gpu"); // GPU devre dışı
        options.addArguments("--window-size=1920,1080"); // Ekran boyutu
        options.addArguments("--remote-allow-origins=*"); // Chrome 111+ için gerekli olabilir

        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://catchylabs-webclient.testinium.com/");
    }

    @AfterScenario
    public void closeDriver() {
        if (webDriver != null) {
            takeScreenshot();
            webDriver.quit();
            webDriver = null;
        }
    }

    private void takeScreenshot() {
        if (webDriver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Ekran Görüntüsü", "image/png", new ByteArrayInputStream(screenshot), ".png");
        }
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Please call initializeDriver() first.");
        }
        return webDriver;
    }

    public static WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            throw new IllegalStateException("WebDriverWait is not initialized. Please call initializeDriver() first.");
        }
        return webDriverWait;
    }
}
