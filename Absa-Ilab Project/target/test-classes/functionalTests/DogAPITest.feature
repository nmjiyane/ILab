Feature: Perform an API request to produce a list of all dog breeds
  Description : The purpose of this API test is to perform an API request to produce a list of all dog breeds


  Scenarios : Get the list of all dog breeds
    Given get the list of all dog breeds
    When  verify the <parameter1> on list of the breed
    Then  produce a list of sub-breeds for parameter2
    And   produce a random image link for the sub-breed "<parameter2>"

    Examples:
      | parameter1  | parameter2  |
      | retriever   | retriever   |
