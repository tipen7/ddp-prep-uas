package YukDDP2100;

// TOPICS COVERED: Inheritance, Method Overriding, Field Shadowing, Super Invocation //
public class ExpressDelivery extends DeliveryTransaction {

    private final boolean highPriorityEscortRequired;
    protected double baseRatePerKm = 15000.0; // Shadows the parent's variable completely!

    public ExpressDelivery(String driverIdentifier, double physicalDistanceKm, ServiceTier activeTier, boolean highPriorityEscortRequired) {
        super(driverIdentifier, physicalDistanceKm, activeTier);
        this.highPriorityEscortRequired = highPriorityEscortRequired;
    }

    @Override
    public double calculateRawCost() {
        // TODO: Implement the calculation using field shadowing mechanics:
        // 1. Calculate base value = getPhysicalDistanceKm() * this.baseRatePerKm
        //    (Note: 'this.baseRatePerKm' grabs 15000.0, while 'super.baseRatePerKm' grabs 8000.0)
        // 2. Multiply that base value by the active tier's cost multiplier.
        // 3. Add the active tier's base surcharge.
        // 4. If highPriorityEscortRequired is true, inject an additional flat fee of 45000.0
        return 0.0;
    }

    @Override
    public double calculateComplianceTax() {
        // TODO: Calculate tax = calculateRawCost() * getActiveTier().getCorporateTaxRate()
        return 0.0;
    }
}