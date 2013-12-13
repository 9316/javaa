package com.company;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 11/4/13
 * Time: 12:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
       //  ArrayList<Carrot> list = new ArrayList<Carrot>();  //Carrot კლასისი მასივი list
       // list.add(new Carrot());   //listმასივში დავამატეთ carrot კლასის ობიექტი

       // for(Carrot c: list){    //იტერატურული ციკლი
         //   c.grow();
        Object car = new Carrot();  //ამ შემთხვაში object კლასისთვის უცნობია მეთოდი grow
        Carrot p = (Carrot) car;   //ამით მივუთითებთ carrot კლასის ობიექტს   //ამას ეძახიან მიმთითებლის "დაკასტვას"
        ((Carrot) car).grow();
        }





    }

