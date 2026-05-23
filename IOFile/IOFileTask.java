package IOFile;

import java.io.*;
import java.util.*;

public class IOFileTask {

    // Simple record container representing financial transactions
    record Transaction(String txId, String clientName, double amount, boolean isSuspicious) {}

    public static void main(String[] args) {
        /* ======================================================================================================== */
        /* SETUP LIVE SAMPLE DATA PAYLOADS                                                                          */
        /* ======================================================================================================== */
        List<Transaction> transactionsTable = Arrays.asList(
                new Transaction("TX-001", "Lefi", 12500.50, false),
                new Transaction("TX-002", "Sean", 950000.00, true), // Suspiciously large!
                new Transaction("TX-003", "Tipen", 450.25, false),
                new Transaction("TX-004", "Kevin", 1100050.75, true) // Suspiciously large!
        );

        System.out.println("=== INITIALIZING TRANSACTION PROCESSING SYSTEM ===");

        // Execute the challenge pipeline
        processAndLogTransactions(transactionsTable);
    }

    public static void processAndLogTransactions(List<Transaction> transactions) {
        String securityAlertLogPath = "security_alerts.txt";
        String bulkTransactionLogPath = "bulk_ledger.txt";
        String businessReportPath = "financial_summary_report.txt";

        /* ======================================================================================================== */
        /* THE RESOURCE PIPELINE SYSTEM CHALLENGE TASK                                                              */
        /* ======================================================================================================== */
        /* DIRECTIONS:
           1. Open a raw FileWriter for `securityAlertLogPath` configured to APPEND mode (true).
           2. Open a BufferedWriter for `bulkTransactionLogPath` configured to OVERWRITE mode (false or default).
           3. Open a PrintWriter for `businessReportPath` to generate a clean, formatted report grid layout.

           CRITICAL REQUIREMENT: Use try-with-resources so all files close and flush automatically!
        */

        // TODO: Implement the resource initialization architecture block here
        // try (...) {

        // Loop through every transaction item in the table:
        for (Transaction tx : transactions) {

            // TASK A: If the transaction is suspicious (tx.isSuspicious() is true), use your raw
            // FileWriter to append the alert string immediately to security_alerts.txt. Add a manual newline.
            // TODO: Write raw append logic

            // TASK B: For every transaction, write its basic details out into the bulk_ledger.txt
            // using the BufferedWriter. Remember to call `.newLine()` so each record sits on its own row!
            // TODO: Write buffered batch data logic

            // TASK C: Use the PrintWriter to append a formatted summary entry line inside financial_summary_report.txt
            // using `.printf()`. Make sure columns align nicely (e.g., ID, Name, and formatted Currency with commas).
            // TODO: Write printf formatted design report logic

        }

        System.out.println("Processing Complete. Verify your local package directory for the three output text files!");

        // } catch (IOException e) {
        //     System.out.println("An I/O processing pipeline structural error occurred: " + e.getMessage());
        // }
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: If the system power cord is completely pulled out mid-execution while processing "TX-002", why is the
    //     suspicious alert entry highly likely to be saved on disk inside "security_alerts.txt", while the standard
    //     ledger records inside "bulk_ledger.txt" might vanish completely? (Hint: Disk vs RAM OS system call barriers).
    //
    // Q2: Why is it bad practice to open a BufferedWriter in a loop (e.g., `for(...) { BufferedWriter bw = new ... }`)?
    //     How does our structural design pattern here optimize system resources?
    //
    // Q3: Notice that the PrintWriter didn't force you to write a try-catch block inside the loop body, even though
    //     it was interacting with a disk file. How does the internal design of PrintWriter handle checked
    //     Exceptions compared to standard Writers?
}