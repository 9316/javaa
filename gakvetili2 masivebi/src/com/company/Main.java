package com.company;

public class Main {

    public static void main(String[] args) {
	// array -მასივები არის არის ერთგვარი კონტეინერი რომელიც შეიცავს ერთიდაიგივე ტიპის გარკვეულ მონაცემებს
  String[] firstarray ={"ნიკა","გიორგი","ლუკა","ირაკლი"}; //მასივებში პირველი ელემენტის ინდექსი იწყება 0-დან
        for(int i=0; i<firstarray.length; i++){  // i ითვლის მასივის ზომას
        System.out.println(firstarray[i]);  //ამ შემთხევაში ჩვენ დავაბეჭდინეთ მასივი ბოლო ელემენტამდე
        }

        // მეორე საშვალება მასივის შექმნის
      // String[]secondarray=new String[4];  //განახადი გავაკეთეთ მასივზე
        // secondarray =new String[4];// 4 ელემენტიანი მასივი
       // secondarray[0]="ლიზა";
       // System.out.println(secondarray[0]);

    }


}
