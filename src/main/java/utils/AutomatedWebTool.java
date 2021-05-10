package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.CodePen;

import java.util.HashMap;
import java.util.Map;

public class AutomatedWebTool {
    private WebDriver driver;
    private WebDriverWait wait;

    public AutomatedWebTool() {
        this.driver = null;
        this.wait = null;
    }

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        System.out.println("Chrome driver is running");

        this.wait = new WebDriverWait(driver, 20);
        this.driver.manage().window().maximize();
    }

    public void goToPage(String url) {
        this.driver.get(url);
    }

    public void closeBrowser() {
        this.driver.quit();
    }

    public WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public WebElement waitAndReturnClickableElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this.driver.findElement(locator);
    }

    public void waitUrlResolve(String url) {
        this.wait.until(ExpectedConditions.urlContains(url));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String navigateBack() {
        driver.navigate().back();
        return getCurrentUrl();
    }
}

