package hw4.ex2;

import hw4.BaseTest;
import hw4.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


@Listeners(TestListener.class)
@Feature("test faulty behavior")
@Story("return false for openHomePage")
public class FailedTest extends BaseTest {

    //1 open Home Page
    @Test(priority = 1)
    public void openHomePage() {
        homePage.openHomePage();
        assertTrue(false);
    }
}
