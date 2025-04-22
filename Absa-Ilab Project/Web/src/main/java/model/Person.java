package model;

public class Person {

   final String URL= "https://www.way2automation.com/angularjs-protractor/webtables/";
    private String fname;
    public String lname;
    public String username;
    public String password;
    public String customer;
    public String role;
    public String email;
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

    public String getURL() {
        return URL;
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
}
