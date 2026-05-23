package OOPrinciples;

/*
In this file, you will learn about Encapsulation in Java.

* Core Concept: Encapsulation is the practice of bundling data (fields) and methods that operate on that data
  into a single class, while hiding internal details (`private`).
* Defensive Coping: It acts as a protective shield, preventing outside code from directly modifying internal states
  and bypassing your business rules.
* Mutable Reference Leakage Trap: Simply using a getter is not enough! If a getter returns a reference to a mutable
  object (like an ArrayList), outside code can still modify its contents directly, breaking encapsulation.
*/
public class Encapsulation {

    static class SecureWallet {
        private double fiatBalance; // Strictly hidden internal state field variable

        public SecureWallet(double initialFunds) {
            if (initialFunds >= 0) { this.fiatBalance = initialFunds; }
        }

        // Exposing safe getter gates
        public double getFiatBalance() { return this.fiatBalance; }

        // Controlled Mutation Gate with strict business validation rules
        public void processWithdrawal(double debitAmount) {
            if (debitAmount > 0 && debitAmount <= this.fiatBalance) {
                this.fiatBalance -= debitAmount;
                System.out.println("Withdrawal approved. Remaining balance: " + this.fiatBalance);
            } else {
                System.out.println("Action Denied: Fraudulent input or insufficient funds detected.");
            }
        }
    }

    public static void main(String[] args) {
        SecureWallet wallet = new SecureWallet(500.0);
        wallet.processWithdrawal(150.0); // Safe mutation interaction
        // wallet.fiatBalance = -100000.0; // COMPILATION ERROR! Protected by encapsulation bounds.
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If a class encapsulates a `private List<String> userRoles;` field and exposes a standard public getter
    //     `public List<String> getUserRoles() { return this.userRoles; }`, explain how an outside class can bypass
    //     encapsulation and modify the contents of that list. How do you fix this using Collections.unmodifiableList()?
    // Q2: Why is declaring fields as public considered a violation of object-oriented design principles, even if
    //     the values don't have any validation rules?

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Smart Vault Cryptographic Safe Manager
    Scenario: Build a secure container that stores cryptographic secrets and prevents tampering.

    Requirements:
    1. Implement a class `CryptographicVault` that holds an internal array of access logs and a secret master string key.
    2. Prevent outside modifications to the master string key. It can only be updated if a correct pin confirmation matches.
    3. When returning the list of access logs via a getter, return a defensive copy or an unmodifiable collection
       so that the internal historical logs cannot be tampered with or cleared by outside entities.
    */
    // TODO: Implement the fully encapsulated CryptographicVault domain class framework.
}