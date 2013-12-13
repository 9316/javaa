package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/28/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student2 {                  //private ტიპი გვაძლევს იმი საშვალებას რომ ვინემ არ მიანიჭოს კლასში არსებულ ცვლადებს
    String name;                         //როცა ცვლადი არის PRIAVATI ცვლადს პირდაპირ ვერ მიანიჭებ ვერაფერს ამისათვის საჭიროა SET DA GET მეთოდები რათა გავაკონტროლოთ ცვლადებზე მინიჭება
  private  int age;
    int minuteSum;



       public void setAge(int newAge){   //Set მეთოდი რომლის მეშვეობითაც შეგვილია privat ცვლადს მივანიჭოთ ამ შემთხევაში გადაცემული პარამეტრი(newAge)
           if(newAge < 0){          //თუ newAge ნაკლებია 0 -ზე
               System.out.println("ადამიანის ასაკი არ შეიძლება იყოს უარყოფითი რიცხვი"); //დაბეჭდს
           }
           else{
               age=newAge;    //age მიენჭა newAge

           }

       }

    public int getAge(){     // get მეთოდი რომელიც გვიბრუნებს age ცვლადს
        return age ;
    }

    public void learnMath(int times , int minutes){        //შევქმენით მეთოდი რომელსაც გადავეცით პარამეტრები
        while(times > 0){                 //სანამ times მეტია 0-ზე
            System.out.println(name + "სწავლობს" + minuteSum); //დაბეჭდოს სახელი და წუთი
            minuteSum+=minutes ;     //minutesSum ენიჭება minute
            times--;          //times დეკრიმენტირდება (იკლებს ყოველჯერზე ჩვენს შემთხვევაში 0-მდე)
        }
    }

    public boolean isDiligent(){     //ლოგიკური მეთოდი
       if(minuteSum > 100){      //თუ დრო მეტია ასზე
           System.out.println(name + "სწავლობს კარგად"); //ბეჭდავს
          return true;          //აბრუნებს თრუს

       }
         else{
           System.out.println(name + "სწავლობს ცუდად");
        return false;
    }
    }
}

