import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"lng\"]/a/span")
    private WebElement belLangButton;

    @FindBy(xpath = "//*[@id=\"lng\"]/span/title=\"Русский/span")
    private WebElement rusLangButton;

    public void changeLangToBl() {
        belLangButton.click();
    }

    public void changeLangToRus() {
        rusLangButton.click();
    }

}
