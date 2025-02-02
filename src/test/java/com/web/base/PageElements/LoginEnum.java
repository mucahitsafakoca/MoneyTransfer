package com.web.base.PageElements;

import org.openqa.selenium.By;

public enum LoginEnum {
    USERNAME_INPUT(By.cssSelector("input[placeholder='Username']")),
    PASSWORD_INPUT(By.cssSelector("input[placeholder='Password']")),
    LOGIN_BUTTON(By.xpath("//div[contains(text(), 'Login')]")),
    INVALID_CREDENTIALS(By.xpath("//div[contains(text(), 'Username or Password Invalid!')]"));
    private final By locator;

    LoginEnum(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}