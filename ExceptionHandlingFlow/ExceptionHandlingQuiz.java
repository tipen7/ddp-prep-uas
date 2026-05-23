package ExceptionHandlingFlow;

/**
 * CONCEPTUAL NOTES: EXCEPTION HANDLING
 * * 1. Checked vs Unchecked Exceptions:
 * - Checked Exceptions (extend Exception but not RuntimeException): Checked at compile-time.
 * Methods must declare them using `throws` or handle them using `try-catch`.
 * - Unchecked Exceptions (extend RuntimeException): Evaluated at runtime. Declaration is optional.
 * * 2. Multi-Catch Blocks:
 * - Caught exceptions are separated by a pipe character (`|`). The variable is implicitly `final`
 * and cannot be reassigned inside the catch block. Classes cannot have subclass relationships.
 * * 3. Finally Block Interception Rule:
 * - If both a `catch` block and a `finally` block declare a `return` or a `throw` statement,
 * the values/exceptions from the `finally` block overwrite and suppress the ones from the catch block!
 */
public class ExceptionHandlingQuiz {

    public static void main(String[] args) {
        System.out.println("Execute ExceptionHandlingQuiz interactive framework below.");
    }

    /* Q1: Consider this nested structural execution pathway:

       public static int trackNestedExecution() {
           try {
               try {
                   throw new NullPointerException("Inner Error");
               } catch (RuntimeException e) {
                   System.out.print("Catch1 ");
                   throw new IllegalArgumentException("Rethrown Error");
               } finally {
                   System.out.print("Finally1 ");
               }
           } catch (Exception e) {
               System.out.print("Catch2 ");
               return 100;
           } finally {
               System.out.print("Finally2 ");
               return 200;
           }
       }
       What is printed to the console window, and what integer value does the method return?
    */
    // TODO: Trace the impact of rethrowing exceptions inside nested try blocks and return statement masking.

    /* Q2: Examine this multi-catch declaration configuration:

       try {
           // Assume a routine that might throw an ArithmeticException or a RuntimeException occurs here
       } catch (ArithmeticException | RuntimeException e) {
           System.out.println(e.getMessage());
       }
       What response does the Java compiler produce when processing this source block code?
    */
    // TODO: Determine if checking for a subclass and parent class together in a multi-catch statement is valid.

    /* Q3: Look at the automated resource execution segment below:

       static class SafeStream implements AutoCloseable {
           @Override
           public void close() throws Exception {
               throw new IllegalArgumentException("CloseException");
           }
       }

       public static void runResourcePipeline() {
           try (SafeStream stream = new SafeStream()) {
               throw new NullPointerException("MainException");
           } catch (Exception e) {
               System.out.print(e.getMessage() + " Suppressed: " + e.getSuppressed().length);
           }
       }
       What specific string data prints out when `runResourcePipeline()` is executed?
    */
    // TODO: Understand how exceptions are prioritized during a try-with-resources statement execution.

    /* Q4: Review the following class definition design parameters:

       class SuperClass {
           public void synchronize() throws IOException {}
       }
       class SubClass extends SuperClass {
           @Override
           public void synchronize() throws Exception {}
       }
       Identify the response or errors produced by the compiler when building this inheritance tree.
    */
    // TODO: Recall the constraints placed on checked exceptions by overriding methods.

    /* Q5: Predict the execution logging output for the following control path scenario:

       public static String evaluateFlowGates() {
           try {
               System.out.print("Try ");
               System.exit(0);
               return "ResultA";
           } catch (Exception e) {
               System.out.print("Catch ");
               return "ResultB";
           } finally {
               System.out.print("Finally ");
           }
       }
    */
    // TODO: Determine if the finally block runs when the virtual machine is shut down mid-execution.

    /* Q6: Consider this code block layout:

       try {
           throw new AssertionError("Fatal validation crash");
       } catch (Exception e) {
           System.out.print("CaughtException ");
       } catch (Throwable t) {
           System.out.print("CaughtThrowable ");
       }
       What pattern is output to the display when running this sequence?
    */
    // TODO: Differentiate between the class boundaries of Exception, Error, and Throwable.

    /* Q7: What is the compilation outcome of the statement sequence below?

       public void performDiskOperation(boolean flag) {
           try {
               if (flag) throw new IOException("Disk failure");
               else System.out.println("Operation stable");
           } finally {
               System.out.println("Cleanup completed");
           }
       }
    */
    // TODO: Assess whether a method can compile if it throws a checked exception without a catch block or a throws clause.

    /* Q8: Examine the following code snippet. What is its structural outcome?

       try {
           throw new NullPointerException();
       } catch (NullPointerException e) {
           System.out.print("Catch ");
           e = new NullPointerException(); // Reassigning exception variable
           throw e;
       }
    */
    // TODO: Analyze the assignment rules of standard catch block variables versus multi-catch block variables.

    /* Q9: Look at this method block setup and determine the printed console trace:

       public static void parseDataValue() {
           try {
               System.out.print("A ");
               int result = 10 / 0;
               System.out.print("B ");
           } catch (ArithmeticException e) {
               System.out.print("C ");
               throw new RuntimeException();
           } finally {
               System.out.print("D ");
           }
           System.out.print("E ");
       }
    */
    // TODO: Trace what happens to downstream code statements when an unhandled exception leaves a method.

    /* Q10: Suppose you have a code segment where an object instance is thrown: `throw null;`.
       What happens at runtime when this statement executes inside an un-nested, empty try block container?
    */
    // TODO: Identify what specific exception type the JVM throws when it encounters a null reference pointer in a throw statement.
}