package ToolsQA.Categories.CategoryExtentions.OfElements;

import ToolsQA.Categories.TestOfElements;
import io.cucumber.java.sl.In;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class WebTablesTest extends TestOfElements {
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    public WebElement addButton;

    public WebTablesTest(WebDriver driver) {
        super(driver);
    }





    public static class RegistrationForm extends WebTablesTest{
        @FindBy(xpath = "//div//form[@id='userForm']")
        WebElement registrationForm;
        @FindBy(xpath = "//form//div[contains(@class,'mt-2')]")
        List<WebElement> formFields;
        @FindBy(xpath = "//button[@id='submit']")
        WebElement submitButton;

        public RegistrationForm(WebDriver driver) {
            super(driver);
        }

        public void full_fill_form(WebDriverWait wait){
            wait.until(ExpectedConditions.visibilityOfAllElements(formFields));
            RandomString randomString = new RandomString(8);
            Random random = new Random();
            WebElement input, label;
            for (WebElement element:
                 formFields) {

                label = element.findElement(By.tagName("label"));
                input = element.findElement(By.tagName("input"));

                if (label.getText().contains("Email")){
                    input.sendKeys(randomString.nextString()+"@example.com");

                }
                else if (label.getText().contains("Age") || label.getText().contains("Salary")) {
                    Integer n = random.nextInt(30);
                    input.sendKeys(n.toString());
                } else input.sendKeys(randomString.nextString());
            }
            submitButton.click();
        }


    }
}
