package timestamp.instagram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Страница просмотра поста
 * 
 * @author timestamp
 */
public class PostPage extends  MainPage{

    public PostPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = ".y09")
    public WebElement postHeader;
    @FindBy(css = ".coreSpriteHeartOpen")
    public WebElement likeButton;
    @FindBy(css = ".coreSpriteRightPaginationArrow")
    public WebElement rightArrow;    
    
    /**
     * Проверяем, что страница поста отрылась
     *
     * @return boolean
     */
    public boolean postHeaderIsPresent() {
        return waitForElementPresent(postHeader);
    }
    
    /**
     * Проверяем, что сердечко отображается
     *
     * @return boolean
     */
    public boolean likeButtonIsPresent() {
        return waitForElementPresent(likeButton);
    }
    
    /**
     * Нажимаем Сердечко с заданным периодом
     * 
     * @param timeout
     */
    public void clicklikeButton(int timeout) {
        likeButton.click();
        waitTimeout(timeout);
    }
    
    /**
     * Нажимаем Далее
     */
    public void clickRightArrowButton() {
        rightArrow.click();
    }
}
