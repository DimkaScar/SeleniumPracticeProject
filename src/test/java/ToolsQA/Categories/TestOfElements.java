package ToolsQA.Categories;

import ToolsQA.ToolsQAStepsDef;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TestOfElements {
    public WebDriver driver;
    @FindBy(className = "element-group")
    public List<WebElement> elementsGroup;

    public TestOfElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public WebElement single_group(String category){
        String chosenC = "";
        WebElement singleGroup;
        int i=0;
        do {
            singleGroup = elementsGroup.get(i);
            WebElement groupTitle = singleGroup.findElement(By.className("header-text"));
            chosenC = groupTitle.getText();
        }while (!chosenC.equals(category) && i++ < elementsGroup.size());
        return singleGroup;
    }
    public void select_text_box(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-0\"]")).click();
    }
    public void select_check_box(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-1\"]")).click();
    }
    public void select_radio_button(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-2\"]")).click();
    }
    public void select_web_tables(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-3\"]")).click();
    }
    public void select_buttons(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-4\"]")).click();
    }
    public void select_links(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-5\"]")).click();
    }
    public void select_broken_links_images(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-6\"]")).click();
    }
    public void select_up_download(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-7\"]")).click();
    }
    public void select_dynamic_properties(WebElement singleGroup){
        singleGroup.findElement(By.xpath("//*[@id=\"item-8\"]")).click();
    }



}
