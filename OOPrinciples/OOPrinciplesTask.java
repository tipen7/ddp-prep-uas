package OOPrinciples;

import java.util.*;

public class OOPrinciplesTask {

    public static void main(String[] args) {
        /* ======================================================================================================== */
        /* POLYMORPHIC EXECUTION MATRIX (TEST SUITE)                                                                */
        /* ======================================================================================================== */
        System.out.println("=== INITIALIZING TRANSACTION CHECKOUT GATEWAY ===");

        // 1. Instantiate Encapsulated, Specialized Processors
        // Processor 1: CreditCard (Needs a processing limit, fee rate, and sets up a secure balance tracking state)
        CreditCardProcessor credit = new CreditCardProcessor("t1", "lefistore", 1_000D, 200D);
        CryptoProcessor crypto = new CryptoProcessor("t2", "tipstore", "california", 150D);
        // Processor 2: CryptoWallet (Needs a public wallet address string, conversion network fee, and crypto token balance)

        // 2. Collect Processors Polymorphically into a Unified Infrastructure Array
        // PaymentProcessor[] activeGatewayNodes = new PaymentProcessor[] { ... };
        PaymentProcessor[] activeGatewayNodes = new PaymentProcessor[]{crypto, credit};

        // 3. Simulate a Multi-Payment Checkout Routine
        double targetBillAmount = 250.00;

        // TODO: Loop through your activeGatewayNodes polymorphically and process the targetBillAmount on each.
        // Verify that your code calls the same method name, but triggers completely distinct business logic per class!
        for (PaymentProcessor paymentProcessor : activeGatewayNodes) {
            if (paymentProcessor.executeTransaction(targetBillAmount)) {
                System.out.println("SUCCESS!");
            } else {
                System.out.println("FAILED!");
            }
        }
    }

    /* ======================================================================================================== */
    /* 1. ABSTRACTION & INHERITANCE LAYER                                                                       */
    /* ======================================================================================================== */
    /* DIRECTIONS:
       - Turn this into an ABSTRACT class named PaymentProcessor.
       - Add private/protected fields common to all processors: String transactionId, String merchantName.
       - Provide a concrete constructor to bind these variables.
       - Define an ABSTRACT method contract: public abstract boolean executeTransaction(double amount);
    */
    static abstract class PaymentProcessor {
        // TODO: Implement the abstract infrastructure template here.
        private String transcationID;
        private String merchantName;
        public PaymentProcessor(String transcationID, String merchantName) {
            this.transcationID = transcationID;
            this.merchantName = merchantName;
        }
        public abstract boolean executeTransaction(double amount);
    }

    /* ======================================================================================================== */
    /* 2. ENCAPSULATION & INHERITANCE SUBCLASS LAYER (CREDIT CARD)                                              */
    /* ======================================================================================================== */
    /* DIRECTIONS:
       - Make CreditCardProcessor extend PaymentProcessor (Inheritance).
       - Encapsulate internal metrics (Encapsulation): private double cardLimit, private double currentOutstandingBalance.
       - Provide a secure constructor that passes core variables up to the parent using super().
       - Expose a safe Getter for currentOutstandingBalance, but NO raw Setter.
       - Implement executeTransaction(double amount): If amount + balance exceeds limit, deny transaction. Otherwise, add to balance.
    */
    static class CreditCardProcessor extends PaymentProcessor {
        // TODO: Implement the encapsulated credit card domain node here.
        private double cardLimit;
        private double currentBalance;
        public CreditCardProcessor(String transactionID, String merchantName, double cardLimit, double currentBalance) {
            super(transactionID, merchantName);
            this.cardLimit = cardLimit;
            this.currentBalance = currentBalance;
        }

        public double getCardLimit() {
            return this.cardLimit;
        }

        public double getCurrentBalance() {
            return this.currentBalance;
        }

        @Override
        public boolean executeTransaction(double amount) {
            if (this.currentBalance + amount <= this.cardLimit) {
                this.currentBalance -= amount;
                return true;
            }
            return false;
        }
    }

    /* ======================================================================================================== */
    /* 3. ENCAPSULATION & INHERITANCE SUBCLASS LAYER (CRYPTO WALLET)                                            */
    /* ======================================================================================================== */
    /* DIRECTIONS:
       - Make CryptoProcessor extend PaymentProcessor (Inheritance).
       - Encapsulate state details: private String walletAddress, private double digitalTokenBalance.
       - Implement executeTransaction(double amount): Verify if digitalTokenBalance is large enough to cover the bill.
         If yes, deduct the amount securely. If not, print a fraudulent/insufficient warning message.
    */
    static class CryptoProcessor extends PaymentProcessor {
        // TODO: Implement the encapsulated crypto wallet domain node here.
        private String walletAddress;
        private double digitalTokenBalance;
        public CryptoProcessor(String transactionID, String merchantName, String walletAddress, double digitalTokenBalance) {
            super(transactionID, merchantName);
            this.walletAddress = walletAddress;
            this.digitalTokenBalance = digitalTokenBalance;
        }

        @Override
        public boolean executeTransaction(double amount) {
            if (this.digitalTokenBalance >= amount) {
                this.digitalTokenBalance -= amount;
                return true;
            }

            return false;
        }
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: In the main checkout execution loop, the reference variable type is "PaymentProcessor", but the code
    //     runs the logic inside "CryptoProcessor" or "CreditCardProcessor". What specific type of polymorphism
    //     is this, and when does the JVM decide which method version to execute (compile-time or runtime)?
    //
    // Q2: Why is it structurally crucial that "PaymentProcessor" is marked as abstract? What real-world system bug
    //     could occur if a developer was accidentally allowed to execute: `new PaymentProcessor("TXN-01", "Store")`?
    //
    // Q3: If an external hacker class gains access to your running application context, explain how marking
    //     `currentOutstandingBalance` as private protects the financial ledger compared to making it public.
}