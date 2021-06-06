package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    WebDriver driver;
    WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void isElementDisplayed(WebElement element){
        waitForVisibility(element);
        Assert.assertTrue(element.isDisplayed());
    }
    public void click(WebElement element){
        waitForVisibility(element);
        element.click();
    }
    public void isElementSelected(WebElement element){
        waitForVisibility(element);
        Assert.assertTrue(element.isSelected());
    }
    public void setCost(String value, WebElement element){
//        click(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value, Keys.ENTER);
//        element.sendKeys(Keys.ENTER);

    }
}
