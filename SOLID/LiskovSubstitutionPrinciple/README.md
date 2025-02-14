Liskov Substitution Principle - if class A is a subtype of class B, then we should be able to replace objects of B with objects of A (i.e., objects of type A may substitute objects of type B) without changing the behavior (correctness, functionality, etc.) of our program.

“Derived types must be completely substitutable for their base types”

In Layman’s terms, it states that an object of a superclass should be replaceable by objects of its subclasses without causing issues in the application. Therefore, a child class should never change the characteristics of its parent class (such as the argument list and return types). Basically, derived classes should never do less than their base class.

Why is it required to follow Liskov Substitution Principle?
This avoids overuse/misuse of inheritance. It helps us conform to the “is-a” relationship. We can also say that subclasses must fulfil a contract defined by the base class.

Example: Code that violates LSP
Suppose a book store asks us to add a new type of book delivery functionality in the application. So, we create a BookDelivery class that informs customers about the number of locations where they can collect their order from as below:

public class BookDelivery {

     String titles;
     Integer userID;

     void getDeliveryLocations() {
           ...
     }
}
However, the store also sells fancy poster maps they only want to deliver to their high street shops. So, we create a new PosterMapDelivery subclass that extends BookDelivery and overrides the getDeliveryLocations() method with its own functionality:

public class PosterMapDelivery extends BookDelivery {

     @Override
     void getDeliveryLocations() {
              ...
     }
}
Later, the store asks us to create delivery functionalities for audiobooks, too. Now, we extend the existing BookDelivery class with an AudioBookDelivery subclass. But, when we want to override the getDeliveryLocations() method, we realize that audiobooks can’t be delivered to physical locations.

public class AudioBookDelivery extends BookDelivery {

     @Override
     void getDeliveryLocations() {

           /* can't be implemented since

            * Audio book doesn't have

            * a physical location. */

     }

}

We could change some characteristics of the getDeliveryLocations() method, however, that would violate the Liskov’s Substitution Principle. After the modification, we couldn’t replace the BookDelivery superclass with the AudioBookDelivery subclass without breaking the application.

Example: Code that follows LSP
In order to solve the problem, we need to fix the inheritance hierarchy. Let’s introduce an extra layer that better differentiates book delivery types. The new OfflineDelivery and OnlineDelivery classes split up the BookDelivery superclass. We will also move the getDeliveryLocations() method to OfflineDelivery. Next, we will create a new getSoftwareOptions() method for the OnlineDelivery class (as this is more suitable for online deliveries). For example, below code demonstrates the concept.

public class BookDelivery {

     String title;
     Integer userID;

}


public class OfflineDelivery extends BookDelivery {

     void getDeliveryLocations() {
          ...
     }
}


public class OnlineDelivery extends BookDelivery {

     void getSoftwareOptions() {
          ...
     }
}

In the refactored code, PosterMapDelivery will be the child class of OfflineDelivery and it will override the getDeliveryLocations() method with its own functionality.

AudioBookDelivery will be the child class of OnlineDelivery which is good news, as now it doesn’t have to deal with the getDeliveryLocations() method. Instead, it can override the getSoftwareOptions() method of its parent with its own implementation (for instance, by listing and embedding available audio players).

public class PosterMapDelivery extends OfflineDelivery {

     @Override
     void getDeliveryLocations() {
          ...
     }

}

public class AudioBookDelivery extends OnlineDelivery {

     @Override
     void getSoftwareOptions() {
          ...
     }

}

After the refactoring, we could use any subclass in place of its superclass without breaking the application.

Violations of LSP cause undefined behavior. Undefined behavior means that it works okay during development but blows up in production, or that you spend weeks debugging something that only occurs once per day, or that you have to go through hundreds of megabytes of logs to figure out what went wrong.

What is the benefit of Liskov Substitution Principle?
If your code follows the Liskov’s Substitutional Principle, you will have below benefits:

1) Code Reusability
2) Easier Maintenance
3) Reduced Coupling

