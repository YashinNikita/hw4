package hw.pages.ex2.component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogWindow {


    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'Colors: value changed to Yellow')]]")
    private WebElement logForYellowDropdownOptionSelection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'metal: value changed to  Gold')]]")
    private WebElement logOfGoldRadioBtnSelection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'metal: value changed to  Silver')]]")
    private WebElement logOfSilverRadioBtnSelection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'metal: value changed to  Bronze')]]")
    private WebElement logOfBronzeRadioBtnSelection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'metal: value changed to  Selen')]]")
    protected WebElement logOfSelenRadioBtnSelection;

    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'Wind: condition changed to true')]]")
    private WebElement waterLogAfterSelection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'Water: condition changed to true')]]")
    private WebElement windLogAfterSelection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'Wind: condition changed to false')]]")
    private WebElement windLogAfterUnselection;
    @FindBy(xpath = "//ul[@class='panel-body-list logs' "
            + "and ./li[contains(.,'Water: condition changed to false')]]")
    private WebElement waterLogAfterUnselection;
    private WebDriver driver;

    public LogWindow(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("get log for selection yellow option in dropdown")
    public WebElement getLogForYellowDropdownOptionSelection() {
        return logForYellowDropdownOptionSelection;
    }

    @Step("get log for radio button selection")
    public WebElement getLogOfGoldRadioBtnSelection() {
        return logOfGoldRadioBtnSelection;
    }

    @Step("get log of silver radio button selection")
    public WebElement getLogOfSilverRadioBtnSelection() {
        return logOfSilverRadioBtnSelection;
    }

    @Step("get log of bronze radio button selection")
    public WebElement getLogOfBronzeRadioBtnSelection() {
        return logOfBronzeRadioBtnSelection;
    }

    @Step("get log for selen radio button selection")
    public WebElement getLogOfSelenRadioBtnSelection() {
        return logOfSelenRadioBtnSelection;
    }

    @Step("get log for Watter selection")
    public WebElement getWaterLogAfterSelection() {
        return waterLogAfterSelection;
    }

    @Step("get log for wind selection")
    public WebElement getWindLogAfterSelection() {
        return windLogAfterSelection;
    }

    @Step("get log for wind unselection")
    public WebElement getWindLogAfterUnselection() {
        return windLogAfterUnselection;
    }

    @Step("get log for water unselection")
    public WebElement getWaterLogAfterUnselection() {
        return waterLogAfterUnselection;
    }



}
