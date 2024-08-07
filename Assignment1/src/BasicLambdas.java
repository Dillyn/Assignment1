
 //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

 interface Printable<T> {
     void print(T t);
 }

 interface Retrievable<T> {
     T retrieve();
 }
 interface Evaluate<T> {
     Boolean isNegative(T t);
 }

 interface Functionable<T, R> {
     R applyThis(T t);
 }

 public class BasicLambdas {
    public static void main(String[] args) {

        BasicLambdas assignment1 = new BasicLambdas();

        List<Person> listPeople = getPeople();
        sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);

        assignment1.consumer();
        assignment1.supplier();
        assignment1.predicate();
        assignment1.function();
    }
//Q1
    public void consumer(){
        //1a
        Printable<String> printC = s -> System.out.println(s);
        printC.print("Printable lambda");


        //1b
        Consumer<String> printC1 = a -> System.out.println(a);
        printC1.accept("Printable lambda");

        Consumer<String> printC2 = System.out::println;
        printC2.accept("Printable lambda");

    }
//Q2
    public void supplier(){
        //2a
        Retrievable<Integer> printS = () -> (77);
        System.out.println(printS.retrieve());

        //2b
        Supplier<Integer> printS1 = () -> (77) ;
        System.out.println(printS1.get());
    }
 //Q3
    public void predicate(){
        //3a
        Evaluate<Integer> printP = s ->  s<0;
        System.out.println(printP.isNegative(-1));
        System.out.println(printP.isNegative(1));

        //3b
        Predicate<Integer> printP1 = i -> i < 0;
        System.out.println(printP1.test(-1));
        System.out.println(printP1.test(1));

        //3c
        int x = 4;
        int y = 7;
        System.out.println(x +" is an even number: "+check(x, b ->  b % 2 ==0 ));
        System.out.println(y +" is an even number: "+check(y, b ->  b % 2 ==0 ));

        String a = "Mr. Joe Bloggs";
        String b = "Ms. Ann Bloggs";
        System.out.println("Does " +a+ " begin with Mr "+check(a,f -> f.startsWith("Mr")));
        System.out.println("Does " +b+ " begin with Mr "+check(b,f -> f.startsWith("Mr")));

        Person mike = new Person("Mike",33,1.8 );
        Person ann = new Person("Ann",13,1.4 );

        System.out.println("Is "+mike+" an adult? "+check(mike.getAge(),f -> f>=18));
        System.out.println("Is "+ann+" an adult? "+check(ann.getAge(),f -> f>=18));
    }

    //Q4
     public void function(){
       //4a
        Functionable<Integer,String> lambda = a -> "The number is: " + a;
        System.out.println(lambda.applyThis(25));

        //4b
         Function<Integer, String> function = a -> "The number is: " + a;
         System.out.println(function.apply(25));
     }
//Q5
     private static List<Person> getPeople() {
         List<Person> result = new ArrayList<>();

         result.add(new Person("Mike", 33, 1.8));
         result.add(new Person("Mary", 25, 1.4));
         result.add(new Person("Alan", 34, 1.7));
         result.add(new Person("Zoe", 30, 1.5));
         return result;

     }
     //Q6
     private static void  sortAge(List<Person> people){
        //6a
         people.sort(Comparator.comparing(p -> p.getAge()));

        //6b
        // people.forEach(p -> System.out.println(p));

         System.out.println("Sorted by age");
        //Q9
         people.forEach(System.out::println);


     }

     //Q7
     private static void sortName(List<Person> people){
        //7a
        people.sort(Comparator.comparing(p -> p.getName()));

        //7b
        // people.forEach(p -> System.out.println(p));
         System.out.println("Sorted by name");
         //Q9
         people.forEach(System.out::println);
     }

     //Q8
     private static void sortHeight(List<Person> people){
        //8a
         people.sort(Comparator.comparing(p -> p.getHeight()));

         //8b
         //people.forEach(p -> System.out.println(p));
         System.out.println("Sorted by height");
         //Q9
         people.forEach(System.out::println);
     }

    //I checked what was your implementation over here. I was a bit confused
     public static <T> boolean  check(T t, Predicate<T> lambda){
         return lambda.test(t);
         }

 }

 class Person {

     private Integer age;
     private String name;
     private Double height;

     Person(String name, Integer age, Double height) {
         this.age = age;
         this.name = name;
         this.height = height;
     }



     @Override
     public String toString() {
         return "Person{" + "age=" + age + ", name=" + name + ", height=" + height + '}';
     }

     public Double getHeight() {
         return height;
     }

     public Integer getAge() {
         return age;
     }

     public String getName() {
         return name;
     }
 }