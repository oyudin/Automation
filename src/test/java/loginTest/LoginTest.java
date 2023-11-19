package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    WebDriver webDriver;
    @Test
    public void validLoginTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        webDriver.get("http://localhost:8080/garage/persons");
        webDriver.findElement(By.xpath(".//a[text() = \"Новий клієнт\"]")).click();
        webDriver.findElement(By.xpath(".//input[@id='name']")).sendKeys("АлінаТест1");
        webDriver.findElement(By.xpath(".//input[@id='surname']")).sendKeys("Автотест");
        webDriver.findElement(By.xpath(".//input[@id='phoneNumber']")).sendKeys("380631112233");
        webDriver.findElement(By.xpath(".//button[@type = 'submit' and text() = 'Створити']")).click();

        webDriver.get("http://localhost:8080/garage/persons");
        webDriver.findElement(By.xpath(".//input[@type = 'search']")).clear();
        webDriver.findElement(By.xpath(".//input[@type = 'search']")).sendKeys("АлінаТест1");
        webDriver.findElement(By.xpath(".//input[@type = 'search']")).submit();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        webDriver.close();
    }
}
