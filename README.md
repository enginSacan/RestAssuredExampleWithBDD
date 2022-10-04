# BackBaseAssignment
This repo is created to show subject below:

* Checking article creation and duplicate article


## How It Works

You need to install maven and add chromedriver to the pc's path.

You have to go to the folder that you clone.

Then you can run command below to run the tests:

```
mvn test -Dcucumber.options="--tags @ArticleApi"
```

You can have the result html, json and Junit XML in the target/cucumber-report folder.

OR 

You can download intellij idea with plugins below:
* Gherkin
* Cucumber for Java
* Cucumber+

You can execute feature file in the IDE.

## Structure

I used lombok library for creating model of the data from requests and responses from api. 
I used generic data structure with the properties. 


## Requirement of the test
* User can create/edit/delete an article

