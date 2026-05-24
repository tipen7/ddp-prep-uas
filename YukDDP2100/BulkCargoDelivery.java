package YukDDP2100;

// TOPICS COVERED: Hierarchy Extensions, Custom Constructor Rules //
public class BulkCargoDelivery extends DeliveryTransaction {

    private final double cargoWeightMetricTons;

    public BulkCargoDelivery(String driverIdentifier, double physicalDistanceKm, ServiceTier activeTier, double cargoWeightMetricTons) {
        super(driverIdentifier, physicalDistanceKm, activeTier);
        this.cargoWeightMetricTons = cargoWeightMetricTons;
    }

    @Override
    public double calculateRawCost() {
        // TODO: Write pricing matrix:
        // Cost = (getPhysicalDistanceKm() * super.baseRatePerKm) * getActiveTier().getCostMultiplier()
        // If cargoWeightMetricTons > 5.0, add an extra weight surcharge = (cargoWeightMetricTons - 5.0) * 12500.0
        return 0.0;
    }

    @Override
    public double calculateComplianceTax() {
        // TODO: If cargoWeightMetricTons > 10.0, apply double corporate tax penalty rate
        // otherwise return basic corporate tax formula.
        return 0.0;
    }
}