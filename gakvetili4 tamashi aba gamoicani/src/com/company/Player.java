package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/22/13
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player extends GuessGame {
    int number;
    public void guess(){
        number =(int) (10 * Math.random()); //numbers მიენიჭა  შემთხვევითი რიცხვები //Match random -ი მთელ რიცხვებს არ გვიბრუნებს
        System.out.println("I'm guessing " + number);
     }
}
