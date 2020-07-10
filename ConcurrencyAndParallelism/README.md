# Concurrency and Parallelism

## Overview ##

This training aims to introduce you to the basics of parallisim and Concurrency programing in Java including JCA for Java 8

Please use your Lion Login to obtain the **[O'Reilly and Pularsight credentials](https://lion.app.box.com/s/venhn6zsx1dr3lr0b76a880yawsg6q9g)** in order to access the videos in the Arrays and Generic Collections chapters, found in the **[Paul Deitel's Java 8 Fundamentals set of videos](https://learning.oreilly.com/videos/java-8-fundamentals/9780133489354)**: 

## Prerequisites and Resources ##

In order to follow the videos correctlly, you should have installed the JDK and a Java IDE beforehand. If you have not done so, you can do it for yourself if you know how to do it, but if not, you can follow the following videos, which will walk you trought the installation of both things.

###  JDK and Java IDE installation (**[Installation and setup environment Videos beginning here](https://learning.oreilly.com/videos/java-8-fundamentals/9780133489354/9780133489354-JFUN_BYB01)**) ###

Recommended IDE to use is IntelliJ IDEA, but if you want to use Eclipse or Netbeans you can do it too. Just follow instructions on the installation video choosing between their respective videos

   * Overview
   * Software Used
   * Installing the JDK (Required) : In this video you can choose between installing just the JDK or the Netbeans bundle, depending on the IDE that you are going to use
   * Installing Eclipse (Optional)
   * Installing IntelliJ IDEA (Optional)




## Contents


### Why Concurrency? (2h)

* [Multithreading Benefits](http://tutorials.jenkov.com/java-concurrency/benefits.html)
* [Multithreading Costs](http://tutorials.jenkov.com/java-concurrency/costs.html)
* [Concurrency Models](http://tutorials.jenkov.com/java-concurrency/concurrency-models.html)
* [Concurrency vs. Parallelism](http://tutorials.jenkov.com/java-concurrency/concurrency-vs-parallelism.html)
* [Thread Safety and Immutability](http://tutorials.jenkov.com/java-concurrency/thread-safety-and-immutability.html)
* [Java Memory Model](http://tutorials.jenkov.com/java-concurrency/java-memory-model.html)tiona

###  Concurrency (**[Watch Lesson 20 Videos beginning here](https://learning.oreilly.com/videos/java-8-fundamentals/9780133489354/9780133489354-JFUN_lesson20_intro)** 3h 30m)

* Introduction
* Concurrent programming overview
* Thread States and Life Cycle
* Creating and Executing Threads with the Executor Framework
* Thread Synchronization Overview
* Unsynchronized Mutable Data Sharing (Not thread safe)
* Synchronized Mutable Data Sharing—Making Operations Atomic
* Producer/Consumer Relationship without Synchronization (Not thread safe)
* Producer/Consumer Relationship: ArrayBlockingQueue
* Performing Computations in a Worker Thread: Fibonacci Numbers
* Processing Intermediate Results: Sieve of Eratosthenes
* sort/parallelSort Timings with the Java SE 8 Date/Time API
* Java SE 8: Sequential vs. Parallel Streams
* Executing Aysnchronous Tasks with CompletableFuture—Fibonacci calculations performed synchronously and asynchronously

### New Java 8 (30 mins)

* Executors and Futures Tutoral [Check here](https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/)


### Challenge

A new restaurant hires you to complete their new dron based deilvery system whit the following requriments:

* The city on which the restaurant works was mapped as a grid where a dron position is determined by a 2 corodinate point (x,y) in the grid.
* A Dron can move forward, backward, to the left and to the right. 
* Each delivery is mapped as a set of instructions given by letters as follows:
   * F to move forward 1 square.
   * B to move backward 1 square.
   * W to move west 1 square
   * E to move east 1 square.
* A dron will have a maximun capacity which will determine the maximun number of orders it can carry in one each trip.

Your task is to create a program using the DeliverySystem for performing dron deliveries and report final destinations. Please be sure you are aware of:

* The order of movements of a dron does not affect it's final postion.
* All drons shall begin their trips at the same time on each morning. 
* Is not necessary for a dron to wait any other finish a trip to begin a new one.
* All drons begin on position (0,0) on the grid.

**Input Format**

A txt file with the following structure:

- First line has an integer indicating the number of drons.
- Second line has an integer indicating the capacity of each dron (number of orders that can carry at a time).
- third lien and beyond delivery isntructions, each line is a delivery order represented by an String with several movement instructions (example: "LLLLFFF")

**Output Format**

A file for each dron including:

- First line and beyond will contain the final destinations as cordinates on the grid for all deliveries done by each dron.
- The last line will have the time when the excution of delivery plan for current dron was finished.

**Technical Requirments**

- Is a must to use parallel streams on ionstructions execution to improve delivery performace of each dron.
- Is a must to execute each dron delivery plan on its own thread to guarantee all drons are delivering orders concurrenlty so then the clients does not need to wait to much.



### Extras (Optional)

- http://tutorials.jenkov.com/java-concurrency/synchronized.html
- http://tutorials.jenkov.com/java-concurrency/volatile.html
- https://youtu.be/TCd8QIS-2KI
- https://youtu.be/FChZP09Ba4E
- https://youtu.be/_RSAS-gIjGo
- https://youtu.be/2Bvz_jsQPHk
