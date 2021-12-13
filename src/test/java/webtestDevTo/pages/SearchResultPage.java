package webtestDevTo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;

    @FindBy(className = "crayons-story__body")
    public List<WebElement> allPosts;
    @FindBy(css = "h3.crayons-story__title")
    public List<WebElement> postTitles;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
