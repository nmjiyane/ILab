package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Person {

    WebElement driver;

    Table table;

    public Person(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.NAME, using = "firstname")
    private String fname;

    @FindBy(how = How.NAME, using = "lastname")
    public String lname;
    @FindBy(how = How.NAME, using = "username")
    public String username;
    @FindBy(how = How.NAME, using = "password")
    public String password;
    @FindBy(how = How.NAME, using = "customer")
    public String customer;
    @FindBy(how = How.NAME, using = "role")
    public String role;
    @FindBy(how = How.NAME, using = "email")
    public String email;
    @FindBy(how = How.NAME, using = "cell")
    public String cell;

    public Person() {
    }

    public Person(String fname, String lname, String username, String password, String customer, String role, String email, String cell) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.customer = customer;
        this.role = role;
        this.email = email;
        this.cell = cell;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCustomer() {
        return customer;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getCell() {
        return cell;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public void enterDetails(String fname, String lname, String username, String password, String customer, String role, String email, String cellNo, String scenarioNo)
    {
        driver.findElement(By.name(getFname())).sendKeys(fname);
        driver.findElement(By.name(getLname())).sendKeys(lname);

        //Ensure that User Name (*) is unique on each run
        if( checkCharacterorUsername(username) == true)
        {
            driver.findElement(By.name(getUsername())).sendKeys(username);
        }
        else {
            System.out.println("Unwanted Character");
        }
        driver.findElement(By.name(getPassword())).sendKeys(password);
        driver.findElement(By.name(getCustomer())).sendKeys(customer);
        driver.findElement(By.name(getRole())).sendKeys(role);
        driver.findElement(By.name(getEmail())).sendKeys(email);
        driver.findElement(By.name(getCell())).sendKeys(cellNo);


        //Ensure that your users are added to the list
        if(scenarioNo.equals("No1"))
        {
            String fname1 = String.valueOf(driver.findElement(By.className(table.getTableName())).getText().equals(fname));
            setFname(fname1);
        }else if(scenarioNo.equals("No2"))
        {
            String fname2 = String.valueOf(driver.findElement(By.className(table.getTableName())).getText().equals(fname));
            setFname(fname2);
        }
        else
        {
            System.out.println("Sorry users are NOT added to the list");
        }
    }
    public boolean checkCharacterorUsername(String username)
    {
        String str = username;
        boolean checkChar = false;
        char targetChar = '*';

        int index = str.indexOf(targetChar);

        if (index != -1) {
            // Character found
            System.out.println("Character '" + targetChar + "' found at index: " + index);

            checkChar = true;
        } else {
            // Character not found
            System.out.println("Character '" + targetChar + "' not found.");
        }
        return checkChar;
    }

}

