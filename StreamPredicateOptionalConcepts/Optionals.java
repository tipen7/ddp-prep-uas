package StreamPredicateOptionalConcepts;

import java.util.*;

/*
In this file, you will learn about Optional container handling in Java.

* Optional is a container object used to represent the presence or absence of a non-null value.
* Avoid NullPointerExceptions: It replaces dangerous literal `null` returns with a clean, functional wrapper API.
* Extraction Methods:
  - .orElse(T fallback): Evaluates the fallback value eagerly (even if the Optional contains a value). Performance risk!
  - .orElseGet(Supplier s): Evaluates the fallback value lazily (only if the Optional container is empty).
  - .orElseThrow(): Throws a NoSuchElementException immediately if the container is empty.
*/
public class Optionals {

    record AccountProfile(String profileId, String profileEmail) {}

    public static Optional<AccountProfile> fetchProfileFromRegistry(String profileId) {
        if ("USR-100".equals(profileId)) {
            return Optional.of(new AccountProfile("USR-100", "admin@domain.com"));
        }
        return Optional.empty(); // Avoid returning a literal null value
    }

    public static void main(String[] args) {
        /* Example 1: Safe Functional Resolution Chain */
        fetchProfileFromRegistry("USR-100")
                .map(AccountProfile::profileEmail)
                .filter(email -> email.endsWith(".com"))
                .ifPresentOrElse(
                        email -> System.out.println("Processing notification routing to: " + email),
                        () -> System.out.println("Profile context missing or invalid registration profile details.")
                );

        /* Example 2: Eager orElse vs Lazy orElseGet Performance Trap */
        System.out.println("--- Starting Eager Resolution Evaluation ---");
        AccountProfile profile1 = fetchProfileFromRegistry("USR-100").orElse(generateFallbackProfile());

        System.out.println("--- Starting Lazy Resolution Evaluation ---");
        AccountProfile profile2 = fetchProfileFromRegistry("USR-100").orElseGet(() -> generateFallbackProfile());
        // Notice that generateFallbackProfile() runs during orElse even though a valid profile was found!
    }

    private static AccountProfile generateFallbackProfile() {
        System.out.println("[WARNING] Expensive fallback method executed!");
        return new AccountProfile("FALLBACK", "backup@domain.com");
    }

    /* ======================================================================================================== */
    /* CONCEPTUAL EVALUATION QUESTIONS                                                                          */
    /* ======================================================================================================== */
    // Q1: Why is it considered an architectural antipattern to pass an `Optional` wrapper as a method parameter,
    //     or to store an `Optional` as a field inside a domain class definition?
    // Q2: What happens if you call `.flatMap()` on an Optional container instead of using `.map()`?
    //     Explain the difference in method signatures.

    /* ======================================================================================================== */
    /* REAL-WORLD PROGRAMMING CHALLENGE                                                                         */
    /* ======================================================================================================== */
    /*
    CHALLENGE: Multi-Tiered Enterprise Security Gateway Resolver
    Scenario: Design a configuration manager that checks fallback options sequentially without using if/else statements.

    Requirements:
    1. Write a pipeline method that checks three options in order: `LocalCache`, `RedisCluster`, and `FallbackDatabase`.
    2. Chain these lookups sequentially using the modern `Optional.or()` method.
    3. Ensure that downstream database lookups are evaluated lazily—they should only run if upstream caches return an empty Optional.
    */
    // TODO: Implement resolveConfigurationContext(Supplier<Optional<String>> cache, Supplier<Optional<String>> redis, Supplier<Optional<String>> db);
}