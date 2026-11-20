package task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShopOrder {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Test(priority = 1)
    public void login() {
        driver.get("https://www.saucedemo.com/");
        Setup.pause();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Setup.pause();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Setup.pause();
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        Setup.pause();
    }

    @Test(priority = 2)
    public void addToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Setup.pause();
        driver.findElement(By.className("shopping_cart_link")).click();
        Setup.pause();
    }

    @Test(priority = 3)
    public void checkout() {
        driver.findElement(By.id("checkout")).click();
        Setup.pause();
        driver.findElement(By.id("first-name")).sendKeys("Abdelrahman");
        Setup.pause();
        driver.findElement(By.id("last-name")).sendKeys("Mohamed");
        Setup.pause();
        driver.findElement(By.id("postal-code")).sendKeys("32511");
        Setup.pause();
        driver.findElement(By.id("continue")).click();
        Setup.pause();
    }

    @Test(priority = 4)
    public void finish() {
        driver.findElement(By.id("finish")).click();
        Setup.pause();
    }

    @Test(priority = 5)
    public void downloadPdf() {
        driver.findElement(By.linkText("Generate PDF order")).click();
        Setup.pause();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
