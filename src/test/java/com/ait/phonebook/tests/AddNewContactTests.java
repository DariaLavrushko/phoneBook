package com.ait.phonebook.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.ContactData;
import com.ait.phonebook.utils.DataProviders;
import com.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest() {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastname(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactCreatedByText(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }



    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderPositiveTest(
            String name,
            String lastName,
            String phone,
            String email,
            String address,
            String description
    ) {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastname(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));

        app.getContact().clickOnSaveButton();
    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderCSVPositiveTest(Contact contact) {
        app.getContact().clickOnAddLink();

        app.getContact().fillContactForm(contact);

        app.getContact().clickOnSaveButton();
    }
}
