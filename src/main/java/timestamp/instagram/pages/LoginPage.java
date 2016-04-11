package timestamp.instagram.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Страница авторизации
 * 
 * @author timestamp
 */
@DefaultUrl("https://www.instagram.com/accounts/login/")
public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "[name='username']")
    public WebElement usernameField;    
    @FindBy(css = "[name='password']")
    public WebElement passwordField;
    @FindBy(css = "._rz1lq")
    public WebElement loginButton;
    @FindBy(css = "#react-root")
    public WebElement loginPageSelector;
    
    /**
     * Проверяем, что страница авторизации отрылась
     * 
     * @return boolean
     */
    public boolean loginPageIsPresent() {
        return waitForElementPresent(loginPageSelector);
    }
    
    /**
     * Заполняем поле логина
     * 
     * @param login
     */
    public void setLogin (String login) {
        usernameField.clear();
        usernameField.sendKeys(login);
    }
    
    /**
     * Заполняем поле пароля
     * 
     * @param password
     */
    public void setPassword (String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    /**
     * Клик по кнопке Войти
     */
    public void clickLogin() {
        loginButton.click();
    }
}
