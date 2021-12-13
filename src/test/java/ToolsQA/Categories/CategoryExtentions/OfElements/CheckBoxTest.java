package ToolsQA.Categories.CategoryExtentions.OfElements;

import ToolsQA.Categories.TestOfElements;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class CheckBoxTest extends TestOfElements {
    @FindBy(className = "rct-text")
    public List<WebElement> checkTree;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/div/button[1]")
    public WebElement expandAll;

    public CheckBoxTest(WebDriver driver) {
        super(driver);
    }

    public Boolean checked_or_unchecked(WebElement element){
        if (element.findElement(By.tagName("svg")).getAttribute("class").contains("uncheck"))
            return true;
        else return false;
    }
    public String result(){
        return driver.findElement(By.id("result")).getText().toLowerCase(Locale.ROOT);
    }
    public String spanTitle(WebElement element){
        return element.findElement(By.className("rct-title")).getText().toLowerCase(Locale.ROOT).replace(" ", "");
    }

    public void check_test(WebDriverWait wait){
        for (int i=0; checkTree.size()>i; i++) {
            WebElement span = checkTree.get(i).findElement(By.className("rct-checkbox"));
            if(checked_or_unchecked(span)){
                checkTree.get(i).findElement(By.className("rct-checkbox")).click();
            }
            else {
                checkTree.get(i).findElement(By.className("rct-checkbox")).click();
                wait.until(ExpectedConditions.elementToBeClickable(checkTree.get(i)));
                checkTree.get(i).findElement(By.className("rct-checkbox")).click();
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
            Assert.assertTrue(result().contains(spanTitle(checkTree.get(i)).replace(".doc", "")));
        }
    }



}
