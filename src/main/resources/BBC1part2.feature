@NegativeTests
Feature: BBC1 part 2
  As a user
  I want to check some question form related functionality of the BBC site
  So I can be sure that this functionality works correctly

  Scenario Outline: Handling invalid question form submission (outline version)
    Given a web browser is at BBC homepage
    And the user finds a form named 'Your questions answered: What questions do you have?'
    When the user trying to submit the form with missing data
      | question       | <question> |
      | Name           | <Name>     |
      | Email          | <Email>    |
      | Contact number | <number>   |
      | Location       | <Location> |
      | Age            | <Age>      |
    Then the error message displayed
      | Error message | <Error msg> |

    Examples:
      | question        | Name     | Email    | number   | Location | Age | Error msg                    |
      | [blank]         | yourself | russian  | warship  | !        | 4,5 | can't be blank               |
      | go              | [blank]  | yourself | russian  | warship  | !   | Name can't be blank          |
      | russian warship | go       | [blank]  | yourself | !        | .   | Email address can't be blank |


  @Looks_messy,but_checks_all_fields_in_a_one_pass
  Scenario: Handling invalid question form submission (one pass version)
    Given a web browser is at BBC homepage
    And the user finds a form named 'Your questions answered: What questions do you have?'
    When the user trying to submit the form with incorrectly entered data
      | question | Name    | Email         | number             | Location   | Age       |
      | [blank]  | а я вам | сейчас покажу | откуда на Беларусь | готовилось | нападение |

    Then the error message "can't be blank" displayed

    And the user trying to submit the form with incorrectly entered data
      | question     | Name    | Email | number | Location   | Age |
      | someQuestion | [blank] | a@b.c | 322223 | relocation | 4,5 |

    And the error message "Name can't be blank" displayed

    And the user trying to submit the form with incorrectly entered data
      | question     | Name     | Email   | number | Location   | Age |
      | someQuestion | someName | [blank] | 322223 | relocation | 4,5 |

    And the error message "Email address can't be blank" displayed

#      | questions    | Name     | Email   | number | Location    | Age | //there is not even basic email validation
#      | someQuestion | someName | a       | 322223 | planetEarth | 4,5 | //so the form would be successfully sent with an "a" email, for example

