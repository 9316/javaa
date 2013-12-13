package com.company;
import java.util.ArrayList;
                                  //როგორც მასივში ელემენტებზე წვდომა გვაკვს ინდექსების საშვალებით ინდექსის ათვლა იწყება 0-დან
public class Main {             // ArrayList არის სტრუქტურა რომელიშიც შეგვიძლია შევინახოთ მონაცემები და დავამატოთ დინამიურად მონაცემები ცავშალოთ მონაცემები

    public static void main(String[] args) {

        ArrayList<String>someList = new ArrayList<String>();//ArrayList მასივის ობიექტზე მიმთითებელი SomeList //<> ეს ინახავს ტიპებს თუ რა ტიპის ცვლადებს შეინახავს
       someList.add("we <3 Java");
        someList.add("are you <3 Java?");
        someList.add("yes i love java");

        System.out.println(someList.size()); //ვბეჭდავთ ელემენტების რაოდენობას
        System.out.println(someList.get(1));  //ვბეჭდავთ კონკრეტულ ელემენტს


    }
}
