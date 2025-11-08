package src;

import java.util.*;

public class CodeLock {

    public static boolean codeLock(Scanner sc) {
        String secret = "4729";  // fixed code for testing (you can randomize later)
        int attempts = 6;

        System.out.println("\n🚪 You found a locked keypad near the Greek statues.");
        System.out.println("Enter the 4-digit security code to proceed. You have " + attempts + " attempts.");

        while (attempts > 0) {
            System.out.print("\nEnter code: ");
            String guess = sc.nextLine().trim();

            // check valid input
            if (guess.length() != 4 || !guess.matches("\\d{4}")) {
                System.out.println("❌ Invalid input. Please enter exactly 4 digits.");
                continue;
            }

            if (guess.equals(secret)) {
                System.out.println("✅ The keypad beeps and the door unlocks!");
                return true;
            }

            // calculate hints
            int correctPosition = 0;
            int correctDigit = 0;
            boolean[] usedSecret = new boolean[4];
            boolean[] usedGuess = new boolean[4];

            // First pass: correct positions
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == secret.charAt(i)) {
                    correctPosition++;
                    usedSecret[i] = true;
                    usedGuess[i] = true;
                }
            }

            // Second pass: correct digits but wrong positions
            for (int i = 0; i < 4; i++) {
                if (usedGuess[i]) continue;
                for (int j = 0; j < 4; j++) {
                    if (!usedSecret[j] && guess.charAt(i) == secret.charAt(j)) {
                        correctDigit++;
                        usedSecret[j] = true;
                        break;
                    }
                }
            }

            attempts--;
            System.out.println("🔎 Hint: " + correctPosition + " digits in correct position, " 
                               + correctDigit + " correct but in wrong position.");
            System.out.println("Attempts left: " + attempts);
        }

        System.out.println("\n🚨 Alarm triggered! You failed to unlock the keypad in time.");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean passed = codeLock(sc);
        if (passed) {
            System.out.println("You move deeper into the museum...");
        } else {
            System.out.println("You were caught! Try again next time.");
        }
    }
}
