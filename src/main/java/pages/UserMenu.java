package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AutomatedWebTool;

public class UserMenu extends PageBase {
    public UserMenu(AutomatedWebTool tool) {
        super(tool);
    }

    private By logoutButtonBy = By.xpath("//a[normalize-space()='Log Out']");
    private By settingsButtonBy = By.xpath("//a[normalize-space()='Settings']");

    public HomePage logout() {
        tool.waitAndReturnClickableElement(logoutButtonBy).click();
        HomePage homePage = new HomePage(tool);
        tool.getWait().until(ExpectedConditions.urlToBe(homePage.getPageUrl()));
        return homePage;
    }

    public SettingsPage openSettings() {
        tool.waitAndReturnClickableElement(settingsButtonBy).click();
        SettingsPage settingsPage = new SettingsPage(tool);
        tool.waitUrlResolve(settingsPage.getPageUrl());
        return settingsPage;
    }


}
