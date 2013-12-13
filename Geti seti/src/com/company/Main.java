package com.company;

public class Main {

    public static void main(String[] args) {
Student2 stud = new Student2();     // შევქმენით tudent2 კლასისი ობიექტი
        stud.name = "გიორგი";    //ობიექტზე მიმთითებელი მიუთითებს name ცვლადზე
      // stud.age = -1;
        stud.learnMath( 50, 10);  //ობიექტზე მიმთითებლის საშვალებით ვიძახებთ  learnMath მეთოდს რომელსაც გადავცემთ არგუმენტებს
        System.out.println(stud.isDiligent()); // დაბეჭდოს  isDiiligent მეთოდი
        stud.setAge(20);          //ობიექტზე მიმთითებლის დახმარებით age ცვლადს გადავცემთ არგუმენტს
        System.out.println(stud.name + " ს ასაკია " + stud.getAge()); //ვბეჭდავთ names და დაბრუნებულ age ცვლადს

    }
}
