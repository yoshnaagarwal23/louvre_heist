package src;

import java.util.*;

public class MathPuzzle {

    public static boolean mathPuzzle(Scanner sc) {
        Random rand = new Random();
        int totalQuestions = 3;
        int correctAnswers = 0;

        System.out.println("\nYou find a control panel that requires solving math equations to disable it.");
        System.out.println("Solve " + totalQuestions + " problems correctly to proceed.\n");

        for (int i = 1; i <= totalQuestions; i++) {
            // generate slightly harder problems
            int a = rand.nextInt(20) + 5; // 5–24
            int b = rand.nextInt(15) + 2; // 2–16
            int c = rand.nextInt(10) + 1; // 1–10

            int pattern = rand.nextInt(3); // pick one of three formula types
            int correct = 0;
            String expression = "";

            switch (pattern) {
                case 0 -> { // (a + b) * c
                    correct = (a + b) * c;
                    expression = "(" + a + " + " + b + ") * " + c;
                }
                case 1 -> { // a * b - c
                    correct = a * b - c;
                    expression = a + " * " + b + " - " + c;
                }
                case 2 -> { // (a - b) * c
                    correct = (a - b) * c;
                    expression = "(" + a + " - " + b + ") * " + c;
                }
            }

            System.out.print("Problem " + i + ": " + expression + " = ");
            String input = sc.nextLine().trim();

            if (!input.matches("-?\\d+")) {
                System.out.println("Invalid input. Numbers only.\n");
                continue;
            }

            int answer = Integer.parseInt(input);

            if (answer == correct) {
                System.out.println("Correct!\n");
                correctAnswers++;
            } else {
                System.out.println("Wrong! The correct answer was " + correct + ".\n");
            }
        }

        System.out.println("You got " + correctAnswers + " out of " + totalQuestions + " correct.");

        if (correctAnswers >= 2) {
            System.out.println("Access granted.");
            return true;
        } else {
            System.out.println("System locked. Try again later.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean success = mathPuzzle(sc);
        if (success) {
            System.out.println("You move to the next area...");
        } else {
            System.out.println("You failed the puzzle.");
        }
    }
}
