# TAforUI final project

Test automation framework for UI.   
This project embodies the knowledge I gained during my studies at AQA winter program 2022 in the EPAM company.

## Stack

All the work was done in a IntelliJ IDEA IDE. Programming language - Java.  
Tools that have been used for writing and running automation tests: 
- Selenium WebDriver
- Cucumber for Java
- Gherkin
- JUnit

All together gathered up by Maven.

## Project structure

- [Page Objects](src/main/java/pageobjects) - supplying UI elements locators for Action classes.   
- [Action classes](src/main/java/actionclasses) (Business Logic Layer classes) implement logical actions.  
Action classes methods call PO's methods to gain locators and are called by Step Definition classes.  
Separate classes for the complex elements [Form.java](src/main/java/complexelements/ScoreBoard.java) and 
[ScoreBoard.java](src/main/java/complexelements/ScoreBoard.java) have been created according to the task's conditions.
- [Step Definitions](src/test/java/stepdefinitions) divided into several classes according to their purpose.
- [Feature files](src/main/resources) scenarios, written with Gherkin syntax.
- [Shared Context](src/main/java/sharedcontext) set of classes used to share the data between the steps.
