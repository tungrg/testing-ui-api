package com.tungrg.testing.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tungrg.testing.core.DriverWrapper;

import java.sql.Driver;

public class selenium4Test extends seleniumBaseTest{
    @Test
    public void TestingChromeAndSeleniumBasic(){
        //ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        //WebDriver driver = new ChromeDriver(service);

        DriverWrapper.getDriver().navigate().to("https://google.com");
        DriverWrapper.getDriver().quit();
        Assert.assertEquals(true,true);
    }
    @Test
    public void testingChromeSearch(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement search = driver.findElement(new By.ByClassName("gLFyf"));
        search.sendKeys("hello");
        search.sendKeys(Keys.ENTER);
        // WebElement keySearch = driver.findElement(new By.ByClassName("gNO89b"));
        // keySearch.click();
        WebElement linkHello = driver.findElement(new By.ByClassName("MMgsKf"));
        Assert.assertEquals("Adele - Hello - YouTube", linkHello.getText());
        Assert.assertTrue(linkHello.getText().contains("Adele"));
        driver.quit();
    }
    @Test
    public void testChromeDoodle(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement searchDoodle = driver.findElement(new By.ByXPath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]"));
        searchDoodle.click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("doodles"));
        driver.quit();
    }
    @Test
    public void testGoogleLanguage() {
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement language = driver.findElement(new By.ByClassName("uU7dJb"));

        Assert.assertTrue(language.getText().contains("Nam"));
        driver.quit();
    }
    @Test
    public void testGoogleApplication(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement application = driver.findElement(new By.ByClassName("gb_f")); // = la tham chieu;
        application.click();
        WebElement gmail = driver.findElement(new By.ByClassName("mobile-before-hero-only"));

        Assert.assertTrue(gmail.getText().contains("Gmail"));
        driver.quit();
    }
    @Test
    public void testGithub() throws InterruptedException {
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://github.com/tungrg/calculator");
        WebElement application = driver.findElement(new By.ByCssSelector("#issues-tab > span:nth-child(2)"));
        application.click();
        Thread.sleep(5000);
        WebElement issue = driver.findElement((new By.ByCssSelector("#js-issues-search")));

        Assert.assertTrue(issue.isDisplayed());
        driver.quit();
    }
    @Test
    public void testGoogleImage (){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement imageButton = driver.findElement(new By.ByCssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(2) > a"));
        imageButton.click();
        WebElement imageLogo = driver.findElement(new By.ByCssSelector("#hplogo"));
        Assert.assertTrue(imageLogo.isDisplayed());
        driver.quit();
    }
    @Test
    public void testGooglePrivacyButton(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement privacyButton = driver.findElement(new By.ByCssSelector("body > div.L3eUgb > div.o3j99.c93Gbe > div.KxwPGc.SSwjIe > div.KxwPGc.iTjxkf > a:nth-child(1)"));
        privacyButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("privacy"));
        driver.quit();
    }
    @Test
    public void testGoogleTermButton(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement termButton = driver.findElement(new By.ByCssSelector("body > div.L3eUgb > div.o3j99.c93Gbe > div.KxwPGc.SSwjIe > div.KxwPGc.iTjxkf > a:nth-child(2)"));
        termButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("term"));
        driver.quit();
    }
    @Test
    public void testGoogleAdsButton(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement adsButton = driver.findElement(new By.ByCssSelector("body > div.L3eUgb > div.o3j99.c93Gbe > div.KxwPGc.SSwjIe > div.KxwPGc.AghGtd > a:nth-child(2)"));
        adsButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("ads"));
        driver.quit();
    }
    @Test
    public void testGoogleSearchImage(){
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);
        driver.navigate().to("https://google.com");
        WebElement search = driver.findElement(new By.ByClassName("gLFyf"));
        search.sendKeys("pokemon");
        search.sendKeys(Keys.ENTER);
        WebElement moreImage = driver.findElement(new By.ByCssSelector("#media_result_group > div > div > a"));
        Assert.assertTrue(moreImage.isDisplayed());
        driver.quit();
    }
}
