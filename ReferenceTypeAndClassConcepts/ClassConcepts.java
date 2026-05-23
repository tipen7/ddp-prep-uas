/*
In this file, you will study Class Structures and Object Lifecycle mechanics in Java.

* Class vs Object Blueprint:
  - Class: A compile-time layout definition detailing code logic blocks and data structures.
  - Object: A real runtime instance allocated inside Heap memory spaces using the `new` operator.
* Lifecycle Tracking Steps:
  1. Class Loading: JVM loads bytecode fields, allocates space for static variables, and runs static initializer blocks.
  2. Instance Initialization: Runs instance initializer blocks followed by the matching constructor configuration chain.
*/

public class ClassConcepts {

    // Static Initialization Block (Runs once when the class is loaded into memory)
    static {
        System.out.println("Step 1: Class bytecode loaded and static initialization complete.");
    }

    // Instance Initialization Block (Runs every time a new object instance is created, right before the constructor)
    {
        System.out.println("Step 2: Memory space allocated. Instance initialization block active.");
    }

    public ClassConcepts() {
        System.out.println("Step 3: Target Constructor executed successfully.");
    }

    public static void main(String[] args) {
        System.out.println("Triggering allocation event...");
        ClassConcepts allocationUnit1 = new ClassConcepts();
        System.out.println("Triggering secondary allocation event...");
        ClassConcepts allocationUnit2 = new ClassConcepts();
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: What is the exact execution order of static initialization blocks, instance initialization blocks,
    //     and constructors when a subclass extending a parent class is instantiated for the first time?
    // Q2: What happens if a constructor is declared as `private`? How can an outside class instantiate
    //     this object? Name a common creational design pattern that uses this approach.

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Database Connection Pool Coordinator
    Scenario: Design a central controller class to manage database connection allocations.

    Requirements:
    1. Create a class `DatabasePoolManager`. Use a static initialization block to pre-load global driver configurations.
    2. Use an instance initialization block to assign a unique microsecond tracking timestamp every time a connection instance is spawned.
    3. Implement a private constructor to enforce the Singleton design pattern, exposing access exclusively through
       a public static factory retrieval method.
    */
    // TODO: Build out the entire pool manager initialization lifecycles.
}