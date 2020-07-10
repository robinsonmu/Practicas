# Fundamentals of Object Oriented Programming (OOP)

This topic will be reviewed into 9 core units:
1. [Classes & Objects, Methods and Strings](#part-one)
2. [Constructors & Overload](#part-two)
3. [Access Modifiers](#part-thr)
4. [Static and Final Keywords](#part-fou)
6. [Inheritance & Overriding](#part-fiv)
7. [Encapsulation & Data Hiding](#part-six)
8. [Polymorphism](#part-sev)
9. [Interfaces](#part-eig)
10. [Hands On](#part-nin)

**Note**: *We will use `Java` as the language for examples.*

<a name="part-one">Part 1</a>
## Concept
OOP means Object-Oriented Programming and has several advantages over **[Procedural Programming](https://en.wikipedia.org/wiki/Procedural_programming)**:
- Faster and easier to execute
- Provides a clear structure for the programs.
- Helps to keep the code DRY "Don't Repeat Yourself", and makes the code easier to maintain, modify and debug.
- Makes it possible to create full reusable applications with less code and shorter development time.

## Classes, Objects, Methods and Strings

### Classes & Objects
Classes and objects are the two main aspects of object-oriented programming.
Everything in OOP is associated with classes and objects, along with its attributes and methods. For example: in real life, imagine in a supermarket you find products, and they are objects. Each product has attributes, such as name, weight, price, brand and due date, and methods, such as verify stock and buy.

| *Class*   | *Objects*   |
|:-------:|:---------:|
|         | Chocolate |
| Product | Rice      |
|         | Milk      |

To create a class with attributes, use the keyword class and types for attributes:
```java
// Creating a class with attributes
public class Product {
  String name = "";
  double weight = "";
  double price = "";
  String brand = "";
}
```

```java
// Creating object using Product class
public class Product {
  String name = "Chocolate";

  public static void main(String[] args) {
    Product ch = new Product();
    System.out.println(ch.name);
  }
}
```

The dot `(.)` syntax let you access attributes by creating an object of the class. Example: `ch.name` for accessing the name of `ch` object.

### Methods and Strings
A method is a block of code which only runs when it is called. You can pass data into it, known as parameters.
Methods are used to perform certain actions, and they are also known as functions. Why do we use them? To reuse code: define the code once, and use it many times.

Following example shows `buy` method printing a text, when it's called. To call a method, write the method's name followed by two parentheses `()`and a semicolon `;`.

```java
// Calling a method
public class Product {
  static void buy() {
    System.out.println("Product being bought");
  }

  public static void main(String[] args) {
    buy();
  }
}
```

<a name="part-two">Part 2</a>
## Constructors & Overload

### Constructors
A constructor is a special method that is used to initialize objects. The constructor is called when an object of a class is created. It can be used to set initial values for object attributes. See following example:

```java
// Product class with constructor
public class Product {
  String n;  // Create a class attribute

  // Create a class constructor for the Product class
  public Product() {
    n = "Chocolate";  // Set the initial value for the class attribute n
  }

  public static void main(String[] args) {
    Product ch = new Product(); // Create an object of class Product (This will call the constructor)
    System.out.println(ch.n); // Print the value of n
  }
}
```

- Note that the constructor name must match the class name, and it cannot have a return type (like void).
- Also note that the constructor is called when the object is created.
- All classes have constructors by default: if you do not create a class constructor yourself, Java creates one for you. However, then you are not able to set initial values for object attributes.
- Constructors can also take parameters, which is used to initialize attributes.

```java
// The following example adds two parameters to the constructor.
// Inside the constructor we set attributes with a value.
// When we call the constructor, we pass a parameters to the constructor, which will set the values of the attributes:
public class Car {
  int modelYear;
  String modelName;

  public Car(String name) {
    modelName = name;
  }

  public Car(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Car myCar = new Car(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}
```

### Overload
Overloading allows different methods (even Constructors) to have the same name, but different signatures where the signature can differ by the number of input parameters or type of input parameters or both. Overloading is related to compile-time (or static) polymorphism.

```java
public class Sum { 
  
    // Overloaded sum(). This sum takes two int parameters 
    public int sum(int x, int y) { 
        return (x + y); 
    } 
  
    // Overloaded sum(). This sum takes three int parameters 
    public int sum(int x, int y, int z) { 
        return (x + y + z); 
    } 
  
    // Overloaded sum(). This sum takes two double parameters 
    public double sum(double x, double y) { 
        return (x + y); 
    } 
  
    // Driver code 
    public static void main(String args[]) { 
        Sum s = new Sum(); 
        System.out.println(s.sum(10, 20)); // Will result an output: 30 
        System.out.println(s.sum(10, 20, 30)); // Will result an output: 60
        System.out.println(s.sum(10.5, 20.5)); // Will result an output: 31.0 
    } 
}
```

<a name="part-thr">Part 3</a>
## Modifiers
We divide modifiers into two groups:
- **Access Modifiers** which controls the access level
- **Non-Access Modifiers** those that do not control access level, but provides other functionality

### Access Modifiers
For **classes**, you can use either `public` or *default*:

| *Modifier* | *Description*                                                                                                  |
|:--------:|--------------------------------------------------------------------------------------------------------------|
| public`   | The class is accessible by any other class                                                                   |
| default  | The class is only accessible by classes in the same package. This is used when you don't specify a modifier. |

For **attributes**, **methods** and **constructors**, you can use the one of the following:

| *Modifier*  | *Description*                                                                                      |
|-----------|--------------------------------------------------------------------------------------------------|
| `public`    | The code is accessible for all classes.                                                          |
| `private`   | The code is only accessible within the declared class.                                           |
| default   | The code is only accessible in the same package. This is used when you don't specify a modifier. |
| `protected` | The code is accessible in the same package and subclasses.                                       |

### Non-Access Modifiers
For **classes**, you can use either `final` or `abstract`:

| *Modifier*  | *Description*                                                                                                  |
|:---------:|--------------------------------------------------------------------------------------------------------------|
| `final`     | The class is accessible by any other class                                                                   |
| `abstract`  | The class is only accessible by classes in the same package. This is used when you don't specify a modifier. |

For **attributes** and **methods**, you can use the one of the following:

|   *Modifier*  | *Description*                                                                                                 |
|:-----------:|-------------------------------------------------------------------------------------------------------------|
| `final`       | Attributes and methods cannot be overridden/modified.                                                       |
| `static`      | Attributes and methods belongs to the class, rather than an object.                                         |
| `abstract`    | The code is only accessible in the same package. This is used when you don't specify a modifier.            |
| `transient`   | Can only be used in an abstract class, and can only be used on methods. The method does not have a body.    |
| `synchronized`| The code is only accessible in the same package. This is used when you don't specify a modifier.            |
| `volatile`    | The code is accessible in the same package and subclasses.                                                  |

<a name="part-fou">Part 4</a>
## Static and Final Keywords
### Static
A `static` method means that it can be accessed without creating an object of the class, unlike `public`:

An example to demonstrate the differences between `static` and `public` methods:
```java
public class NewClass {
  // Static method
  static void aStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void aPublicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[ ] args) {
    aStaticMethod(); // Call the static method
    // aPublicMethod(); This would output an error

    NewClass obj = new NewClass(); // Create an object of NewClass
    obj.aPublicMethod(); // Call the public method
  }
}
```

### Final
If you don't want the ability to override existing attribute values, declare attributes as `
final`:
```java
// attributes as final
public class NewClass {
  final int x = 10;
  final double PI = 3.14;

  public static void main(String[] args) {
    NewClass obj = new NewClass();
    obj.x = 50; // will generate an error: cannot assign a value to a final variable
    obj.PI = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(obj.x);
  }
}
```

<a name="part-fiv">Part 5</a>
## Inheritance & Overriding

### Inheritance
In Java, it is possible to inherit attributes and methods from one class to another. We group the "inheritance concept" into two categories:
- **Superclass** *(parent)* is the class being inherited from.
- **Subclass** *(child)* is the class that inherits from another class.

To inherit from a class, use the `extends` keyword.

In the example below, the Car class (subclass) inherits the attributes and methods from the Vehicle class (superclass):
```java
class Vehicle {
  protected String brand = "Chevrolet";        // Vehicle attribute
  
  public void honk() {                    // Vehicle method
    System.out.println("Plop, plop!");
  }
}

class Car extends Vehicle {
  private String modelName = "Camaro";    // Car attribute
  
  //Main method
  public static void main(String[] args) {
    // Create a myCar object
    Car c = new Car();

    // Call the honk() method (from the Vehicle class) on the c object
    c.honk();

    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
    System.out.println(c.brand + " " + c.modelName);
  }
}
```

### Overriding
In any object-oriented programming language, Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes. When a method in a subclass has the same name, same parameters or signature and same return type (or sub-type) as a method in its super-class, then the method in the subclass is said to override the method in the super-class.

Method overriding is one of the way by which java achieve Run Time Polymorphism. The version of a method that is executed will be determined by the object that is used to invoke it. If an object of a parent class is used to invoke the method, then the version in the parent class will be executed, but if an object of the subclass is used to invoke the method, then the version in the child class will be executed. In other words, it is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed.

```java
// Base Class 
class Parent { 
    void show() { 
        System.out.println("Parent's show()"); 
    } 
} 
  
// Inherited class 
class Child extends Parent { 
    // This method overrides show() of Parent with annotation Override
    @Override
    void show() { 
        System.out.println("Child's show()"); 
    } 
} 
  
// Driver class 
class Main { 
    public static void main(String[] args) { 
        // If a Parent type reference refers to a Parent object,
        // then Parent's show is called 
        Parent obj1 = new Parent(); 
        obj1.show(); 
  
        // If a Parent type reference refers to a Child object Child's show() 
        // is called. This is called RUN TIME POLYMORPHISM.
        Parent obj2 = new Child(); 
        obj2.show(); 
    } 
} 
```

<a name="part-six">Part 6</a>
## Encapsulation & Data Hiding
The meaning of Encapsulation, is to make sure that "*sensitive*" data is hidden from users. To achieve this, you must:
- Declare class variables/attributes as `private`.
- Provide public **get** and **set** methods to access and update the value of a `private` variable.

### Getters and Setters
The `private` variables can only be accessed within the same class (an outside class has no access to it). However, it is possible to access them if we provide `public` **get** and **set** methods.

The `get` method returns the variable value, and the `set` method sets the value. The syntax for both is that they start with either `get` or `set`, followed by the name of the variable, with the first letter in upper case:
```java
public class Person {
  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name; // The get method returns the value of the variable name.
  }

  // Setter
  public void setName(String newName) {
    this.name = newName; // The set method takes a parameter (newName) and assigns it to the name variable.
  }
}
```

It is good to use **Encapsulation** because:
- Better control of class attributes and methods.
- Class attributes can be made read-only (if you only use the `get` method), or write-only (if you only use the `set` method).
- Flexibility: the programmer can change one part of the code without affecting other parts.
- Increased security of data.

<a name="part-sev">Part 7</a>
## Polymorphism
Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.

Like we specified, **Inheritance** lets us inherit attributes and methods from another class. **Polymorphism** uses those methods to perform different tasks. This allows us to perform a single action in different ways.

For example, think of a superclass called `Language` that has a method called `sayHello()`. Subclasses of Languages could be English, French, Spanish - And they also have their own implementation of a greeting:
```java
class Language {
  public void sayHello() {
    System.out.println("Hello!");
  }
}

class English extends Language {
  public void sayHello() {
    System.out.println("Hi there guys!");
  }
}

class Spanish extends Language {
  public void sayHello() {
    System.out.println("¡Hola muchachos!");
  }
}
```
It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.

<a name="part-eig">Part 8</a>
## Abstraction & Interfaces

### Abstraction
Data abstraction is the process of hiding certain details and showing only essential information to the user. It can be achieved with either abstract classes or interfaces.

The `abstract` keyword is a non-access modifier, used for classes and methods:
- **Abstract class**: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
- **Abstract method**: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

An abstract class can have both abstract and regular methods:
```java
abstract class Language {
  public abstract void sayGoodbye();
  public void askForHelp() {
    System.out.println("hi, Could you help me?");
  }
}
```

From the example above, it is not possible to create an object of the Language class:
```java
Language l = new Language(); // will generate an error
```

To access the abstract class, it must be inherited from another class, using 'extends' keyword to make it possible.

### Interfaces
An `interface` is a completely "abstract class" that is used to group related methods with empty bodies:
```java
// interface
interface Car {
  public void start(); // interface method (does not have a body)
  public void stop(); // interface method (does not have a body)
}
```

To access the interface methods, the interface must be "implemented" (similar to inherited) by another class with the `implements` keyword (instead of `extends`). The body of the interface method is provided by the "implement" class:
```java
// Truck "implements" the Car interface
class Truck implements Car {
  public void start() {
    // The body of start() is provided here
    System.out.println("The truck starts here!");
  }
  public void stop() {
    // The body of stop() is provided here
    System.out.println("Truck breaking!");
  }
}

class MyMainClass {
  public static void main(String[] args) {
    Truck tr = new Truck();  // Create a Truck object
    tr.start();
    tr.stop();
  }
}
```

Something to remark about Interfaces:
- Like **abstract classes**, interfaces cannot be used to create objects (in the example above, it is not possible to create an "Animal" object in the MyMainClass)
- Interface methods do not have a body - the body is provided by the "implement" class
- On implementation of an interface, you must override all of its methods
- Interface methods are by default `abstract` and `public`
- Interface attributes are by default `public`, `static` and `final`
- An interface cannot contain a constructor (as it cannot be used to create objects)
- Use Interfaces to achieve security - hide certain details and only show the important details of an object (interface).
- Java does not support "multiple inheritance" (a class can only inherit from one superclass). However, it can be achieved with interfaces, because the class can implement multiple interfaces. Note: To implement multiple interfaces, separate them with a comma (see example below).

<a name="part-nin">Part 9</a>
## Hands On
You'll begin our OOP challenge [here](handsOn.md), so you can practice all what we have reviewed about this topic.