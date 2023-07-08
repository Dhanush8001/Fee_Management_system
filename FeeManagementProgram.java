import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double feesPaid;
    private double totalFees;

    public Student(String name, int rollNumber, double totalFees) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.totalFees = totalFees;
        this.feesPaid = 0;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getRemainingFees() {
        return totalFees - feesPaid;
    }
}

class FeeManagementSystem {
    private Map<Integer, Student> students;

    public FeeManagementSystem() {
        students = new HashMap<>();
    }

    public void addStudent(String name, int rollNumber, double totalFees) {
        Student student = new Student(name, rollNumber, totalFees);
        students.put(rollNumber, student);
    }

    public void updateFeesPaid(int rollNumber, double feesPaid) {
        Student student = students.get(rollNumber);
        if (student != null) {
            student.setFeesPaid(student.getFeesPaid() + feesPaid);
            System.out.println("Fees updated successfully for student: " + student.getName());
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    public void displayFeeDetails(int rollNumber) {
        Student student = students.get(rollNumber);
        if (student != null) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Total Fees: " + student.getTotalFees());
            System.out.println("Fees Paid: " + student.getFeesPaid());
            System.out.println("Remaining Fees: " + student.getRemainingFees());
        } else {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }
}

public class FeeManagementProgram {
    public static void main(String[] args) {
        FeeManagementSystem feeManagementSystem = new FeeManagementSystem();

        feeManagementSystem.addStudent("John", 1, 2000);
        feeManagementSystem.addStudent("Mary", 2, 1500);
        feeManagementSystem.addStudent("David", 3, 3000);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFee Management System Menu:");
            System.out.println("1. Add Fees");
            System.out.println("2. Update Fees");
            System.out.println("3. Display Fee Details");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter roll number of the student: ");
                int rollNumber = scanner.nextInt();
                System.out.print("Enter fees paid: ");
                double feesPaid = scanner.nextDouble();
                feeManagementSystem.updateFeesPaid(rollNumber, feesPaid);
            } else if (choice == 2) {
                System.out.print("Enter roll number of the student: ");
                int rollNumber = scanner.nextInt();
                System.out.print("Enter additional fees paid: ");
                double feesPaid = scanner.nextDouble();
                feeManagementSystem.updateFeesPaid(rollNumber, feesPaid);
            } else if (choice == 3) {
                System.out.print("Enter roll number of the student: ");
                int rollNumber = scanner.nextInt();
                feeManagementSystem.displayFeeDetails(rollNumber);
            } else if (choice == 4) {
                System.out.println("Exiting Fee Management System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}