package nyc.c4q;

import java.util.Scanner;

public class Main {
    public static boolean isValid() {
        boolean letsGoAgain = false;
        boolean repeat = true;
        do {
        System.out.println("Do you want to play again?");
        Scanner whyNot = new Scanner(System.in);
        String userAnswer = whyNot.next();
        userAnswer = userAnswer.toLowerCase();

        if (userAnswer.equals("yes") ||
                userAnswer.equals("y")) {
            letsGoAgain = true;
            return letsGoAgain;
        }
        if (userAnswer.equals("no") ||
                userAnswer.equals("n")) {
            letsGoAgain = false;
            return letsGoAgain;
        } else {
            System.out.println("Please type only yes/no/y/n as a valid answer:");
            continue;
        }
    } while (repeat);
        return letsGoAgain;
    }

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        boolean notDone = true;
//        while (notDone == false) {
            while (hangman.getMisses() < 5 && notDone) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            isValid();

//        }
    }
}
