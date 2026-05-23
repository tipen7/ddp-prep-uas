package KeywordModifiers;

/*
In this file, you will learn about the protected access modifier in Java.

* Visibility Scope: The `protected` modifier balances encapsulation with flexible inheritance.
* Access Bounds: A protected member is accessible to:
  1. Any class operating inside the exact same package boundaries.
  2. Any subclass extending this parent class, even if that subclass lives in a completely different package.
*/
public class Protected {

    static class CloudInfrastructureNode {
        protected String internalDnsRoutingHostname = "node-us-east-44.internal";

        protected void establishSecureTunnelConnection() {
            System.out.println("Opening system control tunnels across regional infrastructure backplanes...");
        }
    }

    public static void main(String[] args) {
        CloudInfrastructureNode clusterNode = new CloudInfrastructureNode();
        clusterNode.establishSecureTunnelConnection(); // Accessible inside the same package
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If a class in package `com.company.parent` has a protected method, and a subclass in package
    //     `com.company.child` inherits from it, can a completely unrelated class in `com.company.child` invoke
    //     that protected method on the subclass instance? Explain the restriction rule.
    // Q2: When overriding a protected superclass method in a subclass, can you change its access modifier to public?
    //     Can you change it to private? Explain Java's visibility relaxation rules during inheritance.

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Custom Framework Extensibility Toolkit
    Scenario: Design a base framework class meant to be extended and customized by third-party developers.

    Requirements:
    1. Build a class `BaseDataPipeline` that exposes a protected hooks framework method `.preprocessPayloadRawData()`.
    2. Allow subclasses in external packages to inherit from your pipeline and override the protected method to insert
       custom cleaning rules.
    3. Restrict external endpoint users from invoking these pipeline cleaning steps directly.
    */
    // TODO: Implement the protected framework base infrastructure hooks layout.
}