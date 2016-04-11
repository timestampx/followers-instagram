package timestamp.instagram;

import timestamp.instagram.pages.LoginPage;
import timestamp.instagram.pages.FeedPage;
import org.junit.Assert;
import org.junit.Test;
import timestamp.instagram.pages.*;

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

        loginPage.setLogin(Config.getLogin());
        loginPage.setPassword(Config.getPassword());
        loginPage.clickLogin();

        // Проверяем, что новости отображаются
        FeedPage feedPage = new FeedPage(driver);

        Assert.assertTrue("Страница списка новостей не отображается",
                feedPage.feedPageIsPresent());

        // Ставим лайки
        for (int i = 1; i <= 12; i++) {
            Assert.assertTrue("Сердечко у новости не отображается",
                    feedPage.likeButtonByIndexFeedIsPresent(i));
            feedPage.clickLikeByIndexFeed(i);
        }

        feedPage.waitTimeout(5000);
        int timeout = (int) (Math.random() * 5000 + 36000);
        for (int i = 13; i <= 96; i++) {
            Assert.assertTrue("Сердечко у новости не отображается",
                    feedPage.likeButtonByIndexFeedIsPresent(i));
            feedPage.clickLikeByIndexFeed(i);
            feedPage.waitTimeout(timeout);
        }
    }
}
