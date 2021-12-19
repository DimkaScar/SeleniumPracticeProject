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
    /*@FindBy(xpath = "//button[text()='Double Click Me']")
    WebElement doubleClickBtn;
    @FindBy(xpath = "//button[text()='Right Click Me']")
    WebElement rightClickBtn;
    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement simpleClick;*/

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
            WebElement curBut = buttons.get(i).findElement(By.tagName("button"));
            wait.until(ExpectedConditions.elementToBeClickable(curBut));
            if (curBut.getText().contains("Double Click"))
                action.doubleClick(curBut).build().perform();
            else if(curBut.getText().contains("Right Click"))
                action.contextClick(curBut).build().perform();
            else if (curBut.getText().contains("Click"))
                curBut.click();
            else{
                System.out.println("No such button");
                break;
            }
            wait.until(ExpectedConditions.visibilityOfAllElements(result));
            String r = result.get(i).getText();
            String g = curBut.getText().toLowerCase(Locale.ROOT).replace(" me", "");
            Assert.assertTrue(r.contains(g));
            System.out.println(result.get(i).getText());

        }


    }


}
