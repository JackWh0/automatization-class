package dev.jackson.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.jackson.pages.RegisterPage;

public class RegisterPageTest {

    private RegisterPage registerPage;
    private final String URL = "https://automationexercise.com/login";

    @BeforeEach
    public void doItBeforeEachTest() {
        registerPage = new RegisterPage();
        registerPage.visit(URL);
    }

    @AfterEach
    public void doItAfterEachTest() {
        registerPage.quitWebDriver();
    }

    @Test
    public void testIfRegisterPageTakesYouToTheForm() {
        registerPage.insertDataToRegister();

        String actualEmail = registerPage.getEmailNewAccount();
        String expectedEmail = "jackwho@brq.com";
        Assertions.assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testIfRegistrationFormWorks() {
        this.registerPage.fillOutForm();

        String actualEmail = registerPage.getEmailNewAccount();
        String expectedEmail = "jackwho@brq.com";
        Assertions.assertEquals(expectedEmail, actualEmail);
    }
}
