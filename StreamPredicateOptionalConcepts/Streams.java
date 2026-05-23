package StreamPredicateOptionalConcepts;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Streams {

    /*
    In this file, you will learn about Stream in Java and their application
    in every functional programming.

    * Streams does not store data, but they process data from a source like
    arrays, collections, files, etc.
    
    * Streams are lazy, means that intermediate operations are not executed immediately.
    * Streams cannot be reused
    * Streams does bot modify or mutate the original source, but create new results
    
    * Intermediate Operations
      Returns another stream
      1. filter()
      2. map()
      3. sorted()
      4. distinct()
      5. limit()
      etc..

    * Terminal Operations
      End of a stream
      1. collect()
      2. forEach()
      3. reduce()
      4. count()
      5. findFirst()
      etc..
    */

    public static void main(String[] args) {
        
        /* Example 1: Stream's Laziness */
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream()
            .filter(num -> {
                System.out.println("Filtering: " + num);
                return num % 2 == 0;
            });
        
        /*  doesn't print anything because filter is one of the intermediate
        operations in Java Stream, hence the line inside the function are not
        executed immediately.
        */

        /* Example 2: Stream Reuse */
        Stream<Integer> stream = Stream.of(1, 2, 3);

        stream.forEach(System.out::println); // executed
//        stream.forEach(System.out::println); // throws exception because it already closed or used

        /* Example 3: Mutability */
        List<Integer> numbers = List.of(1, 2, 3);

        numbers.stream()
            .map(num -> num * 2);
            System.out.println(numbers); // does not modify the original list because stream creates a new object

        /* Q1 */
        Student student1 = new Student("Lefi", 1);
        Student student2 = new Student("Sean", 2);
        Student student3 = new Student("Tipen", 3);
        Student student4 = new Student("Kevin", 4);
        Student student5 = new Student("Lefi", 1);
        Student student6 = new Student("Nizami", 6);
        Course course1 = new Course("Calculus", Arrays.asList(student1, student2, student3));
        Course course2 = new Course("DSA", Arrays.asList(student4, student5, student6));
        getAllUniqueStudentsSorted(Arrays.asList(course1, course2));

        /* Q2 */
        Product p1 = new Product("Buku 1", "Buku", 1);
        Product p2 = new Product("Buku 2", "Buku", 1);
        Product p3 = new Product("Buku 3", "Buku", 1);

        Product p4 = new Product("Alat 1", "Alat", 1);
        Product p5 = new Product("Alat 2", "Alat", 1);
        Product p6 = new Product("Alat 3", "Alat", 1);

        Map<String, List<String>> groupedProducts = getProductNamesByCategory(Arrays.asList(p1, p2, p3, p4, p5, p6));
        System.out.println("groupedProducts: " + groupedProducts);

        /* Q3 */
        Transaction t1 = new Transaction(1, 10.0);
        Transaction t2 = new Transaction(2, 20.0);
        Transaction t3 = new Transaction(3, 30.0);
        System.out.println("getTotalTransactionAmount: " + getTotalTransactionAmount(Arrays.asList(t1, t2, t3)));

        /* Q4 */
        Stream<Double> temperatures = Stream.of(100.0, 99.2, 85.6, 120.1);
        System.out.println("isSystemSafe(temperatures): " + isSystemSafe(temperatures));

        /* Q5 */
        OptionalDouble average = calculateAveragePrice(new int[]{1, 2, 3, 4, 5});
        System.out.println("Average: " + average.getAsDouble());

        /* Q6 */
        List<String> databaseRecords = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        int pageSize = 2;
        int pageNumber = 2;
        List<String> pagination = getPage(databaseRecords, pageNumber, pageSize);
        System.out.println("pagination: " + pagination);

        /* Q7 */
        Employee employee1 = new Employee("Lefi", "Software Engineer", "IT", 100_000_000);
        Employee employee2 = new Employee("Tipen", "Software Engineer", "IT", 200_000_000);
        Employee employee3 = new Employee("Jocim", "Software Engineer", "IT", 300_000_000);

        Employee employee4 = new Employee("Sean", "Marketing and Sales", "HR", 100_000_000);
        Employee employee5 = new Employee("Tania", "Marketing and Sales", "HR", 200_000_000);

        Map<String, Map<String, Double>> summary = getAverageSalaryByDeptAndTitle(Arrays.asList(employee1, employee2, employee3, employee4, employee5));
        System.out.println("summary: " + summary);

        /* Q8 */
        Player player1 = new Player("Lefi", "Blue", 10, true);
        Player player2 = new Player("Tipen", "Blue", 12, false);
        Player player3 = new Player("Sean", "Blue", 7, true);
        Player player4 = new Player("Kevin", "Red", 20, false);
        Player player5 = new Player("Vincent", "Red", 22, true);
        Player player6 = new Player("Hakim", "Red", 19, false);
        Map<Boolean, Map<String, Integer>> summary1 = getTeamScoresByActivity(Arrays.asList(player1, player2, player3, player4, player5, player6));
        System.out.println("summary1: " + summary1);

        /* Q9 */
        int n = 1;
        int[] fibonacci = generateFibonacciSequence(n);
        for (int num : fibonacci) {
            System.out.print(num + ", ");
        }

    }

    /*  Practice Questions */

    /* Q1: You are building an analytics dashboard for a school platform. You have a list of Course objects, and each course contains
    a list of student names registered for that course. You need to gather a unique, alphabetically sorted list of every student
    across all courses. */

    static class Course {
        String title;
        List<Student> enrolledStudents;
        public Course(String title, List<Student> enrolledStudents) {
            this.title = title;
            this.enrolledStudents = enrolledStudents;
        }

        List<Student> getEnrolledStudents() {
            return this.enrolledStudents;
        }
    }

    static class Student {
        String name;
        int id;
        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }
        String getName() {
            return this.name;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(id);
        }

    }

    public static void getAllUniqueStudentsSorted(List<Course> courses) {
        courses.stream()
                .flatMap(course -> course.getEnrolledStudents().stream())
                .distinct()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(student -> System.out.println(student.getName()));
    }

    /* ======================================================================================================== */

    /* Q2 : You run an online store. You have a list of Product objects, each belonging to a category (e.g., "Electronics", "Books")
     and containing a price. You need to group the products by their category, but instead of getting a Map<String, List>,
     you want a Map<String, List> where the value is a list of just the product names in that category. */

    record Product(String name, String category, int price) {}
    public static Map<String, List<String>> getProductNamesByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.mapping(Product::name, Collectors.toList())
                ));
    }

    /* ======================================================================================================== */

    /* Q3: You are processing system logs and need to calculate the total financial transaction volume from a stream of log items.
     While you could use mapToDouble() and sum(), you want to master the reduce() operation. Implement a calculator that safely
     sums the prices using an identity element and an accumulator.*/

    record Transaction(int id, double amount) {}
    public static double getTotalTransactionAmount(List<Transaction> transactions) {
        return transactions.stream()
                          .map(transaction -> transaction.amount)
                          .reduce(0.0, (t1, t2) -> t1 + t2);
    }

    /* ======================================================================================================== */

    /* Q4 : You are writing a safety validator for an industrial application. You have a massive stream of temperature sensor
    readings. If even one sensor readings exceeds $100^\circ\text{C}$, you must instantly halt verification and sound an alarm.
    You should not process the remaining items in the stream once a violation is discovered. */
    public static boolean isSystemSafe(Stream<Double> temperature) {
        return temperature.allMatch(temp -> temp < 100);
                // temperature.noneMatch(temp -> temp >= 100);
    }

    /* ======================================================================================================== */

    /* Q5: You are handling a high-frequency trading platform dataset containing millions of stock price movements as an
    array of integers. Mapping them to a standard wrapper stream like Stream will cause massive memory allocation overhead
    due to auto-boxing. Process these values using primitive streams to find the average value safely. */

    public static OptionalDouble calculateAveragePrice(int[] raw) {

        return Arrays.stream(raw).average();

    }

    /* Q6: You are implementing database pagination manually on a collection of records. Write a method that returns a specific
     "page" of results from a list. For example, if pageSize is 10 and pageNumber is 2, it should return records 11 through 20
     (index 10 to 19). */

    public static List<String> getPage(List<String> databaseRecords, int pageNumber, int pageSize) {
        return databaseRecords.stream()
                              .skip(pageNumber)
                              .limit(pageSize)
                              .toList();
    }

    /* ======================================================================================================== */

    /* Q7 : You have a list of Employee records. You need to write a method that calculates the average salary for
    each position title within each individual department. Your final output must map a Department name to another
    Map of Job Titles and their respective average salaries. */
    record Employee(String name, String jobTitle, String department, double salary) {}
    public static Map<String, Map<String, Double>> getAverageSalaryByDeptAndTitle(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.groupingBy(Employee::jobTitle,
                                Collectors.averagingDouble(Employee::salary)
                )));
    }

    /* ======================================================================================================== */

    /* Q8 : You are building an analytics module for a gaming platform. You have a list of Player records.
    You need to organize players into a nested structure:
    1. First, partition them into two groups: Active vs. Inactive.
    2. Inside each of those groups, group them further by their Team Color.
    3. For the final value, instead of returning the players themselves, calculate the total combined score of that specific team subgroup.  */

    record Player(String name, String teamColor, int score, boolean isActivated) {}
    public static Map<Boolean, Map<String, Integer>> getTeamScoresByActivity(List<Player> players) {
        return players.stream()
                .collect(Collectors.partitioningBy(Player::isActivated, Collectors.groupingBy(Player::teamColor, Collectors.summingInt(Player::score))));
    }

    /* ======================================================================================================== */

    /* Q9 : You need to generate math sequences dynamically without hardcoding arrays. Use Stream.iterate to generate
    an infinite stream representing the Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, ... and collect the first N
    elements into an integer array. */

    public static int[] generateFibonacciSequence(int n) {
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]}).limit(n).mapToInt(num -> num[0]).toArray();
    }

}
