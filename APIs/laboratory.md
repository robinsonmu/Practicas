# APIs - Laboratory

## Overview ##


In this practice, you will learn how to develop REST APIs by using Spring Data REST and Spring Boot. During the laboratory; you will create a new Spring Boot application, create a JPA entity and use Spring Data REST to provide basic operations. You will also learn how to validate the data your API is dealing with, as well as how to protect your application.

Don’t worry If you haven’t used Spring yet to develop an application, this laboratory will be very straightforward since its intention is to give you an idea of building an API in the real life. If you don't have previous experience with Java you can follow this laboratory along, learn how to develop RESTful APIs with Spring Boot and Spring Data REST and after that, learn about the new terms as you go along.

## Introduction ##

Developing RESTful APIs has became the most popular approach backend developers take advantage to provide an interface for their applications. Spring community built Spring Data REST; a framework that eases the life of developers while creating these APIs. Spring Boot, along with Spring Data REST, give you the power to create APIs ready for production in a very short time.

*Spring Data REST builds on top of Spring Data repositories, analyzes your application’s domain model and exposes hypermedia-driven HTTP resources for aggregates contained in the model.* - **[Spring Data REST](https://spring.io/projects/spring-data-rest/)**


## What You Will Create ##

A simple RESTful API that exposes CRUD (Create, Retrieve, Update, and Delete) operations over an entity called `Offer`. For the purpose of this laboratory, the `Offer` entity will represent a Car Deal available in a Car Dealership. Your API will allow users to manipulate Offers that contains information like brand, model, year, details and price.

While developing this RESTful API, you will learn how to:

*	Provide an API with different basic operations over the entity created
*	Validate data
*	Secure the API

## What You Need ##

You will will need Java 8 or superior (up to Java 11). If you don't have Java installed yet, please refer to  **[the official documentation](https://docs.oracle.com/javase/8)** to install it in your local environment. Furthermore, you will need an IDE (Integrated Development Environment) to help you in the development process (e.g. **[IntelliJ IDEA](https://www.jetbrains.com/idea/)**, **[https://www.eclipse.org/ide/](Eclipse)**, and **[https://netbeans.org/](NetBeans)**). If you don't have one yet, try with **[the community version of IntelliJ IDEA](https://www.jetbrains.com/idea/download/)**.

## Before you start ##

Before starting to develop the RESTful API, you will need to generate the spring boot project with just what you need to start.

Open the **[Spring Initializr website](https://start.spring.io/)** and fill the form as follows:

*	Generate a Gradle Project with Java and Spring Boot 2.X 
*	**Group:** com.pdg
*	**Artifact:** offers
*	**Name:** offers
*	**Description:** Demo project for Spring Boot
*	**Packaging:** Jar
*	**Java:** 8

Then add the following Dependencies, use the search for dependencies field to add them:

*	**Spring Web:** A library that helps you build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
*	**Rest Repositories:** The library that will allow you to expose your database as a RESTful API.
*	**JPA:** The Java Persistence API library that will help you map SQL databases to objects and vice-versa.
*	**Lombok:** Java annotation library that helps you to reduce boilerplate code.
*	**HyperSQL Database SQL:** library that will allow you to have a Lightweight 100% Java SQL Database Engine instead of having to install and configure a new one.

Click on the Generate Project button to download your new application. Once done, extract the downloaded .zip file and move the extracted folder to a desired location.

Use your IDE to open your new project. E.g. If you are using IntelliJ IDEA. Click Open and then select the extracted folder called offers.

Let's start.

## 1. Creating a RESTful API with Spring Data REST ##

Now that you have created the new Spring Boot project and that you have opened it in your IDE, the first thing you will do is to create the JPA entity that you will expose with the help of Spring Data REST. To do this, create a new class called `Offer.java` inside the `com.pdg.offers` package and add the following code to it:

```java
package com.pdg.offers;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@EqualsAndHashCode
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String model;
    private String year;
    private String details;
    private BigDecimal price;

    public Offer(Long id, String brand, String model, String year, String details, BigDecimal price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.details = details;
        this.price = price;
    }

    protected Offer() {
    }
}
``` 

You already defined a new JPA `@Entity` called `Offer` to hold five different fields. Most of these fields are self-explanatory. However, the only one that might need further explanation is the Long `id` field. As you can notice, this field is marked with two annotations:

*	`@Id`: This annotation marks the field as the unique identifier of the ad (i.e., the primary key in the database).
*	`@GeneratedValue`: This annotation tells JPA that the database will need to supply its value. In this case, the database will auto-generate (GenerationType.AUTO) this field, no matter how (the strategy to do so depends on what database you are using).

After creating the `Offer` JPA entity, you will need to focus on creating a class that will allow you to interface with the database. Also, you will need to map the database operations into RESTful API endpoints so external clients can use them. Sounds like a lot of work? On the contrary! This is where Spring Data REST shines.

To achieve both things described in the last paragraph (map to the database and expose the operations in your API), you will need to do only one thing. You will need to create an interface called `OfferRepository` (inside the `com.pdg.offers` package) and add the following code to it:

```java
package com.pdg.offers;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OfferRepository extends PagingAndSortingRepository<Offer, Long> {
}
```

With the `OfferRepository` interface in place, the application is ready to be executed and start sending requests to it. What is happening here is that Spring Boot and Spring Data REST identify that you have created an interface which extends `PagingAndSortingRepository` and work together to create a number endpoints for you.

`PagingAndSortingRepository` interface is an extension of `CrudRepository` to provide additional methods to retrieve entities using pagination and sorting. To be more specific, as described on the **[Core Concepts](https://docs.spring.io/spring-data/data-commons/docs/2.2.6.RELEASE/reference/html/#repositories.core-concepts)** documentation of the Spring Data library, together, `PagingAndSortingRepository` and `CrudRepository` add the methods below to your application to allow it to handle your entities on a SQL database:

*	`save(S entity)`: This method enables the app to insert or update entities.
*	`findById (ID id)`: This method enables the app to retrieve an entity based on its primary key.
*	`findAll()`: This method enables the app to retrieve all entities saved on the database.
*	`Long count()`: This method that returns the number of entities available on the database.
*	`delete(T entity)`: This method enables to delete a given entity.
*	`existsById(ID id)`: This method returns whether an entity with the given id exists.

Since you are using Spring Data REST, this library creates RESTful endpoints to exposes all the methods defined by `PagingAndSortingRepository` and `CrudRepository`.

To see all this in action, you can run the application from the IDE, or you can execute the following comand in a terminal (from the project root):

`./gradlew bootRun`

Once the application is running, you can start sending HTTP requests to those endpoints. To do so, you can use a graphical HTTP client like Postman, or you can open a new terminal and use a tool like curl(which is how we are going to do it during this laboratory, through the terminal). 

The next section will show you how to use curl to send some requests to your new application. 

Note: You will know that the application is running when you see a message similar to 

```
2020-04-03 15:19:01.214  INFO 11251 --- [main] com.pdg.offers.OffersApplication : Started OffersApplication in 4.014 seconds (JVM running for 4.291)
2020-04-03 15:19:32.726  INFO 11251 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]: Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-04-03 15:19:32.726  INFO 11251 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet: Initializing Servlet 'dispatcherServlet'
2020-04-03 15:19:32.742  INFO 11251 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet: Completed initialization in 16 ms
<=========----> 75% EXECUTING 
> :bootRun
```

### Testing the Spring Data REST endpoints ##

To confirm that your application is working properly, you can send the following request (run the command below in a new terminal):

```
#check if there are offers persisted
curl http://localhost:8080/offers
```

Running this command will make your API return all the offers persisted on the database (which will be none:  "offers" : [ ] , and a few other things like:

* `page.size`: the number of offers that the API will return on each page (20).
* `page.totalElements`: the number of offers returned on this page (0).
* `page.totalPages`: the number of pages available (0).
* `page.number`: the current page number (0).


As you haven't created any entity yet, the results won't be very interesting. So, the next thing you can do is to issue a request to insert a new Offer in your API:

```
# insert a new Offer
curl -X POST -H "Content-Type:application/json" -d '{
    "brand": "Subaru",
    "model": "Ascent",
    "year": "2020",
    "details": "2020 Subaru Ascent Sport Utility. 8-Passenger Specs. Automatic Transmission",
    "price": 31.995
}' http://localhost:8080/offers 
```

```json
{
  "brand" : "Subaru",
  "model" : "Ascent",
  "year" : "2020",
  "details" : "2020 Subaru Ascent Sport Utility. 8-Passenger Specs. Automatic Transmission",
  "price" : 31.995,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/offers/1"
    },
    "offer" : {
      "href" : "http://localhost:8080/offers/1"
    }
  }
}
```

By executing this command, the output will show the details of the `offer` created (all the properties above) along with a link to the ad itself `self.href`. If you execute this link through a curl command, it will retrieve the details of the Offer:

```
#retrieve the new offer
curl http://localhost:8080/offers/1
```
Now, if you run the command to see the list of persisted offers again:

```
curl http://localhost:8080/offers
```

The offers array now includes the new offer and that the page properties (size, totalElements, totalPages, number) are updated respectively:

```json
{
  "_embedded": {
    "offers": [
      {
        "brand": "Subaru",
        "model": "Ascent",
        "year": "2020",
        "details": "2020 Subaru Ascent Sport Utility. 8-Passenger Specs. Automatic Transmission",
        "price": 31.99,
        "_links": {
          "self": {
            "href": "http://localhost:8080/offers/1"
          },
          "offer": {
            "href": "http://localhost:8080/offers/1"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/offers{?page,size,sort}",
      "templated": true
    },
    "profile": {
      "href": "http://localhost:8080/profile/offers"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 1,
    "totalPages": 1,
    "number": 0
  }
}
```


If you want, you can delete the offer by executing the following command:

```
curl -X DELETE http://localhost:8080/offer/1
```

After creating the base application with the Spring Initializr, you just had to define two things: the Offer entity and the OfferRepository interface to have a runnable RESTful API.

## 2. Data Validation

Let's validate the data by using the Bean Validation Java specification. This is as easy as adding some annotations to the fields in your JPA entity. 

Open the `Offer.java` class and update the code as follows:

```java
package com.pdg.offers;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Getter
@EqualsAndHashCode
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Which is the brand of the Car in the offer?")
    private String brand;

    @NotNull(message = "Please, inform the model of the Car in the offer.")
    private String model;

    @Size(min = 4, max = 4, message = "Year must have {min} characters.")
    private String year;

    @NotNull(message = "Please, inform the details for the offer.")
    @Size(min = 10, max = 600, message = "Details must have between {min} and {max} characters.")
    private String details;

    @Min(message = "Price cannot be negative", value = 0)
    private BigDecimal price;

    public Offer(Long id, String brand, String model, String year, String details, BigDecimal price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.details = details;
        this.price = price;
    }

    protected Offer() {
    }
}
```

The new version of this entity contains three new annotations:

* `@Min`: The value of the field or property must be an integer value greater than or equal to the number in the value element.
* `@NotNull`: The value of the field or property must not be null. In the case above, you are marking brand, model and details as required fields.
* `@Size`: The size of the field or property is evaluated and must match the specified boundaries. For example, on the code above, you are making sure you won't persist offers with details that contain less than 10 characters or more than 600 characters.

Once updating the `Offer.java` class, you can run your application again. When the app finishes starting, you can send requests like the following to make sure that the restrictions are working as expected:

```
# it won't work since there are too few characters on the details property
curl -X POST -H "Content-Type:application/json" -d '{
    "brand": "Seat",
    "model": "Ibiza",
    "year": "2019",
    "details": "Ibiza P",
    "price": 25.990
}' http://localhost:8080/offers 

# it won't work since the price is negative
curl -X POST -H "Content-Type:application/json" -d '{
    "brand": "Seat",
    "model": "Ibiza",
    "year": "2019",
    "details": "Ibiza PCP offer with USD 1,750 towards your deposit at 5.9% APR Representative Finance",
    "price": -20
}' http://localhost:8080/offers 

# it won't work, there is no details
curl -X POST -H "Content-Type:application/json" -d '{
    "brand": "Seat",
    "model": "Ibiza",
    "year": "2019",
    "price": 25.990
}' http://localhost:8080/offers 

# it will work, all properties contain valid values
curl -X POST -H "Content-Type:application/json" -d '{
    "brand": "Seat",
    "model": "Ibiza",
    "year": "2019",
    "details": "Ibiza PCP offer with USD 1,750 towards your deposit at 5.9% APR Representative Finance",
    "price": 25.990
}' http://localhost:8080/offers 
```

While sending the invalid requests above, the first three, you will see that your app returns a response that looks like this:


```json
{
	"timestamp": "2020-04-03T23:27:33.172+0000",
	"status": 500,
	"error": "Internal Server Error",
	"message": "Could not commit JPA transaction; nested exception is 	javax.persistence.RollbackException: Error while committing the transaction",
	"path": "/offers"
}
```

Although this response seems to be enough for the user to understand that something went wrong, it doesn't help to identify what just exactly happened. To improve this, you can create a new class called `ApiExceptionHandler ` inside the com.pdg.offers package and add the following code to it:

```java
package com.pdg.offers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TransactionSystemException.class)
    
    protected ResponseEntity<List<String>> handleTransactionException(TransactionSystemException ex) throws Throwable {
        
        Throwable cause = ex.getCause();
        if (!(cause instanceof RollbackException)) throw cause;
        if (!(cause.getCause() instanceof ConstraintViolationException)) throw cause.getCause();
        ConstraintViolationException validationException = (ConstraintViolationException) cause.getCause();
        List<String> messages = validationException.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        
        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }
}
```
With this class you are creating and registering a global exception handler for the application:

* Inside this handler, you are defining a method that will catch instances of TransactionSystemException to unwrap the problem through ex.getCause(). 
* If the unwrapped exception is not an instance of RollbackException, this method will throw the underlying exception.
* If the unwrapped problem is an instance of RollbackException, the method unwraps the cause one more time through cause.getCause(). This time, we want to check if the second unwrap is an instance of ConstraintViolationException. If this is not the case, the unwrapped result is thrown. If this is the case, this method generates a list of messages to send it back as a response.

After creating this exception handler, if you restart your app and issue bogus requests, you will get some friendly messages. For example, if you issue the following request:

```
curl -X POST -H "Content-Type:application/json" -d '{
    "brand": "Seat",
    "model": "Ibiza",
    "year": "2019",
    "details": "Ibiza P",
    "price": -25.990
}' http://localhost:8080/offers

```

You will get a list of messages as follows:

```
[
    "Details must have between 10 and 600 characters.",
    "Price cannot be negative"
]
```

## 3. Securing Spring Data REST APIs


So far, you were able to create a backend application that exposes a number of RESTful APIs and you also were able to extend it with data validation. 

To add a security layer, you will need to add the Spring Security framework on top of your application. This will use **[Auth0](https://auth0.com/docs/getting-started/overview)** to generate and validate access tokens.

Below you will make your project import two new dependencies. The first one is the Spring Boot extension for the Spring Security framework. The second one is a library that facilitates configuring **[OAuth (the authorization framework)](https://auth0.com/docs/protocols/oauth2)** that is used by Auth0.

To add them, open the build.gradle file of your project and update it like this:

```
// ... leave everything else as it is ...

dependencies {
    // ... leave everything else as it is ...
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:2.2.6.RELEASE'
}
```

Once these new dependencies are imported, you will need to: 

* 1. Add some properties to the application.properties file to configure these dependencies 
* 2. Create a class to define how the endpoints will be accessible.

However, before doing that, you will have to configure an Auth0 API to represent you RESTful backend.

Here you will need to create an Auth0 account: **[sign up for a free one](https://auth0.com/signup)**.

While signing in, pick a name for your Tenant(e.g., api-rest-lab.auth0.com). Once signed in, go to the APIs section of your Auth0 Dashboard and click on the Create API button. 

Auth0 will ask you for three things:

* `Name`: A friendly name for the API. You can use something like "Spring Data REST Laboratory").
* `Identifier`: A logical identifier for the API you are creating. You can use something like https://offers-api
* `Signing Algorithm`: Leave it as RS256.

Once this form filled, click on the Create button and then back to your project, open the application.properties file and add the following to it:

```
/src/main/resources/application.properties
security.oauth2.resource.jwk.keySetUri=https://${AUTH0-DOMAIN}/.well-known/jwks.json
security.oauth2.resource.id=https://offers-api
```

You will have to replace the `${AUTH0-DOMAIN}` placeholder with your Auth0 domain (api-rest-lab.auth0.com) and this way, the resource.id will point to the identifier you used during the register of your API.

With all the above in place, you will have to create a new class called SecurityConfig inside the com.auth0.offers and add the following code to it:

```java
package com.pdg.offers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter{
    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/offers/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(resourceId);
    }
}
```

The code in this class is very simple. You are using some Spring Boot annotations: @Configuration and @Value, to make Spring configure the class during running the app. 

Additionally, you are defining two `configure` methods to tell the application how the Spring Security framework should behave:

* The first `configure` method is telling the framework that all calls to /offer/** must be authenticated. 
* The second `configure` method is telling the ResourceServerSecurityConfigurer to use the value you added to the security.oauth2.resource.id property as the resourceId.

After creating your Auth0 API and adding the changes described above, restart your application one more time and send the following request:

`curl http://localhost:8080/offers`

This request or any other endpoint starting with /offers that do not have an access token, will response the following:

```json
{
	"error": "unauthorized",
	"error_description": "Full authentication is required to access this resource"
}
```

In order add a proper access token to our API offers requests, back to your Auth0 Dashboard and open the API you just created: APIs > Spring Data REST Laboratory and go to the Test. Here you will see a Response section that contains an `access_token` value. This value will provide you a temporary token which can be used to test your API endpoints.

Finally, use your terminal to send an HTTP request to your API with the valid token:

```
# use the token to set the TOKEN variable
TOKEN=eyJhbGci...Dkow

# send an authenticated HTTP request
curl -H 'Authorization: Bearer '$TOKEN http://localhost:8080/offers
```

You should have been able to consume your services again.