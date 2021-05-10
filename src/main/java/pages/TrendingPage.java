package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.AutomatedWebTool;


public class TrendingPage extends PageBase {

    private By userMenuButtonBy = By.xpath("//button[@title='User Menu']");
    private By userMenuBy = By.xpath("//ul[@class='UserMenu_userMenu-1_h1W']");


    public TrendingPage(AutomatedWebTool tool) {
        super(tool);
    }

    public UserMenu openUserMenu() {
        tool.waitAndReturnClickableElement(userMenuButtonBy).click();
        tool.waitAndReturnElement(userMenuBy);

        return new UserMenu(tool);
    }

    public String getUserMenuHoverTitle() {
        Actions builder = new Actions(tool.getDriver());
        WebElement userMenuBtn = tool.waitAndReturnClickableElement(userMenuButtonBy);

        builder.moveToElement(userMenuBtn).perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String toolTip = userMenuBtn.getAttribute("title");

        return toolTip;
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "trending";
    }
}
