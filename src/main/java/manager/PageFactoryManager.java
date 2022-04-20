package manager;

import org.openqa.selenium.WebDriver;
import pageobjects.*;
import pageobjects.forms.QuestionForm;
import pageobjects.menus.NewsNavigationBar;
import pageobjects.menus.SportNavigationBar;
import pageobjects.menus.TopMenuBar;

public class PageFactoryManager {

    WebDriver driver;
    TopMenuBar topMenuBar;
    NewsPage newsPage;
    SearchPage searchPage;
    NewsNavigationBar newsNavigationBar;
    QuestionForm questionForm;
    SportNavigationBar sportNavigationBar;
    ScoresAndFixturesPage scoresAndFixturesPage;
    MatchOverviewPage matchOverviewPage;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public TopMenuBar getTopMenuBar() {
        return (topMenuBar == null) ? new TopMenuBar(driver) : topMenuBar;
    }

    public NewsPage getNewsPage() {
        return (newsPage == null) ? new NewsPage(driver) : newsPage;
    }

    public SearchPage getSearchPage() {
        return (searchPage == null) ? new SearchPage(driver) : searchPage;
    }

    public NewsNavigationBar getNewsNavigationBar() {
        return (newsNavigationBar == null) ? new NewsNavigationBar(driver) : newsNavigationBar;
    }

    public QuestionForm getQuestionForm() {
        return (questionForm == null) ? new QuestionForm(driver) : questionForm;
    }

    public SportNavigationBar getSportNavigationBar() {
        return (sportNavigationBar == null) ? new SportNavigationBar(driver) : sportNavigationBar;
    }

    public ScoresAndFixturesPage getScoresAndFixturesPage() {
        return (scoresAndFixturesPage == null) ? new ScoresAndFixturesPage(driver) : scoresAndFixturesPage;
    }

    public MatchOverviewPage getMatchOverviewPage() {
        return (matchOverviewPage == null) ? new MatchOverviewPage(driver) : matchOverviewPage;
    }

}
