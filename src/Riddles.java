package src;

import java.util.Scanner;
import java.util.Random;

public class Riddles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Louvre-themed riddles
        String[][] riddles = {
            {"Which famous painting is displayed in the Louvre and is known for her enigmatic smile?", "mona lisa"},
            {"What is the large glass pyramid at the entrance of the Louvre called?", "pyramid"},
            {"Which wing of the Louvre houses Egyptian antiquities?", "egyptian wing"},
            {"The Louvre was originally built as a what?", "fortress"},
            {"Which French king transformed the Louvre into a royal palace?", "francis i"},
            {"Which sculpture of a winged goddess is one of the most famous works in the Louvre?", "winged victory"},
            {"In which city is the Louvre located?", "paris"},
            {"What river runs beside the Louvre?", "seine"},
            {"Which room in the Louvre is famous for Greek and Roman classical sculptures?", "denon wing"},
            {"Which famous French museum rivaled the Louvre and was built during the same period?", "versailles"}
        };

        // Pick a single random riddle
        int index = random.nextInt(riddles.length);
        String riddle = riddles[index][0];
        String answer = riddles[index][1];

        // Ask the riddle
        System.out.println("Louvre Riddle: " + riddle);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().trim().toLowerCase();

        // Boolean variable to store whether the answer was correct
        boolean answeredCorrectly = userAnswer.contains(answer);

        if (answeredCorrectly) {
            System.out.println("Correct! The answer is '" + answer + "'.");
        } else {
            System.out.println("Wrong! The correct answer was '" + answer + "'.");
        }

        // Display the boolean value
        System.out.println("Answered correctly? " + answeredCorrectly);

        scanner.close();
    }
}