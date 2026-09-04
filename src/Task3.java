import java.util.Scanner;
import java.util.concurrent.*;
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
                "Which language is used for Android development?",
                "Which keyword is used to create a class in Java?",
                "Which symbol is used to end a statement in Java?"
        };
        String[][] options = {
                {"A. Java", "B. Python", "C. HTML", "D. CSS"},
                {"A. function", "B. class", "C. define", "D. create"},
                {"A. :", "B. .", "C. ;", "D. ,"}
        };
        char[] correctAnswers = {'A', 'B', 'C'};
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.println("You have 10 seconds to answer.");
            System.out.print("Enter your answer (A/B/C/D): ");
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> answer = executor.submit(() -> sc.nextLine());
            try {
                String userAnswer = answer.get(10, TimeUnit.SECONDS);
                if (userAnswer.equalsIgnoreCase(
                        String.valueOf(correctAnswers[i]))) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong answer.");
                }
            } catch (TimeoutException e) {
                System.out.println("\nTime's up!");
                answer.cancel(true);
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
            executor.shutdownNow();
        }
        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Your Score: " + score + "/" + questions.length);

        sc.close();
    }
}



