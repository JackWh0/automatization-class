package dev.jackson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void executarAntesCadaTeste() {
        
        driver.get("https://automationexercise.com/login");
    }

    @AfterEach
    void executarAposCadaTeste() {
        driver.quit();
    }

    @Test
    void executarTesteLogin() {
        WebElement emailAddressElement = driver.findElement(By.name("email"));
        emailAddressElement.sendKeys("jackson.silva.who@gmail.com");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("senhaDificil");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        LoginButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";

        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}
