package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement enterAccountText (){
        return driver.findElement(By.className("login-form"));
    }
    public WebElement getTitleRadioButton (String sex){
        if (sex.equals("female")){
            return driver.findElement(By.id("uniform-id_gender2"));}
            else if (sex.equals("male")){
               return driver.findElement(By.id("uniform-id_gender1"));}
            return null;
    }

    public WebElement getNameInput (){
        return driver.findElement(By.id("name"));
    }
    public WebElement getEmailInput (){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput (){
        return driver.findElement(By.id("password"));
    }
    public void selectDay(String day){
        Select select = new Select( driver.findElement(By.id("days")));
        select.selectByValue(day);
    }
    public void selectMonth(String months){
        Select select = new Select( driver.findElement(By.id("months")));
        select.selectByValue(months);
    }
    public void selectYear(String year){
        Select select = new Select( driver.findElement(By.id("years")));
        select.selectByValue(year);
    }
    public WebElement newsLetterCheckBox(){
        return driver.findElement(By.id("newsletter"));
    }
    public WebElement specialOffersCheckBox(){
        return driver.findElement(By.id("optin"));
    }

    public WebElement getFirstNameInput(){
        return driver.findElement(By.id("first_name"));
    }

    public WebElement getLasttNameInput(){
        return driver.findElement(By.id("last_name"));
    }
    public WebElement getCompanyInput(){
        return driver.findElement(By.id("company"));
    }
    public WebElement getAddress1Input(){
        return driver.findElement(By.id("address1"));
    }
    public WebElement getAddress2Input(){
        return driver.findElement(By.id("address2"));
    }

    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByValue(country);
    }
    public WebElement getStateInput(){
        return driver.findElement(By.id("state"));
    }
    public WebElement getCityInput(){
        return driver.findElement(By.id("city"));
    }
    public WebElement getZipCodeInput(){
        return driver.findElement(By.id("zipcode"));
    }
    public WebElement getMobileNumberInput(){
        return driver.findElement(By.id("mobile_number"));
    }
    public WebElement getCreateAccountButton(){
        return driver.findElement(By.xpath("//*[@data-qa='create-account']"));
    }

    public WebElement getContinueButton(){
        return driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
    }
}

