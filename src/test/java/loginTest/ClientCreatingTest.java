package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import login.ClientCreatingPage;
import login.HomePage;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;


public class ClientCreatingTest {
    private Random random = new Random();
    private Logger logger = Logger.getLogger(getClass());
    private WebDriver webDriver;
    private String userName = "TestUser " + random.nextInt(1000);

    @Test
    public void validClientCreatingTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        webDriver.get(HomePage.HOME_PAGE);
        logger.info("Home page is opened");
        webDriver.findElement(By.xpath(ClientCreatingPage.NEW_CLIENT_BUTTON)).click();


        webDriver.findElement(By.xpath(ClientCreatingPage.NAME_FIELD)).sendKeys(userName);
        webDriver.findElement(By.xpath(ClientCreatingPage.SURNAME_FIELD)).sendKeys("Автотест");
        webDriver.findElement(By.xpath(ClientCreatingPage.PHONE_NUMBER_FIELD)).sendKeys("380631112233");
        logger.info("The fields are filled out: Name, Surname, PhoneNumber");

        webDriver.findElement(By.xpath(ClientCreatingPage.SUBMIT_USER_CREATING_BUTTON)).click();
        logger.info("A new user is created" + logger);


        webDriver.get(HomePage.HOME_PAGE);
        webDriver.findElement(By.xpath(HomePage.SEARCH_FIELD)).clear();
        webDriver.findElement(By.xpath(HomePage.SEARCH_FIELD)).sendKeys(userName);
        webDriver.findElement(By.xpath(HomePage.SEARCH_FIELD)).submit();

        webDriver.close();
    }
}
