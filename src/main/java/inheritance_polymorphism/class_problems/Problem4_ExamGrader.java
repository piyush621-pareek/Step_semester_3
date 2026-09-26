
import java.util.*;

/**
 * Problem 4: Examination Question Grader (no custom input — data hardcoded)
 *
 * Polymorphism: each Question type grades a student answer with its own rule.
 * The grader loops over all questions uniformly and sums the scores.
 */
public class Problem4_ExamGrader {

    abstract static class Question {

        protected String text, correctAnswer, studentAnswer;
        protected int points;

        Question(String text, String correct, String student, int points) {
            this.text = text;
            this.correctAnswer = correct;
            this.studentAnswer = student;
            this.points = points;
        }

        abstract String type();

        abstract double score();
    }

    static class McqQuestion extends Question {

        McqQuestion(String t, String c, String s, int p) {
            super(t, c, s, p);
        }

        String type() {
            return "MCQ";
        }

        double score() {
            return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0;
        }
    }

    static class TfQuestion extends Question {

        TfQuestion(String t, String c, String s, int p) {
            super(t, c, s, p);
        }

        String type() {
            return "TF";
        }

        double score() {
            return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0;
        }
    }

    static class EssayQuestion extends Question {

        EssayQuestion(String t, String c, String s, int p) {
            super(t, c, s, p);
        }

        String type() {
            return "ESSAY";
        }

        double score() {
            String student = studentAnswer.toLowerCase();
            int matches = 0;
            for (String kw : correctAnswer.split(",")) {
                kw = kw.trim().toLowerCase();
                if (!kw.isEmpty() && student.contains(kw)) {
                    matches++;
                }
            }
            if (matches >= 2) {
                return points * 0.75;
            }
            if (matches == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Question> questions = Arrays.asList(
                new McqQuestion("What is the capital of France?", "Paris", "Paris", 10),
                new TfQuestion("The Earth is flat?", "False", "True", 5),
                new EssayQuestion("Name two primary OOP principles.",
                        "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20),
                new EssayQuestion("Describe abstraction and composition.",
                        "Abstraction, Composition", "I talked about abstraction.", 15)
        );

        double total = 0;
        for (Question q : questions) {        // uniform processing
            double s = q.score();
            total += s;
            System.out.printf("%s: %.2f%n", q.type(), s);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
