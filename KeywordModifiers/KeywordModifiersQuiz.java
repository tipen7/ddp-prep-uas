package KeywordModifiers;

/**
 * CONCEPTUAL NOTES: KEYWORD MODIFIERS
 * * 1. Access Modifiers:
 * - private: Accessible only within the declaring class.
 * - default (package-private): Accessible only within the declaring package.
 * - protected: Accessible within the declaring package and by subclasses in external packages.
 * - public: Accessible everywhere.
 * 2. Non-Access Modifiers:
 * - static: Belongs to the class rather than instances. Static methods cannot access non-static variables.
 * - final:
 * - Variables: Cannot be reassigned once initialized.
 * - Methods: Cannot be overridden in subclasses.
 * - Classes: Cannot be extended.
 * - abstract: Cannot be instantiated. Must be extended or implemented.
 * 3. Hiding vs Overriding: Static methods cannot be overridden; they are hidden if redefined in subclasses.
 */

public class KeywordModifiersQuiz {

    static class ControllerNode {
        public static final int SYSTEM_ID = 101;
        protected int configurationFlags = 0;

        public static void printMeta() { System.out.print("ParentStatic "); }
        public final void syncState() { System.out.print("Synced "); }
    }

    static class CloudController extends ControllerNode {
         public static void printMeta() { System.out.print("ChildStatic "); }
        // public void syncState() { System.out.print("ChildSync "); }
    }

    public static void main(String[] args) {
        // Analyze keyword rules and access modifier scopes here.
    }

    /* Q1: Consider the commented line inside `CloudController`: `public static void printMeta()`.
       If this line is uncommented, what is the correct term for this behavior, and how does it
       interact with polymorphic execution when invoked from a `ControllerNode` reference variable? */
    // TODO: Distinguish between compile-time static method hiding and runtime dynamic overriding.
    // Answer : static method on ControllerNode is called when we try to do CloudController.printMeta() because
    // static methods cannot be overriden from the super class to sub class

    /* Q2: If a developer uncomments the method `public void syncState()` inside `CloudController`,
       what specific structural message or error does the Java compiler emit during build validation? */
    // TODO: Deduce the strict behavioral protections applied by the `final` keyword modifier on methods.
    // Answer : it occurs an error saying that the method syncState on the superclass is final so it cannot be changed

    /* Q3: Analyze the initialization sequence below. Which code statement safely completes compilation?

       final List<String> inventoryList = new ArrayList<>();
       Statement 1: inventoryList = new ArrayList<>();
       Statement 2: inventoryList.add("Item_Alpha");
       Statement 3: inventoryList = null;
       Answer : only Statement 2 is safe, because final modifier on inventoryList means that the values cannot be reassigned
    */
    public static void evaluateFinalReferenceMutability() {
        // TODO: Differentiate between changing an object reference assignment vs mutating the internal state of that object.
    }

    /* Q4: Suppose a class `DataPipeline` inside package `org.engine` has a member field marked as `protected`.
       Class `AnalyticsNode` inside package `org.reporter` does NOT extend `DataPipeline`. Can an instance
       of `AnalyticsNode` read or write that protected field value directly? */
    // TODO: Define the package boundaries and subclass boundaries enforced by the `protected` modifier.
    // Answer : it cannot since both of them are in a different package, therefore i cannot be accessed since the
    // modifier is set to proteceted which means it can only be accessed by their subclass

    /* Q5: What happens when compilation runs against this constructor architecture design?

       public abstract class AbstractWorker {
           public abstract AbstractWorker();
           public static abstract void performTask();
       }

       Answer : it occurs compile error since an abstact class cannot be instatiated immediately, also the method public static
       abstract void performTask() is also will produce a compile error since we cant directly call AbstractWorker.performTask() immediately
    */

    public static void checkAbstractIllegalCombinations() {
        // TODO: Identify why combining abstract with constructors or static signatures is fundamentally illegal.
    }

    /* Q6: Trace the output when running the execution steps below:

       class TokenHolder {
           public static int executionCount = 0;
           public TokenHolder() { executionCount++; }
       }

       Execution:
       TokenHolder t1 = new TokenHolder();
       TokenHolder t2 = new TokenHolder();
       TokenHolder.executionCount += 5;
       System.out.println(t1.executionCount);

       Answer : note that executionCount is a static instance variable which means we can directly access it without constructing
       new TokenHolder() and also it always reference to the same executionCount everytime we created a new TokenHolder().
       So the answer is 7
    */
    public static void verifyStaticScopeSharing() {
        // TODO: Track how static updates impact access paths through individual object reference instances.
    }

    /* Q7: Identify the compile-time viability of the following scenario:
       A class is declared as `final abstract class TemplateMatrix {}`.
       What specific feedback will the Java compiler provide regarding this design declaration? */
    // TODO: Recognize the contradiction between forcing extension (abstract) and blocking extension (final).
    // Answer : It will produce an error since they are both a contradictive modifiers (final and abstract), final means that
    // the class cannot be changed/modified/reassigned meanwhile abstract means that this class is meant to be extended for their
    // subclass.

    /* Q8: Examine this code segment layout:

       class BaseFieldHolder {
           private int secretKey = 999;
       }
       class ChildFieldExtender extends BaseFieldHolder {
           public int secretKey = 888;
       }

       Execution:
       BaseFieldHolder runner = new ChildFieldExtender();
       System.out.println(((ChildFieldExtender)runner).secretKey);

       Answer : 888, first we cannot modify the superclass private attributes to public in the subclass, so this means that
       secretKey in the superclass and subclass are two completely different variable/reference, therefore runner get cast out
       from BaseFieldHolder to ChildFieldExtender, since secretKey is public there, it prints 888
    */
    public static void checkPrivateFieldShadowing() {
        // TODO: Evaluate how access qualifiers affect variable shadowing across inheritance trees.
    }

    /* Q9: Can a non-static inner class declare static initialization blocks or static method structures
       directly inside its body block context under standard Java 8 parameters? */
    // TODO: Determine the constraints placed on static structures within non-static inner scopes.

    /* Q10: What happens if a local variable declared inside a method is accessed inside an anonymous
       inner class or local lambda expression scope block? What requirement is placed on that local variable? */
    // TODO: Connect the concept of "effectively final" boundaries with local context capture variables.
}