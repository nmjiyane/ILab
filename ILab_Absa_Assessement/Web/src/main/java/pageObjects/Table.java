package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Table {

    WebDriver driver;
    public Table() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CLASS_NAME, using ="smart-table table table-striped")
    private  String tableName;

    @FindBy(how =  How.CLASS_NAME, using = "#billing_first_name")
    private  String button;
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getButton() {
        return button;
    }
    public Boolean checkTableIsDisplayed() {

        boolean check = true;
        driver.findElement(By.className(getTableName())).isDisplayed();


        try { Thread.sleep(3000);
        }
        catch (InterruptedException e) {}

        return  check;
    }
    public void clickButton() {

        driver.findElement(By.className(getButton())).click();

        try { Thread.sleep(3000);
        }
        catch (InterruptedException e) {}

    }
}
