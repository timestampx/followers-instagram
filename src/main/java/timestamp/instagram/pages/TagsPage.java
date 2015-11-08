package timestamp.instagram.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Страница новостей по тегу
 * 
 * @author timestamp
 */
public class TagsPage extends MainPage {

    public TagsPage(WebDriver driver) {
        super(driver);
    }
    
    String postInfo = ".//*[@class='-cx-PRIVATE-PostsGrid__row'][1]/a[%d]";
    
    @FindBy(css = "-cx-PRIVATE-TagPage__tagName")
    public WebElement tagNameElement;    
    
    /**
     * Проверяем, что страница новостей по тегу отрылась
     *
     * @return boolean
     */
    public boolean tagsPageIsPresent() {
        return waitForElementPresent(tagNameElement);
    }
    
    /**
     * Открываем пост по индексу
     *
     * @param index
     */
    public void clickPostByIndex(int index) {
        String locator = String.format(postInfo, index);
        element(locator).click();
    }
}
