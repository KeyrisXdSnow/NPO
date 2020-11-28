import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicAppeal {

    private final static int timeout = 2000;
    private final WebDriver driver;

    public ElectronicAppeal(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"REGION_1\"]/div[1]/div/div/ul/li[3]/a")
    private static WebElement menu;
    @FindBy (xpath = "//*[@id=\"field_fio\"]")
    private static WebElement fio;
    @FindBy (xpath = "//*[@id=\"field_place\"]")
    private static WebElement address;
    @FindBy (xpath = "//*[@id=\"field_email\"]")
    private static WebElement email;
    @FindBy (xpath = "//*[@id=\"field_question\"]")
    private static WebElement message;
    @FindBy (xpath = "//*[@id=\"pmgtext\"]")
    private static WebElement pin;
    @FindBy (xpath = "//*[@id=\"eo_feedback_form\"]/li[11]/span[2]/input")
    private static WebElement send;

    private void inputFio (String strFio) {
        fio.sendKeys(strFio);
    }

    private void inputAddress (String strAdress) { address.sendKeys(strAdress); }
    private void inputEmail (String strEmail) { email.sendKeys(strEmail); }
    private void inputMessage (String strMessage) { message.sendKeys(strMessage); }
    private void inputPin (String strPin) { pin.sendKeys(strPin); }

    public void freeMealsApplication() throws InterruptedException {
        menu.click();

        inputFio("fio");
        inputAddress("adress");
        inputEmail("email@email.com");
        inputMessage("test message");
        inputPin("test");

        Thread.sleep(timeout);
        send.click();
        Thread.sleep(timeout); // to check result
        checkAlert();
        Thread.sleep(timeout);

    }

    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
