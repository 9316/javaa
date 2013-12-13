package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 11/3/13
 * Time: 1:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Persons {
  private String name="ნიკა";   //ეს ნიშნავს იამს რო person კლასის String name-ცვლადზე პირდაპირი წვდომა არ გვექნება
    int age;
    int id;
                                             //კლასისის ის ცვლადები ან მეთოდები რომელიბ არიან privet არ გადაეცემიან მემკივდრეობით
      void speak(){
        System.out.println(name  + " ლაპარაკობს....");
    }
    public void eat(){
        System.out.println(name + " ჭამს.... ");
    }
    public void study(){
        System.out.println(name + " სწავლობს...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {     //კონსტრუქტორი
        this.name = name;
    }
}
