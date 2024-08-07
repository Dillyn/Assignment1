import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LambdasAndMethodReferences {
    public static void main(String[] args) {

    staticMR();
    boundMR();
    unboundMR();
    constructorMR();

    }
//Q1
    public static void staticMR(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(5);

        System.out.println("Lambda list not sorted: "+list);

        Consumer<List<Integer>> listConsumer = a -> Collections.sort(a);
        listConsumer.accept(list);

        System.out.println("Lambda list sorted: "+list);

        list.clear();

        list.add(1);
        list.add(2);
        list.add(7);
        list.add(4);
        list.add(5);

        System.out.println("Method reference list not sorted: "+list);

        Consumer<List<Integer>> listConsumer2 = Collections::sort;
        listConsumer2.accept(list);

        System.out.println("Method reference list sorted: "+list);

    }
    //Q2
    public static void boundMR(){
        String name = "Mr. Joe Bloggs";

        Predicate<String> bound = a -> name.startsWith(a);

        System.out.println(bound.test("Mr."));
        System.out.println(bound.test("Mrs."));


        Predicate<String> boundMethod = name::startsWith;

        System.out.println(boundMethod.test("Mr."));
        System.out.println(boundMethod.test("Mrs."));

    }
    //Q3
     public static void unboundMR(){
        Predicate<String> lambda = a -> a.isEmpty();

        System.out.println(lambda.test(""));
        System.out.println(lambda.test("xyz"));

        Predicate<String> methodRef = String::isEmpty;

        System.out.println(methodRef.test(""));
        System.out.println(methodRef.test("xyz"));

         BiPredicate<String, String> biPredicate = (a, b) -> a.startsWith(b);
         System.out.println(biPredicate.test("Mr. Joe Bloggs", "Mr."));
         System.out.println(biPredicate.test("Mr. Joe Bloggs", "Mrs."));

         BiPredicate<String, String> biPredicate2 = String::startsWith;
         System.out.println(biPredicate2.test("Mr. Joe Bloggs", "Mr."));
         System.out.println(biPredicate2.test("Mr. Joe Bloggs", "Mrs."));

     }
     //Q4
    public static void constructorMR(){
        Supplier<List<String>> supplier = () -> new ArrayList<>();
        List<String> list = supplier.get();

        list.add("Lambda");

        System.out.println(list);



        Supplier<List<String>> supplier2 = ArrayList::new;
        list = supplier2.get();
        list.add("method reference");

        System.out.println(list);

        Function<Integer,List<String>> listFunction = n -> new ArrayList<>(n);
        list = listFunction.apply(10);
        list.add("Lambda");
        System.out.println(list);

        Function<Integer,List<String>> listFunction2 = ArrayList::new;
        list = listFunction2.apply(10);
        list.add("Method reference");
        System.out.println(list);

    }
}