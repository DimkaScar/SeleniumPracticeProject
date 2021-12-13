package ToolsQA.Categories.CategoryExtentions.OfElements;

import ToolsQA.Categories.TestOfElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.Locale;

public class ButtonsTest extends TestOfElements {
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;
    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;
    @FindBy(id = "mjdMl")
    WebElement simpleClick;

    @FindBy(xpath = "//div[contains(@class,'col-md-6')]//div//div//button/parent::div")
    List<WebElement> buttons;
    @FindBy(xpath = "//div[contains(@class,'col-md-6')]//p")
    List<WebElement> result ;

    public ButtonsTest(WebDriver driver) {
        super(driver);
    }

    public void buttons_test(WebDriverWait wait){
        for (int i = 0; buttons.size() > i; i++){
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-md-6')]//div//div//button")));
            if (buttons.get(i).findElement(By.id("doubleClickBtn")).isDisplayed())
                action.doubleClick(doubleClickBtn).build().perform();
            else if(buttons.get(i).findElement(By.id("rightClickBtn")).isDisplayed())
                action.contextClick(rightClickBtn).build().perform();
            else if (buttons.get(i).findElement(By.id("mjdMl")).isDisplayed())
                simpleClick.click();
            else{
                System.out.println("No such button");
                break;
            }
            wait.until(ExpectedConditions.visibilityOfAllElements(result));
            String r = result.get(i).getText();
            String g = buttons.get(i).getText().toLowerCase(Locale.ROOT).replace(" me", "");
            Assert.assertTrue(r.contains(g));
            System.out.println(result.get(i).getText());

        }
    }


}
git status