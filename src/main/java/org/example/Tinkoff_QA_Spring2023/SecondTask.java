package org.example.Tinkoff_QA_Spring2023;
import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
        Scanner valueCurrency = new Scanner (System.in);
        String[] input1 = valueCurrency.nextLine().split(" ");
        long USD = Integer.parseInt(input1[0]); //66
        long EUR = Integer.parseInt(input1[1]); //70
        long GPB = Integer.parseInt(input1[2]); //80
        long result;

        Scanner accountAmount = new Scanner (System.in);
        String[] input2 = accountAmount.nextLine().split(" ");
        long sumUSD = Integer.parseInt(input2[0]); //20
        long sumEUR = Integer.parseInt(input2[1]); //150
        long sumGPB = Integer.parseInt(input2[2]); //1000
        //1320 10593 80600
        result = (USD * sumUSD) + (EUR * sumEUR) + (GPB * sumGPB);
        System.out.println(result);
    }
}

