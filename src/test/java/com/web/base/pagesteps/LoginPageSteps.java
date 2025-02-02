package com.web.base.pagesteps;

import com.thoughtworks.gauge.Step;

public class LoginPageSteps extends BaseSteps {

    @Step("Login with username <username> and password <password>")
    public void login(String username, String password) {
        sendKeysToElement(username, "USERNAME_INPUT");
        sendKeysToElement(password, "PASSWORD_INPUT");
        clickElement("LOGIN_BUTTON");
        System.out.println("Login işlemi tamamlandı.");
    }
}