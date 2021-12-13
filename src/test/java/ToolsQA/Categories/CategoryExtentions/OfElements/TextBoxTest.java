package ToolsQA.Categories.CategoryExtentions.OfElements;

import ToolsQA.Categories.TestOfElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxTest extends TestOfElements {
    @FindBy(id = "userName")
    public WebElement nameField;
    @FindBy(id = "userEmail")
    public WebElement emailField;
    @FindBy(id = "currentAddress")
    public WebElement currAdrField;
    @FindBy(id = "permanentAddress")
    public WebElement permAdrField;
    @FindBy(id = "submit")
    public WebElement submitButt;

    @FindBy(id = "name")
    public WebElement nameOutput;
    @FindBy(id = "email")
    public WebElement emailOutput;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div/p[3]")
    public WebElement currAdrOutput;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[6]/div/p[4]")
    public WebElement permAdrOutput;

    public TextBoxTest(WebDriver driver) {
        super(driver);
    }

    public void put_the_text(){
        nameField.sendKeys("userName");
        emailField.sendKeys("name@example.com");
        currAdrField.sendKeys("currentAddress");
        permAdrField.sendKeys("permanentAddress");
    }
    public void check_text_fields(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
        Assert.assertTrue(nameOutput.getText().contains(nameField.getText()));
        Assert.assertTrue(emailOutput.getText().contains(emailField.getText()));
        Assert.assertTrue(currAdrOutput.getText().contains(currAdrField.getText()));
        Assert.assertTrue(permAdrOutput.getText().contains(permAdrField.getText()));
    }
}
