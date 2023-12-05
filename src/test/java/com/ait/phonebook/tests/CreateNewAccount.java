package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.UserData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateNewAccount extends TestBase {

    // precondition: user should be logger out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
//        //click on Login link
//        driver.findElement(By.cssSelector("[href='/login']")).click();
//        //enter email
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).clear();
//        driver.findElement(By.name("email")).sendKeys("email@gmail.com");
//        //enter password
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).sendKeys("Wert1!%&");
//
//        //click on Registration button
//        driver.findElement(By.name("registration")).click();
//        //assert Alert
////        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
//        Assert.assertTrue(isAlertPresent());
    }

}
