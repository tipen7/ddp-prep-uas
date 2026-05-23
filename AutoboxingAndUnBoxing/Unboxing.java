package AutoboxingAndUnBoxing;

import java.util.*;

/*
In this file, you will learn about Unboxing in Java.

* Unboxing is the reverse process of autoboxing: converting an object of a wrapper
  class (e.g., Integer) back into its corresponding primitive type (e.g., int).
* The Danger Zone: Unboxing implicitly calls method conversions like `.intValue()` or `.doubleValue()`.
  If the wrapper object reference is literal `null`, this operation throws a NullPointerException (NPE).
*/
public class Unboxing {

    public static void main(String[] args) {
        /* Example 1: Implicit Unboxing */
        Integer wrappedCount = Integer.valueOf(10);
        int primitiveCount = wrappedCount; // Automatic conversion via .intValue()

        /* Example 2: The Unboxing Crash Trap */
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Laptop", 5);
        inventory.put("Phone", null); // Valid mapping entry

        try {
            int phoneStock = inventory.get("Phone"); // CRASHES! Implicitly invokes .intValue() on a null value.
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException due to implicit unboxing!");
        }

        /* ======================================================================================================== */
        /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
        /* ======================================================================================================== */
        // Q1: Given the expression: `Integer val = null; if (val == 0) { ... }`, why does the condition fail
        //     at runtime with an NPE instead of evaluating safely to false?
        // Q2: How does a ternary assignment like `double d = (condition) ? Double.valueOf(1.0) : null;`
        //     behave when condition is false? Explain the internal compiler conversion step.

        /* ======================================================================================================== */
        /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
        /* ======================================================================================================== */
        /*
        CHALLENGE: Telemetry Processing Engine
        Scenario: You receive metric readings from IoT sensors packed inside a collection: `List<Double> sensorOutputs`.
        Some values are recorded as `null` representing transmission dropouts.

        Requirements:
        1. Write a processing matrix method that safely evaluates these inputs.
        2. Calculate the total metric sum without letting any null values trigger a NullPointerException during iteration.
        3. Convert the safe results back into a primitive double array (`double[]`) using an optimized, zero-allocation loop.
        */
        // TODO: Implement processSafeTelemetry(List<Double> sensorOutputs);
    }
}