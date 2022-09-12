@Sport_scores
Feature: BBC2 part 2
  As a user
  I want to check some sport scores related functionality of the BBC site
  So I can be sure that this functionality works correctly

  Scenario Outline: Check football scores and teams on the Match overview page
    Given a web browser is at BBC homepage
    And the user navigates to Football Scores & Fixtures
    When the user made a search by '<Championship name>'
    And the user select a '<Month>'
    Then there is a match between '<Team1>' and '<Team2>' with '<Score1>' - '<Score2>' on the Scores & Fixtures page
    And the user clicks on 'Home team'
    And there is a match between '<Team1>' and '<Team2>' with '<Score1>' - '<Score2>' on the Match Overview page

    Examples:
      | Championship name     | Month   | Team1        | Score1 | Score2 | Team2       |
      | Premier League        | 2022-03 | Arsenal      | 0      | 2      | Liverpool   |
      | Championship          | 2022-02 | Blackpool    | 4      | 1      | Reading     |
      | Swiss Super League    | 2021-10 | Lugano       | 2      | 1      | Servette    |
      | Scottish Championship | 2022-01 | Raith Rovers | 0      | 0      | Dunfermline |
      | Spanish La Liga       | 2021-12 | Sevilla      | 1      | 1      | Barcelona   |

  Scenario Outline: ScoreBoard class saves the match score of given opponents
    Given a web browser is at BBC homepage
    And the user navigates to Football Scores & Fixtures
    When the user made a search by '<Championship name>'
    And the user select a '<Month>'
    And the score of the match between '<Team1>' and '<Team2>' is '<Team1 score>' - '<Team2 score>'

    Examples:
      | Championship name  | Month   | Team1     | Team1 score | Team2 score | Team2     |
      | Premier League     | 2022-03 | Arsenal   | 0           | 2           | Liverpool |
      | Championship       | 2022-02 | Blackpool | 4           | 1           | Reading   |
#      | Swiss Super League | 2021-10 | Lugano    | 2           | 1           | Servette  |
