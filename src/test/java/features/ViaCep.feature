Feature: Test consult the via CEP API

  @viaCep
  Scenario: Test Get viaCEP 2
    Given User calls "viaCEP2" with "GET" http request
    Then Status code is 200
    And Validate the schema "viaCEP"