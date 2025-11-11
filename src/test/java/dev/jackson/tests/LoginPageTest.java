package dev.jackson.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.jackson.pages.LoginPage;

public class LoginPageTest {

    private LoginPage loginPage;
    private final String URL = "https://automationexercise.com/login";
    
    @BeforeEach
    public void doItBeforeEachTest() {
        this.loginPage = new LoginPage();
        this.loginPage.visit(this.URL);
    }

    @AfterEach
    public void doItAfterEachTest() {
        this.loginPage.quitWebDriver();
    }

    @Test
    public void test () {
        //when
        this.loginPage.signIn();

        //then
        Assertions.assertTrue(this.loginPage.amILoggedIn());
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(this.URL));
    }
}
