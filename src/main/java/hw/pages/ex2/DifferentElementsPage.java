package hw.pages.ex2;

import hw.pages.ex2.component.LogWindow;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;
    @FindBy(className = "label-radio")
    private List<WebElement> radios;
    @FindBy(css = "div .main-content-hg .uui-form-element")
    private List<WebElement> dropdown;
    @FindBy(css = "div .main-content-hg .uui-button")
    private List<WebElement> buttons;
    @FindBy(className = "right-fix-panel")
    private WebElement rightPanel;
    @FindBy(className = "sidebar-menu")
    private WebElement leftSection;
    @FindBy(css = "label.label-checkbox:nth-child(1) > input")
    private WebElement checkBoxWater;
    @FindBy(css = "label.label-checkbox:nth-child(3) > input")
    private WebElement checkBoxWind;
    @FindBy(css = "label.label-radio:nth-child(1) > input")
    private WebElement goldRadioBtn;
    @FindBy(css = "label.label-radio:nth-child(2) > input")
    private WebElement silverRadioBtn;
    @FindBy(css = "label.label-radio:nth-child(3) > input")
    private WebElement bronzeRadioBtn;
    @FindBy(css = "label.label-radio:nth-child(4) > input")
    private WebElement selenRadioBtn;
    @FindBy(css = "select.uui-form-element")
    private WebElement select;
    @FindBy(css = "select.uui-form-element > option:nth-child(4)")
    private WebElement yellowDropdownOption;

    private LogWindow logWindow;
    WebDriver driver;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        logWindow = new LogWindow(driver);
    }

    @Step("ex2.8.1 get checkboxes quantity on Different elements page")
    public int getSizeCheckboxes() {
        return checkboxes.size();
    }

    @Step("ex2.8.2 get checkboxes quantity on Different elements page")
    public int getSizeRadios() {
        return radios.size();
    }

    @Step("ex2.8.3 get checkboxes quantity on Different elements page")
    public int getSizeDropdown() {
        return dropdown.size();
    }

    @Step("ex2.8.4 get checkboxes quantity on Different elements page")
    public int getSizeButtons() {
        return buttons.size();
    }

    @Step("9. get Right Section visibility")
    public boolean checkVisibilityRightPanel() {
        return rightPanel.isDisplayed();
    }

    @Step("10. get Left Section visibility")
    public boolean checkVisibilityLeftSection() {
        return leftSection.isDisplayed();
    }

    @Step("11.1 Select checkboxes Water")
    public boolean testWaterCheckBoxSelection() {
        checkBoxWater.click();
        return checkBoxWater.isSelected();
    }

    @Step("11.2 Select checkboxes Wind")
    public boolean testWindCheckBoxSelection() {
        checkBoxWind.click();
        return checkBoxWind.isSelected();
    }

    @Step("12.1 get water log")
    public boolean isWaterLogDisplayed() {
        return logWindow.getWaterLogAfterSelection().isDisplayed();
    }

    @Step("12.2 get wind log")
    public boolean isWindLogDisplayed() {
        return logWindow.getWindLogAfterSelection().isDisplayed();
    }

    @Step("13 select Selen radio")
    public boolean testSelenRadioBtnSelection() {
        selenRadioBtn.click();
        return selenRadioBtn.isSelected();
    }

    @Step("14 check logs for radio button")
    public boolean checkLogsForAllRadioBtnSelection() {
        goldRadioBtn.click();
        silverRadioBtn.click();
        bronzeRadioBtn.click();
        selenRadioBtn.click();
        return logWindow.getLogOfGoldRadioBtnSelection().isDisplayed()
                && logWindow.getLogOfSilverRadioBtnSelection().isDisplayed()
                && logWindow.getLogOfBronzeRadioBtnSelection().isDisplayed()
                && logWindow.getLogOfSelenRadioBtnSelection().isDisplayed();

    }

    @Step("15 select yellow dropdown")
    public boolean testYellowDropdownOptionSelection() {
        select.click();
        yellowDropdownOption.click();
        return yellowDropdownOption.isSelected();
    }

    @Step("16 get log for yellow dropdown")
    public boolean testLogForYellowDropdownOptionSelection() {
        return logWindow.getLogForYellowDropdownOptionSelection().isDisplayed();
    }

    //works only if check box has been selected
    @Step("17.1 unselect water checkbox")
    public void unselectWaterCheckbox() {
        checkBoxWater.click();
    }

    //works only if check box has been selected
    @Step("17.2 unselect wind checkbox")
    public void unselectWindCheckbox() {
        checkBoxWind.click();
    }

    @Step("18 get logs visibility for water and wind")
    public boolean checkLogForWaterAndWindUnselection() {
        return logWindow.getWaterLogAfterUnselection().isDisplayed()
                && logWindow.getWindLogAfterUnselection().isDisplayed();
    }


}
