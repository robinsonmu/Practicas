# S.O.L.I.D

**S.O.L.I.D** is an acronym for the **first five object-oriented design** (**OOD**) **principles** by Robert C. Martin, popularly known as [Uncle Bob](https://en.wikipedia.org/wiki/Robert_Cecil_Martin).

These principles, when combined together, make it easy for a programmer to develop software that are easy to maintain and extend. They also make it easy for developers to avoid code smells, easily refactor code, and are also a part of the agile or adaptive software development.

## S.O.L.I.D stands for:

When expanded the acronyms might seem complicated, but they are pretty simple to grasp.

-   **S** - Single-responsiblity principle
-   **O** - Open-closed principle
-   **L** - Liskov substitution principle
-   **I** - Interface segregation principle
-   **D** - Dependency Inversion Principle

Let's look at each principle individually to understand why S.O.L.I.D can help make us better developers.

## S: Single Responsibility Principle
![Single Responsability](https://deviq.com/wp-content/uploads/2014/11/SingleResponsibility.jpg)
### Simple meanings
- A class should have one, and only one, reason to change.
- A class should have one and only one reason to change, meaning that a class should have only one job.

### Explained meaning
- The more responsibilities a class has, the more change requests it will get, and the harder those changes will be to implement

### Example
Let’s say we are working on a project that helps people become more active in their community, and the system needs to have social media integration. It would be a good idea to separate the social media integration responsibility from the other parts of the system, as we should always be prepared for external changes.

### Advantages
- Testing – A class with one responsibility will have far fewer test cases
- Lower coupling – Less functionality in a single class will have fewer dependencies
- Organization – Smaller, well-organized classes are easier to search than monolithic ones

### Functional example
Let’s have a book class.

    public class Book {
        private String name;
        private String author;
        private String text;
        // constructor, getters and setters
    }

Let's now add a couple of methods to query the text

	public String replaceWordInText(String word) {
	    return text.replaceAll(word, text);
	}
	
	public boolean isWordInText(String word) {
	    return text.contains(word);
	}
	
	void printTextToConsole() {
	    // our code for formatting and printing the text
	}
Are all methods correct? No.
Why? Because it isn’t a concern of our book class to implement how a book will be printed. For that concern, we should create a new class like:

	public class BookPrinter {
	
	    // methods for outputting text
	
	    void printTextToConsole(String text) {
	        // our code for formatting and printing the text
	    }
	
	    void printTextToAnotherMedium(String text) {
	        // code for writing to any other location...
	    }
	}

### Considerations
What should need to be separated?
- Persistence
- Validation
- Notification
- Error Handling
- Logging
- Class Selection / Instantiation
- Formatting
- Parsing
- Mapping

## O: Open-Close Principle
![Open Closed](https://deviq.com/wp-content/uploads/2014/11/OpenClosedPrinciple-300x300.jpg)
### Simple meaning
- You should be able to extend a class’s behavior, without modifying it.
- This principle is the foundation for building code that is maintainable and reusable.
- Objects or entities should be open for extension, but closed for modification.

### Explained meaning
- **Open for extension:** This ensures that the class behavior can be extended. As requirements change, we should be able to make a class behave in new and different ways, to meet the needs of the new requirements.
- **Closed for modification:** The source code of such a class is set in stone, no one is allowed to make changes to the code.
- In simpler words, means that a class or factory function in our case, should be easily extendable without modifying the class or function itself.
- Is just a principle and not a generic solution.

### Example
If we had a system that works with different shapes as classes, we would probably have classes like Circle, Rectangle, etc. In order for a class that depends on one of these classes to implement OCP, we need to introduce a Shape interface/class. Then, wherever we had Dependency Injection, we would inject a _Shape_ instance instead of an instance of a lower-level class. This would give us the luxury of adding new shapes without having to change the dependent classes’ source code.

### Advantages
- Potentially streamline code maintenance and minimizing risk of breaking the existing code base.
### Functional example
Imagine we've implemented a _Guitar_ class

    public class Guitar {
        private String make;
        private String model;
        private int volume;
        // Constructors, getters & setters
    }

Now, we have to implement some different kinds of guitar like

    public class SuperCoolGuitarWithFlames extends Guitar {
        private String flameColor;
 
        //constructor, getters + setters
    }

By extending the Guitar class we can be sure that our existing application won't be affected.

The Open-Closed Principle can also be achieved in many other ways, including through the use of inheritance or through compositional design patterns like the Strategy pattern.


## L: Liskov substitution principle
![Liskov](https://deviq.com/wp-content/uploads/2014/11/LiskovSubstitution-300x300.jpg)
### Simple meaning
- If class A is a subtype of class B, then we should be able to replace B with A without disrupting the behavior of our program.
- All this is stating is that every subclass/derived class should be substitutable for their base/parent class.

### Explained meaning
- Using a contract via interfaces or abstract classes, we can extend functionality without changing code in all places that we have used before.
### Example

Let’s visualize the definition with a case study. Let’s say we have a Rectangle class, and we have a class that extend it, Square. Let’s also say that Rectangle has two methods, setWidth and setHeight, which, well, set the width and height of the rectangle respectively.

The problem is that the behavior for the two methods differs between the Rectangle and the Square classes. The reason for that is that a Square, by mathematical definition is a Rectangle with equal height and width. So, the two methods will change the same value, whereas for the Rectangle, they will change the width and height respectively, which are different values from each other.

When we are using abstraction(Open-Closed Principle), we want the methods to behave the same for each derived class, and not differently. In this case, we can clearly see that a Square class should not be extending the Rectangle class, because the behavior of the inherited methods differs.

### Advantages
- Supportability and reliability.
- Extensibility
- Support unit testing
### Functional example

    public interface Car {
        void turnOnEngine();
        void accelerate();
    }

Above, we define a simple Car interface with a couple of methods that all cars should be able to fulfill – turning on the engine, and accelerating forward.

    public class MotorCar implements Car {
    
        private Engine engine;
 
        // Constructors, getters + setters
    
        public void turnOnEngine() {
            //turn on the engine!
            engine.on();
        }
 
        public void accelerate() {
            //move forward!
            engine.powerOn(1000);
        }
    }

But we are now living in the era of electric cars:

    public class ElectricCar implements Car {
    
        public void turnOnEngine() {
            throw new AssertionError("I don't have an engine!");
        }
    
        public void accelerate() {
            //this acceleration is crazy!
        }
    }
By throwing a car without an engine into the mix, we are inherently changing the behavior of our program. This is a blatant violation of Liskov substitution and is a bit harder to fix than our previous 2 principles.

One possible solution would be to rework our model into interfaces that take into account the engine-less state of our Car.

## I: Interface Segregation principle
![Interface segregation](https://deviq.com/wp-content/uploads/2014/11/InterfaceSegregation-300x300.jpg)
### Simple meaning
- A client should never be forced to implement an interface that it doesn’t use or clients shouldn’t be forced to depend on methods they do not use.
- Make fine grained interfaces that are client specific.
- Clients should not be forced to implement interfaces they do not use.

### Explained meaning
- Larger interfaces should be split into smaller ones. By doing so, we can ensure that implementing classes only need to be concerned about the methods that are of interest to them.
- In other words, it is better to have many smaller interfaces, than fewer, fatter interfaces.

### Example
Let’s say we had an interface called Animal, which would have eat, sleep and walk methods. This would mean that we have a monolithic interface called Animal, which would not be the perfect abstraction, because some animals can fly. Breaking this monolithic interface into smaller interfaced based by role, we would get CanEat, CanSleep and CanWalk interfaces. 

This would then make it possible for a species to eat, sleep and for example fly. A species would be a combination of roles, instead of being characterized as an animal, which would not necessarily be the best description. At a larger scale, microservices are a very similar case, they are pieces of a system separated by responsibilities, instead of being a great monolith.

### Advantages
- By breaking down interfaces, we favor Composition instead of Inheritance, and Decoupling over Coupling.
- We favor composition by separating by roles(responsibilities) and Decoupling by not coupling derivative classes with unneeded responsibilities inside a monolith.

### Functional example
Let's start with an interface that outlines our roles as a bear keeper:

    public interface BearKeeper {
        void washTheBear();
        void feedTheBear();
        void petTheBear();
    }

As avid zookeepers, we're more than happy to wash and feed our beloved bears. However, we're all too aware of the dangers of petting them. Unfortunately, our interface is rather large, and we have no choice than to implement the code to pet the bear.

Let's fix this by splitting our large interface into 3 separate ones:

    public interface BearCleaner {
        void washTheBear();
    }
 
    public interface BearFeeder {
        void feedTheBear();
    }
 
    public interface BearPetter {
        void petTheBear();
    }

Now, thanks to interface segregation, we're free to implement only the methods that matter to us:

    public class BearCarer implements BearCleaner, BearFeeder {
     
        public void washTheBear() {
            //I think we missed a spot...
        }
 
        public void feedTheBear() {
            //Tuna Tuesdays...
        }
    }

## D: Dependency Inversion principle
![DependencyInversion](https://deviq.com/wp-content/uploads/2014/11/DependencyInversion-300x300.jpg)
### Simple meaning
- Entities must depend on abstractions not on concretions. It states that the high level module must not depend on the low level module, but they should depend on abstractions.

### Explained meaning
- The principle of Dependency Inversion refers to the decoupling of software modules. This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.
- Depend on abstractions, not on concretions.

### Example
We have a system that handles authentication through external services such as Google, GitHub, etc. We would have a class for each service: GoogleAuthenticationService, GitHubAuthenticationService, etc. Now, let’s say that some place in our system, we need to authenticate our user. To do that, as mentioned, we have several services available. To be able to make use of all the services, we have two possibilities: We either write a piece of code that adapts each service to the authentication process, or we define an abstraction of the authentication services. 

The first possibility is a dirty solution that will potentially introduce technical debt in the future; in case a new authentication service is to be integrated to the system, we will need to change the code, which as a result violates the OCP. The second possibility is much cleaner, it allows for future addition of services, and changes can be done to each service without changing the integration logic. 

By defining a AuthenticationService interface and implementing it in each service, we would then be able to use Dependency Injection in our authentication logic and have our authentication method signature look something like this: authenticate(AuthenticationService authenticationService). Then, we could authenticate by a specific service like this: authenticate(new GoogleAuthenticationService). This helps us generalize the authentication logic without having to integrate each service separately.

### Advantages
- By depending on higher-level abstractions, we can easily change one instance with another instance in order to change the behavior.
- Dependency Inversion increases the reusability and flexibility of our code.

### Functional example
Now let’s see how a naive design would look without any dependency inversion and what are the loopholes in that design. 

    public class Manager {
        private List<Developer> developers;
        private List<Designer> designers;
        private List<Tester> testers;

        public Manager() {
            this.developers = new ArrayList<>();
            this.designers = new ArrayList<>();
            this.testers = new ArrayList<>();
        }

        public void addDeveloper(Developer dev) {
            this.developers.add(dev);
        }

        public void addDesigner(Designer designer) {
            this.designers.add(designer);
        }
    
        public void addTester(Tester tester) {
            this.testers.add(tester);
        }
    }

    public class Developer {
        public Developer() {
            System.out.println("Developer added");
        }
    }
    
    public class Designer {
        public Designer() {
            System.out.println("Designer added");
        }
    }
    
    public class Tester {
        public Tester() {
            System.out.println("Tester added");
        }
    }
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addDeveloper(new Developer());
        manager.addDesigner(new Designer());
    }

Now, let’s look at the design loop holes in the source code:
First, you have exposed everything about the lower layer to the upper layer, thus abstraction is not mentioned. That means Manager must already know about the type of the workers that he can supervise.
Now if another type of worker comes under the manager lets say, QA (quality assurance), then the whole class needs to be rejigged. This is where dependency inversion principle pitch in.

    public abstract class Employee {
        public abstract void work();
    }
    
    public class Manager {
        private List<Employee> employees;
    
        public Manager() {
            this.employees = new ArrayList<>();
        }
    
        public void addEmployee(Employee employee) {
            this.employees.add(employee);
        }
    }

    public class Developer extends Employee {
        public Developer() {
            System.out.println("Developer added");
        }
    
        @Override
        public void work() {
            System.out.println("Turning coffee into code");
        }
    }

    public class Designer extends Employee {
        public Designer() {
            System.out.println("Designer added");
        }
    
        @Override
        public void work() {
            System.out.println("Turning lines into wireframes");
        }
    }
    
    public class Tester extends Employee {
        public Tester() {
            System.out.println("Tester added");
        }
    
        @Override
        public void work() {
            System.out.println("Testing everything out there");
        }
    }
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addEmployee(new Developer());
        manager.addEmployee(new Designer());
    }

Now if any other kind of the employee is added it can be simply be added to Manager without making the manager explicitly aware of it. The creation of the abstraction between different employees and Manager has resulted in very good-looking design code which is easily maintainable and extendable.

Following principles always has benefits. It is no different in software engineering. Following the SOLID Principles gives us many benefits, they make our system reusable, maintainable, scalable, testable and more.

### Feedback session after Laboratories (1h)

### Execises

Check Laboratories file.

### Challenge (4 hrs)

You have been tasked to design a web service for  a new online book lending system. The university library thought on help the students by allowing them to lend books from home, the idea is that them the request online and receving the book by mail and make sure the return them to the delivery boy the day after when he comes back for pickup. That way the students can continue accesing library contents while for the covid-19's curfew still in force.
The service will have to model the library as it is phisically so then the staff can find the books to dispatch them when those are lent.

* The books are located on shelfs which are separated in the different sections of the library, one per each gender: horror, comedy, drama, kids and historic.
* From each book is required to storage the name, author, ISBN code, and number of available copies.
* The service should allow the client to lend a book, return a book, add new adquisitions to the library and remove damaged copies of a book, no book without available copies will be reatined in the system.
* All the book information should be persisted using a provided persistence service, which receives a JSON document to be stored.
* The library also holds some e-books but those are managed differently, however this service should allow adding this type of books to the lending system. For instance these are not comming by mail but using a web link. The ebook service will be added in the future but for sure it will use this lending system. So your desing should support this tipe of books and a possible future integration without affetting this implementation.
* When a book lean is requested and availity is confirmed and email should be sent to the user with the book information and the lending information including when to wait for the lent copy to be delivered at destination.


Your task is to propose a desing for this book lending system for being used in the backend side from an existent frontend application. Yo can deliver the classes skeleton if is easier for you. Anyway your desing must indetify attributes and operations for all entites modeled.

### Feedback Session (1h)



References
- https://hackernoon.com/solid-principles-made-easy-67b1246bcdf
- https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
- https://www.baeldung.com/solid-principles
- https://deviq.com/solid/
- https://medium.com/@a.vathanaka/benefits-of-the-open-closed-principle-dc9284d47598


