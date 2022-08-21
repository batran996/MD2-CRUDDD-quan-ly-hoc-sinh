package view;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().menu();

    }

    public void menu() {
        System.out.println("Menu");
        System.out.println("1.Classroom menu");
        System.out.println("2.Student menu");
        System.out.println("3.Exit");
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            menu();
        }
        switch (choice) {
            case 1:
                new ClassroomView().menu();
                break;
            case 2:
                new StudentView().menu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
        menu();
    }
}