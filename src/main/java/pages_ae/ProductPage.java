package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public List<WebElement> getAllProducts() {
        return driver.findElements(By.className("single-products"));
    }
    public List<WebElement> getViewDetails() {
        return driver.findElements(By.className("choose"));
    }
    public WebElement getSearchBox(){
        return driver.findElement(By.cssSelector("input#search_product"));
    }
    public WebElement getSearchButton (){
        return  driver.findElement(By.cssSelector("button#submit_search"));
    }
    public List<WebElement> getProductName(){
       return driver.findElements(By.xpath("//div[contains(@class, 'col-sm-4')]//div[contains(@class, 'productinfo')]"));
    }
    public List<WebElement> getAddToCartButton () {
      return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'overlay-content')]/a")));
    }

    public WebElement getContinueShoppingButton(){

       return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='modal-footer']/button")));
    }
    public WebElement getViewCartButton(){
      return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/view_cart']")));
    }
    public WebElement getProductQuantity(){
        return driver.findElement(By.cssSelector("input#quantity"));
    }
    public WebElement getAddToCartButtonViewDetailPage(){
        return driver.findElement(By.xpath("//*[@type='button']"));
    }
    public WebElement getReviewNameInput(){
        return driver.findElement(By.xpath("//*[@id='review-form']//input[@id='name']"));
    }
    public WebElement getReviewEmailInput(){
        return driver.findElement(By.xpath("//*[@id='review-form']//input[@id='email']"));
    }
    public WebElement getReviewTextInput(){
        return driver.findElement(By.xpath("//*[@id='review-form']//textarea[@id='review']"));
    }
    public WebElement getSendReviewButton(){
        return driver.findElement(By.xpath("//*[@id='review-form']//button[@id='button-review']"));
    }
    public WebElement getReviewSuccsessfulySentMessage()   {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]/span")));
    }
}
