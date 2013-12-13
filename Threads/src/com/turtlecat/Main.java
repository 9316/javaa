package com.turtlecat;

import java.util.Scanner;

public class Main {
    public static boolean stop;

    public static void main(String[] args) {
        stop =false;
	    Thread t = new Thread(new MyThread("ნაკადი 1"));   //Thread კლასი აუცილებლად ითხოვს Runnable ინტერფეისის მეთოდების იმპლემენტირებას, ან კლასის ობიექტს სადაც ეს უკვე გაკეთებულია
        t.start();

        Thread t2 = new Thread(new MyThread("ნაკადი 2"));
        t2.start();

//        String name = "გიორგი";
//        String sName = "გიორგი";
//        if(name.equals(sName)){  String-ების შედარება ხდება მეთოდით equals სადაც გადაეცემა შესადარებელი ცვლადი ან სტრინგი
//
//        }
//        if(name.equals("გიორგი")){
//
//        }


        Scanner scan = new Scanner(System.in);
        if(scan.nextLine().equals("stop")){     //თუ შემოვიდა სტრინგი  stop
            stop=true;
        }

        if(stop){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0; i<70; i++){
                        System.out.println("მე ვარ დამატებითი ნაკადი");
                    }
                }
            }).start();
        }


    }
}
