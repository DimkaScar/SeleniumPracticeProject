package ToolsQA.Categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MainPageToolQA {
    WebDriver driver;
    String url = "https://demoqa.com/";

    @FindBy(css = "div.card.top-card")
    public List<WebElement> categoriesOfTests;

    public MainPageToolQA(WebDriver driver){
        this.driver = driver;
        this.driver.get(url);
        PageFactory.initElements(this.driver, this);
    }
    public void chooseCategory(String category){
        String chosenC = "";
        WebElement singleCategory;
        int i=0;
        do {
            singleCategory = categoriesOfTests.get(i);
            WebElement categoryTitle = singleCategory.findElement(By.tagName("h5"));
            chosenC = categoryTitle.getText();
        }while (!chosenC.equals(category) && i++ < categoriesOfTests.size());
        singleCategory.click();
    }


}
