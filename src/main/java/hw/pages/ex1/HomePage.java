package hw.pages.ex1;

import hw.pages.ex2.DifferentElementsPage;
import hw.pages.ex2.component.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private final Header header;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        header = new Header(driver);
    }

    @FindBy(className = "icons-benefit")
    private List<WebElement> benefitImages;
    @FindBy(className = "benefit-txt")
    List<WebElement> imageDescription;
    @FindBy(css = "ul.dropdown-menu > li")
    List<WebElement> menuOptions;
    @FindBy(className = "main-title")
    WebElement mainTitle;
    @FindBy(className = "main-txt")
    WebElement mainTxt;
    @FindBy(id = "second_frame")
    WebElement secondFrame;
    @FindBy(id = "epam-logo")
    WebElement epamLogo;
    @FindBy(css = "h3.text-center > a")
    WebElement subHeader;
    @FindBy(id = "mCSB_1")
    WebElement leftSection;
    @FindBy(css = ".footer-content")
    WebElement footerContent;
    @FindBy(className = "caret")
    WebElement serviceMenuButton;
    @FindBy(css = "ul.dropdown-menu > li:nth-child(8)")
    WebElement difElemPage;

    @Step("e1.1 Open Home Page")
    public void openHomePage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Step("e1.2/e1.5 get title")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("e1.3 Perform a login using: login = {login}, password= {password}")
    public void login(String login, String password) {
        header.getDropDownForLogin().click();
        header.getUserNameField().sendKeys(login);
        header.getPasswordInputField().sendKeys(password);
        header.getLoginButton().click();
    }

    @Step("e1.4 get User name in the left-top side of screen that user is loggined")
    public String getUserName() {
        return header.getUserNameIcon().getText();
    }


    @Step("e1.6.1 get item size")
    public int getHeaderBtnSize() {
        return header.getHeadersElements().size();
    }

    @Step("e1.6.2 get item visibility")
    public boolean areHeaderBtnDisplayed() {
        boolean result = true;
        for (WebElement element : header.getHeadersElements()) {
            if (!element.isDisplayed()) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Step("e1.6.3/e1.9 get item texts")
    public List getHeaderBtnTexts() {
        List headerBtnText = new ArrayList();
        for (WebElement element : header.getHeadersElements()) {
            headerBtnText.add(element.getText());
        }
        return headerBtnText;
    }

    @Step("e1.7.1 get quantity of images")
    public int getNumberOfBenefitImages() {
        return benefitImages.size();
    }

    @Step("e1.7.2 get visibility of images")
    public boolean areBenefitImgDisplayed() {
        boolean result = true;
        for (WebElement element : benefitImages) {
            if (!element.isDisplayed()) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Step("e1.8.1 get quantity of images on the Index Page")
    public int getNumberOfBenefitDescription() {
        return imageDescription.size();
    }

    @Step("e1.8.2 get text description under images")
    public List<String> getBenefitDescriptionsText() {
        List<String> imgDescription = new ArrayList<String>();
        for (WebElement description : imageDescription) {
            imgDescription.add(description.getText());
        }
        return imgDescription;
    }

    @Step("e1.10 get IFrame in the center of page")
    public boolean getCentralIFrameVisibility() {
        return secondFrame.isDisplayed();
    }

    @Step("e1.11.1 Switch to the iframe")
    public void switchToCentralIFrame() {
        driver.switchTo().frame(secondFrame);
    }

    @Step("e1.11.2 get EPAM logo")
    public boolean getVisibilityEpamLogoOnCentralIFrame() {
        return epamLogo.isDisplayed();
    }

    @Step("e1.12 Switch to original window")
    public void goToMainPage() {
        driver.switchTo().defaultContent();
    }

    @Step("e1.13 Get text of the sub header")
    public String getSubHeaderText() {
        return subHeader.getText();
    }

    @Step("e1.14 get JDI GITHUB url")
    public String getSubHeaderHref() {
        return subHeader.getAttribute("href");
    }

    @Step("e1.15 get left section visibility")
    public boolean getLeftSectionVisibility() {
        return leftSection.isDisplayed();
    }

    @Step("e1.16 get footer visibility")
    public boolean getFooterVisibility() {
        return footerContent.isDisplayed();
    }

    @Step("ex2.5.1/ex2.5.3 click on service category")
    public void clickOnServiceMenuButton() {
        serviceMenuButton.click();
    }

    @Step("ex2.5.2 get service dropdown options")
    public List<String> getServiceMenuOptionNames() {
        List<String> menu = new ArrayList<String>();
        for (WebElement element : menuOptions) {
            menu.add(element.getText());
        }
        return menu;
    }

    @Step("7 move to Different Elements Page")
    public DifferentElementsPage moveToDifElemPage() {
        clickOnServiceMenuButton();
        difElemPage.click();
        return new DifferentElementsPage(driver);
    }
}
