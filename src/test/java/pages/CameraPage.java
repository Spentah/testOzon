package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;

public class CameraPage extends PageBase {
    public CameraPage(WebDriver driver) {
        super(driver);
    }
    public static String cameraAttribute;
    public static String expectedPrice;

    @FindBy(xpath = "//div[@class='cx8']//div[@class='_3eqP']")
    private WebElement checkbox;

    @FindBy(xpath = "//span[@class='show']")
    private WebElement showAll;

    @FindBy(xpath = "//input[@qa-id='range-from']")
    private WebElement costFrom;

    @FindBy(xpath = "//input[@qa-id='range-to']")
    private WebElement costTo;

    @FindBy(xpath = "//a[@data-widget='cart']")
    private WebElement basket;

    @FindBy(xpath = "//div[@class='b9x3']//div[@tabindex='-1']")
    private WebElement inBasket;

    @FindBy(xpath = "//span[@class='c2h5 c2h6']")
    private WebElement price;

    @FindBy(xpath = "//span[@class='f-caption--bold a9c4']")
    private WebElement checkBasket;

    @FindBy(xpath = "//input[@class='_16XE hlVC']")
    private WebElement searchField;

    By basketButton = By.xpath("//div[@class='widget-search-result-container ao3']//a[@class='tile-hover-target b3u9']");

    public void searchCheckBox(){
        waitForVisibility(showAll);
        showAll.click();
        searchField.sendKeys("gopro");
    }

    public void chooseCheckbox() {
//        waitForVisibility(checkbox);
        checkbox.click();
        if (driver.findElement(By.xpath("//div[@class='cx8']//div[@class='_3eqP']//input"))
                .getAttribute("checked").equals("false")) {
            Assert.fail("Чекбокс не активен");
        }
    }

    public void setCostTo(){
        setCost("30000",costTo);
    }
    public void chooseRandomCamera() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> cameraPool = driver.findElements(basketButton);
        Collections.shuffle(cameraPool);
        cameraAttribute = cameraPool.get(0).getAttribute("outerText");
        cameraPool.get(0).click();
        expectedPrice = price.getAttribute("outerText");
        inBasket.click();
        if (!(checkBasket.getAttribute("textContent").equals("1"))) {
            Assert.fail("Счетчик корзины не поменялся");
        }
    }
    public void goToBasket(){
        click(basket);
    }
}
