package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/27/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class City {                                 //მასივი არის ობიექტი და არ არსებობს მასივის ცვლადი არსებობს ცვლადი რომელიც მიუთითებს ამ მასივის ობიექტზე
    String name;                                    //და სწორედ arrCity არის ის მიმთითებელი  რომელიც ამ ობიექტზე მიუთითებს
    public static void main(String[] args) {                       //მიმთითებელი რომელიც  არცერთ ობიექტზე არ მიუთითებს არის NULL ტოლი

        City[] arrCity; //გავაკეთეთ განაცხადი მასივის ობიექტის მიმთითებელზე
        arrCity = new City[4]; //შევქმენით ეს ობიექტი და დავაკავშირეთ მიმთითებელს

       arrCity[0] =new City(); //arrCity[0] მიმთითებელი დავაკავშირეთ City კლასის ობიექტს
       arrCity[1] =new City();     //მასივში ელემენტების ათვლა იწყება 0 -დან

        arrCity[0].name = "თბილის";
        arrCity[1].name = "ბათუმი";


        System.out.println(arrCity[0].name);
       // arrCity[0].name = "თბილისი"; //arrCity[0] არის მიმთითებელი  და მივანიჭოთ name-ს მნიშვნელობა მაგ:თბილისი


    }
}

