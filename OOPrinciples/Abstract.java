package OOPrinciples;

/*
In this file, you will learn about Abstract Classes in Java.

* Core Concept: An abstract class serves as a partial template for other classes. It cannot be instantiated
  directly using the `new` operator.
* State Capability: Unlike standard Java interfaces, abstract classes can maintain private instance variables,
  manage life-cycle fields, and require subclasses to invoke their constructors via `super()`.
* Strict Validation: Abstract methods have no body and **must** be implemented by the first concrete subclass
  that extends the abstract parent class.
*/
public class Abstract {

    static abstract class AutomatedMarketMaker {
        private double totalLiquidityPoolTokenCount; // Abstract classes can manage real state variables

        public AutomatedMarketMaker(double seedTokens) {
            this.totalLiquidityPoolTokenCount = seedTokens;
        }

        public double getTotalLiquidityPoolTokenCount() { return totalLiquidityPoolTokenCount; }

        // Abstract method contract rule: forces sub-classes to specify exact conversion math
        public abstract double estimateSwapOutput(double tokensDeposited);
    }

    static class ConstantProductPool extends AutomatedMarketMaker {
        public ConstantProductPool(double seedTokens) { super(seedTokens); }

        @Override
        public double estimateSwapOutput(double tokensDeposited) {
            // Specialized trading equation algorithm ($x \times y = k$)
            return tokensDeposited * 0.997; // Simplified representation applying swap fee deductions
        }
    }

    public static void main(String[] args) {
        AutomatedMarketMaker pool = new ConstantProductPool(100000);
        System.out.println("Calculated Output Token Swap Yield: " + pool.estimateSwapOutput(500));
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: Can an abstract class declare a method as `public abstract static void runEngine();`? Explain why
    //     this syntax is invalid and will fail compilation based on Java design choices.
    // Q2: Can you declare a class as abstract even if it contains absolutely zero abstract methods inside its definition?
    //     What is the architectural purpose of doing this?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Automated Continuous Integration Deployment Agent
    Scenario: Build a pipeline orchestration engine tool designed to manage cloud deployments.

    Requirements:
    1. Implement an abstract framework class `DeploymentPipeline` tracking fields like `buildId` and `targetEnvironment`.
    2. Implement concrete shared routines for code compilation: `.runStaticAnalysisLinting()`.
    3. Define an abstract method `.executeCloudDeploymentStep()`.
    4. Subclass this framework into concrete models: `AWSLambdaPipeline` and `KubernetesPipeline` to run cloud-specific deployment steps.
    */
    // TODO: Design and build the abstract deployment architecture classes.
}