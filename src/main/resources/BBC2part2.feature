Feature: BBC1 part 1
  As a user
  I want to check some sport scores related functionality of the BBC site
  So I can be sure that this functionality works correctly

  Scenario Outline: Check football scores and teams on the Match overview page
    Given A web browser is at BBC homepage
    And User navigates to Football Scores & Fixtures
    When User made a search by '<Championship name>'
    And User select a '<Month>'
    Then There is a match between '<Team1>' and '<Team2>' with '<Team1 score>' - '<Team2 score>' on the Scores & Fixtures page
    And User clicks on 'Home team' name
    And There is a match between '<Team1>' and '<Team2>' with '<Team1 score>' - '<Team2 score>' on the Match Overview page

    Examples:
      | Championship name  | Month   | Team1     | Team1 score | Team2 score | Team2    |
      | Championship       | 2022-02 | Blackpool | 4           | 1           | Reading  |
      | Swiss Super League | 2021-10 | Lugano    | 2           | 1           | Servette |

  Scenario Outline: ScoreBoard class saves the match score of given opponents
    Given A web browser is at BBC homepage
    And User navigates to Football Scores & Fixtures
    When User made a search by '<Championship name>'
    And User select a '<Month>'
    And The score of the match between '<Team1>' and '<Team2>' is '<Team1 score>' - '<Team2 score>'

    Examples:
      | Championship name  | Month   | Team1     | Team1 score | Team2 score | Team2    |
      | Championship       | 2022-02 | Blackpool | 4           | 1           | Reading  |
      | Swiss Super League | 2021-10 | Lugano    | 2           | 1           | Servette |
