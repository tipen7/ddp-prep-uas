package InterfaceEnumClass;

public class InterfaceEnumClassTask {

    public static void main(String[] args) {
        /* ======================================================================================================== */
        /* EXECUTION MATRIX (TEST SUITE)                                                                            */
        /* ======================================================================================================== */
        System.out.println("=== INITIALIZING LOGISTICS & FULFILLMENT SYSTEMS ===");

        // 1. Create a simulated order item payload
        Order order = new Order("ORD-9982", 150.00, ShippingTier.EXPRESS);

        // 2. Instantiate our pluggable shipping processor strategy
        // ShippingGateway gateway = new ShippingGateway();

        // TODO: Pass the order object to your shipping gateway.
        // Based on the order's ShippingTier enum value, the gateway should dynamically invoke
        // the correct concrete implementation of your interface and print out the correct calculation rates!
    }

    /* ======================================================================================================== */
    /* 1. THE STATE ENGINE LAYER (ENUM)                                                                         */
    /* ======================================================================================================== */
    /* DIRECTIONS:
       - Turn this into an ENUM named ShippingTier.
       - Define three specific categories: STANDARD, EXPRESS, and INTERNATIONAL.
       - Advanced Enum Practice: Give this enum an internal final primitive field `double baseRateMultiplier`.
       - Provide a private constructor inside the enum to bind this value (e.g., STANDARD(1.0), EXPRESS(2.5)).
       - Expose a public getter method `public double getBaseRateMultiplier()`.
    */
    enum ShippingTier {
        // TODO: Implement the parameterized enum values and matching fields here.
    }

    /* ======================================================================================================== */
    /* 2. THE BEHAVIOR CONTRACT LAYER (INTERFACE)                                                               */
    /* ======================================================================================================== */
    /* DIRECTIONS:
       - Turn this into an INTERFACE named ShippingProcessor.
       - Define a single abstract method contract: double calculateCost(double packageValue);
       - Hint: Remember that all methods declared inside an interface are implicitly public and abstract.
    */
    interface ShippingProcessor {
        // TODO: Define the abstract behavioral contract layout here.
    }

    /* ======================================================================================================== */
    /* 3. THE PLUGGABLE IMPLEMENTATION SCHEME                                                                   */
    /* ======================================================================================================== */
    /* DIRECTIONS:
       - Implement concrete classes for your shipping rules that honor your interface contract.
       - Class 1: StandardShipping implements ShippingProcessor -> Costs = packageValue * 0.05
       - Class 2: ExpressShipping implements ShippingProcessor -> Costs = (packageValue * 0.12) + 15.00
    */
    static class StandardShipping {
        // TODO: Implement your interface contract here.
    }

    static class ExpressShipping {
        // TODO: Implement your interface contract here.
    }

    /* ======================================================================================================== */
    /* 4. THE ENTITY MODEL STRUCTURE CONTAINER                                                                  */
    /* ======================================================================================================== */
    static class Order {
        private final String orderId;
        private final double orderValue;
        private final ShippingTier tier; // Binding our Enum directly as an internal instance state attribute

        public Order(String orderId, double orderValue, ShippingTier tier) {
            this.orderId = orderId;
            this.orderValue = orderValue;
            this.tier = tier;
        }

        public String getOrderId() { return orderId; }
        public double getOrderValue() { return orderValue; }
        public ShippingTier getTier() { return tier; }
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: What is the main architectural benefit of passing an instance of the "ShippingTier" Enum into the Order
    //     constructor instead of a standard string value like `new Order("ORD1", 100, "Express")`?
    //     (Hint: Type Safety and Compile-time Validation).
    //
    // Q2: Can an Enum implement an Interface in Java? If yes, how does that help clean up messy `switch-case`
    //     or `if-else` blocks when choosing a processing strategy?
    //
    // Q3: Why can't you instantiate an interface directly using the `new` operator (e.g., `new ShippingProcessor()`)?
    //     What must a concrete class do to become instantiable?
}