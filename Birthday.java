package portifolio;

import java.util.Scanner;
import java.util.Random;

public class Birthday {
    public static void main (String[] args) {

        int attempt = 0;
        int min = 20;
        int max = 40;
        int num = 0;

        Random number = new Random();
        int age = number.nextInt((max - min) + 1) + min;
        Scanner choice = new Scanner(System.in);

        System.out.println("\nHi! Today is my birthday.");
        System.out.println("How old do you think I am?");
        System.out.println("You will have three attempts.\n");

        while (attempt < 4) {

            if (attempt == 0) {
                System.out.println("This is your first attempt.");
                System.out.print("Choose an age between 20 and 40: ");
                num = choice.nextInt(); // transforma o objeto 'choice' num número inteiro
            } else if (attempt == 1) {
                System.out.println("\nThis is your second attempt.");
                System.out.print("Choose another age: ");
                num = choice.nextInt();
            } else if (attempt == 2) {
                System.out.println("\nThis is your third and final attempt. Think about...");
                System.out.print("Choose another age: ");
                num = choice.nextInt();
            } else if (attempt == 3) {
                System.out.println("\nI'm sorry... You can't find my age.");
                System.out.print("I'm " + age + " years old.\n");
                System.exit(0); // parar a execução do programa
            }

            if (num < age) {
                System.out.println("\nI'm older.");
            } else if (num > age) {
                System.out.println("\nI'm younger.");
            } else {
                System.out.println("\nCongratulations! This is my age.\n");
                System.exit(0);
            }

            attempt = attempt + 1;

        }

    }

}
