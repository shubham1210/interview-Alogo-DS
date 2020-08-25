package com.gartner.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class LambdaTest {

    public interface FuncInt {

        // An abstract function
        void abstractFun(int x);

        // A non-abstract (or default) function
        default void normalFun()
        {
            System.out.println("Hello");
        }
    }
    // operation is implemented using lambda expressions
    interface FuncInter1
    {
        int operation(int a, int b);
    }

    // sayMessage() is implemented using lambda expressions
    // above
    interface FuncInter2
    {
        void sayMessage(String message);
    }

    public static void main(String[] args) {
        FuncInt fobj = (int x) ->{
            System.out.println(x);
        };

        fobj.abstractFun(5);
        fobj.normalFun();

        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(11);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        System.out.println("Whole LIst");
        arrL.forEach(n-> System.out.println(n));

        Stream<Integer> filtered_data = arrL.stream().filter(p->p>3);
        System.out.println("Filtered LIst");
        filtered_data.forEach(item-> System.out.println(item));


        System.out.println("even LIst");
        arrL.forEach(n -> {
            if (n % 2 == 0) System.out.println(n);
        });
        System.out.println("sorted");
        Collections.sort(arrL,(o1,o2)-> {return o1.compareTo(o2);});

        arrL.forEach(n-> System.out.println(n));

        FuncInter1 add = (int a , int b) -> a+b;
        FuncInter1 multiply = (int a , int b) -> a*b;
        FuncInter2 printmsg = (String msg) ->System.out.println(""+msg);

        System.out.println(add.operation(5,6));
        System.out.println(multiply.operation(5,6));
        printmsg.sayMessage("dine");

        System.out.println("hey".chars().allMatch(Character::isLetter));

        Runnable r1 = () ->{
                System.out.println("here");
        };

        Thread t1 = new Thread(r1);
        t1.start();
        try{
            t1.join(); // you are pausing main thread to pause till the time t1 is not completed.
        }catch (InterruptedException e)
        {

        }

        System.out.println("main is there");
    }
}
