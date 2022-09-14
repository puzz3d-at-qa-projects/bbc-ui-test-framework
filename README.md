# BBC UI test automation framework

Complex framework for BBC UI testing, that implements PO pattern, BDD, a layer of "action" classes, and model classes for complex objects.

## Stack

Tools that have been used for writing and running automation tests: 
- Java 17.
- Selenium WebDriver.
- Cucumber for Java.
- Gherkin.
- JUnit.
- Maven.

## Project structure

- [Page Objects](src/main/java/pageobjects) - supplying UI elements locators for Action classes.   
- [Action classes](src/main/java/actionclasses) (Business Logic Layer classes) implement logical actions.  
Action classes methods call PO's methods to gain locators and are called by Step Definition classes.  
Separate classes for the complex elements [Form.java](src/main/java/complexelements/ScoreBoard.java) and 
[ScoreBoard.java](src/main/java/complexelements/ScoreBoard.java) have been created according to the task's conditions.
- [Step Definitions](src/test/java/stepdefinitions) divided into several classes according to their purpose.
- [Feature files](src/main/resources) scenarios, written with Gherkin syntax.
- [Shared Context](src/main/java/sharedcontext) set of classes used to share the data between the steps.

## Task

1. Add a test that:
    - Goes to BBC
    - Clicks on News
    - Checks the name of the headline article (the one with the biggest picture and text) against a value specified in your test (hard-coded)

2. Add another test:
    - Goes to BBC
    - Clicks on News
    - Checks secondary article titles (the ones to the right and below the headline article) against a List<String> specified in your test (hard-coded).
      Imagine that you are testing the BBC site on a test environment, and you know what the titles will be. Your test, then, checks that these titles are in fact present on the page.
      The test should pass if all the titles are found, and fail if they are not found. It's normal that your test will fail the next day - this would not happen if we had a Test environment for BBC, with a static database.

3. Write a test that:
    - Goes to BBC
    - Clicks on News
    - Stores the text of the Category link of the headline article (e.g. World, Europe...)
    - Enter this text in the Search bar
    - Check the name of the first article against a specified value (hard-coded)

4.	Add a test which verifies that user can submit a question to BBC:
      - Find a form (several text boxes and possibly check boxes, with some sort of Send/Submit button) that allows you to send a question to BBC. Note that this form sometimes moves around the BBC site - ask in chat if you cannot find it.
      Below steps work as of 16.09.2020:
    - From BBC Home page go to News;
    - Click on "Coronavirus" tab, and then on "Your Coronavirus Stories" tab;
    - Go to “Coronavirus: Send us your questions”;
    - Scroll down to find the form.
      - Fill the form with information, but one of the required fields empty or with invalid data;
      - Click Send/Submit;
      - Verify that the submission did not work, either by checking for correct error message, or, failing that, that the form still contains entered data.
5.	Add at least 2 more tests (use copy-paste). They should do the same as the one we just wrote, except they will cover different *negative* test cases.
      Add one case for each required field/checkbox that leaves it empty. If Email is required - add a case where it is invalid.

### Implement the Page Object (PO) pattern.

Add a class representing a complex element
For BBC1 task, there is a form involved: a set of controls that you use to input information and then press Submit (or similar button) to send the information to the server.
For BBC2, you need to create a Scoreboard class.

### Add Business Logic layer
1.	You will probably need just one Business Logic Layer (BLL) class;
2.	Create methods that implements logical actions that a user can do with your part of functionality, for example: “submit a question to BBC”;
3.	Move logic into these methods until your tests call *only* BLL methods, while BLL class calls creates PO instances and *only* calls PO methods;
4.	Make sure POs never call or use other POs (with some exceptions, such as returning another PO’s instance in a method that switches to that page).

### Implement BDD approach.