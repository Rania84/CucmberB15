Feature: Searching the employee
  Background:
    When  user enters valid email and valid password
    And  click on login button
    When user clicks on PIM option

  #@empSearch
  @smoke1
  Scenario: Search Employee by Id
    # Given open the browser and launch HRMS application
    # When  user enters valid email and valid password
   # And  click on login button
    When user clicks on PIM option
    When user enters valid employee id
    And  Clicks on search button
    And  user see employee information is displayed
   # And  close the browser

    #@empSearchJobTittle
  @smoke1
  Scenario: Search Employee by Job Title
  #  Given open the browser and launch HRMS application
  #  When user enters valid email and valid password
  #  And click on login button
    # When user clicks on PIM option
    When user select Job Title
    And Clicks on search button
    And user see employee information is displayed
     # And  close the browser

    # Hooks  :use is Step Definition File for defining pre and post steps in any Cucumber framework
     #HOOKS: For defining pre and post steps in any Cucumber Framework
     #        : This is always created inside StepDefinition folder
     #        : This class cannot be inherited
     #        : is taking care pre and post of condition

    #Background: This is used to define all the common steps that multiple scenarios have in the same feature file
  # till the time the flow is not broken
     #1. Hard Code
   #2. Config file
   #-----------------Cucumber itself provides multiple option through which we can feed data from
   # feature file into Step Definition---------------------------------------------
   #3. Regular Expressions
       # put the data in double quotes [""]
    #4. Scenario Outline
       # Provides you an alternative to Data driven testing
       # Also supports parametrization
  #===================================PARAMETERIZATION================================
  # Executing the same test case with multiple data

     #If you want to use parameterization
     #If you wish to implement data driven testing
     # Scenario Outline is always used along with the keyword 'Examples'
