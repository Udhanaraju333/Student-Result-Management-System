import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks;
    int total;
    double percentage;
    String grade;

    // Constructor
    Student(String name, int rollNo, int subjects) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = new int[subjects];
    }

    // Method to calculate results
    void calculateResult() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        percentage = (double) total / marks.length;

        if (percentage >= 75) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B";
        } else if (percentage >= 40) {
            grade = "C";
        } else {
            grade = "Fail";
        }
    }

    // Method to display result
    void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            System.out.print("\nEnter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();

            Student s = new Student(name, rollNo, subjects);

            System.out.println("Enter marks for " + subjects + " subjects:");
            for (int j = 0; j < subjects; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                s.marks[j] = sc.nextInt();
            }

            s.calculateResult();
            students.add(s);
        }

        // Display all results
        for (Student s : students) {
            s.displayResult();
        }

        sc.close();
    }
}
