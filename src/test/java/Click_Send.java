import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static java.time.Duration.ofSeconds;

public class Click_Send {

    // Инициализируем WebDriver при помощи модификатора доступа public Static и создания нового поля,
    // для автоматического использования в других классах
    public static WebDriver  driver;

    public static void main(String[] args) throws InterruptedException {

        // Установка веб драйвера
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Устанавливаем не явную задержку на десять секунд.
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));

        // Развертывание страницы на весь экран
        driver.manage().window().maximize();

        driver.get("https://rozetka.ua");

        Thread.sleep(4000);//Задержка обязательна, минимум 3 секунды
        WebElement closeBtn = driver.findElement(By.xpath("//span[@class=\"exponea-close-cross\"]"));
        closeBtn.click();

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Iphone 13");

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException m) {
            System.out.println("<<<<<<Alert not exist>>>>>>>");;
        }

        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),' Найти ')]"));
        searchBtn.click();

        WebElement thirdPhone = driver.findElement
                (By.xpath("(//span[contains(text(),' Мобильный телефон Apple iPhone 13')])[3]"));
        thirdPhone.click();

        Thread.sleep(3000);
        WebElement basket = driver.findElement(By.xpath("(//button[@class=\"header__button ng-star-inserted\"])[2]"));
        basket.click();

        Thread.sleep(3000);
        driver.quit();
        System.out.println("<<<<< Test Passed >>>>>>");


    }
}
