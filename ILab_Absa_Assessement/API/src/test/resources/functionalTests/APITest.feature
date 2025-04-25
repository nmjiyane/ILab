Feature: Get Dog Details
  Scenario: Retrieve list of breed dogs
    Given produce a list of all dog breeds
    When  verify "retriever" breed is within the list
    Then request to produce a list of sub-breeds for "retriever"
    And produce a random image or link for the sub-breed "golden"