package hw4.ex2;

import hw.pages.ex2.DifferentElementsPage;
import hw4.BaseTest;
import hw4.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Listeners(TestListener.class)
@Feature("CheckBoxes, Dropdown selection and correct Logs in Log field")
@Story("Test Different Element Page functionality")
public class Ex2 extends BaseTest {

    private DifferentElementsPage differentElementsPage;


    @BeforeClass
    public void setEx2() {
        differentElementsPage = new DifferentElementsPage(getDriver());
    }


    //1 open Home Page
    @Test(priority = 1)
    public void openHomePage() {
        homePage.openHomePage();
    }

    //2 Assert Browser title
    @Test(priority = 2)
    public void checkTitle() {
        assertEquals(homePage.getTitle(), (dataHW.getHomepageTitle()));
    }

    //3 Perform login
    @Test(priority = 3)
    public void performLogin() {
        homePage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    //4 Assert User name in the left-top side of screen that user is loggined
    @Test(priority = 4, dependsOnMethods = "performLogin")
    public void checkUserNameVisibilityAfterLogin() {
        compareStrings(homePage.getUserName(), properties.getProperty("full_name"));
    }

    //5 Click on "Service" subcategory in the header and check that drop down contains options
    //6 Click on "Service" subcategory in the header and check that drop down contains options
    @Test(priority = 5)
    public void checkServiceCategoryNaming() {
        homePage.clickOnServiceMenuButton();
        compareListStrings(homePage.getServiceMenuOptionNames(), dataHW.getDiElemPageMenuItems());
        homePage.clickOnServiceMenuButton();
    }

    //7 Open through the header menu Service -> Different Elements Page
    @Test(priority = 7)
    public void openDifferentElementsPage() {
        homePage.moveToDifElemPage();
    }

    //8 Check interface on Different elements page, it contains all needed elements
    // 4 checkboxes, 4 radios, 1 dropdown, 2 buttons
    @Test(priority = 8)
    public void checkInterfaceOnDifPage() {
        compareQuantity(differentElementsPage.getSizeCheckboxes(), dataHW.getCheckBoxesQuantity());
        compareQuantity(differentElementsPage.getSizeRadios(), dataHW.getRadiosQuantity());
        compareQuantity(differentElementsPage.getSizeDropdown(), dataHW.getDropdownQuantity());
        compareQuantity(differentElementsPage.getSizeButtons(), dataHW.getButtonsQuantity());
    }

    //9 Assert that there is Right Section
    @Test(priority = 9)
    public void checkRightSection() {
        expectTrue(differentElementsPage.checkVisibilityRightPanel());
    }

    //10 Assert that there is Left Section
    @Test(priority = 10)
    public void checkLeftSection() {
        expectTrue(differentElementsPage.checkVisibilityLeftSection());
    }

    //11 Select checkboxes Water, Wind
    @Test(priority = 11)
    public void selectCheckBoxes() {
        expectTrue(differentElementsPage.testWaterCheckBoxSelection());
        expectTrue(differentElementsPage.testWindCheckBoxSelection());
    }

    //12 Assert that for each checkbox there is an individual log row
    // and value is corresponded to the status of checkbox.
    @Test(priority = 12)
    public void checkLogRowsForCheckBox() {
        expectTrue(differentElementsPage.isWaterLogDisplayed());
        expectTrue(differentElementsPage.isWindLogDisplayed());
    }

    //13 Select radio Selen
    @Test(priority = 13)
    public void testRadioBtnSelenSelection() {
        expectTrue(differentElementsPage.testSelenRadioBtnSelection());
    }

    //14 Assert that for radiobutton there is a log row
    // and value is corresponded to the status of radiobutton.
    @Test(priority = 14)
    public void checkLogRowsForRadio() {
        expectTrue(differentElementsPage.checkLogsForAllRadioBtnSelection());
    }

    //15 Select in dropdown Yellow
    @Test(priority = 15)
    public void testYellowDropdownOptionSelection() {
        expectTrue(differentElementsPage.testYellowDropdownOptionSelection());
    }

    //16 Assert that for dropdown there is a log row
    // and value is corresponded to the selected value.
    @Test(priority = 16)
    public void checkLogForSelectYellowDropdownSelection() {
        expectTrue(differentElementsPage.testLogForYellowDropdownOptionSelection());
    }

    //17 Unselect and assert checkboxes Water,Wind Elements are unchecked
    @Test(priority = 17)
    public void testCheckBoxesUnselection() {
        differentElementsPage.unselectWaterCheckbox();
        differentElementsPage.unselectWindCheckbox();
    }


    //18 Assert that for each checkbox there is an individual log row
    // and value is corresponded to the status of checkbox.
    @Test(priority = 18)
    public void checkLogForWaterAndWindUnselection() {
        expectTrue(differentElementsPage.checkLogForWaterAndWindUnselection());
    }
}
