package StreamPredicateOptionalConcepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Optionals {

    /*
    In this file, you will learn about Optional in Java and their application
    in safe, functional, null-pointer-free programming environments.

    * Optional is a single-value container object which may or may not contain a non-null value.
    * It is primarily intended for use as a method return type where there is a clear
      need to represent "no result".
    * Optional is NOT meant to be used for class fields, method parameters, or added to collections.

    * Core Method Categories:
      1. Creation Instances: empty(), of(), ofNullable()
      2. Value Validation: isPresent(), isEmpty(), ifPresent(), ifPresentOrElse()
      3. Conditional Pipelines: filter(), map(), flatMap(), stream(), or()
      4. Fallback Extraction: get(), orElse(), orElseGet(), orElseThrow()
    */

    public static void main(String[] args) {

        /* ======================================================================================================== */
        /* EVERY SINGLE OPTIONAL METHOD EXECUTED WITH CLEAR EXAMPLES                                                */
        /* ======================================================================================================== */

        /* 1. Optional.empty() */
        Optional<String> emptyOpt = Optional.empty();
        System.out.println("Empty representation: " + emptyOpt); // Optional.empty

        /* 2. Optional.of(T value) */
        Optional<String> presentOpt = Optional.of("Lefi");
        System.out.println("Present representation: " + presentOpt); // Optional[Lefi]
        // Optional.of(null); // Throws NullPointerException instantly!

        /* 3. Optional.ofNullable(T value) */
        Optional<String> nullBasedOpt = Optional.ofNullable(null);
        System.out.println("Nullable assignment: " + nullBasedOpt); // Optional.empty safely

        /* 4. isPresent() */
        boolean checkPresence = presentOpt.isPresent();
        System.out.println("isPresent evaluation: " + checkPresence); // true

        /* 5. isEmpty() (Introduced in Java 11) */
        boolean checkEmptiness = emptyOpt.isEmpty();
        System.out.println("isEmpty evaluation: " + checkEmptiness); // true

        /* 6. ifPresent(Consumer<? super T> action) */
        presentOpt.ifPresent(val -> System.out.println("ifPresent consumer execution: " + val));

        /* 7. ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) (Introduced in Java 9) */
        emptyOpt.ifPresentOrElse(
                val -> System.out.println("Found: " + val),
                () -> System.out.println("ifPresentOrElse default alternative pathway executed.")
        );

        /* 8. filter(Predicate<? super T> predicate) */
        Optional<String> longNameOpt = presentOpt.filter(name -> name.length() > 10);
        Optional<String> shortNameOpt = presentOpt.filter(name -> name.length() < 10);
        System.out.println("filter result state: " + longNameOpt); // Optional.empty due to false match
        System.out.println("filter result state: " + shortNameOpt);

        /* 9. map(Function<? super T, ? extends U> mapper) */
        Optional<Integer> nameLengthOpt = presentOpt.map(String::length);
        Optional<String> nameValidOpt = Optional.of("Steven Ganteng");
        Optional<Boolean> isValidName = nameValidOpt.map(name -> Character.isUpperCase(name.charAt(0)));
        System.out.println("map transformation payload: " + nameLengthOpt); // Optional[4]
        System.out.println("map transformation for valid name " + nameValidOpt.get() + " is " + isValidName.get());

        /* 10. flatMap(Function<? super T, ? extends Optional<? extends U>> mapper) */
        Optional<String> flatMappedOpt = presentOpt.flatMap(name -> Optional.of(name.toUpperCase()));
        System.out.println("flatMap un-nesting: " + flatMappedOpt); // Optional[LEFI]

        /* 11. or(Supplier<? extends Optional<? extends T>> supplier) (Introduced in Java 9) */
        Optional<String> cascadingOpt = emptyOpt.or(() -> Optional.of("Sean"));
        System.out.println("or() lazy fall-through backup option: " + cascadingOpt); // Optional[Sean]

        /* 12. stream() (Introduced in Java 9) */
        Stream<String> convertedStream = presentOpt.stream();
        System.out.println("stream() item elements count: " + convertedStream.count()); // 1

        /* 13. get() */
        String rawUnwrappedString = presentOpt.get();
        System.out.println("get() extraction target: " + rawUnwrappedString); // Lefi
        // emptyOpt.get(); // Throws NoSuchElementException! Never use get() without checking presence first.

        /* 14. orElse(T other) */
        System.out.println("--- Starting orElse (Eager Allocation Check) ---");
        String eagerResult = presentOpt.orElse(executeExpensiveOperation());
        // Notice that executeExpensiveOperation() evaluates even if the value is present!

        /* 15. orElseGet(Supplier<? extends T> supplier) */
        System.out.println("--- Starting orElseGet (Lazy Evaluation Check) ---");
        String lazyResult = presentOpt.orElseGet(() -> executeExpensiveOperation());
        // executeExpensiveOperation() will NOT run here because presentOpt contains a value.

        /* 16. orElseThrow() (Introduced in Java 10) */
        String guaranteedPayload = presentOpt.orElseThrow();
        System.out.println("orElseThrow direct value extraction: " + guaranteedPayload);

        /* 17. orElseThrow(Supplier<? extends X> exceptionSupplier) */
        try {
            emptyOpt.orElseThrow(() -> new IllegalArgumentException("Context state error: missing parameters."));
        } catch (IllegalArgumentException e) {
            System.out.println("orElseThrow targeted exception caught: " + e.getMessage());
        }

        /* 18. equals(Object obj) and hashCode() */
        System.out.println("Equality evaluation: " + Optional.of("Tipen").equals(Optional.of("Tipen"))); // true

        /* ======================================================================================================== */
        /* SAMPLE TEST RUNNERS                                                                                      */
        /* ======================================================================================================== */
        System.out.println("\n--- Initializing Practice Question Setup Invocations ---");

        // Q1 Execution Test
        UserAccount u1 = new UserAccount("USR1", "Active", new AccountConfig(true));
        UserAccount u2 = new UserAccount("USR2", "Suspended", null);
        System.out.println("Q1 Target Result Status: " + isMessagingEnabled(Optional.of(u1))); // true
        System.out.println("Q1 Target Fallback Status: " + isMessagingEnabled(Optional.of(u2))); // false

        // Q2 Execution Test
        System.out.println("Q2 Fallback Pipeline Target: " + fetchSystemToken(Optional.empty(), () -> Optional.empty()));

        // Q3 Execution Test
        List<Optional<String>> networkPayloads = Arrays.asList(
                Optional.of("PACKET_ALPHA"),
                Optional.empty(),
                Optional.of("PACKET_BETA"),
                Optional.empty(),
                Optional.of("PACKET_GAMMA")
        );

        System.out.println("Raw Input List Size: " + networkPayloads.size() + " elements (includes empty dropouts).");

        List<String> sanitizedPayloads = purgeAndExtractPayloads(networkPayloads);

        System.out.println("Sanitized Output List: " + sanitizedPayloads);
        System.out.println("Sanitized List Size: " + sanitizedPayloads.size() + " (Successfully purged empty states!)");
        // Expected Output: [PACKET_ALPHA, PACKET_BETA, PACKET_GAMMA]

        // Q4 Execution Test

        // Q5 Execution Test

        // Q6 Execution Test

        // Q7 Execution Test
    }

    private static String executeExpensiveOperation() {
        System.out.println("[WARNING] Expensive method evaluated!");
        return "Fallback Constant";
    }

    /* ======================================================================================================== */
    /* PRACTICE QUESTIONS (UNIMPLEMENTED - FOR YOUR IMPLEMENTATION TASK)                                       */
    /* ======================================================================================================== */

    /* Q1: You are building an enterprise microservice router. You receive an Optional wrapping a UserAccount instance.
    A UserAccount can have a null AccountConfig reference. Inside AccountConfig, there is a boolean field tracking messaging setups.
    Safely extract the configuration option using monadic transformations. If any layer is missing or if the user is suspended,
    return false. Do not use any explicit conditional keywords (if, else, ternary) or instance checks. */

    static class UserAccount {
        private String id;
        private String status;
        private AccountConfig config;

        public UserAccount(String id, String status, AccountConfig config) {
            this.id = id;
            this.status = status;
            this.config = config;
        }
        public String getStatus() { return status; }
        public Optional<AccountConfig> getConfig() { return Optional.ofNullable(config); }
    }

    static class AccountConfig {
        private boolean isMessagingActive;
        public AccountConfig(boolean active) { this.isMessagingActive = active; }
        public boolean isMessagingActive() { return isMessagingActive; }
    }

    public static boolean isMessagingEnabled(Optional<UserAccount> accountOpt) {
        // TODO: Refactor using flatMap, filter, map and orElse to determine if notifications are allowed
        return accountOpt.filter(acc -> !acc.getStatus().equals("Suspended"))
                         .flatMap(UserAccount::getConfig)
                         .map(AccountConfig::isMessagingActive)
                         .orElse(false);
    }

    /* ======================================================================================================== */

    /* Q2: You are writing a microservice component that fetches authorization credentials. To guarantee service uptime,
    you must query a series of fallbacks in sequence. Implement a processing method that accepts a primary token holder wrapper,
    and a secondary provider. If both fail, lazily fetch a third fallback token. Ensure you use modern
    Optional composition features to implement lazy fallback cascading short-circuit rules. */

    public static String fetchSystemToken(Optional<String> primary, java.util.function.Supplier<Optional<String>> secondary) {
        // TODO: Chain options together using Optional.or() logic and fall back to "GUEST_TOKEN" if all evaluate as empty
        return primary
                .or(secondary)
                .or(() -> Optional.of("TERTIARY_TOKEN"))
                .orElse("GUEST_TOKEN");
    }

    /* ======================================================================================================== */

    /* Q3: You have an application stream collection tracking metrics payloads. Some payloads are empty due to data dropouts.
    Process the stream by filtering out empty states, unwrapping the interior values, and collecting them into an unmodifiable
    list of strings. Implement this entirely using Optional's stream integration feature. */

    public static List<String> purgeAndExtractPayloads(List<Optional<String>> rawPayloads) {
        // TODO: Transform the collection using Stream + Optional::stream mechanisms
        return rawPayloads.stream()
                          .flatMap(payloads -> payloads.stream())
                          .toList();
    }

    /* ======================================================================================================== */

    /* Q4: You are building a metrics auditing module for a banking gateway. If an optional transaction identifier is found,
    you must pass the value to an external logging framework. If it is completely absent, you must instantly execute a critical
    subsystem alarm routine. Route this logic inline inside a single continuous statement without extracting state variables. */

    interface AuditEngine {
        void recordTransactionToken(String token);
        void soundSystemAlarm();
    }

    public static void processAuditRouting(Optional<String> tokenOpt, AuditEngine engine) {
        // TODO: Implement using a non-extracting conditional branching matrix method
        tokenOpt.ifPresentOrElse(engine::recordTransactionToken, engine::soundSystemAlarm);
    }

    /* ======================================================================================================== */

    /* Q5: You are designing a real-time order processing platform database gateway. When looking up an order profile by its unique ID,
    the repository returns an Optional wrapper. If the record isn't found in the database, you must throw a custom domain exception
    named OrderNotFoundException. Ensure that you preserve the missing ID context within the thrown exception's error message string. */

    static class OrderNotFoundException extends RuntimeException {
        public OrderNotFoundException(String msg) { super(msg); }
    }

    record OrderProfile(String orderId, double priceValue) {}

    public static OrderProfile locateOrderRecord(Optional<OrderProfile> searchResult, String lookupId) {
        // TODO: Use an extraction method to return the profile or throw your custom exception with the missing ID
        return searchResult.orElseThrow(() -> new OrderNotFoundException("Order registry allocation failed for ID: " + lookupId));
    }

    /* ======================================================================================================== */

    /* Q6: You are optimizing an algorithmic system engine tracking sensor metrics. You are dealing with a stream containing millions
    of numbers. Standard objects like Optional<Double> introduce significant garbage collection overhead due to boxing operations.
    Refactor the lookup methodology to calculate the largest value in a primitive data stream array safely without memory allocation bloat. */

    public static OptionalDouble trackPeakMetricPrimitive(double[] rawDataPoints) {
        // TODO: Process elements directly into a primitive specialized Optional numeric wrapper container
        return Arrays.stream(rawDataPoints)
                     .max();
    }

    /* ======================================================================================================== */

    /* Q7: You are designing an asynchronous data parsing process. You receive a standard asynchronous Future payload wrapper
    containing an Optional account record data profile block. Complete the pipeline transformation: extract the interior account name
    from the nested object if it exists, or automatically throw an IllegalStateException if the context evaluates to empty. */

    record ClientProfile(String username, Optional<String> registrationAddress) {}

    public static java.util.concurrent.CompletableFuture<String> extractAddressAsync(
            java.util.concurrent.CompletableFuture<Optional<ClientProfile>> asyncPayload
    ) {
        // TODO: Process the future context cleanly using un-nesting transformations
        return asyncPayload.thenApply(
                client -> client.flatMap(c -> c.registrationAddress)
                                                   .orElseThrow(() -> new IllegalStateException("Failed to extract client")));
    }
}