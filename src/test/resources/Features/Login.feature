Feature: Loin Functionalities


  @smoke
  Scenario: Valid Admin login
    # Given open the browser and launch HRMS application ((I have replaced with hooks))
    When  user enters valid email and valid password
    And  click on login button
    Then user is logged in successfully
    # And close the browser((I have replaced with hooks))

  @smoke2
  Scenario: Valid Admin login
    # Given open the browser and launch HRMS application ((I have replaced with hooks))
    When  user enters valid "ADMIN" and valid "Hum@nhrm123"
    And  click on login button
    Then user is logged in successfully
    # And close the browser((I have replaced with hooks))

     @scenarioOutline
  # Parameteriztion / Data Driven
  Scenario Outline: Login with multiple credentials using Scenario outline
 # Given open the browser and launch HRMS application ((I have replaced with hooks))
    When  user enters valid "<username>" and valid "<password>"
    And  click on login button
    Then user is logged in successfully
    # And close the browser((I have replaced with hooks))

    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |


       @dateTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |






