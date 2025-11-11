package dev.jackson.pages;

import org.openqa.selenium.By;

public class MenClothesPage extends BasePage {
    private By menOptionLocator = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    private By tShirtOptionLocator = By.xpath("//div[@id='Men']/div/ul/li/a[contains(text(), 'Tshirts')]");
    private By homeTitleLocator = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/h2");
    private By menSessionTitleLocator = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    private By firstItemToShopLocator = By.xpath("/html/body/section/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]");
    private By addToCartButtonLocator = By.cssSelector(
            "body > section > div > div.row > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products > div.product-overlay > div > a");
    private By confirmationMessageLocator = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[1]");
    private By modal = By.xpath("//*[@id=\"cartModal\"]");

    public void viewMenClothesPage() {
        if (super.isDisplayed(homeTitleLocator)) {
            super.findElement(menOptionLocator).click();
            this.makeThisMovementOnTheElement(tShirtOptionLocator);
            super.findElement(tShirtOptionLocator).click();
            if (super.isDisplayed(menSessionTitleLocator)) {
                this.makeThisMovementOnTheElement(firstItemToShopLocator);
                super.findElement(addToCartButtonLocator).click();
            }
        } else {
            System.out.println("the menu is not being displayed on the page");
        }
    }

    public String getConfirmationMessage() {
        if (super.isDisplayed(modal))
            return this.findElement(confirmationMessageLocator).getText();
        return "fail";
    }
}
