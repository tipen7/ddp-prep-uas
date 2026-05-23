package StreamPredicateOptionalConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {

    /* 
    
    * In this file, you will learn about Predicate in Java and what are their
    application in programming. Note that before learning more about these topics,
    there are several topis that u need to understand, such as interfaces, generics, Stream, and functions in Java.

    * Predicate is essentially a function that returns a boolean. We can predicate a Collections
    such as List, HashMap, Set, etc. Predicate sits in the java.util.function package, where

    @FunctionalInterface
    public interface Predicate<T> {
        public boolean test(T obj)
    }

    * Since we can instantiate an interface, so we can also define our own Predicate<T> with our desired
    data type T
    
    */

    public static void main(String[] args) {
        
        /* Define a predicate that checks wether a number is even */
        Predicate<Integer> isEven = num -> num % 2 == 0;
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        nums.stream()
            .filter(isEven)
            .toList()
            .forEach(System.out::println); // this prints all even numbers in the list, also note that stream creates
                                           // a new Object not modifying it
        
        /* There are also some methods in the Predicate interface that are worth to consider, such as
        1. and (Predicate<? super T> other) -> returns a Predicate<T> that are logical AND with the other Predicate
        2. negate() -> returns a Predicate<T> that are logical NOT of the Predicate
        3. or(Predicate<? super T> other) -> returns a Predicate<T> that are logical OR with the other Predicate
        4. test(T obj) -> returns a boolean weather the obj type is the same as the Predicate<T> T type
        5. not(Predicate<? super T> target) -> returns a Predicate<T> that are the negation of the target
        6. isEqual(Predicate<? super T> obj) -> Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object) 
        */


        /* Practice Question */

        /* Q1 : You are building a user registration system. Write a predicate to check if a chosen username 
        is longer than 5 characters, and test it against a sample username. */

        Predicate<String> isValidUsername = s -> s.length() > 5;
        boolean testName1 = isValidUsername.test("Tip");
        boolean testName2 = isValidUsername.test("Tipenganteng");

        System.out.println("Tip is a valid username? " + testName1);
        System.out.println("Tipengateng is a valid username? " + testName2);

        /* Q2: An HR application filters job applicants. Create two predicates: one to check if an applicant has a 
        degree, and another to check if they have over 3 years of experience. Combine them to find candidates 
        who meet both criteria. */

        Applicant applicant1 = new Applicant(true, 5);
        Applicant applicant2 = new Applicant(false, 2);

        Predicate<Applicant> hasDegree = applicant -> applicant.hasDegree;
        Predicate<Applicant> has3YearsExperience = applicant -> applicant.yearsExperience > 3;

        Predicate<Applicant> isValidCandidates = hasDegree.and(has3YearsExperience);

        boolean testApplicant1 = isValidCandidates.test(applicant1);
        boolean testApplicant2 = isValidCandidates.test(applicant2);

        System.out.println("Applicant 1 is a valid candidate? " + testApplicant1);
        System.out.println("Applicant 2 is a valid candidate? " + testApplicant2);

        /* Q3:  An e-commerce system offers a free shipping discount if a customer is a premium member or if their order
         total is greater than $100. Create a combined predicate to evaluate this eligibility. */

        Order order1 = new Order(false, 200);
        Order order2 = new Order(true, 300);

        Predicate<Order> isPremiumOrder = order -> order.isPremium;
        Predicate<Order> totalMoreThan100 = order -> order.total > 100;
        Predicate<Order>  getsDiscount = isPremiumOrder.or(totalMoreThan100);

        boolean testOrder1 = getsDiscount.test(order1);
        boolean testOrder2 = getsDiscount.test(order2);

        System.out.println("Order 1 will get discount? " + testOrder1);
        System.out.println("Order 2 will get discount? " + testOrder2);

        /* Q4: : You have a predicate that identifies prime numbers. Use it to cleanly build a new predicate that
        identifies composite (non-prime) numbers. */

        Predicate<Integer> isPrime = Predicates::isPrimeNumber;
        Predicate<Integer> isComposite = isPrime.negate();

        int prime_num = 3;
        int composite_num = 8;

        boolean testPrime = isPrime.test(prime_num);
        boolean testComposite = isComposite.test(composite_num);

        System.out.println("The number " + prime_num +  " is a prime number? " + testPrime);
        System.out.println("The number " + composite_num +  " is a composite number? " + testComposite);

        /* Q5: You are filtering a list of strings and want to discard all blank strings. Use Predicate.not alongside a Java String
        method reference to find non-blank strings. */

        List<String> words = Arrays.asList("Lefi", "", "", "Tipen", "Hunting", "", "Fineshyt");
        Predicate<String> isBlank = String::isEmpty;
        words.stream().filter(Predicate.not(isBlank)).forEach(System.out::println);

        /*  Q6: You are writing a security scanner that processes incoming network requests. You need a fast, null-safe way to
         flag requests coming from a known malicious IP address ("192.168.1.50").*/
        Predicate<String> isMaliciousIP = Predicate.isEqual("192.168.1.50");

        String IP1 = "192.168.1.50";
        String IP2 = "192.167.4.30";

        boolean testIP1 = isMaliciousIP.test(IP1);
        boolean testIP2 = isMaliciousIP.test(IP2);

        System.out.println(IP1 + " is a malicious IP? " + testIP1);
        System.out.println(IP2 + " is a malicious IP? " + testIP2);
        

    }

    /* Let's define a function to check weather a number is prime or not */
    private static boolean isPrimeNumber(int num) {

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    /* Lets define class Applicant first */
    static class Applicant {
        boolean hasDegree;
        int yearsExperience;

        Applicant(boolean hasDegree, int yearsExperience) {
            this.hasDegree = hasDegree;
            this.yearsExperience = yearsExperience;
        }
    }

    /* Let's define Order first*/
    static class Order {
        boolean isPremium;
        int total;
        Order(boolean premium, int total) {
            this.isPremium = premium;
            this.total = total;
        }
    }

}
