package ToolsQA;

import ToolsQA.Categories.CategoryExtentions.OfElements.*;
import ToolsQA.Categories.MainPageToolQA;
import ToolsQA.Categories.TestOfElements;
import browserUtills.BaseDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ToolsQAStepsDef {
    String category = "Elements";
    WebDriver driver;
    WebDriverWait wait;
    MainPageToolQA mainPageToolQA;
    TestOfElements testOfElements;

    @Before
    public void Setup(){
        driver = BaseDriver.setLocalDriver();
        wait = new WebDriverWait(driver, 10);
        mainPageToolQA = new MainPageToolQA(driver);
        mainPageToolQA.chooseCategory(category);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-header")));
    }
    ///////////////////////////////////////////////////////////////////////////////////
    @Test
    public void FirstTest(){
        String pageTitle = driver.findElement(By.className("main-header")).getText();
        Assert.assertEquals(category, pageTitle);
        driver.close();
    }
/////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void Text_Box_Test(){
        testOfElements = new TestOfElements(driver);
        testOfElements.select_text_box(testOfElements.single_group(category));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userForm")));

        TextBoxTest textBoxTest = new TextBoxTest(driver);
        textBoxTest.put_the_text();
        textBoxTest.submitButt.click();
        textBoxTest.check_text_fields(wait);
        driver.close();
    }

/////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void Check_Box_Test(){
        testOfElements = new TestOfElements(driver);
        testOfElements.select_check_box(testOfElements.single_group(category));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("check-box-tree-wrapper")));

        CheckBoxTest checkBoxTest = new CheckBoxTest(driver);
        checkBoxTest.expandAll.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(checkBoxTest.checkTree));
        checkBoxTest.check_test(wait);
        driver.close();
    }
/////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void Radio_Button_Test(){
        testOfElements = new TestOfElements(driver);
        testOfElements.select_radio_button(testOfElements.single_group(category));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]")));

        RadioButtonTest radioButtonTest = new RadioButtonTest(driver);
        radioButtonTest.check_radio_button(wait);
        driver.close();
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /*@Test
    public void Web_Tables_Test(){
        testOfElements = new TestOfElements(driver);
        testOfElements.select_web_tables(testOfElements.single_group(category));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("web-tables-wrapper")));
        WebTablesTest webTablesTest = new WebTablesTest(driver);
        int i=0;
        while (i<20) {
            webTablesTest.addButton.click();
            WebTablesTest.RegistrationForm form = new WebTablesTest.RegistrationForm(driver);
            form.full_fill_form(wait);
            i++;
        }

      driver.close();
    }*///   Test is not finished
    @Test
    public void Button_Test(){
        testOfElements = new TestOfElements(driver);
        testOfElements.select_buttons(testOfElements.single_group(category));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'col-md-6')]")));

        ButtonsTest buttonsTest = new ButtonsTest(driver);
        buttonsTest.buttons_test(wait);



    }
}


