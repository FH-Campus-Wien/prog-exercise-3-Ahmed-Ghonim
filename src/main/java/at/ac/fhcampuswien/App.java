package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    // int[] name, int[] name = {2,3,1,9}



    public static long [] lcg(long seed){

        long[] random = new long [11];
        long[] save = new long [11];

        long a = 1103515245;
        long m = (long) Math.pow(2, 31);
        long c = 12345;
        random[0] = seed;
        save[0] = seed;

        for(int i = 1; i < random.length; i++) {
            random[i] = (a * save[i-1] + c) % m;
            save[i] = random[i];
        }

        return  random;
    }

    public static void guessingGame( int numberToGuess){
        Scanner scanner = new Scanner(System.in);

        for( int i = 0;i < 10; i++) {
            System.out.print("Guess number " + i + ": ");
            int guess = scanner.nextInt();

            if (guess > numberToGuess && i != 10)
                System.out.println("The number AI picked is lower than your guess.");
            if (guess < numberToGuess && i != 10)
                System.out.println("The number AI picked is higher than your guess.");

            if (i == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }


            if (guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }

        }

    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(100)+1;
    }

    public static boolean swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] - arr2[i];
            arr2[i] = arr2[i] + arr1[i];
            arr1[i] = arr2[i] - arr1[i];
        }

        return true;
    }

    public static String camelCase(String Zeichen) {
        char[] c = Zeichen.toCharArray();

        if (c[0] >= 97 && c[0] <= 122)
            c[0] -= 32;

        for (int i = 0; i < c.length; i++) {
            if (i >= 1 && c[i-1] == ' ' && c[i] >= 97 && c[i] <= 122){
                c[i] -= 32;
            }
            if (i >= 1 && c[i-1] != ' ' && c[i] >= 65 && c[i] <= 90){
                c[i] += 32;
            }
        }

        for (int i = 0; i < c.length; i++) {
            if ((c[i] > 0 && c[i] <= 64) || (c[i] >= 91 && c[i] <= 96) || (c[i] >= 123 && c[i] <= 127)){
                c[i] = 32;
            }
        }
        String x = String.valueOf(c).replaceAll(" ","");
        return x;
    }

    public static int checkDigit(int arr[]){
        int sum = 0;
        int gewichtung = 2;
        int rest;
        int number;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (gewichtung+i);
        }
        rest = sum%11;
        number = 11 - rest;
        if (number == 10) {
            return 0;
        } else if (number == 11) {
            return 5;
        } else {
            return number;
        }
    }


    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        System.out.println("---- <Pseudo Random Numbers> ----");
        System.out.println(Arrays.toString(lcg(8)));
        System.out.println();

        System.out.println("---- <Guessing Game> ----");
        guessingGame(randomNumberBetweenOneAndHundred());
        System.out.println();

        System.out.println("---- <Swap Arrays> ----");
        int[] afirst = new int[] { 7, 6, 2, 4, 8, 5};
        int[] asecond = new int[] {1, 92, 130, 66, 2, 6};

        System.out.println("Array 1: " + Arrays.toString(afirst));
        System.out.println("Array 2: " + Arrays.toString(asecond));

        if(swapArrays(afirst,asecond) == false) {
            System.out.println(swapArrays(afirst, asecond));
        } else {
            System.out.println();
            System.out.println("Array 1: " + Arrays.toString(afirst));
            System.out.println("Array 2: " + Arrays.toString(asecond));
            System.out.println();
        }



        System.out.println("---- <CamelCase> ----");
        System.out.println(camelCase("Fischers Fritz fischt frische Fische"));
        System.out.println();


        System.out.println("---- <Check Digit> ----");
        System.out.println(checkDigit(afirst));

    }
}


