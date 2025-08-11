import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // Method to input student data
    public static void inputStudentData(ArrayList<String> names, ArrayList<Double> grades) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Student Grade Input ===");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            double grade = -1;
            while (true) {
                System.out.print("Enter grade for " + name + " (0 - 100): ");
                try {
                    grade = Double.parseDouble(scanner.nextLine());
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            names.add(name);
            grades.add(grade);
        }
    }

    // Method to calculate average
    public static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Method to find highest score
    public static int getHighestScoreIndex(ArrayList<Double> grades) {
        int index = 0;
        double max = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > max) {
                max = grades.get(i);
                index = i;
            }
        }
        return index;
    }

    // Method to find lowest score
    public static int getLowestScoreIndex(ArrayList<Double> grades) {
        int index = 0;
        double min = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) < min) {
                min = grades.get(i);
                index = i;
            }
        }
        return index;
    }

    // Method to display summary report
    public static void displaySummary(ArrayList<String> names, ArrayList<Double> grades) {
        System.out.println("\n=== Summary Report ===");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s: %.2f%n", names.get(i), grades.get(i));
        }

        double average = calculateAverage(grades);
        int highestIndex = getHighestScoreIndex(grades);
        int lowestIndex = getLowestScoreIndex(grades);

        System.out.printf("\nAverage Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %.2f (by %s)%n", grades.get(highestIndex), names.get(highestIndex));
        System.out.printf("Lowest Grade: %.2f (by %s)%n", grades.get(lowestIndex), names.get(lowestIndex));
    }

    // Main method
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

        inputStudentData(studentNames, studentGrades);

        if (studentNames.isEmpty()) {
            System.out.println("No student data entered.");
        } else {
            displaySummary(studentNames, studentGrades);
        }

        System.out.println("\nThank you for using the Student Grade Tracker!");
    }
}
