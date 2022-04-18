Feature: BBC1 part 2
  As a user
  I want to check some question form related functionality of the BBC site
  So I can be sure that this functionality works correctly

  @NegativeTests
  Scenario: Check handling invalid question form submission
    Given A web browser is at BBC homepage
    And User finds a form named 'Your questions answered: What questions do you have?'
    When User trying to submit the form with incorrect entered data
      | questions | Name     | Email | number | Location    | Age |
      | [blank]   | someName | a@b.c | 322223 | planetEarth | 4,5 |

    Then Error message " can't be blank" displayed

    And User trying to submit the form with incorrect entered data
      | questions    | Name    | Email | number | Location    | Age |
      | someQuestion | [blank] | a@b.c | 322223 | planetEarth | 4,5 |

    And Error message "Name can't be blank" displayed

    And User trying to submit the form with incorrect entered data
      | questions    | Name     | Email   | number | Location    | Age |
      | someQuestion | someName | [blank] | 322223 | planetEarth | 4,5 |

    And Error message "Email address can't be blank" displayed

#      | questions    | Name     | Email   | number | Location    | Age | //there is not even basic email validation
#      | someQuestion | someName | a       | 322223 | planetEarth | 4,5 | //so the form would be successfully sent with an "a" email, for example
