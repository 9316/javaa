package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/15/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student {       //დავწერეთ კლასი Student  რომელსაც აქვს ცვლადები name,university,age და აქვს 2 მეთოდი(პუნქცია) learnmath და mathchimestry
    String name;
    String university;
    int age;

    void learnmath(){
        System.out.println("ნიკა სწავლობს პროგრამირებას");
    }
    void mathchimestry(){
        System.out.println("სწავლის პერიოდია 1 წელი");
    }
}
