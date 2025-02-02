package com.web.base.PageElements;

import org.openqa.selenium.By;

public enum MoneyTransferMainEnum {
    MY_ACCOUNT_TEXT(By.xpath("//div[contains(text(), 'My account')]"));

    private final By locator;

    MoneyTransferMainEnum(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

}
