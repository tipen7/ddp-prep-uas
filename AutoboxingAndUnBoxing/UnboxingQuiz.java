package AutoboxingAndUnBoxing;

import java.util.ArrayList;
import java.util.List;

public class UnboxingQuiz {

    public static void main(String[] args) {

    /* Question 1 */
    Integer a = 100;
    Integer c = 200;

    System.out.println(a == 100);
    System.out.println(c == 200);

    int sum = a + c;
    System.out.println(sum);
    

    /* Explanation

       --- Ouput ---
       true
       true
       300
       -------------

       * When a == 200, Java actually did unboxing from Integer to int with the 200,
       c.IntValue() which valued 200. Note that if we uses == between two primitive data types,
       then it only compare their values, because originally primitive data types does not have reference.
       Thus, it become 200 == 200 ? true! Same goes with a == 100?


    */


    /* Question 2 */

    List<Integer> numbers = new ArrayList<>();

    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    for (int x : numbers) {
        x *= 2;
    }

    System.out.println(numbers);

    /* Explanation

    --- Output ---
    [1, 2, 3]
    --------------

    * So there are two things happening here, autoboxing and then unboxing. Autoboxing occurs when we tried to do
    numbers.add(1) which we know 1 is an int data types, so Java applies autoboxing from int -> Integer, same goes
    with 2 and 3. 

    * And then Java did unboxing, from Integer -> int in the for loop,
    int temp = x.IntValue()
    temp *= 2
    since temp is an int or primitive data types, it doesnt have a reference, therefore the original list does not
    affected by this line of code.
    
    */


    /* Question 3 */

    Integer x = null;

    try {

        Integer y = x + 10;

        System.out.println(y);

    } catch (Exception e) {

        System.out.println(e.getClass().getSimpleName());
    }

    /* Explanation
    ------ Output ------
    NullPointerException
    --------------------

    * We know that x is initially null, then we try to do Integer y = x + 10, what happens here is unboxing and autoboxing,
    y = Integer.valueOf(x.IntValue() + 10), but since x is null, we cant invoke method on a null object, therefore resulted
    in NullPointerException.

    * Note:
    For any Java wrapper classes, they cant immediately be operated with arithmetic operators,
    +, -, *, /, %, ++, so Java did unboxing from Wrapper -> their related data types, and the autobox if neccessary.
    
    */

   
        
    }

    
    
}
