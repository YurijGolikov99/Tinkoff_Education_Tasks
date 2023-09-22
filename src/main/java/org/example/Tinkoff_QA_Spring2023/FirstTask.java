package org.example.Tinkoff_QA_Spring2023;
import java.util.*;

public class FirstTask {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        byte n = number.nextByte();
        if(n <= 1 || n >= 100) {
            System.out.println("Incorrect Value");
            return;
        }
        Scanner meaning = new Scanner(System.in);
        String m = meaning.nextLine();
        if (m.length() <= 1){
            System.out.println("Too much short text");
            return;
        }
        else if(m.length() >= 100){
            System.out.println("Too much long text");
            return;
        }
        Scanner blackYelow = new Scanner(System.in);
        String by = blackYelow.nextLine();
        if (by.length() != m.length()){
            System.out.println("Wrong length");
        }
        else {
            System.out.println("The Best Logo");
        }
    }
}
