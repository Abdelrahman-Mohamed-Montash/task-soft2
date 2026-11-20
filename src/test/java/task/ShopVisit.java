package task;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShopVisit {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void openShop() {
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test(priority = 2)
    public void goAndBack() {
        driver.navigate().to("https://www.selenium.dev/");
        driver.navigate().back();
        System.out.println(driver.getTitle());
    }

    @Test(priority = 3)
    public void devices() {
        driver.manage().window().setSize(new Dimension(390, 844));
        Setup.pause();
        driver.manage().window().setSize(new Dimension(1366, 1024));
        Setup.pause();
        driver.manage().window().maximize();
        Setup.pause();
    }

    @Test(priority = 4)
    public void newTab() {
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        System.out.println(driver.getWindowHandle());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
