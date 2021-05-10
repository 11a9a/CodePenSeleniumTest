package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.AutomatedWebTool;

public class ProfileSettingsPage extends PageBase {
    public ProfileSettingsPage(AutomatedWebTool tool) {
        super(tool);
    }

    private By nameInputBy = By.xpath("//input[@id='name']");
    private By locationInputBy = By.xpath("//input[@id='location']");
    private By bioInputBy = By.xpath("//textarea[@id='bio']");
    private By url1InputBy = By.xpath("//input[@id='url']");
    private By url2InputBy = By.xpath("//input[@id='url1']");
    private By url3InputBy = By.xpath("//input[@id='url2']");

    public void updateProfile(String nameInput, String locationInput, String bioInput, String url1, String url2, String url3) {
        if (nameInput != null) {
            tool.waitAndReturnClickableElement(nameInputBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), nameInput);
            tool.waitAndReturnElement(By.xpath("//*[contains(text(), 'Display Name updated')]"));
        }
        if (locationInput != null) {
            tool.waitAndReturnClickableElement(locationInputBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), locationInput);
            tool.waitAndReturnElement(By.xpath("//*[contains(text(), 'Location updated')]"));
        }
        if (bioInput != null) {
            tool.waitAndReturnClickableElement(bioInputBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), bioInput);
            tool.waitAndReturnElement(By.xpath("//*[contains(text(), 'Bio updated')]"));

        }
        if (url1 != null) {
            tool.waitAndReturnClickableElement(url1InputBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), url1);
            tool.waitAndReturnElement(By.xpath("//*[contains(text(), 'Link #1 updated')]"));

        }
        if (url2 != null) {
            tool.waitAndReturnClickableElement(url2InputBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), url2);
            tool.waitAndReturnElement(By.xpath("//*[contains(text(), 'Link #2 updated')]"));
        }
        if (url3 != null) {
            tool.waitAndReturnClickableElement(url3InputBy).sendKeys(Keys.chord(Keys.CONTROL, "a"), url3);
            tool.waitAndReturnElement(By.xpath("//*[contains(text(), 'Link #3 updated')]"));
        }

    }

    public String getNameInput() {
        return tool.waitAndReturnClickableElement(nameInputBy).getAttribute("value");
    }

    public String getLocationInput() {
        return tool.waitAndReturnClickableElement(locationInputBy).getAttribute("value");

    }

    public String getBioInput() {
        return tool.waitAndReturnClickableElement(bioInputBy).getAttribute("value");

    }

    public String getUrl1Input() {
        return tool.waitAndReturnClickableElement(url1InputBy).getAttribute("value");
    }

    public String getUrl2Input() {
        return tool.waitAndReturnClickableElement(url2InputBy).getAttribute("value");
    }

    public String getUrl3Input() {
        return tool.waitAndReturnClickableElement(url3InputBy).getAttribute("value");
    }

    @Override
    public String getPageUrl() {
        return super.getPageUrl() + "settings/profile";
    }

}
