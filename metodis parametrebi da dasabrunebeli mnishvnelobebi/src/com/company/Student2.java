package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/27/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student2 {
    String name;
    int age;


    public void learnThat(int times){
        while(times > 0){
            System.out.println(name + "სწავლობს");
            times--;
            }
        //System.out.println(times);
    }


    public static void main(String[] args) {
        Student2 a = new Student2();
        a.name = "ნიკა";
        a.age = 20;
        a.learnThat(3);      //i კოპირდება int times
    }

}
