package com.company;

public class Main {

    public static void main(String[] args) {
       Baby by = new Baby(); // შევქმენით baby კლასის ობიექტზე მიმთითებელი
        by.speak();    //გამოვიძახეთ baby-კლასის speak მეთოდი
        Persons per = new Persons(); //შევქმენით persons -კლასის per obieqt-ზე მიმთითებელი
        per.setName("gia");  //setName-ეს მივანიჭეთ გია
        per.getName();   //getnames საშვალებით გამოვიძახეთ მინიჭებული მნიშვნელობა
        per.speak();    //გამოვიძახეთ speak მეთოდი

    }
}
