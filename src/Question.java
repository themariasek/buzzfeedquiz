/* Irene Feng 10/12/2022
A question class with Answers.
*/ 
import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    // ask a question, and return the category that corresponds to the answer
    Category ask(Scanner sc) {
        System.out.println(this.label);
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" + this.possibleAnswers[i].label);
        }

        while (true) {
            if (!sc.hasNextInt()) {
                sc.next();
                System.out.println("That's not an answer, silly. Please enter a number between 1 and 4.");
                continue;
            }

            int ans = sc.nextInt();
            if (ans >= 1 && ans <= this.possibleAnswers.length && this.possibleAnswers[ans - 1] != null) {
                return this.possibleAnswers[ans - 1].cat;
            }

            System.out.println("That's not an answer, silly. Please enter a number between 1 and 4.");
        }
    }

}
