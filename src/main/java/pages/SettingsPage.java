package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AutomatedWebTool;

public class SettingsPage extends PageBase {
    public SettingsPage(AutomatedWebTool tool) {
        super(tool);
    }

    private By profileButtonBy = By.xpath("//a[normalize-space()='Profile']");

    public ProfileSettingsPage openProfile() {
        tool.waitAndReturnClickableElement(profileButtonBy).click();
        ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage(tool);
        tool.getWait().until(ExpectedConditions.urlToBe(profileSettingsPage.getPageUrl()));
        return profileSettingsPage;
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "settings";
    }
}
