Feature:Perform an API request to produce a list of all dog breeds
  Description : The purpose of this API test is to perform an API request to produce a list of all dog breeds


  Scenario: Get the list of all dog breeds
    Given get the list of all dog breeds
    When  verify the "<Breed>" on list of the breed
    And   produce a list of sub-breeds for parameter2
    Then   produce a random image link for the sub-breed "<golden>"

    Examples:
      | Breed | golden |
      | Breed | golden |
      | retriever | golden    |