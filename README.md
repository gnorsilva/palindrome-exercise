Palindrome exercise for LJC's Feb 2012 code share session:

http://www.meetup.com/Londonjavacommunity/events/48795462/

We are not using a DI framework. We use JBehave and Junit for our tests. We also have a class called StartPalindromaton that initialises the application. This class creates all the classes and inject them into each other. 

The JBehave stories are here:
https://github.com/sandromancuso/palindrome-exercise/tree/master/src/test/resources/com/gnorsilva/palindrome/acceptancetests/stories

To run all the tests you can:
Command line: mvn test
Eclipse: Right click on the project and select Run As >> JUnit Test