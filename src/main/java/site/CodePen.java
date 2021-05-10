package site;

import pages.HomePage;
import pages.LoginPage;
import pages.TrendingPage;
import pages.UserMenu;
import utils.AutomatedWebTool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CodePen {
    private static final Properties properties = getProperties();

    public static final String siteUrl = properties.getProperty("siteUrl");
    public static final String username = properties.getProperty("username");
    public static final String email = properties.getProperty("email");
    public static final String password = properties.getProperty("password");

    private AutomatedWebTool tool;

    private HomePage homePage;
    private TrendingPage trendingPage;
    private LoginPage loginPage;

    public CodePen(AutomatedWebTool tool) {
        this.tool = tool;
        tool.goToPage(siteUrl);
    }

    public TrendingPage login() {
        homePage = new HomePage(tool);
        loginPage = homePage.login();
        trendingPage = loginPage.login();
        return trendingPage;
    }

    public HomePage logout() {
        UserMenu userMenu = trendingPage.openUserMenu();
        homePage = userMenu.logout();
        return homePage;
    }


    private static Properties getProperties() {
        String propFileName = "config.properties";
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            inputStream = AutomatedWebTool.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
                prop.load(inputStream);
            else
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Exception: " + e);
                e.printStackTrace();
            }
        }

        return prop;
    }
}
