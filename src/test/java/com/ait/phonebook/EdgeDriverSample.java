package com.ait.phonebook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverSample {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new EdgeDriver();
        try {
            driver.navigate().to("https://bing.com");

            WebElement element = driver.findElement(By.id("sb_form_q"));
            element.sendKeys("WebDriver");
            element.submit();

            Thread.sleep(5000);
        } finally {
            driver.quit();
        }
    }
}
