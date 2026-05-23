package ExceptionHandlingFlow;

import java.io.IOException;

/*
In this file, you will learn about the structural flow of Exception Handling in Java.

* Throwable Hierarchy:
  - Error: Fatal conditions outside application scope control (e.g., OutOfMemoryError). Banned from catch handling.
  - Exception (Checked): Must be explicitly handled or declared in the method signature (e.g., IOException).
  - RuntimeException (Unchecked): Programming logic bugs (e.g., NullPointerException). Optional validation mapping.
* Flow Control Rules:
  - try: Defines the boundary of protected execution.
  - catch: Catches matching exceptions. Evaluates sequentially from specific subclasses to general parent exceptions.
  - finally: Guaranteed execution block regardless of exceptions. Used to clean up database connections or file handles.
*/
public class ExceptionHandling {

    // Custom Domain Exceptions
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String msg) { super(msg); }
    }

    public static void main(String[] args) {
        /* Example 1: Specific Catch Sequence Flow */
        try {
            double balance = 50.0;
            if (balance < 100) throw new InsufficientFundsException("Balance below threshold margin.");
            throw new IOException("Network dropped during clearing.");
        } catch (InsufficientFundsException e) {
            System.out.println("Domain catch block intercepted: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("System IO error caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic fallback catch block executed.");
        } finally {
            System.out.println("Resource cleanup complete.");
        }

        /* INVALID CODE PATTERNS */
        /*
        try {
            throw new IOException();
        } catch (Exception e) { ... }
          catch (IOException e) { ... }
          // COMPILATION ERROR! Parent Exception cannot precede its subclass child exception block. Unreachable code.
        */
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If a method body runs `return 1;` inside the `try` block, but its `finally` block runs `return 2;`,
    //     what value is returned to the caller? Explain how this edge case disrupts predictable code flow.
    // Q2: What is the difference between the `throw` keyword and the `throws` keyword in terms of architecture?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Multi-Tier Failover Transaction Pipeline
    Scenario: You are designing a settlement network router. Create a method handling nested validation scopes.

    Requirements:
    1. Attempt to execute a primary database persistence route.
    2. If a network `TimeoutException` occurs, intercept it and run a fallback secondary storage tracking route.
    3. If the fallback also throws a fatal `SQLException`, wrap the root cause inside a custom runtime domain exception
       `TransactionFailureException` using Exception Chaining (passing the root cause to the constructor) to preserve the stack trace.
    4. Ensure the transaction lock is always released inside a `finally` block.
    */
    // TODO: Implement executeResilientTransaction(TransactionPayload data);
}