package com.web.base.pages;

import com.web.base.utils.WebTestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends WebTestMethods {

    public void checkUrl(String url) {
        super.checkUrl(url);
        System.out.println("URL kontrol edildi: " + url);
    }
}