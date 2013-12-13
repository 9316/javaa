package com.company;

public class Main {

    public static void main(String[] args) {
	Persons pers= new Persons();
        Persons.name = "ნიკა";
        pers.age =20;
        pers.id = 456232;
        Persons.cookin();
        Persons.eat();
        Persons.speak();

        Baby bab = new Baby();
        Baby.name = "გიორგი";
        bab.age = 3;
        bab.id = 789;
        Baby.speak();
        Baby.sleep();
    }
}
