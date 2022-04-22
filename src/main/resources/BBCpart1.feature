Feature: BBC1 part 1
  As a user
  I want to check some functionality of the BBC site
  So I can be sure that this functionality works correctly

  Scenario: Checks the name of the News headline article
    Given A web browser is at BBC homepage
    When User navigates to News page
    Then Headline article title is
      | Anguish for thousands trapped in Mariupol as evacuation stalls |

  Scenario: Checks the names of the News promo articles
    Given A web browser is at BBC homepage
    When User navigates to News page
    Then Titles of the promo articles are

      | Ukraine round-up: Civilians trapped as fighter gives 'last address' |
      | Mariupol fighters' relatives tell of bitter pride                   |
      | In maps: Russia builds up troops in new offensive                   |
      | Why Russia wants to seize Ukraine's eastern Donbas                  |
      | Ukraine round-up: Allies pledge weapons as Russia targets east      |

  Scenario: Check the name of the first article in search results
    Given A web browser is at BBC homepage
    And User navigates to News page
    And User memorize the Category of the headline article
    When User made a search by this word
    Then The name of the first article in search results is
      | Europe: Strangers on My Doorstep |