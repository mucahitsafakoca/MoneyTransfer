package com.web.base.pagesteps;

import com.thoughtworks.gauge.Step;
import com.web.base.utils.LocatorFactory;
import com.web.base.pages.HomePage;
import org.openqa.selenium.By;

public class HomePageSteps extends BaseSteps{
    private final HomePage homePage;
    private final LocatorFactory locatorFactory;

    public HomePageSteps() {
        this.homePage = new HomePage();
        this.locatorFactory = LocatorFactory.getInstance();
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        clickElement("LOGOUT_BUTTON");
        System.out.println("Logout butonuna tıklandı.");
    }
}