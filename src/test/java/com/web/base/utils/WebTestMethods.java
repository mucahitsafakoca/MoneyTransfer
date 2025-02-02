package com.web.base.utils;

import com.web.base.driver.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public class WebTestMethods {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebTestMethods() {
        this.driver = Driver.getWebDriver();
        this.wait = Driver.getWebDriverWait();
    }
    protected void takeScreenshot() {
        if (driver != null && driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Ekran Görüntüsü", new ByteArrayInputStream(screenshot).toString(), "image/png");
        }
    }

    public void checkUrl(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        System.out.println("URL kontrolü başarılı: " + expectedUrl);
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}