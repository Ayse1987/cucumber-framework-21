@scenario_outline_1 @smoke
Feature: Multiple_google_search
  Background: use is navigate to google page
    Given user in on the google page
  Scenario Outline: searching_word_capitals
    Given user search for "<world_capitol>"
    Then verify the result has "<world_capitol>"
    Then close the application
    Examples: capitals
      |world_capitol|
      |paris        |
      |london       |
      |berlin       |
      |ankara       |
      |baku         |
