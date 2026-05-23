package ExceptionHandlingFlow;

import java.io.IOException;

public class ExceptionHandlingTask {

    // Custom checked system domain exception
    static class DatabaseConnectionException extends Exception {
        public DatabaseConnectionException(String msg) { super(msg); }
    }

    // Custom unchecked system domain exception
    static class InvalidTransactionException extends RuntimeException {
        public InvalidTransactionException(String msg) { super(msg); }
    }

    // A mock resource that implements AutoCloseable to test automatic resource lifecycle teardown
    static class AutomatedLedgerChannel implements AutoCloseable {
        private final boolean forceCloseFailure;

        public AutomatedLedgerChannel(boolean forceCloseFailure) {
            this.forceCloseFailure = forceCloseFailure;
        }

        public void writeLog(String entry) throws IOException {
            if (entry.contains("CORRUPT")) {
                throw new IOException("Disk write hardware failure intercepted.");
            }
        }

        @Override
        public void close() throws Exception {
            System.out.print("ChannelClosed ");
            if (forceCloseFailure) {
                throw new IllegalStateException("Teardown buffer flush failure.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EXECUTION SCENARIO A: NORMAL FAULT PROCESSING ===");
        processLedgerTransaction("STANDARD_PAYLOAD", false);

        System.out.println("\n\n=== EXECUTION SCENARIO B: SUPPRESSED RESOURCE FAILURE ===");
        processLedgerTransaction("CORRUPT_PAYLOAD_ALARM", true);
    }

    /**
     * DIRECTIONS:
     * 1. Wrap the initialization of `AutomatedLedgerChannel` inside a try-with-resources statement.
     * 2. Inside the try block, invoke `channel.writeLog(payload)`.
     * 3. Construct a catch block scheme targeting `IOException` first, followed by a catch block for general `Exception`.
     * 4. If an IOException occurs, wrap it inside a new `InvalidTransactionException` (unchecked) and throw it.
     * 5. Add a `finally` block that prints out "ExecutionGatewayExit " to verify execution order.
     */
    public static void processLedgerTransaction(String payload, boolean triggerCloseCrash) {
        // TODO: Implement the nested exception structure and resource management block here
        // Try to handle all edge cases to make sure code prints the correct tracking strings in sequence
    }
}