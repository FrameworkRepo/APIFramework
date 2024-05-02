Feature: Validating Add place API's

  Scenario: Verify addplace API place order successfully
    Given Add place payload
    When User call "AddplaceAPI" with post http request
    Then API call success with statuscode as 200
    And In response body "status" as "OK"
    And In response body "scope" as "APP"