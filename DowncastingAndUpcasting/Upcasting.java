package DowncastingAndUpcasting;

/*
In this file, you will learn about Upcasting in Java.

* Upcasting is casting a subclass reference type to a superclass reference type.
* Safety: It is completely implicit and guaranteed to be safe because a subclass
  "is-a" structural implementation of its parent.
* Polymorphic Access: Once upcast, you can only access methods defined in the superclass type scope.
  Specific child variations are hidden from direct access.
*/
public class Upcasting {

    static class Payment {
        public void execute() { System.out.println("Processing general transactional ledger fund transfer..."); }
    }

    static class CreditCardPayment extends Payment {
        @Override
        public void execute() { System.out.println("Authorizing payment token via credit network clearing house..."); }

        public void checkCVV() { System.out.println("Validating security CVV signatures..."); }
    }

    public static void main(String[] args) {
        /* Example 1: Implicit Upcasting */
        CreditCardPayment visa = new CreditCardPayment();
        Payment processingGate = visa; // Upcast occurs automatically here

        /* Example 2: Dynamic Method Dispatch */
        processingGate.execute(); // Invokes the overriden child execution path at runtime!

        /* INVALID CODE BOUNDS */
        // processingGate.checkCVV(); // COMPILATION ERROR! The reference variable type scope hides specific child methods.
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If Upcasting hides specific child class behaviors, why is it considered one of the most
    //     valuable design patterns in enterprise code structures?
    // Q2: Explain how polymorphism interact with class variable fields. If both parent and child classes
    //     define an identical variable `public int id`, which value is read after an Upcast occurs?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Cloud Notification Streaming Architecture
    Scenario: You need to manage diverse downstream cloud delivery nodes.

    Requirements:
    1. Define a parent abstraction layout `CloudChannel` and subclasses `SMSChannel` and `WebhookChannel`.
    2. Write a batch scheduling engine method that accepts a polymorphic container: `List<CloudChannel>`.
    3. Upcast all channels into the list container collection to iterate cleanly, executing a shared `.transmit()` rule
       while hiding custom connection strings.
    */
    // TODO: Implement routePolymorphicChannels(List<CloudChannel> activeChannels, String payload);
}