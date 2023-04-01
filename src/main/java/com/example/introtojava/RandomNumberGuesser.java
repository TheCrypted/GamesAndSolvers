package com.example.introtojava;

import java.util.Arrays;
import java.util.Scanner;

class RandomNumberGuesser {
    public static void main(String[] args){
        int score = 10;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        String inputStr = new String();
        while(run) {
            System.out.println("Do you wish to play (Y/N): ");
            inputStr = scStr.nextLine();
            if (inputStr.toLowerCase().equals("y")) {
                int randint = (int) (Math.round((Math.random() * 10)));
                System.out.println(randint);
                System.out.println("Enter your guess from 1-10: ");
                int inputInt = sc.nextInt();

                if (inputInt != randint) {
                    while (inputInt != randint){
                        if (inputInt < randint) {
                            System.out.println("Your guess is lower than the number");
                            System.out.println("Enter your guess from 1-10: ");
                            inputInt = sc.nextInt();
                            score -= 1;
                        } else {
                            System.out.println("Your guess is greater than the number");
                            System.out.println("Enter your guess from 1-10: ");
                            inputInt = sc.nextInt();
                            score -= 1;
                        }
                    }
                } else {
                    System.out.println("Your guess is correct!!!");
                }
            } else if (inputStr.toLowerCase().equals("n")){
                run = false;
                System.out.println("Thank you for playing...! Your score was: " + score);
            }
        }
    }
}
