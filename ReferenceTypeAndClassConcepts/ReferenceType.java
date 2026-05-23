
/*
In this file, you will study Reference Types and Pass-By-Value mechanics in Java.

* Memory Architecture Management:
  - Stack Memory: Stores local variables and reference memory addresses. Extremely fast allocation bounds.
  - Heap Memory: Stores actual object instance states and arrays. Managed by the Garbage Collector (GC).
* Pass-by-Value Rule:
  - Java is strictly Pass-by-Value.
  - For primitives, a copy of the actual value is passed to methods.
  - For objects, a copy of the reference address is passed. Both references still point to the same object in Heap memory.
*/
public class ReferenceType {

    static class DataNode { int numericPayload = 10; }

    public static void modifyState(int localPrimitive, DataNode localReference) {
        localPrimitive = 999; // Modifies only the isolated primitive copy inside the local Stack frame.
        localReference.numericPayload = 555; // Modifies the actual object instance state in Heap memory!

        // Reassigning the reference variable local link inside the method scope
        localReference = new DataNode();
        localReference.numericPayload = 888; // Does NOT affect the original caller's reference variable pointer.
    }

    public static void main(String[] args) {
        int primitiveData = 10;
        DataNode trackingNode = new DataNode();

        System.out.println("Pre-invocation values: Primitive=" + primitiveData + ", Object payload=" + trackingNode.numericPayload);
        modifyState(primitiveData, trackingNode);
        System.out.println("Post-invocation values: Primitive=" + primitiveData + ", Object payload=" + trackingNode.numericPayload);
        // Expected output: Primitive remains 10, Object payload becomes 555
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: Explain why reassigning an object reference parameter inside a method body via `node = new DataNode();`
    //     has no effect on the original reference variable pointer used by the caller.
    // Q2: What is a memory leak in Java? How can an object still occupy space in Heap memory even if it is no
    //     longer being used by active application threads?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: High-Performance Cache Eviction Tracker
    Scenario: Verify how reference paths change across system execution boundaries.

    Requirements:
    1. Create a method that accepts an array list containing data cache node structures.
    2. Modify internal status flags inside the individual nodes directly during execution.
    3. Swap element locations within the array container list using indices.
    4. Write a verification check to prove that data mutation persists across scope boundaries, while reference
       reassignments remain completely local to the executing method stack frame.
    */
    // TODO: Build out the cache eviction pointer tracker simulator tool.
}