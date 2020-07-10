# Internship Program Assessment Exercise


**Welcome Intern! (45min)**

Welcome to the *Prodigious* Internship program. This is the very first activity you'll be required to address within this experience. This exercise is intended to to understand how do you unwind while performing software development tasks with defined scope and delivery. This is not meant to evaluate your technical skills, as you'll be guide into a full training program in which you're going to improve those. However this would require some knowledge on JAVA programing language specially on control structures like conditionals and loops.


# Background

As you may know *Math* and *Software Development* are tightly joined, conceptually at least. but the relationship between those two, is much bigger than that. That's why this exercise will introduce and put into practice some elements of Math which are related the most with the process of creating software:

## Fibonacci Numbers

The *Fibonacci Numbers* or *Fibonacci Sequence* is a sequence of numbers with a lot of interesting mathematical properties. This sequence is built in by defining the first two elements as 1 and from there on each number would be the sum of the two previous ones. For example:

`1,1,2,3,5, .....`

where

element 1 is `1`	
element 2 is `1`	
element 3 is `2 as (1+1=2)` 	
element 4 is `3 as (1+2=3)`		
element 5 is `5 as (2+3=5)`	

and so on.

For mathematical purposes, there is defined a element in the position zero "0"  as  `0`, so then the mostly accepted formal definition is:

<img src="https://render.githubusercontent.com/render/math?math=F_0=0">, <img src="https://render.githubusercontent.com/render/math?math=F_1=1">

<img src="https://render.githubusercontent.com/render/math?math=And">

<img src="https://render.githubusercontent.com/render/math?math=F_n = F_{n-1}%2BF_{n-2} ">

Check this basic implementation for the *Fibonacci Sequence* in Java using recurrence:

```java
fib(n){
	if(n==0){
		return 0;
	}else if(n==1){
		return 1;
	}else{
		return fib(n-2)+fib(n-1);
	}	
}
```
> try to create a non-recursive version, is it possible?

## The Golden Ratio

In Math two numbers are said to be in *Golden Ratio* if their ratio is the same as the ratio of their sum to the biggest of the two numbers. 

![enter image description here](https://upload.wikimedia.org/wikipedia/commons/4/44/Golden_ratio_line.svg)

formally if we have 2 numbers  <img height="13" src="https://render.githubusercontent.com/render/math?math=a \gt b \gt 0"> then <img height="9" src="https://render.githubusercontent.com/render/math?math=a">  and <img height="13" src="https://render.githubusercontent.com/render/math?math=b">  are in *golden ratio* if 


<img height="40" src="https://render.githubusercontent.com/render/math?math=\frac{a}{b}=\frac{a%2Bb}{a}"> 

above equation would result on the quadratic formula <img height="15" src="https://render.githubusercontent.com/render/math?math=x^2-x-1=0"> when solved for the ratio <img height="15" src="https://render.githubusercontent.com/render/math?math=a/b">. whose positive solution is:


<img height="35" src="https://render.githubusercontent.com/render/math?math=x=\frac{1 %2B \sqrt{5}}{2}=1.6180339887...">


Such number is called the *golden number*. noted by  <img height="15" src="https://render.githubusercontent.com/render/math?math=\varphi">.


<img height="18" src="https://render.githubusercontent.com/render/math?math=\varphi=1.6180339877...">.



Such number us called like that because it is present on most of the elements in human environment, such as plants, animals and even the human body. 

>try to create a Java program to calculate the *golden number*

### Golden Number and Fibonacci

As told before there are so many interesting mathematical properties on the *Fibonacci numbers*. One of the coolest ones is the relation between the numbers on the sequence and the *golden ratio*. 

It was discovered that if you take whatever two consecutive numbers in the *Fibonacci sequence* the ratio is almost equal to the *golden ratio*. Further more, the farther in the sequence you pick the numbers the nearer is their ratio to the *golden number*. Formally:




<img height="40" src="https://render.githubusercontent.com/render/math?math=\frac{F_{n%2B1}}{F_n} \approx \varphi">

for example pick <img height="12" src="https://render.githubusercontent.com/render/math?math=n=6"> then



<img height="35" src="https://render.githubusercontent.com/render/math?math=\frac{F_{7}}{F_6}=\frac{13}{8}=1.625 \approx \varphi">

Actually in this case the difference between both numbers is just 0,007 equivalent to an error of 0,043 (percentage difference from Fibonacci ratio to the *golden ratio*). 


# The Problem (8 hrs)


Your goal is to build a program in Java that calculates the minimum value of <img height="10" src="https://render.githubusercontent.com/render/math?math=n"> (position in the *Fibonacci sequence*) for which the ratio error does not exceed the given error. That's for a given maximum ratio error <img height="12" src="https://render.githubusercontent.com/render/math?math=E"> then the output should fulfill

min <img height="10" src="https://render.githubusercontent.com/render/math?math=n"> such that

<img height="50" src="https://render.githubusercontent.com/render/math?math=\left| \frac{F_{n%2B1}}{F_n} - \varphi \right| /100 < E">
 

**Input Format**

The first line of the input consists of an integer <img height="15" src="https://render.githubusercontent.com/render/math?math=k">.  
The next line contains <img height="15" src="https://render.githubusercontent.com/render/math?math=k"> space-separated decimal values contained in the array.

**Output Format**

Print the minimum position on the *fibonacci sequence* <img height="10" src="https://render.githubusercontent.com/render/math?math=n"> for which the ratio error does not exceed the given value in the array.

**Constraints**

- <img height="15" src="https://render.githubusercontent.com/render/math?math=1 \leq k  \leq 10">
- <img height="20" src="https://render.githubusercontent.com/render/math?math=10^{-5} \leq ar[i] \leq 5^{-1}">

**Feedback Session (1h)**