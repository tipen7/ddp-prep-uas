package InterfaceEnumAbstractClass;

/*
In this file, you will learn about Abstract Classes in Java.

* Abstract Classes cannot be instantiated directly using the `new` operator. They act as partial templates.
* Structural State Capability: Unlike standard interfaces, abstract classes can maintain instance variable states
  and track structural object modifications.
* Concrete vs Abstract Methods: They can mix non-abstract methods (with a body) with abstract methods
  (without a body, forcing child overriding implementations).
*/
public class Abstract {

    static abstract class DatabaseConnector {
        private final String connectionString; // Abstract classes can hold state

        public DatabaseConnector(String connectionString) {
            this.connectionString = connectionString; // Enforces child constructor propagation via super()
        }

        public String getConnectionString() { return connectionString; } // Shared concrete behavior

        public abstract void connect(); // Abstract structural blueprint rule
    }

    static class PostgresConnector extends DatabaseConnector {
        public PostgresConnector(String url) { super(url); } // Required constructor linkage

        @Override
        public void connect() { System.out.println("Opening TCP socket connection channel to Postgres network port..."); }
    }

    public static void main(String[] args) {
        DatabaseConnector db = new PostgresConnector("jdbc:postgresql://localhost:5432/core_db");
        db.connect();
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: What happens if a subclass does not explicitly call the `super()` constructor of its abstract parent class
    //     when the parent defines a custom parameterized constructor?
    // Q2: Can an abstract class declare a method as `public abstract final void evaluate();`? Explain why this syntax
    //     is valid or invalid according to inheritance design principles.

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Dynamic Game Character Engine
    Scenario: Design a base gameplay combat architecture layout.

    Requirements:
    1. Build an abstract base framework class `GameCharacter` carrying common parameters (`health`, `mana`).
    2. Define a shared concrete routine method `.takeDamage(int hitPoints)`.
    3. Define an abstract specialized logic method `.castUltimateAbility()`.
    4. Create child entities `Mage` and `Warrior` that implement their unique ability behaviors based on their parent's state.
    */
    // TODO: Build out the entire abstract class tree mechanics matching these exact rules.
}