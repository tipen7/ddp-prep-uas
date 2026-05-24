package YukDDP2100;

// TOPICS COVERED: Enums, State Mapping, Encapsulation, Keyword Modifiers //
public enum ServiceTier {
    STANDARD(1.0, 0.0, 0.05),
    EXPRESS(1.5, 15000.0, 0.08),
    BULK_CARGO(2.5, 75000.0, 0.12),
    CROSS_BORDER_PREMIUM(3.8, 250000.0, 0.18);

    private final double costMultiplier;
    private final double baseSurcharge;
    private final double corporateTaxRate;

    private ServiceTier(double costMultiplier, double baseSurcharge, double corporateTaxRate) {
        this.costMultiplier = costMultiplier;
        this.baseSurcharge = baseSurcharge;
        this.corporateTaxRate = corporateTaxRate;
    }

    // TODO: Write standard public getter methods for all three private final fields.
    // - getCostMultiplier()
    // - getBaseSurcharge()
    // - getCorporateTaxRate()
}