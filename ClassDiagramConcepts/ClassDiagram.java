package ClassDiagramConcepts;

import java.util.List;

/*
In this file, you will learn how Unified Modeling Language (UML) Class Diagram
relationships map directly into Java Source Code structures.

Relationships Reference Matrix:
1. Dependency ("uses-a"): Short-term relationship. A class accepts another class as a method parameter.
2. Association ("has-a"): Structural relationship. A class retains a reference to another class as an instance field.
3. Aggregation ("has-a" weak structural): Parent can exist independently of the child (e.g., Department and Professor).
4. Composition ("has-a" strong ownership): Child cannot exist without the parent (e.g., Room inside a House).
5. Inheritance ("is-a"): Explicit class extension using the `extends` keyword.
6. Realization ("implements"): Class implements a defined structural contract using the `implements` keyword.
*/
public class ClassDiagram {

    // 1. COMPOSITION: Engine instance lifespan is bound directly to Car construction/destruction bounds
    static class Engine {
        private final String serialNumber;
        public Engine(String sn) { this.serialNumber = sn; }
    }

    // 2. AGGREGATION: Wheel objects can survive outside the Car scope context
    static class Wheel {
        private int psi;
        public Wheel(int psi) { this.psi = psi; }
    }

    static class Car {
        private final Engine engine; // Composition association
        private List<Wheel> wheels;   // Aggregation association

        public Car(String engineSn, List<Wheel> outsideWheels) {
            this.engine = new Engine(engineSn); // Instantiated inside parent scope = Composition
            this.wheels = outsideWheels;        // Assigned from outside scope = Aggregation
        }

        // 3. DEPENDENCY: Short-lived linkage. Tool is used only within this specific execution thread
        public void repair(DiagnosticTool tool) {
            tool.runScan(this);
        }
    }

    static class DiagnosticTool {
        public void runScan(Car car) { System.out.println("Scanning vehicle engine blocks..."); }
    }

    public static void main(String[] args) {
        System.out.println("UML Relationships Mapping Blueprint Active.");
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If a `Library` contains a `List<Book>`, how do you distinguish whether this relationship
    //     is an Aggregation or a Composition in your Java code implementation?
    // Q2: Draw or map out the structural code representation of a self-referential Association (a class that retains
    //     a field pointing to its own class type). Provide a common, real-world data structure example.

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: E-Commerce Fulfilment Engine Architecture
    Scenario: You need to translate a complex warehouse logistical class diagram into a code structure.

    Requirements:
    1. Implement an ownership relationship network mapping: `Order`, `LineItem`, `InventoryProduct`, and `ShippingLabel`.
    2. Enforce absolute Composition structural bounds between `Order` and `LineItem` (destroying an order drops its line items).
    3. Model an Aggregation link between `LineItem` and `InventoryProduct`.
    4. Model a temporary Dependency parameter link inside the calculation method between `Order` and an external `TaxCalculator` utility.
    */
    // TODO: Implement the fully connected domain models matching these exact relationship bounds.
}