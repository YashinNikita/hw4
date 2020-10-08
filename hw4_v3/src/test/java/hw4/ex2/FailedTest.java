package hw4.ex2;

import hw4.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FailedTest extends BaseTest {

    //1 open Home Page
    @Test(priority = 1)
    public void openHomePage() {
        assertTrue(false);
    }
}
