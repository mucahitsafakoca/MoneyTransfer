package com.web.base.pagesteps;

import com.thoughtworks.gauge.Step;
import com.web.base.utils.LocatorFactory;
import com.web.base.utils.WebTestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseSteps extends WebTestMethods {
    private final LocatorFactory locatorFactory;

    public BaseSteps() {
        this.locatorFactory = LocatorFactory.getInstance();
    }

    @Step("Check if the URL is <url>")
    public void checkUrl(String url) {
        super.checkUrl(url);
        System.out.println("URL kontrolü tamamlandı: " + url);
    }

    @Step("Click <element>")
    public void clickElement(String element) {
        By locator = locatorFactory.getLocator(element);
        WebElement webElement = findElement(locator);
        clickElement(webElement);
        System.out.println(element + " alanına tıklandı");
    }

    @Step("Enter <text> into <element>")
    public void sendKeysToElement(String text, String element) {
        By locator = locatorFactory.getLocator(element);
        WebElement webElement = findElement(locator);
        sendKeys(webElement, text);
        System.out.println(text + " metni " + element + " alanına yazıldı");
    }
    @Step("Verify that <element> is visible")
    public void verifyElementVisible(String element) {
        By locator = locatorFactory.getLocator(element);
        WebElement webElement = findElement(locator);
        boolean isVisible = webElement.isDisplayed();
        if (isVisible) {
            System.out.println(element + " alanı görünüyor");
        } else {
            System.out.println(element + " alanı görünmedi");
        }
    }
}