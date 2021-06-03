package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Экшн')]")
    private WebElement camera;

    @FindBy(xpath = "//div[@class='a7o7']")
    private WebElement actualPrice;

    public void isCameraCorrect() {
//        Assert.assertEquals(CameraPage.cameraAttribute,camera.getAttribute("outerText"));
//
        wait.until(ExpectedConditions.visibilityOf(camera));
        if (!(CameraPage.cameraAttribute.equals(camera.getAttribute("outerText")))) {
            Assert.fail("Не та камера в корзине");
        }
    }
}
