package timestamp.instagram;

import timestamp.instagram.pages.LoginPage;
import timestamp.instagram.pages.FeedPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Добавляет лайки на все новости на которые подписан
 * @author timestamp
 */
public class AddLikeByFollows_Test extends BaseTestClass {

    @Test
    public void add_like_follows() {

        LoginPage loginPage = new LoginPage(driver);

        // Авторизуемся
        loginPage.open();
        Assert.assertTrue("Страница авторизации не отображается",
                loginPage.loginPageIsPresent());
        loginPage.setLogin("login");
        loginPage.setPassword("password");
        loginPage.clickLogin();

        // Проверяем, что новости отображаются
        FeedPage feedPage = new FeedPage(driver);

        Assert.assertTrue("Страница списка новостей не отображается",
                feedPage.feedPageIsPresent());
        
        // Ставим лайки
        feedPage.clickLikeAllFeed();
    }
}
