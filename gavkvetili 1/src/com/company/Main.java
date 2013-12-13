package com.company;

public class Main {

    public static void main(String[] args) {
                                          // 1
             int n =6;         //ინტ ცვლადი ნ უდრის 6
             int k=0;
        boolean b=true;
             System.out.println("დღევანდელი რიცხვია " + n);   //დაბეჭვდვა
                  // if
         // შევქმენით ლოგიკური ცვლადი bool - ი რომელიც არის  false
            if(b) { // თუ ბ არის true
            System.out.println("ნიკა");  //დაბეჭდე ნიკა
        }
        else System.out.println("გიორგი"); //თუ არის false მაშინ დაბეჭდე გიორგი
                               //  while
        while(b) {
            System.out.println(" ეს ცვლადი არის კ" + k);
            k++; //ინკრემენტის ოპერატორი რომელიც იზრდება ყოველჯერზე 1-ით
             if(k==200){   //k გახდა 200
                 b=false; // b გახდა false პირობა აგარ შესრულდება

             }
        }
    }
}