import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationPage {

    private final static int timeout = 2000;
    private final WebDriver driver;


    public ApplicationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@id=\"h_menu\"]/ul/li[1]/a")
    private static WebElement menu;

    @FindBy (xpath = "//*[@id=\"h_menu\"]/ul/li[1]/ul/li[3]/a")
    private static WebElement appSample;

    @FindBy (xpath = "//*[@id=\"region_2_default\"]/div[2]/div/p[6]/a")
    private static WebElement freeMealsButton;

    public void freeMealsApplication() throws InterruptedException {
        moveMouse(menu);
        appSample.click();

        Thread.sleep(timeout);

        freeMealsButton.click();

        Thread.sleep(timeout);
    }

    private void moveMouse(WebElement element) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        Thread.sleep(timeout/10);

    }

}
