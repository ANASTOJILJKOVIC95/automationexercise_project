package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getAdress(){
        return driver.findElement(By.id("address_delivery"));
    }

    public WebElement getCommentInput(){
        return driver.findElement(By.cssSelector("textarea.form-control"));
    }
    public WebElement getPlaceOrderButton(){
        return driver.findElement(By.cssSelector("a[href='/payment']"));
    }
    public WebElement getNameOnCardInput(){
        return driver.findElement(By.xpath("//input[contains(@name,'name_on_card')]"));
    }
    public WebElement getCardNumberInput(){
        return driver.findElement(By.xpath("//input[contains(@name,'card_number')]"));
    }
    public WebElement getCVCInput(){
        return driver.findElement(By.xpath("//input[contains(@name,'cvc')]"));
    }
    public WebElement getExpirationMonthInput(){
        return driver.findElement(By.xpath("//input[contains(@name,'expiry_month')]"));
    }
    public WebElement getExpirationYearInput(){
        return driver.findElement(By.xpath("//input[contains(@name,'expiry_year')]"));
    }
    public WebElement getConfirmButton(){
        return driver.findElement(By.id("submit"));
    }
}
