 import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        if (subjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            return;
        }

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {
            int marks;

            do {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Enter a value between 0 and 100.");
                }

            } while (marks < 0 || marks > 100);

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / subjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else if (averagePercentage >= 50) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.println("\n----- STUDENT RESULT -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}