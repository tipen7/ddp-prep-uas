package AutoboxingAndUnBoxing;

import java.util.*;

/*
In this file, you will learn about Autoboxing in Java.

* Autoboxing is the automatic conversion that the Java compiler makes between
  primitive types (e.g., int, double) and their corresponding object wrapper classes (e.g., Integer, Double).
* Performance Cost: Autoboxing allocates heap objects. Inside heavy loops, this creates
  severe garbage collection overhead.
* Cached Objects: Java caches wrapper objects for low ranges to save memory:
  - Integer, Long, Short, Byte: -128 to 127
  - Character: 0 to 127
  - Boolean: true and false values
*/
public class Autoboxing {

    public static void main(String[] args) {
        /* Example 1: Implicit Autoboxing */
        int primitiveInt = 42;
        Integer wrappedInt = primitiveInt; // Automatic conversion via Integer.valueOf(42)

        /* Example 2: The Identity Trap (Caching System) */
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // Prints true (References point to the same cached instance)

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // Prints false (Outside cache bounds! New heap allocations)
        System.out.println(c.equals(d)); // Prints true (Correct way to evaluate identity values)

        /* ======================================================================================================== */
        /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
        /* ======================================================================================================== */
        // Q1: Look at this loop: Double sum = 0.0; for(int i=0; i<1_000_000; i++) { sum += i; }
        //     Explain why this causes high latency and severe memory allocation bloat on the Heap.
        // Q2: Why does `Long x = 127L; Long y = 127L; System.out.println(x == y);` evaluate to true,
        //     but changing the values to `128L` evaluates to false?

        /* ======================================================================================================== */
        /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
        /* ======================================================================================================== */
        /*
        CHALLENGE: HFT High-Frequency Trading Aggregator
        Scenario: You are designing an order book processing service. Implement a method that receives a primitive
        array of execution prices: `long[] ticks`.

        Requirements:
        1. Parse the primitive values and filter out prices below a dynamic threshold.
        2. Group the values into a Map where the key represents the integer portion, and the value is a List
           containing wrapped Long instances.
        3. Identify the exact line or block in your code where implicit autoboxing occurs and optimize the stream
           by switching entirely to LongStream collections to measure performance variations.
        */
        // TODO: Implement highPerformanceTickReducer(long[] ticks, long floorThreshold);
    }
}