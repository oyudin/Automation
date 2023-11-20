package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import login.AccountCreatingPage;
import login.ClientCreatingPage;
import login.HomePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class AccountCreatingTest {
    private Random random = new Random();
    private Logger logger = Logger.getLogger(getClass());
    private WebDriver webDriver = new ChromeDriver();
    private String userName = "TestAccount " + random.nextInt(1000);

    private void setWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @Test
    public void validClientCreatingTest() {
        setWebDriverManager();

        webDriver.get(AccountCreatingPage.ACCOUNT_PAGE);
        logger.info("Accounts tab is open");
        webDriver.findElement(By.xpath(AccountCreatingPage.NEW_ACCOUNT_BUTTON)).click();
        logger.info("Account creating page is open");

        webDriver.findElement(By.xpath(AccountCreatingPage.PARTNER_ACCOUNT_RADIO_BUTTON));
        webDriver.findElement(By.xpath(AccountCreatingPage.NEXT_BUTTON));
        logger.info("Partner Account type creating pop-up is open");

        webDriver.findElement(By.xpath(AccountCreatingPage.ACCOUNT_NAME)).sendKeys(userName);
        webDriver.findElement(By.xpath(AccountCreatingPage.ACCOUNT_WEBSITE)).sendKeys("test@i.com");
        webDriver.findElement(By.xpath(AccountCreatingPage.ACCOUNT_EMAIL)).sendKeys(userName + "@mail.com");
        webDriver.findElement(By.xpath(AccountCreatingPage.ACTIVE_ACCOUNT_STATUS)).click();
        webDriver.findElement(By.xpath(AccountCreatingPage.SAVE_ACCOUNT_BUTTON)).click();
        logger.info("A new account is created");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        webDriver.quit();
    }
}
