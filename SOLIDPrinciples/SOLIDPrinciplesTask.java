package SOLIDPrinciples;

import java.util.*;

public class SOLIDPrinciplesTask {

    // Target Data Record Container
    record DocumentItem(String docId, String content, String author, boolean isArchived) {}

    /* ======================================================================================================== */
    /* 1. SINGLE RESPONSIBILITY PRINCIPLE (SRP)                                                                 */
    /* DIRECTIONS: Split the old, bloated "DocumentManager" class into two separate, single-purpose classes:
       - Class A: DocumentRepository (Responsible ONLY for managing data storage and search lookups).
       - Class B: DocumentFormatter (Responsible ONLY for rendering a text report format string).
    ======================================================================================================== */
    static class DocumentRepository {
        private final List<DocumentItem> database = new ArrayList<>();

        public void addDocument(DocumentItem doc) { database.add(doc); }
        // TODO: Move storage/lookup arrays here out of old legacy code modules
    }

    static class DocumentFormatter {
        // TODO: Implement report string building layout transformation code independently here
    }

    /* ======================================================================================================== */
    /* 2. OPEN/CLOSED PRINCIPLE (OCP) & DEPENDENCY INVERSION PRINCIPLE (DIP)                                    */
    /* DIRECTIONS: Instead of making an "ExportEngine" class containing messy if/else statements for each
       format type (PDF, JSON, XML), declare an abstraction layer interface named "ExportFormatHandler".
       Then implement two separate concrete extension strategy components.
    ======================================================================================================== */
    interface ExportFormatHandler {
        // TODO: Define an abstract contract method signature: void exportData(DocumentItem doc);
    }

    static class JsonExportHandler implements ExportFormatHandler {
        // TODO: Implement abstract contract methods to output fake JSON strings
    }

    static class HtmlExportHandler implements ExportFormatHandler {
        // TODO: Implement abstract contract methods to output fake HTML tags
    }

    /* ======================================================================================================== */
    /* 3. LISKOV SUBSTITUTION PRINCIPLE (LSP) & INTERFACE SEGREGATION PRINCIPLE (ISP)                           */
    /* DIRECTIONS: We used to have an interface called "SuperProcessor" that declared `.read()`, `.write()`,
       and `.encrypt()`. But ReadOnlyDocument items crashed when callers invoked `.write()`.
       Segregate that bloated interface into two clean, distinct contracts to enforce LSP and ISP.
    ======================================================================================================== */
    interface ReadableSource {
        void readContent(DocumentItem doc);
    }

    interface WritableSource {
        void writeContent(DocumentItem doc, String newText);
    }

    // Concrete implementation that safely respects LSP parameters because it never encounters unimplemented methods
    static class ReadOnlyDocumentNode implements ReadableSource {
        @Override
        public void readContent(DocumentItem doc) {
            System.out.println("Reading resource content securely: " + doc.content());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== INITIALIZING SOLID ARCHITECTURE TEST GATEWAY ===");

        DocumentItem orderReceipt = new DocumentItem("DOC-404", "Enterprise System Core Architecture Log", "Steven", false);

        /* ======================================================================================================== */
        /* POLYMORPHIC EXECUTION MATRIX                                                                             */
        /* ======================================================================================================== */
        // TODO: Instaniate your segregated repositories, link your OCP strategy components via interface pointers,
        // and run a clean data lifecycle workflow without modifying legacy source files!
    }
}