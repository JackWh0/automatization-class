package dev.jackson.pages;

import java.time.Duration;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private By nameFieldLocator = By.name("name");
    private By emailAddressFieldLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By signUpButtonLocator = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    private By titleFormLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
    private By genderLocator = By.id("id_gender1");
    private By passwordLocator = By.id("password");
    private By daysLocator = By.id("days");
    private By monthsLocator = By.id("months");
    private By yearsLocator = By.id("years");
    private By optinLocator = By.id("optin");
    private By firstNameLocator = By.id("first_name");
    private By lastNameLocator = By.id("last_name");
    private By addressLocator = By.id("address1");
    private By countryLocator = By.id("country");
    private By stateLocator = By.id("state");
    private By cityLocator = By.id("city");
    private By zipCodeLocator = By.id("zipcode");
    private By mobileNumberLocator = By.id("mobile_number");
    private By createAccountButtonLocator = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");


    public void insertDataToRegister() {
        if(super.isDisplayed(nameFieldLocator)) {
            typeThis("jackwho@brq.com", emailAddressFieldLocator);
            typeThis("Hugo Motta", nameFieldLocator);
            
            click(signUpButtonLocator);
        } else {
            System.out.println("The field name was not found.");
        }
    }

    public void fillOutForm() {
        this.insertDataToRegister();
        super.waitVisibilitOfElementLocated(titleFormLocator, Duration.ofSeconds(2));

        if (isDisplayed(genderLocator)) {
            click(genderLocator);
            typeThis("1234", passwordLocator);
            selectByValue(daysLocator, "11");
            selectByValue(monthsLocator, "7");
            selectByValue(yearsLocator, "1999");
            click(optinLocator);
            typeThis("Hugo", firstNameLocator);
            typeThis("Motta", lastNameLocator);
            selectByValue(countryLocator, "United States");
            typeThis("Rua viva", addressLocator);
            typeThis("Rio de Janeiro", stateLocator);
            typeThis("Rio de Janeiro", cityLocator);
            typeThis("566985", zipCodeLocator);
            typeThis("3299999999",mobileNumberLocator);            
            click(createAccountButtonLocator);
        }else {
            System.out.println("Gender field not found.");
        }
    }

    public String getEmailNewAccount() {
        return super.getTextByAttribute(emailAddressFieldLocator, "value");
    }
}
