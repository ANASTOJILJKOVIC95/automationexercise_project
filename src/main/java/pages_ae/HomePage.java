package pages_ae;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement footer(){
        return driver.findElement(By.id("footer"));
    }
    public WebElement getSubscriptionBox(){
        return driver.findElement(By.cssSelector("input#susbscribe_email"));
    }
    public WebElement getSubscriptionButton(){
        return driver.findElement(By.cssSelector("button#subscribe"));
    }
    public WebElement getSubscriptionMessage () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'alert-success')]")));
    }
    public WebElement getWomenCategoryButton(){
        return  driver.findElement(
                By.xpath("//a[@href='#Women']"));
    }
    public WebElement getDressCategoryButton() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//a[@href='/category_products/1']"))));
    }

    public WebElement getMenCategoryLink() {
        return driver.findElement(
                By.xpath("//a[@href='#Men']"));
    }
    public WebElement getTshirtsCategoryButton() {
     return    wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//a[@href='/category_products/3']"))));
    }
    public WebElement getPoloBrandButton() {
        return driver.findElement(
                By.xpath("//a[@href='/brand_products/Polo']"));
    }
    public WebElement getMadameBrandButton() {
        return driver.findElement(
                By.xpath("//a[@href='/brand_products/Madame']"));
    }
    public WebElement getRecommendedItems(){
        return driver.findElement(By.className("recommended_items"));
    }
    public WebElement getRecommendedItemAddToCartButton(){
  return driver.findElement(By.xpath("//div[@class='recommended_items']//div[@class='item active']/div//a")); }

    public WebElement header(){
        return driver.findElement(By.id("header"));
    }
    public WebElement getHomePageText(){
        return driver.findElement(By.className("col-sm-6"));
    }
    public WebElement getScrollUpArrow(){
        return driver.findElement(By.id("scrollUp"));
    }
}
