package com.company;

public class Main {

    public static void main(String[] args) {   //Main ფუნქცია
        Student n=new Student(); //შევქმენით Student კლასის ობიექტი და გამოვიყენეთ მისი მეთოდები და ცვლადები და დავაბეჭდინეთ

        n.age=20;
        n.name="ნიკა" ;
        n.university="TSU";
        System.out.println("მისი სახელია " + n.name);
        System.out.println(n.name +" არის " + n.age + " წლის");
        System.out.println(n.name + " სწავლობს " + n.university + "-ში");
       n.learnmath();
        n.mathchimestry();

        //class-ი გვაქვს ერთი და მისი მეთოდების და ცვალდების გამოყენებისათვის საჭიროა კლასსის ობიექტის შექმნა

    }
}
