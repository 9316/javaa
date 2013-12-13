package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/22/13
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuessGame {
    Player p1;   //დავამატეთ Player კლასის  ობიექტი
    Player p2;
    Player p3;
    public void startGame(){
        p1=new Player();    //p1 ობიექტის მიმთითებელს მივანიჭეთ Player ახალი ობიექტი
        p2=new Player();
        p3=new Player();

        int guessP1 =0;        //შევქმენით 3 int ტიპის ცვლადი რომელშიც შევინახავთ Player ობიექტის ნათქვამ რიცხვს
        int guessP2 =0;
        int guessP3 =0;

        boolean p1isRight = false;   //შევქმენით boolean ტიპის 3 ლოგიკური ცვლადი
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10); //targetNumbers მინეიჭა შემთხვევითი რიცხვები 0-9 მდე

        while(true){
            System.out.println("Number to guess is" + targetNumber);    //სტუმრის ამორჩეული ნომერი

         p1.guess();     // player მოთამაშეების აზრი თუ რა რიცხვს ფიქრობენ მოთამაშეები
         p2.guess();     //გამოვიძახეთ მეთოდი guesst
         p3.guess();




            guessP1 = p1.number;   //player მოთამაშეები ასახელებ 0-9 მდე რიცხვებს
            System.out.println("Player one guessed " + guessP1);

            guessP2 = p2.number;
            System.out.println("Player two guessed " + guessP2);

            guessP3 = p3.number;
            System.out.println("Player three guessed " + guessP3);

            if(guessP1==targetNumber){   //ვადარებთ ჩაფიქრებულ მნიშვნელობას
                p1isRight=true;
            }
             if(guessP2==targetNumber){
                p2isRight=true;
            }
             if(guessP3==targetNumber){
                p3isRight=true;
            }

        if(p1isRight|| p2isRight || p3isRight){  //თუ პირველმა მოთამაშემ გამოიცნო ან მეორემ ან მესამემ
            System.out.println("We have a winner");
            System.out.println("Player one " + guessP1 + " " + p1isRight);
            System.out.println("Player two " + guessP2 + " " + p2isRight);
            System.out.println("Player three "+ guessP3 + " "+ p3isRight);
            System.out.println("Game is over");
            break;
        }
            else {
            System.out.println("Players will have to try again");
            }


        }
      }
   }
