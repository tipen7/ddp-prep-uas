package IOFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
In this file, you will learn about BufferedWriter in Java.

* Core Concept: BufferedWriter wraps around another Writer (like FileWriter) and buffers characters.
  It accumulates written data inside an internal 8KB memory byte array.
* Performance Advantage: Instead of hitting the disk constantly, it writes to RAM. When the buffer fills up
  or is explicitly flushed, it writes the entire block to disk in a single system call.
* The Flush Rule: Data can get stuck in memory! Always call `.flush()` or close the stream via try-with-resources
  to force the buffer to write its data to disk.
*/
public class BufferedWriterConcepts {

    public static void main(String[] args) {
        /* Example 1: High-Performance Buffered Processing */
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("buffered_output.txt"))) {
            for (int i = 0; i < 5; i++) {
                bufferedWriter.write("Buffered batch row entry element: " + i);
                bufferedWriter.newLine(); // Platform-independent line separator (\n or \r\n)
            }
            // bufferedWriter.flush(); // Automatically handled when closing via try-with-resources
        } catch (IOException e) {
            System.out.println("Buffered I/O error: " + e.getMessage());
        }

        /* ======================================================================================================== */
        /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
        /* ======================================================================================================== */
        // Q1: If an application unexpectedly terminates via `System.exit(0)` right before a try-with-resources
        //     block closes a BufferedWriter, will your data be visible inside the target file? Explain why.
        // Q2: Explain the structural architectural pattern used when wrapping a `FileWriter` inside a `BufferedWriter`.
        //     (Hint: Name the structural design pattern).

        /* ======================================================================================================== */
        /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
        /* ======================================================================================================== */
        /*
        CHALLENGE: Bulk High-Throughput CSV Exporter
        Scenario: You are designing an export engine that processes database dumps containing millions of rows.

        Requirements:
        1. Write a high-performance exporter that streams rows into a text-based CSV file.
        2. Use buffering structures to optimize I/O performance.
        3. Manually call a flush sequence every 50,000 processed data cycles to prevent memory bloat.
        */
        // TODO: Implement streamBulkDataToCSV(List<String[]> databaseRows, String targetPath);
    }
}