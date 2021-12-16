package ToolsQA.Categories.CategoryExtentions.OfElements;

import ToolsQA.Categories.TestOfElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class LinksTest extends TestOfElements {
    @FindBy(css = "div#linkWrapper p:not(#linkResponse)")
    List<WebElement> links;

    @FindBy(css = "p#linkResponse")
    WebElement response;
    public LinksTest(WebDriver driver) {
        super(driver);
    }

    public void linkCheck( WebDriverWait wait){

        for (WebElement link:
                links) {
            WebElement href = link.findElement(By.tagName("a"));
            if (href.getAttribute("target").equals("_blank")){
                String currentURL = null;
                String currentPageHandle = driver.getWindowHandle();
                href.click();

                Set<String> allTabsHandles = driver.getWindowHandles();
                for (String eachHandle:
                     allTabsHandles) {
                    if (eachHandle.equalsIgnoreCase(currentPageHandle)){
                        continue;
                    }
                    else{
                        driver.switchTo().window(eachHandle);
                        currentURL = driver.getCurrentUrl();
                        driver.close();
                        driver.switchTo().window(currentPageHandle);
                    }
                }
                Assert.assertTrue(href.getAttribute("href").equals(currentURL));
            }
            else {
                int code = BrokenLnkImg.getResponseCode(href.getAttribute("href"));
                href.click();
                wait.until(ExpectedConditions.visibilityOf(response));
                Assert.assertTrue(response.getText().contains(Integer.toString(code)));
            }
        }
    }
}
