package hw.pages.ex2.component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Header {

    private WebDriver driver;


    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".caret:nth-child(2)")
    private WebElement dropDownForLogin;
    @FindBy(id = "name")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userNameIcon;
    @FindBy(xpath = "//nav/ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headersElements;

    @Step("get dropdown for login")
    public WebElement getDropDownForLogin() {
        return dropDownForLogin;
    }

    @Step("get user name field")
    public WebElement getUserNameField() {
        return userNameField;
    }

    @Step("get password field")
    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    @Step("get login button")
    public WebElement getLoginButton() {
        return loginButton;
    }

    @Step("get user name icon")
    public WebElement getUserNameIcon() {
        return userNameIcon;
    }

    @Step("get header elements")
    public List<WebElement> getHeadersElements() {
        return headersElements;
    }

}
