package com.turtlecat;

/**
 * ალექსანდრე პატარიძე
 * Date: 10/16/13
 * Time: 4:00 PM
 */
public class MyThread implements Runnable {
    public static int i=1;
    public String name;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);  //ნაკადს ვთხოვთ შეისვენოს 100 მილიწამით
            } catch (InterruptedException e) {  //sleep მეთოდმა შეიძლება გამოისროლოს შეცდომა ამიტომ ჩასმულია try catch მეთოდში
                e.printStackTrace();
            }
            System.out.println(name + " " +  i++ + "\t");  //  ბეჭდავს ნაკადის სახელს და ინდექსაციის ნომერს, რომელიც ინკრემიტირდება

            if(i==1001)    //თუ გაუტოლდა 1001-ს მაშინ გათიშოს ციკლი
                break;
            if(Main.stop){   //თუ
                break;
            }
        }
    }
    public MyThread(String name){
        this.name=name;
    }
}
