package DowncastingAndUpcasting;

/*
In this file, you will learn about Downcasting in Java.

* Downcasting is casting a superclass reference back to a subclass reference type.
* Danger Control: It must be explicitly declared and verified. Casting an invalid reference type
  throws a ClassCastException at runtime.
* Protection Rules: Always protect downcasts using the `instanceof` check operator or
  Modern Java Pattern Matching context rules.
*/
public class Downcasting {

    static class RemoteWorker {}
    static class Engineer extends RemoteWorker {
        public void writeCode() { System.out.println("Compiling codebase files..."); }
    }
    static class Accountant extends RemoteWorker {}

    public static void main(String[] args) {
        RemoteWorker staff1 = new Engineer(); // Implicit upcast
        RemoteWorker staff2 = new Accountant(); // Implicit upcast

        /* Example 1: Standard Protected Downcast */
        if (staff1 instanceof Engineer) {
            Engineer dev = (Engineer) staff1; // Explicit downcast
            dev.writeCode();
        }

        /* Example 2: Modern Pattern Matching Downcast (Java 14+) */
        if (staff1 instanceof Engineer dev) {
            dev.writeCode(); // Automatically cast and assigned inside scoped code execution bounds
        }

        /* Example 3: The Runtime Trap */
        try {
            Engineer falseCast = (Engineer) staff2; // Compiles, but CRASHES at runtime!
        } catch (ClassCastException e) {
            System.out.println("Safely intercepted an invalid Downcast ClassCastException!");
        }
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: Why does the Java compiler allow `Engineer dev = (Engineer) staff2;` to compile cleanly even though
    //     staff2 points to an `Accountant` object instance in heap memory?
    // Q2: Explain how pattern matching `instanceof` improves code readability and safety compared to explicit downcasting blocks.

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Media Processing Pipeline
    Scenario: You are designing an asset pipeline processing a mixed payload array: `Object[] assets`.

    Requirements:
    1. Evaluate the collection pipeline using dynamic casting checks.
    2. If the item type is cast to a `VideoAsset`, invoke its custom method `.transcode(String codec)`.
    3. If the item type evaluates to an `ImageAsset`, extract its `.compress()` routine.
    4. Safely discard any unsupported reference types without causing processing pipeline failure exceptions.
    */
    // TODO: Implement processComplexMediaPayloads(Object[] assets);
}