package pages;

import org.openqa.selenium.By;
import site.CodePen;
import utils.AutomatedWebTool;

public class LoginPage extends PageBase {
    private By emailInputBy = By.xpath("//input[@id='login-email-field']");
    private By passwordInputBy = By.xpath("//input[@id='login-password-field']");
    private By loginButtonBy = By.xpath("//button[@id='log-in-button']");

    public LoginPage(AutomatedWebTool tool) {
        super(tool);
    }

    public TrendingPage login() {
        tool.waitAndReturnClickableElement(emailInputBy).sendKeys(CodePen.email);
        tool.waitAndReturnClickableElement(passwordInputBy).sendKeys(CodePen.password);
        tool.waitAndReturnClickableElement(loginButtonBy).click();

        TrendingPage trendingPage = new TrendingPage(tool);
        tool.waitUrlResolve(trendingPage.getPageUrl());
        return trendingPage;
    }
}
