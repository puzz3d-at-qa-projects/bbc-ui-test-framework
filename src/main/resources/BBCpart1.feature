@News_titles
Feature: BBC1 part 1
  As a user
  I want to check some news related functionality of the BBC site
  So I can be sure that this functionality works correctly

  Scenario: the News page displays the headline article
    Given a web browser is at BBC homepage
    When the user navigates to the News page
    Then the Headline article title is
      | Anguish for thousands trapped in Mariupol as evacuation stalls |

  Scenario: The News page displays the promo articles
    Given a web browser is at BBC homepage
    When the user navigates to the News page
    Then the titles of the promo articles are
      | Ukraine round-up: Civilians trapped as fighter gives 'last address' |
      | Mariupol fighters' relatives tell of bitter pride                   |
      | In maps: Russia builds up troops in new offensive                   |
      | Why Russia wants to seize Ukraine's eastern Donbas                  |
      | Ukraine round-up: Allies pledge weapons as Russia targets east      |

  Scenario: The search by the news category name displays the given article
    Given a web browser is at BBC homepage
    And the user navigates to the News page
    And the user memorize the Category of the headline article
    When the user enters this Category into the search bar
    Then the name of the first article in the search results is
      | Europe: Strangers on My Doorstep |