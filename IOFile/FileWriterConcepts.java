package IOFile;

import java.io.FileWriter;
import java.io.IOException;

/*
In this file, you will learn about FileWriter in Java.

* Core Concept: FileWriter is a character-oriented class used to write character data
  directly to a file. It writes data directly to the disk subsystem one character or string at a time.
* Performance Trap: Because it lacks an internal buffer, every single .write() invocation causes a
  direct OS-level system call to the underlying storage hardware. This causes severe disk I/O bottlenecks.
* Append Mode: By default, it overwrites files. Passing `true` as the second constructor parameter activates append mode.
*/
public class FileWriterConcepts {

    public static void main(String[] args) {
        /* Example 1: Direct Disk Write (No Buffer) */
        try (FileWriter writer = new FileWriter("raw_output.txt", false)) {
            writer.write("Writing direct unbuffered character array data straight to disk.");
        } catch (IOException e) {
            System.out.println("Disk write error: " + e.getMessage());
        }

        /* ======================================================================================================== */
        /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
        /* ======================================================================================================== */
        // Q1: If you call writer.write("A") inside a loop that runs 10,000 times using a raw FileWriter,
        //     how many OS system write calls are made? What is the impact on your application's execution thread?
        // Q2: What happens if the target file path does not exist when initializing a FileWriter? What happens if
        //     the directory structure itself does not exist?

        /* ======================================================================================================== */
        /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
        /* ======================================================================================================== */
        /*
        CHALLENGE: Unbuffered Real-Time Audit Trail
        Scenario: You are developing an append-only security auditing log that must immediately commit data to disk
        so that data isn't lost if the JVM crashes or loses power.

        Requirements:
        1. Implement a method that writes an explicit event payload to a file using character arrays.
        2. Enforce an append-only configuration so that historical security logs are never wiped out during restarts.
        */
        // TODO: Implement appendAuditRecord(String logPath, String securityEvent);
    }
}