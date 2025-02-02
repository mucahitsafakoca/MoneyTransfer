package com.web.base.utils;

import com.web.base.PageElements.HomePageEnum;
import com.web.base.PageElements.LoginEnum;
import com.web.base.PageElements.MoneyTransferMainEnum;
import lombok.Getter;
import org.openqa.selenium.By;

public class LocatorFactory {

    // Singleton örneği
    @Getter
    private static LocatorFactory instance = new LocatorFactory();

    private LocatorFactory() {
    }
    public static LocatorFactory getInstance() {
        if (instance == null) {
            instance = new LocatorFactory();
        }
        return instance;
    }
    public By getLocator(String element) {
    try {
        return LoginEnum.valueOf(element.toUpperCase()).getLocator();
    } catch (IllegalArgumentException e) {
        try {
            return HomePageEnum.valueOf(element.toUpperCase()).getLocator();
        } catch (IllegalArgumentException e2) {
            try {
                return MoneyTransferMainEnum.valueOf(element.toUpperCase()).getLocator();
            } catch (IllegalArgumentException e3) {
                throw new IllegalArgumentException("Geçersiz element: " + element);
            }
        }
    }
}
}