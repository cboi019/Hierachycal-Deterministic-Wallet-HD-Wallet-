package com.charles.example;


public class Main {
    public static void main(String[] args){
        try {
            // Lets Simulate Creating a Wallet

            String name = "Okoronkwo Charles";
            String age = "23";

            String user = name + age;

            // Now Press Create Account (FrontEnd)

            System.out.println("~~~~~~~New Account~~~~~~~");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

            HDwallet.getHDWallet(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

