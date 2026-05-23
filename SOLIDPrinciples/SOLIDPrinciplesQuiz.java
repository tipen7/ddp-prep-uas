package SOLIDPrinciples;

/**
 * CONCEPTUAL NOTES: SOLID PRINCIPLES REVISION MATRIX
 * * 1. SRP vs ISP:
 * - SRP focuses on the actor/cohesion level of a class ("reasons to change").
 * - ISP focuses on the client-facing signature design ("don't force empty overrides").
 * * 2. LSP Contract Rules:
 * - Subclasses can loosen preconditions (accept wider inputs) but cannot tighten them.
 * - Subclasses can tighten postconditions (return narrower, more specific outputs) but cannot loosen them.
 * * 3. Dependency Inversion Boundary:
 * - High-level architectural policies shouldn't know anything about concrete database sockets,
 * UI controllers, or framework wrappers. Everything links through an abstract interface bridge.
 */
public class SOLIDPrinciplesQuiz {

    public static void main(String[] args) {
        System.out.println("Execute SOLIDPrinciplesQuiz conceptual matrix evaluations below.");
    }

    /* Q1: A developer creates a class named `UserSessionEngine` that handles database connection pooling,
       processes credentials validation parsing, and sends user password-reset transactional emails.
       Which specific SOLID design parameter is severely violated in this structural model? */
    // TODO: Pinpoint the principle broken by loading multiple disjoint responsibilities onto a single object.

    /* Q2: Look at the method block segment below:

       public void processBilling(String gatewayType, double amount) {
           if (gatewayType.equals("STRIPE")) { // execute Stripe charge }
           else if (gatewayType.equals("PAYPAL")) { // execute PayPal charge }
           else if (gatewayType.equals("CRYPTO")) { // execute Crypto transfer }
       }

       If you want to add a fourth payment option, you are forced to modify this class's existing source code.
       What core architectural design principle is being violated here? */
    // TODO: Determine which principle uses abstract interfaces to add new features without changing existing code.

    /* Q3: Examine this overriding mechanism path:

       class Bird { public void fly() { System.out.println("Flying"); } }
       class Ostrich extends Bird {
           @Override
           public void fly() { throw new UnsupportedOperationException("Cannot fly"); }
       }

       If a client method expects a collection of `Bird` instances and iterates through calling `.fly()`,
       passing an `Ostrich` reference instantly crashes the program. Which design pillar is violated here? */
    // TODO: Track the rule that prevents subclasses from breaking behaviors expected of their parent classes.

    /* Q4: Suppose an interface named `SmartAppliance` defines `turnOn()`, `turnOff()`, `connectToWifi()`,
       and `adjustThermostat()`. A developer implements this interface to create a simple `SmartLightBulb` class,
       leaving `adjustThermostat()` to throw a generic error because lightbulbs can't regulate temperature.
       What structural error is being committed here? */
    // TODO: Differentiate between interface pollution issues and deep type hierarchy mismatches.

    /* Q5: High-level business calculation component class `OrderProcessor` directly instantiates a concrete low-level data
       driver driver implementation: `private MySqlDriver driver = new MySqlDriver();`. Why does this architecture
       fail the Dependency Inversion Principle, and how should it be structurally decoupled? */
    // TODO: Map out the dependency inversion model where high-level and low-level code meet at an abstract interface boundary.

    /* Q6: A subclass overrides a parent method: `public List<String> fetchKeys()`. The overriding subclass
       changes the return signature type parameter configuration to: `public ArrayList<String> fetchKeys()`.
       Does this change violate the Liskov Substitution Principle (LSP) regarding covariance return parameters? */
    // TODO: Analyze how covariant return types impact runtime structural compatibility.

    /* Q7: What real-world architectural system flaw commonly occurs if a development team chooses to ignore
       the Open/Closed Principle (OCP) and instead updates source files directly for every new requirement? */
    // TODO: Connect direct code editing with regression bugs, merge conflicts, and code rigidity.

    /* Q8: An infrastructure team segregates a single large database configuration interface into three
       smaller interface units: `ReadConnection`, `WriteConnection`, and `AdminMaintenanceConnection`.
       Which specific design metric has this software engineering team successfully optimized? */
    // TODO: Identify the exact principle that promotes lean, highly specialized interface footprints.

    /* Q9: If you use the Dependency Injection structural pattern (passing interfaces via class constructors
       using frameworks like Spring), which of the SOLID principles are you directly implementing to make
       your system loosely coupled and highly testable? */
    // TODO: Name the principle that advocates for decoupling concrete objects by injecting abstract adapters.

    /* Q10: Consider this scenario: Class A has a single clear responsibility. However, to fulfill that
       responsibility, it is tightly coupled to four other concrete subclasses, requiring updates whenever
       any of those subclasses change. Explain how a class can follow SRP but still violate DIP and OCP. */
    // TODO: Review how SRP operates at the class level, while OCP and DIP guide how classes interact across system layers.
}