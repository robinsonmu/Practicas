# HANDS ON - Exception Handling

## Exercise 1: try-catch-finally

The objective in this exercise is to practice basic *try-catch-finally* as well as creating new exceptions.

**First** - Download the [ExceptionHandlingLab](ExceptionHandlingLab) Folder. It is a basic Java project, go through it and read project overview.

#### Note
Before beginning, clone this repo in your machine and create a new development branch from it with the following name:
   
   `REPLACE_WITH_LION_LOGIN_LOWERCASE-errorhandling-challenge`
   
   For example, a valid branch name would it be:
   
   `carmosqu-errorhandling-challenge`


#### Project Overview:
* The main class is Application.java. It has a main method which calls an ExceptionThrower 10 times.
* ExceptionThrower generates a random number between 1 and 100 and throws an exception depending on the number.
  * If randomNumber < 20, An illegal state exception is thrown.
  * If randomNumber > 80, A runtime exception is thrown.
  * If randomNumber is between 20 and 40, a message is printed on the console.
  * If randomNumber is between 40 and 60, a custom runtime exception is thrown.
  * If randomNumber is between 60 and 80, a custom checked exception is thrown.

**Your task is to do the following steps to match the output similar to the one at the bottom.**

1. Go to the custom package and create a new Runtime Exception.
2. Go to the custom package and create a new Checked Exception.
3. Open ExceptionThrower.java and complete the 2 TODOs in the file.
   * throwCustomRuntimeException should throw the exception created on step 1
   * throwCustomCheckedException should throw the exception created on step 2
4. Implement any code required to make sure the for loop runs 10 times and do the following:
   * If an IllegalStateException is thrown, it should print: "I'm an IllegalStateException".
   * If any other runtime exception is thrown, it should print its message.
   * If a Checked Exception is thrown, it should print its stack trace.
   * After each iteration, it should print: Ending and the number of the Iteration
     e.g. Ending 1

**Example of an Output:**

```
I'm an IllegalStateException
Ending 0
No exception thrown here! Value: 22
Ending 1
I'm throwing a RuntimeException. Value: 95
Ending 2
java.lang.Exception
  at com.prodigious.thrower.ExceptionThrower.throwCustomCheckedException(ExceptionThrower.java:41)
  at com.prodigious.thrower.ExceptionThrower.throwRandomException(ExceptionThrower.java:24)
  at com.prodigious.Application.main(Application.java:13)
Ending 3
...
```
---

## Exercise 2: Reading a CSV File

A CSV export file has been provided to you ([ProdigiousBalanceExport.csv](ProdigiousBalanceExport.csv)) containing debits and credits of different people in Prodigious. Your task is to create a new Java project, read the CSV file and output the sum of debits, the sum of credits and the total balance for each person.

Rules:
* The path of the file, has to be provided as an input to the java program.
* If the file does not exist, display the following error message: "File Not Found: <path>"
* If there is any IOException just print the stack trace.
* The CSV file cannot be changed.
* The output can be standard output (System.out.println).
* You can create as many classes as you want.
* No external dependencies can be used.
* If there is no name as the first value on a single row, it can be skipped.
* If someone has no credits or debits, 0 can be assumed.
* BigDecimal is encouraged for operations.
* For the Output, just make use of System.out.println().
* Output must have the following pattern: Name;SumOfDebits;SumOfCredits;TotalBalance
* Output should match the result below:

Output:
```
Daniel;23060967.35;-10000053.99;13060913.36
Diana;1000.02;-1000.02;0.00
Juan;0;0;0
Alejandra;3000;-1000.01;1999.99
Maria;30000.43;-30000.43;0.00
```