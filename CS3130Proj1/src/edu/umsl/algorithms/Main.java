package edu.umsl.algorithms;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static int findDegree(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the degree of the polynomial. (Between 100000 and 200000)");
        int degree = input.nextInt();
        return degree;
    }

    public static double findX(){
        double x = Math.random();
        while (x == 0 || x == 1){
            Math.random();
        }
        return x;
    }

    public static int [] findCoefficientArray(int degree){
        Random random = new Random();
        int [] coefficient = new int[degree + 1];
        for (int i = 0; i <= degree; i++){
            coefficient[i] = random.nextInt(100) + 1;
        }

        return coefficient;
    }

    public static double forLoop(int [] coefficient, double x, int degree) {
        double result = 0;
        for (int i = 0; i <= degree; i++){
            double nextTerm = coefficient[i];
            for (int j = 0; j < degree - i; j++) {
                nextTerm = nextTerm * x;
            }
            result += nextTerm;
        }
        return result;
    }

    public static double pow(int [] coefficient, double x, int degree){
        double result = 0;
        for (int i = 0; i <= degree; i++) {
            double nextTerm = coefficient[i] * Math.pow(x, degree - i);
            result += nextTerm;
        }
        return result;
    }

    public static double horners(int [] coefficient, double x, int degree){
        double result = coefficient[0];
        for (int i  = 1; i <= degree; i++) {
            result = (result * x) + coefficient[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int degree = findDegree();;
        double x = findX();
        int [] coefficient = findCoefficientArray(degree);
        int userChoice = 1;
        double answer;
        Scanner input = new Scanner(System.in);
        System.out.println("The degree: " + degree);
        System.out.println("x: " + x);
        System.out.println();
        System.out.println("1: Evaluate polynomial using a for loop.");
        System.out.println("2: Evaluate polynomial using pow function");
        System.out.println("3: Evaluate polynomial using Horner's Rule");
        System.out.println("0: Exit application");
        System.out.println();
        while(userChoice != 0) {
            System.out.println("Please select a method to evaluate the polynomial. (1, 2, 3) Enter 0 to exit.");
            userChoice = input.nextInt();
            while(userChoice < 0 || userChoice > 3) {
                System.out.println("Error! You have selected an invalid option.");
                userChoice = input.nextInt();
            }
            if (userChoice == 1) {
                long start1 = System.currentTimeMillis();
                answer = forLoop(coefficient, x, degree);
                long end1 = System.currentTimeMillis();
                System.out.println("Using a for loop the polynomial evaluates to: " + answer);
                System.out.println("It took this calculation: " + (end1 - start1) + " milliseconds" );
            }
            else if (userChoice == 2) {
                long start2 = System.currentTimeMillis();
                answer = pow(coefficient, x, degree);
                long end2 = System.currentTimeMillis();
                System.out.println("Using a pow function the polynomial evaluates to: " + answer);
                System.out.println("It took this calculation: " + (end2 - start2) + " milliseconds" );
            }
            else if (userChoice == 3) {
                long start3 = System.currentTimeMillis();
                answer = horners(coefficient, x, degree);
                long end3 = System.currentTimeMillis();
                System.out.println("Using Horner's Rule the polynomial evaluates to: " + answer);
                System.out.println("It took this calculation: " + (end3 - start3) + " milliseconds" );
            }
        }
        System.out.println("Bye!");
    }
}
