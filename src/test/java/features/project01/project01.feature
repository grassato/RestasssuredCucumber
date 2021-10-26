Feature: Test consult the via CEP API - project01


  @viaCep @project01
  Scenario: Test Get viaCEP - project01
    Given User calls "viaCEP" with GET http request
    Then Status code is 200
    And Validate the schema "viaCEP"

  @viaCep
  Scenario: Test Get viaCEP 1
    Given User calls "viaCEP2" with GET http request
    Then Status code is 200
    And Validate the schema "viaCEP1"

  @viaCep
  Scenario: Test Get viaCEP 2
    Given User calls "viaCEP2" with GET http request
    Then Status code is 200
    And Validate the schema "viaCEP2"