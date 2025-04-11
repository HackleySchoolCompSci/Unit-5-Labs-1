package com.example;

import java.util.Scanner;
public class CoinBiasDriver
{
    public static void main (String[] args)
    {
        //data necessary for program
        Scanner scan = new Scanner(System.in);
        int heads1 = 0;
        int heads2 = 0;

        //unbias coin
        CoinBias coin1 = new CoinBias();

        //bias coin initialized with user input
        //there shouldn’t be a check for user input error (constructor accounts for this)
        System.out.print("Enter the probability of heads for the second coin (0-1 exclusive): "); 
        CoinBias coin2 = new CoinBias(scan.nextDouble());

        //100 rounds that keep the user updated on coin flips
        for (int i = 0; i < 100; i++)
        {
            System.out.println("Flip " + i);

            coin1.flip();
            if (coin1.isHeads())
            {
                heads1++;
            }
            System.out.println("Coin1 Heads counter: " + heads1);

            coin2.flip();
            if (coin2.isHeads())
            {
                heads2++;
            }
            System.out.println("Coin1 Heads counter: " + heads1);
        }

        // Print the results
        System.out.println ("Coin 1 with bias " + coin1.getBias() + " came up heads " + heads1 + " times.");
        System.out.println ("Coin 2 with bias " + coin2.getBias() + " came up heads " + heads2 + " times.");
    }
}
