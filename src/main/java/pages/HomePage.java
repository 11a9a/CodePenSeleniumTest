package pages;

import org.openqa.selenium.By;
import utils.AutomatedWebTool;

public class HomePage extends PageBase{
    private By accessLoginPageBtnBy = By.xpath("//a[normalize-space()='Log In']");

    public HomePage(AutomatedWebTool tool) {
        super(tool);
    }

    public LoginPage login() {
        tool.waitAndReturnClickableElement(accessLoginPageBtnBy).click();
        return new LoginPage(tool);
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl();
    }
}
