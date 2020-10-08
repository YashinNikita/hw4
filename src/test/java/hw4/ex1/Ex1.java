package hw4.ex1;
import hw4.BaseTest;
import hw4.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
@Feature("Login. Header's menu")
@Story("Test Home Page functionality")
public class Ex1 extends BaseTest {


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

    //5 Assert Browser title
    @Test(priority = 5)
    public void checkTitleAfterLogin() {
        assertEquals(homePage.getTitle(), dataHW.getHomepageTitle());
    }

    //6 Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test(priority = 6, dependsOnMethods = "performLogin")
    public void checkHeaderElements() {
        compareQuantity(homePage.getHeaderBtnSize(), dataHW.getHeaderBtnElements().size());
        expectTrue(homePage.areHeaderBtnDisplayed());
        compareListStrings(homePage.getHeaderBtnTexts(), (dataHW.getHeaderBtnElements()));
    }

    //7 Assert that there are 4 images on the Index Page and they are displayed
    @Test(priority = 7)
    public void countPicturesOnIndexPage() {
        compareQuantity(homePage.getNumberOfBenefitImages(), dataHW.getBenefitsImgAmount());
        expectTrue(homePage.areBenefitImgDisplayed());
    }

    //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
    // 4 texts below of each image
    // Texts are displayed and equal to expected
    @Test(priority = 8)
    public void countTextUnderPictures() {
        compareQuantity(homePage.getNumberOfBenefitDescription(), dataHW.getNumberOfTextUnderImgs());
        compareListStrings(homePage.getBenefitDescriptionsText(), dataHW.getTextUnderImg());
    }

    //9 Assert a text of the main headers
    @Test(priority = 9)
    public void checkHeadersTexts() {
        compareListStrings(homePage.getHeaderBtnTexts(), (dataHW.getHeaderBtnElements()));
    }

    //10 Assert that there is the iframe in the center of page
    @Test(priority = 10)
    public void checkIFrameExistence() {
        expectTrue(homePage.getCentralIFrameVisibility());
    }

    //11 Switch to the iframe and check that there is
    // Epam logo in the left top conner of iframe
    @Test(priority = 11)
    public void checkLogoOnIFrame() {
        homePage.switchToCentralIFrame();
        expectTrue(homePage.getVisibilityEpamLogoOnCentralIFrame());
    }

    //12 Switch to original window back
    @Test(priority = 12)
    public void switchToMain() {
        homePage.goToMainPage();
    }


    //13 Assert a text of the sub header
    @Test(priority = 13)
    public void checkSubHeaderText() {
        compareStrings(homePage.getSubHeaderText(), dataHW.getJgiGithubText());
    }

    //14 Assert that JDI GITHUB is a link and has a proper URL
    @Test(priority = 14)
    public void checkSubHeaderUrl() {
        compareStrings(homePage.getSubHeaderHref(), dataHW.getJdiGitHref());
    }

    //15 Assert that there is Left Section
    @Test(priority = 15)
    public void checkIfLeftSectionPresent() {
        expectTrue(homePage.getLeftSectionVisibility());
    }

    //16 Assert that there is Footer
    @Test(priority = 16)
    public void checkIfFooterIsPresent() {
        expectTrue(homePage.getFooterVisibility());
    }

}
