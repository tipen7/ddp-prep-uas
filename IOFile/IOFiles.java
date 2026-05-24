package IOFile;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class IOFiles {

    /*
    In this file, you will learn about Java Character-Output I/O Writer Architectures
    and their low-level applications in data streaming and formatting.

    * Writer Architectures do not store permanent datasets within memory wrappers;
      they stream characters directly to physical system endpoints or memory buffers.

    * I/O Streams and Writers are heavy system-resource drains. If they are not
      explicitly closed, they cause file-lock leaks and resource exhaustion.

    * The Core Writer Hierarchy:
      1. FileWriter:
         - Low-level, unbuffered, character-oriented system node connection.
         - Connects directly to the file system disk, making every write() call an expensive OS system operation.
         - Supports boolean append options but lacks efficient formatting or bulk processing logic.
      2. BufferedWriter:
         - Mid-level buffering optimization layer wrapper.
         - Implements an internal memory character array shield (default: 8192 characters).
         - Dramatically reduces expensive physical storage disk operations by delaying writes until full.
         - Crucial features: .newLine() (cross-platform newline spacing) and .flush() (forcing buffer evacuation).
      3. PrintWriter:
         - High-level syntax enhancement wrapper.
         - Wraps low-level node writers to inject advanced textual reporting operations (.print(), .println(), .printf()).
         - Internalizes and swallows raw IOException checked errors into an internal boolean error flag matrix.
         - Can optionally activate auto-flushing logic to process data on every println execution sequence.

    * Character vs Binary Encoding:
      Writers process 16-bit Unicode char elements, automatically applying character encoding mappings
      (like UTF-8) down into raw binary bytes.
    */

    public static void main(String[] args) {
        String testDir = "io_mastery_sandbox/";
        try { Files.createDirectories(Paths.get(testDir)); } catch (IOException ignored) {}

        /* Example 1: The Danger of Missing .flush() / .close() */
        try {
            FileWriter fw = new FileWriter(testDir + "leak_demo.txt");
            fw.write("Enterprise Architecture Analytics Log Payload");
            // Notice: No .flush() or .close() is called here.

            String content = Files.readString(Paths.get(testDir + "leak_demo.txt"));
            System.out.println("Read immediately before flush: '" + content + "'");
            // May output an empty string because the operating system is holding the characters in a low-level buffer!
        } catch (IOException e) { e.printStackTrace(); }

        /* Example 2: Automatic Resource Management via Try-With-Resources */
        // This structural pattern guarantees .close() is safely called even if an exception occurs mid-stream.
        try (FileWriter safeWriter = new FileWriter(testDir + "safe_demo.txt")) {
            safeWriter.write("Auto-Closing Resource Security Validated.");
        } catch (IOException e) { e.printStackTrace(); }

        /* Example 3: Checked Exception Swallowing in PrintWriter */
        try (PrintWriter pw = new PrintWriter(new FileWriter(testDir + "swallow_demo.txt"))) {
            pw.println("Testing Error Tracking Core Engine");
            boolean hasErrorOccurred = pw.checkError();
            System.out.println("PrintWriter internal exception state flag: " + hasErrorOccurred);
            // Returns false safely; exceptions are intercepted inside print method calls!
        } catch (IOException e) { e.printStackTrace(); }

        System.out.println("\n=== EXECUTING CHALLENGE RUNTIME TARGETS ===");

        /* Verification Matrix Execution Stubs */
        List<AuditLog> records = Arrays.asList(
                new AuditLog("CRITICAL", "DB-404", "Connection timeout isolated to main pool"),
                new AuditLog("INFO", "AUTH-200", "User registration token validated successfully"),
                new AuditLog("CRITICAL", "SYS-500", "Heap memory thresholds crossed maximum limit")
        );
        exportCriticalLogsBuffered(records, testDir + "critical_output.log");

        List<ReportSection> report = Arrays.asList(
                new ReportSection("Financial Operations Summary", List.of("Q1 Revenue: $4.2M", "Gross Margin: 64.2%")),
                new ReportSection("Infrastructure Vulnerabilities", List.of("Outdated open-source library path", "SSL expiration warning"))
        );
        generateStructuredReport(report, testDir + "enterprise_report.txt");

        List<UserRecord> users = Arrays.asList(
                new UserRecord(1001, "Steven Dyanizha", "Engineering", 152500.50),
                new UserRecord(1002, "Eve", "Design Operations", 168000.75),
                new UserRecord(1003, "Cia", "Product Architecture", 145000.00)
        );
        exportMetricsReport(users, testDir + "payroll_metrics.csv");
    }

    /* ======================================================================================================== */
    /* PRACTICE HIGH-DIFFICULTY CHALLENGES                                                                      */
    /* ======================================================================================================== */

    /* Q1: You are building an infrastructure health monitor plugin. You receive a dynamic list of system AuditLog
       records. You need to identify items marked as "CRITICAL", strip out their internal diagnostic tokens, and write
       them to a file.

       To protect storage drive health from excessive small write disk-head movements, you MUST optimize your file-system
       calls by utilizing a BufferedWriter wrapper around a raw appender FileWriter instance. Maintain system-native
       newlines between every output line. */

    record AuditLog(String severity, String componentCode, String details) {}

    public static void exportCriticalLogsBuffered(List<AuditLog> sourceLogs, String destinationPath) {
        // TODO: Implement filtering logic and write matching entries efficiently via BufferedWriter.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destinationPath))) {
            for (AuditLog log : sourceLogs) {
                if (log.severity.equals("CRITICAL")) {
                    bw.write("[" + log.componentCode + "] " + log.details);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ======================================================================================================== */

    /* Q2: You are writing a microservice reporting engine that transforms deep nested object layers into a clean text
       report file. You have a list of hierarchical ReportSection items. You must write the section title on its own line,
       underlined by matching equal characters ('='), followed by its nested details indented by an identical 4-space tab layout.

       Because your report format relies on exact layout specifications, line breaks, and alignment rules, utilize a
       combination of BufferedWriter (for low-level newline handling) and PrintWriter (for flexible, high-level line printing)
       to stream the output smoothly. Ensure that no data remains trapped in buffers when the method completes. */

    record ReportSection(String title, List<String> bulletPoints) {}

    public static void generateStructuredReport(List<ReportSection> data, String targetFile) {
        // TODO: Combine PrintWriter and BufferedWriter to write structured data with matching underline counts and indentation.
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(targetFile)))) {
            for (ReportSection section : data) {
                writer.println(section.title);

                String divider = "=".repeat(section.title.length());
                writer.println(divider);

                for (String bulletPoint : section.bulletPoints) {
                    writer.println("   ");
                    writer.println(bulletPoint);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ======================================================================================================== */

    /* Q3: You are constructing a highly accurate data export engine for a financial auditing team. You receive a list
       of complex UserRecord domain elements. You need to output this data into a standardized Comma-Separated Values (.csv) file.

       Requirements:
       1. The file must start with an immediate header row: "UID,Full_Name,Division,Monthly_Calculated_Payroll".
       2. Every numeric double financial field must be explicitly formatted to exactly two decimal places, regardless of its original size.
       3. You must use a PrintWriter instance wrapped around a basic FileWriter. Leverage explicit printf string-formatting
          masks to guarantee consistent spacing and rounding alignment across all rows. */

    record UserRecord(int userId, String name, String department, double basicSalary) {}

    public static void exportMetricsReport(List<UserRecord> matrixData, String outputCsvPath) {
        // TODO: Use PrintWriter's printf formatting engine to generate a precision-aligned CSV dataset.
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputCsvPath))) {

            writer.println("UID,Full_Name,Division,Monthly_Calculated_Payroll");
            for (UserRecord record : matrixData) {
                writer.printf("%d,%s,%s,%.2f\n", record.userId, record.name, record.department, record.basicSalary);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}