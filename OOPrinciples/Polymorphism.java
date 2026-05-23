package OOPrinciples;

import java.util.List;

/*
In this file, you will learn about Polymorphism in Java.

* Core Concept: Polymorphism is the ability of an object to take on many forms. It allows a superclass reference
  to point to a subclass object.
* Runtime Dispatch: When an overriden method is invoked through a superclass reference, Java dynamically determines
  which method version to execute based on the actual object type in memory—not the reference variable type.
* Field Hiding Rule: Unlike methods, variable fields are **not** polymorphic! Fields do not participate in dynamic
  binding. If both parent and child define an identical field variable, referencing the variable yields the parent
  type's value when upcast.
*/
public class Polymorphism {

    static class NotificationSystem {
        public String typeMarker = "GENERIC_SYSTEM";

        public void dispatchAlert() { System.out.println("Dispatching basic notification alerts..."); }
    }

    static class SlackNotification extends NotificationSystem {
        public String typeMarker = "SLACK_INTEGRATION"; // Shadowing/Hiding field variable

        @Override
        public void dispatchAlert() { System.out.println("Sending encrypted webhook payload to Slack workspace..."); }
    }

    public static void main(String[] args) {
        /* Polymorphic reference linkage */
        NotificationSystem alertNode = new SlackNotification();

        // 1. Method Execution (Polymorphic Dynamic Dispatch)
        alertNode.dispatchAlert(); // Executes SlackNotification's method!

        // 2. Variable Field Access (Static Compile-Time Binding)
        System.out.println("Type Marker Value: " + alertNode.typeMarker);
        // TRAP WARNING: Prints "GENERIC_SYSTEM"! Fields are bound at compile time based on the reference type.
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: Explain the functional difference between Method Overriding (Runtime Polymorphism) and Method Overloading
    //     (Compile-time Polymorphism). How do their method signatures differ?
    // Q2: Given the code snippet: `NotificationSystem node = new SlackNotification();`, why can't you access a method
    //     defined exclusively inside `SlackNotification` using the `node` variable without downcasting?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Global Asset Investment Portfolio Evaluator
    Scenario: You are designing an engine for an investment app that evaluates different financial asset classes.

    Requirements:
    1. Create a superclass `FinancialAsset` that defines a `.calculateYield(double marketFluctuation)` calculation contract.
    2. Create distinct subclasses: `StockAsset`, `CryptoAsset`, and `RealEstateAsset`, each overriding the calculation
       method to use its own custom risk profile.
    3. Process a mixed array of these assets polymorphically within a loop, calculating total portfolio valuation shifts.
    */
    // TODO: Implement evaluateTotalPortfolioYield(FinancialAsset[] currentPortfolio, double volatilityIndex);
}