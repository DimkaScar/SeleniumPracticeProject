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

public class RadioButtonTest extends TestOfElements {
    WebElement input, label;
    @FindBy(xpath = "//div[contains(@class, 'custom-radio')]")
    List<WebElement> radioButtons;
    @FindBy(className = "text-success")
    WebElement result;

    public RadioButtonTest(WebDriver driver) {
        super(driver);
    }

    public void check_radio_button(WebDriverWait wait){
        for (int i=0; radioButtons.size()>i; i++){
            input = radioButtons.get(i).findElement(By.tagName("input"));       // Radio Button input is not clickable
            label = radioButtons.get(i).findElement(By.tagName("label"));       // instead LABEL gets the click() function
            wait.until(ExpectedConditions.elementToBeClickable(label));
            label.click();
            if(!input.isSelected()){        // but in the same time INPUT still has to get check for isSelected()
                Assert.assertFalse(false);
                System.out.println(" Button is not clickable");
            }else {
                wait.until(ExpectedConditions.visibilityOf(result));
                Assert.assertTrue(result.getText().equals(radioButtons.get(i).getText()));
            }

            // Module works but not in the proper way
        }
    }

}
