package dev.jackson.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.jackson.pages.MenClothesPage;

public class MenClothesPageTest {

    private MenClothesPage menClothesPage;

    @BeforeEach
    public void doItBeforeEachTest(){
        this.menClothesPage = new MenClothesPage();
        this.menClothesPage.visit("https://automationexercise.com/");
    }

    @AfterEach
    public void doItAfterEachTest() {
        this.menClothesPage.quitWebDriver();
    }

    @Test
    public void checkIfAddToCartFeatureIsWorking () {
        this.menClothesPage.viewMenClothesPage();

        String actualConfirmationMessage = this.menClothesPage.getConfirmationMessage();
        String expectedMessage = "Your product has been added to cart.";

        Assertions.assertEquals(expectedMessage, actualConfirmationMessage);
    }
}
