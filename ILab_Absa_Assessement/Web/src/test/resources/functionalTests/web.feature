Feature:Add users on the user list on Web application
  Description : Add users on the user list on Web application


  Scenario: Add and verify if the users are added
    Given Navigate to web page"<https://www.way2automation.com/angularjs-protractor/webtables/>"
    When  Validate that you are on the User List Table
    Then  Click Add user
    And   Add users with the details "<FirstName>" "<LastName>" "<Username>" "<Password>" "<Customer>" "<Role>" "<Email>" "<Email>"

    Example:
      TestCase1 | FirstName | LastName | Username | Password | Customer | Role | Email | Email
      |No1  | FName1 |  |LName1 | User1| Pass1 | CompanyAAA | Admin1 | admin@gmail.com |  |0733344444
      |No2  | FName2 |  |LName2 | User2| Pass2 | CompanyAAA | Admin1 | admin@gmail.com |  |0733344444