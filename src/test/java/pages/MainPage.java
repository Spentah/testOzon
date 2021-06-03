package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Каталог']")
    public WebElement catalog;

    @FindBy(xpath = "//span[text()='Экшн-камеры']")
    public WebElement category;

    public void goTo(){
        driver.get("https://www.ozon.ru/");
    }
}
