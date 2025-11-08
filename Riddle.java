import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Riddle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of riddles and answers
        String[][] riddles = {
            {"What has to be javabroken before you can use it?", "egg"},
            {"I'm tall when I'm young, and I'm short when I'm old. What am I?", "candle"},
            {"What month of the year has 28 days?", "all of them"},
            {"What is full of holes but still holds water?", "sponge"},
            {"What question can you never answer yes to?", "are you asleep"},
            {"What is always in front of you but can't be seen?", "future"},
            {"There's a one-story house in which everything is yellow. What color are the stairs?", "there are no stairs"},
            {"What can you break, even if you never pick it up or touch it?", "promise"},
            {"What goes up but never comes down?", "age"},
            {"What gets wet while drying?", "towel"}
        };

        // Convert riddles to a List and shuffle it
        List<String[]> riddleList = Arrays.asList(riddles);
        Collections.shuffle(riddleList);

        int score = 0;

        // Loop through each riddle once
        for (String[] pair : riddleList) {
            String riddle = pair[0];
            String answer = pair[1];

            System.out.println("\nRiddle: " + riddle);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (userAnswer.contains(answer)) {
                System.out.println(" Correct! The answer is '" + answer + "'.");
                score++;
            } else {
                System.out.println(" Wrong! The correct answer was '" + answer + "'.");
            }
        }

        // Final score
        System.out.println("\n You've answered all the riddles!");
        System.out.println("Your final score: " + score + " out of " + riddles.length);

        scanner.close();
    }
}