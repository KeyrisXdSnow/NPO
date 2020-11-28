import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tests {

    private static WebDriver webDriver;

    private static MainPage mainPage;
    private static ApplicationPage applicationPage;
    private static ElectronicAppeal electronicAppeal;

    @BeforeClass
    public static void setUp () {
        System.setProperty("webdriver.chrome.driver",ConfigProperties.getProperty("chromeDriver"));

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get(ConfigProperties.getProperty("indexPage"));

        mainPage = new MainPage(webDriver);
        applicationPage = new ApplicationPage(webDriver);
        electronicAppeal = new ElectronicAppeal(webDriver);

    }

    @Test
    public void electronicAppealTest()  {

        try {
            electronicAppeal.freeMealsApplication();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.changeLangToBl();

    }
    @Test
    public void mainPageTest()  {
        mainPage.changeLangToBl();
     }

    @Test
    public void applicationPageTest () {
        try {
            applicationPage.freeMealsApplication();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void tearDown () {
        webDriver.quit();
    }



}
