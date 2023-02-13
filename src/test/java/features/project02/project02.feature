Feature: Test consult the via CEP API - Scenario Outline

  @viaCep
  Scenario Outline: Test Get viaCEP 2
    Given an address code <cep>
    When User calls "viaCEP1" with "GET" http request
    Then Status code is 200
    And Validate the schema "viaCEP"
    Examples:
      | cep        |
      | "12248310" |
      | "12248330" |
      | "12248320" |