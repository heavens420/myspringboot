package com.zlx.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://baidu.com");
        WebElement element = webDriver.findElement(By.id("kw"));
        element.sendKeys("google");
    }
}
