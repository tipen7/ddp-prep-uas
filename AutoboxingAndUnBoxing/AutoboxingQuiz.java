package AutoboxingAndUnBoxing;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingQuiz {

    /* For Question 2 */
     static void print(int x) {
        System.out.println("primitive");
    }

    static void print(Integer x) {
        System.out.println("wrapper");
    }

    static void print(long x) {
        System.out.println("long");
    }

    public static void main(String[] args) {
        
        /* Question 1 */
        Integer a = 100; // Equals to Integer a =  Integer.valueOf(100);
        Integer b = 100; // Equals to Integer b = Integer.valueOf(100);

        Integer c = 200; // Equals to Integer c = Integer.valueOf(200);
        Integer d = 200; // Equals to Integer d = Integer.valueOf(200);

        System.out.println(a == b);      // Comparing wether a and b are the same OBJECT or have the same address in the memory
        System.out.println(c == d);      // Comparing wether c and d are the same OBJECT or have the same address in the memory
        System.out.println(a.equals(b)); // Comparing wether a and b have the same VALUES
        System.out.println(c.equals(d)); // Comparing wether c and d have the same VALUES

        /* Explanation

            -- Output --
            true
            false
            true
            true
            ------------

            * Note: 
            == means that we comparing address location in the memory 
            .equals() in the otherside compares the actual values

            * Integer range's is within -128 to 127, so 100 is still in range, therefore Java uses Integer caching
            which by definition means that Java 'reuses' the same object for a value thats within the range. Meanwhile
            200 is out of range, so Java allocates a new address or creates a new object for c and d.

        */

        /* Question 2 */
        Integer num = 10;
        print(num);

        short s = 5;
        print(s);

        /* Explanation 

        -- Output --
        wrapper (from print(Integer x))
        primitive (from print(int x))
        ------------

        * Note:
        Valid data type casting order in Java:
        1. Implicit casting
        byte -> short -> char ->  int -> long -> float -> double

        ---- Valid implicit casting --- 
        double d = 10F; 
        long l = 10;
        float f = 50L;
        ....

        2. Explicit casting
        double -> float -> long -> int -> char -> short -> byte

        ---- Valid explicit casting
        double d = 10;
        int i = (int) d;
        ...


        * num is initially an Integer type thats assigned with a primitive int value 10. Java automatically applies
        autoboxing from int -> Integer, so num is still an Integer type but with a value of 10. When print() gets invoked, 
        it will search for a method thats taken an Integer type as their parameter which print(Integer x) is suitable, 
        therefore it prints wrapper.

        * s is a short data type which can be casted out implicitly by higher hierarchial order (int, long, float, double), 
        when print(s) is invoked, Java searched for a method that has short as their parameter, but found nothing,
        alternatively, Java finds a print() method that has int data type as their parameter, therefore applies implicit 
        casting from short to int (valid),
        int s_int = (int) s;
        then choosed to use that method.

        */

        /* Question 3 */
        Integer wrapper = null;
        // int primitive = wrapper;
        // System.out.println(primitive);

        /* Explanation

        -- Output --
        NullPointerException at line int primitive = wrapper;

        * Auboxing behind the scene do,
        int primitive = wrapper.intValue();
        and since the wrapper is null, when intValue() gets invoked, it throws NullPointerException

        */

        /* Question 4 */

        List<Integer> nums = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            nums.add(i);
        }

        for (Integer x: nums) {
            x++;
        }

        System.out.print("nums = [");
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + ", ");
        }
        System.out.print("]");

        /* Explanation

        -- Output --
        nums = [0, 1, 2, 3, 4]

        * In the first loop, it succesfully added elements into the list, behind the scene, Java did,
        nums.add(Integer.valueOf(i)), therefore nums are [0, 1, 2, 3, 4] now.

        * When the second loop iterates, x++ somehow creates a new Integer object which completely different from
        the nums list (doesnt refer to the elements in the nums list), 

        x++ -> x = Integer.valueOf(x.intValue() + 1), hence it creates a new Integer object

        Lets get walkthrough with each iteration,
        First number is 0, nums.get(0) = 0, then x++ means 0++, but Java did
        0 = Integer.valueOf(0.intValue() + 1) which creates a new object differ from the original list references


        */

    }
    
}
