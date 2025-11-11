package dev.jackson.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    //locators
    private By emailAddressLocator = By.name("email");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By logOutButtonLocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public void signIn(){
        if(super.isDisplayed(emailAddressLocator)) {
            super.typeThis("jackson.silva.who@gmail.com", emailAddressLocator);
            super.typeThis("senhaDificil", passwordLocator);
            super.click(loginButtonLocator);
        } else {
            System.out.println("Email address field not being displayed on page");
        }
    }

    public Boolean amILoggedIn() {
        return super.isDisplayed(logOutButtonLocator);
    }
}
