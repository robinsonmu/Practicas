# Challenge

## Implement a clock that handles times without dates

Apply Object Oriented principles to build the solution.

#### Note
Before beginning, clone this repo in your machine and create a new development branch from it with the following name:
   
   `REPLACE_WITH_LION_LOGIN_LOWERCASE-oop-challenge`
   
   For example, a valid branch name would it be:
   
   `carmosqu-oop-challenge`


#### Project Overview:
* Implement a clock that handles times without dates.
* Constructor shoul be able to receive hours and minutes, these are used to initialize the clock.
* You should be able to add and subtract minutes to it.
* Two clocks that represent the same time should be equal to each other.

#### Tips
In order to satisfy the requirement that two clocks are considered equal just when they are set to the same time, you will need to override the equals and hashcode methods in your Clock class.
For more information on how to override these methods, see this [JavaWorld article](https://www.javaworld.com/article/2072762/object-equality.html)

#### Test
In order to make sure your solution is working correctly you can use the following Test Suites:
* ClockAddTest.java
* ClockCreationTest.java
* ClockEqualTest.java