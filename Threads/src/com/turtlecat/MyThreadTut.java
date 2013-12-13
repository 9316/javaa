package com.turtlecat;

/**
 * ალექსანდრე პატარიძე
 * Date: 10/16/13
 * Time: 4:04 PM
 */
public class MyThreadTut implements Runnable {
    String name;
    public int i= 1;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " " + i++ + "\t");
            if(i%10==0){
                System.out.println();
            }
            if(i==1001)
                break;
            if(Main.stop){
                break;
            }
        }
    }
    public MyThreadTut(String name){
        this.name = name;
    }
}
