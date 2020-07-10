# Laboratories
In able to test the code refer to the following online compiler: https://www.tutorialspoint.com/compile_java8_online.php
All the code examples have more that one correct answer.

## Single responsability principle ##

**Task**: The following code breaks the single responsability principle. Refactor the code to make it better. What´s the problem? Well, the Employee class have the responsability to print
the department name. This should be a responsability for the Printer class. Change the entire code if needed.

    public static void main(String []args) {
        
        // Create Department instance
        Department department = new Department("IT");
        // Create Employee instance
        Employee employee = new Employee("David", department);
        
        // Create Printer instance
        Printer printer = new Printer();
        
        // Call PrintEmployee method
        printer.PrintEmployee(employee);
        
        // Call PrintDeparmentName method
        employee.PrintDepartmentName();
    }

    // Employee class
    static class Employee {
        
		// Private Employee fields
        private String _name;
        private Department _department;
        
        // Employee constructor method
        public Employee(String name, Department department) {
            _name = name;
            _department = department;
        }
        
        // Employee GetName method
        public String GetName() {
            return _name;
        }
        
        // Employee GetDepartment method
        public Department GetDepartment() {
            return _deparment;
        }
        
        // Employee PrintDepartmentName method
        public void PrintDepartmentName() {
            System.out.println(_department.GetName());
        }
    }
    
    // Department class
    static class Department {
        
		// Private Department field
        private String _name;
        
        // Department constructor method
        public Department(String name) {
            _name = name;
        }
        
        // Department GetName method
        public String GetName() {
            return _name;
        }
    }
    
    // Printer class
    static class Printer {
        
		// Printer PrintEmployee method
        public void PrintEmployee(Employee employee) {
            System.out.println(employee.GetName());
        }
    }


## Open / Closed principle ##

**Task**: The following code needs the implementation of the Open / Closed principle to work as it is expected. To do that refactor is needed. 
Notice that AreaCalculator class have a method named GetArea that receives a Rectangle type as a parameter. 
Make use of the abstract class Shape to allow AreaCalculator work either with a Rectangle or a Circle type.

Use the following line code to make the Calculation of the area of a circle
//area = circle.GetRadius() * circle.GetRadius() * Math.PI;

Use the following line code to identify the Shape type
// if(shape instanceof Circle) { }

    public static void main(String []args) {
        
		// Create Rectangle instance
        Rectangle rectangle = new Rectangle(2,2);
        
        // Create Circle instance
        Circle circle = new Circle(2);
        
        // Create AreaCalculator instance
        AreaCalculator areaCalculator = new AreaCalculator();
        
        // Get rectangleArea
        double rectangleArea = areaCalculator.GetArea(rectangle);
        
        
        // Print rectangle messages
        System.out.println("Rectangle width: " + rectangle.GetWidth());
        System.out.println("Rectangle height: " + rectangle.GetHeight());
        System.out.println("Rectangle area: " + rectangleArea);
        
        // Get circleArea
        double circleArea = areaCalculator.GetArea(circle);
        
        // Print rectangle messages
        System.out.println("Circle radius: " + circle.GetRadius());
        System.out.println("Circle area: " + circleArea);
        
        // The console output should be:
        // Rectangle width: 2.0
        // Rectangle height: 2.0
        // Rectangle area: 4.0
        // Circle radius: 2.0
        // Circle area: 12.566370614359172
    }
    
    // Rectangle class
    static class Rectangle {
        
		// Rectangle Private fields
        private double _width;
        private double _height;
        
        // Rectangle constructor method
        public Rectangle(double width, double height) {
            _width = width;
            _height = height;
        }
        
        // Rectangle GetWidth method
        public double GetWidth() { 
            return _width;
        }
        
        // Rectangle GetHeight method
        public double GetHeight() { 
            return _height;
        }
    }
    
    // AreaCalculator class
    static class AreaCalculator {
        
		// AreaCalculator constructor
        public AreaCalculator() { }
        
        // AreaCalculator GetArea method
        public double GetArea(Rectangle rectangle)
        {
            double area = 0;
            
            // Formula to calculate the are of a rectangle
            area = rectangle.GetWidth() * rectangle.GetHeight();

            return area;
        }
    }
    
    // Circle class
    static class Circle extends Shape {
        
		// Circle Private fields
        private double _radius;
        
        // Circle constructor method
        public Circle(double radius) {
            _radius = radius;
        }
        
        // Circle GetRadius method
        public double GetRadius() { 
            return _radius;
        }
    }
    
    // Shape abstract class
    static abstract class Shape{

    }


## Liskov substitution principle ##

**Task**: The following code needs the implementation of the Liskov substitution principle to work as it is expected. To do that refactor is needed. 

    public static void main(String []args) {
        
		// Create Phone instance
        IPad iPad = new IPad("Juan");
        
        // Call IPad methods
        iPad.TurnOn();
        iPad.PlayYouTubeVideo();
        iPad.TurnOff();
        
        // Create Tv instance
        Tv tv = new Tv("David");

        // Call Tv methods
        tv.TurnOn();
        tv.SetChannel(10);
        tv.TurnOff();
    }
    
    // Device class
    static abstract class Device {
        
		// Device TurnOn method
        public void TurnOn() {
            System.out.println("Turning " + _owner + " device on.");
        }
    }
    
    // Phone class
    static class IPad extends Device {
        
		// Phone MakeACall method
        public void PlayYouTubeVideo() {
            System.out.println("Playing youtube video in " + super._owner + " IPad");
        }
    }
    
    // Tv class
    static class Tv {

        // Tv constructor method
        public Tv(String owner) {
            super(owner);
        }
    }


## Interface segregation principle ##

**Task**: The following code needs the implementation of the Interface segregation principle to work as it is expected. To do that refactor is needed. 
The idea is to be able to create another athlete who doesn't swim but is a high jump competitor.
Then create another athlete who doesn't swim but is a long jump competitor.
All competitors needs the compete method to allow them to participate.

    public static void main(String []args) {
        
    }
    
	// Athlete interface
    public interface Athlete {
        void compete();
        void swim();
        void highJump();
        void longJump();
    }
    
	// Person class
    public class Person implements Athlete {
        
        @Override
        public void Compete() {
            System.out.println("Started competing");
        }
        
        @Override
        public void Swim() {
            System.out.println("Started swimming");
        }
        
        @Override
        public void HighJump() {
        }
        
        @Override
        public void LongJump() {
        }
    }


## Dependency inversion principle ##

**Task**: The following code needs the implementation of the Dependency inversion principle to work as it is expected. To do that refactor is needed. 
Notice that Yahoo and Outlook have almost the same implementation. The idea is to remove the dependency of Yahoo and Outlook from EmailServer on SendEmail method.
There should only be one SendEmail method.

    public static void main(String []args) {
        
		// Create Outlook instance
        Outlook outlook = new Outlook(
            "JuanLopez@prodigious.com", 
            "LuisaGil@prodigious.com",
            "What's the point of the Depencency Inversion?");
            
        // Create Yahoo instance
        Yahoo yahoo = new Yahoo(
            "LuisaGil@prodigious.com",
            "JuanLopez@prodigious.com", 
            "Basically, depend on abstractions, not concretions");
        
		// Create EmailServer instance
        EmailServer emailSender = new EmailServer();
        
		// Call SendEmail methods
        emailSender.SendEmail(outlook);
        emailSender.SendEmail(yahoo);
    }
     
    // EmailSender interface
    public interface EmailSender {
		
		// EmailSender Send method
        void Send(String emailFrom, String emailTo, String message);
    }
    
	// Outlook class
    static class Outlook {
        
		// Outlook private fields
        private String _emailFrom;
        private String _emailTo;
        private String _message;
        
		// Outlook constructor
        public Outlook(String emailFrom, String emailTo, String message) {
            _emailFrom = emailFrom;
            _emailTo = emailTo;
            _message = message;
        }
        
		// Outlook Send method
        public void Send() {
            System.out.println("Sending email from Outlook:");
            System.out.println("From: " + _emailFrom);
            System.out.println("To: " + _emailTo);
            System.out.println("Message: " + _message);
        }
    }
    
	// Yahoo class
    static class Yahoo {
        
		// Yahoo private fields
        private String _emailFrom;
        private String _emailTo;
        private String _message;
        
		// Yahoo constructor
        public Yahoo(String emailFrom, String emailTo, String message) {
            _emailFrom = emailFrom;
            _emailTo = emailTo;
            _message = message;
        }
        
		// Yahoo Send method
        public void Send() {
            System.out.println("Sending email from Yahoo:");
            System.out.println("From: " + _emailFrom);
            System.out.println("To: " + _emailTo);
            System.out.println("Message: " + _message);
        }
    }
    
    // EmailServer class
    static class EmailServer {
        
		// EmailServer constructor
		public EmailServer() { }
        
		// EmailServer SendEmail method
        public void SendEmail(Yahoo email) {
            email.Send();
        }
        
		// EmailServer SendEmail method
        public void SendEmail(Outlook email) {
            email.Send();
        }
    }
