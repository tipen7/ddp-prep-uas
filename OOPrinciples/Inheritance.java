package OOPrinciples;

/*
In this file, you will learn about Inheritance in Java.

* Core Concept: Inheritance allows a subclass to inherit attributes and behaviors from a superclass (`extends`).
* Code Reuse: It establishes an "is-a" structural relationship, making it easy to share common functionality
  without duplicating code.
* The Constructor Rule: Constructors are **not** inherited. A subclass constructor must always invoke a constructor
  from its parent class using `super()` as its very first statement. If you don't explicitly add it, the compiler
  implicitly inserts a default, no-argument `super()` call.
*/
public class Inheritance {

    static class CoreServerNode {
        private final String networkAddress;

        // Parameterized constructor - no default constructor is generated automatically now!
        public CoreServerNode(String ip) {
            this.networkAddress = ip;
            System.out.println("Base Server initialized at network port: " + ip);
        }

        public String getNetworkAddress() { return networkAddress; }
    }

    static class EdgeComputeNode extends CoreServerNode {
        private final double processingPowerFlops;

        public EdgeComputeNode(String ip, double computationalCapacity) {
            super(ip); // MANDATORY FIRST LINE. Binds and links data states to the parent constructor frame.
            this.processingPowerFlops = computationalCapacity;
            System.out.println("Edge Compute Extension instantiated with capacity: " + computationalCapacity);
        }
    }

    public static void main(String[] args) {
        EdgeComputeNode node = new EdgeComputeNode("192.168.1.50", 4500.22);
        System.out.println("Active IP pointer target: " + node.getNetworkAddress());
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If a parent class defines a parameterized constructor `public CoreServerNode(String ip)` and does not
    //     explicitly provide a default no-argument constructor, what happens if its subclass constructor omits
    //     the `super(ip)` call? Why?
    // Q2: Why does Java forbid a class from extending multiple parent classes directly? (e.g., `class Child extends ParentA, ParentB`).
    //     What classic structural problem does this prevent?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Enterprise HR Payroll Classification Matrix
    Scenario: Design a specialized employee record tracking framework for an enterprise HR system.

    Requirements:
    1. Implement a base class `Employee` that manages shared parameters (`employeeId`, `legalName`, `baseSalary`).
    2. Build a subclass `ExecutiveEmployee` that extends `Employee` and adds unique fields for tracking quarterly bonuses.
    3. Enforce proper state initialization across the inheritance chain by ensuring the child constructor correctly
       forwards arguments to the parent class.
    */
    // TODO: Build out the Employee inheritance tree model structures based on these instructions.
}