package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","D:\\beat\\chromedriver.exe");
        StepDefinition.driver = new ChromeDriver();
        StepDefinition.driver.manage().window().maximize();
        StepDefinition.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @After
    public void end(){
        StepDefinition.driver.quit();
    }
}
