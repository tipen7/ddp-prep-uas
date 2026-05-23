package KeywordModifiers;

/*
In this file, you will learn about the static modifier in Java.

* Core Concept: The `static` keyword binds a member (field or method) directly to the Class definition itself,
  rather than to discrete object instances.
* Memory Allocation: Static variables are allocated exactly once inside the JVM's Metaspace area when the class
  is loaded. Every instance of the class shares the exact same static variable reference.
* Isolation Rule: Static methods can only access other static fields or invoke other static methods.
  They cannot use the `this` reference or access non-static instance fields directly, because they run
  independently of any object instance.
*/
public class Static {

    // Shared global static tracking field variable
    public static int cumulativeSystemNodeAllocationsCount = 0;

    private final String individualNodeInstanceUuid; // Unique instance-level variable field

    public Static(String uuid) {
        this.individualNodeInstanceUuid = uuid;
        cumulativeSystemNodeAllocationsCount++; // Modifies the shared class variable
    }

    public static int getGlobalAllocationPoolSize() {
        // return individualNodeInstanceUuid; // COMPILATION ERROR! Cannot resolve instance variables inside a static context.
        return cumulativeSystemNodeAllocationsCount;
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If two distinct threads execute updates concurrently on a shared variable `public static int counter = 0;`,
    //     explain what race conditions can occur. Is the `static` keyword inherently thread-safe?
    // Q2: What is a static inner class? How does it differ from a standard inner class regarding its connection
    //     to an instance of the outer enclosing class?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Cluster Network Unique Snowflake ID Coordinator
    Scenario: Design a centralized tracking system that generates unique identification keys across an application cluster.

    Requirements:
    1. Implement a class `IdentityCoordinator` that uses a private static tracker variable to maintain sequential numeric states.
    2. Write a static method `.generateClusterUniqueSequenceKey()` that increments the tracker and returns a formatted key string.
    3. Ensure that instance creation is disabled so that developers invoke the identifier generator method directly
       through the class definition interface.
    */
    // TODO: Implement the static tracking IdentityCoordinator engine from scratch.
}