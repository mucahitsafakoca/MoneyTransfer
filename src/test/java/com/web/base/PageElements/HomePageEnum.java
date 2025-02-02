package com.web.base.PageElements;

import org.openqa.selenium.By;

public enum HomePageEnum {
    OPEN_MONEY_TRANSFER_BUTTON(By.xpath("//div[contains(text(), 'Open Money Transfer')]")),
    LOGOUT_BUTTON(By.xpath("//div[contains(text(), 'Logout')]"));

    private final By locator;

    HomePageEnum(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

}
