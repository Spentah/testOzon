package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasketPage;
import pages.CameraPage;
import pages.MainPage;

import java.io.ByteArrayInputStream;

public class StepDefinition {
    public static WebDriver driver;
    public MainPage main = PageFactory.initElements(driver,MainPage.class);
    public CameraPage camera = PageFactory.initElements(driver,CameraPage.class);
    public BasketPage basket = PageFactory.initElements(driver,BasketPage.class);


    public void screenshot() {
        Allure.addAttachment("Скриншот", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Допустим("пользователь заходит на сайт Озон")
    public void пользовательЗаходитНаСайтОзон() {
        main.goTo();
        screenshot();
    }

    @И("на главной странице кликает на Каталог")
    public void наГлавнойСтраницеКликаетНаКаталог() {
        main.click(main.catalog);
        screenshot();
    }

    @И("в разделе каталог кликает на раздел Экшн-камеры")
    public void вРазделеКаталогКликаетНаРазделЭкшнКамеры() {
        main.click(main.category);
        screenshot();
    }

    @Когда("на странице экшн-камер выбирает чебокс GoPro и убеждается в том что чекбокс активен")
    public void наСтраницеЭкшнКамерВыбираетЧебоксGoProИУбеждаетсяВТомЧтоЧекбоксАктивен() throws Exception {
        camera.searchCheckBox();
        camera.chooseCheckbox();
        screenshot();
    }

    @И("выставляет цену от {string} до {string} рублей")
    public void выставляетЦенуОтДоРублей(String arg0, String arg1) {
        camera.setCostTo();
        screenshot();
    }

    @И("кладет случайню камеру в корзину")
    public void кладетСлучайнюКамеруВКорзину() throws InterruptedException {
        camera.chooseRandomCamera();
        camera.goToBasket();
        screenshot();
    }

    @Тогда("в корзине появляется именно эта камера")
    public void вКорзинеПоявляетсяИменноЭтаКамера() {
        basket.isCameraCorrect();
        screenshot();
    }
}
