package view;

import controller.ClassroomController;
import controller.Studencontroller;
import model.ClassroomModel;
import model.StudentModel;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StudentView {
    Studencontroller studencontroller = new Studencontroller();
    ClassroomController classroomController = new ClassroomController();
    Scanner scanner = new Scanner(System.in);
    List<StudentModel> studentList = studencontroller.getListStudent();


    public void menu() {
        System.out.println("Menu");
        System.out.println("1.Show list Student");
        System.out.println("2.Create Student");
        System.out.println("3.Edit Student");
        System.out.println("4.Delete Student");
        System.out.println("5.Search Student");
        System.out.println("6.Back to menu");

        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            menu();
        }
        switch (choice) {
            case 1:
                showListStudent();
                break;
            case 2:
                createStudent();
                break;
            case 3:
                editStuden();
                break;
            case 4:
                deleteStuden();
                break;
            case 5:
                searchStudent();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice");
        }
        menu();
    }

    private void searchStudent() {
        System.out.println("Enter name to search");
        String nameSearch = scanner.nextLine();
        for (StudentModel student : studentList) {
            if (student.getName().toLowerCase(Locale.ROOT).contains(nameSearch.toLowerCase())) {
                System.out.println(student);
            }
        }

    }

    private void deleteStuden() {
        showListStudent();
        System.out.println("Enter Id to Delete");
        int idDelete = -1;

        try {
            idDelete = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            deleteStuden();
        }
        StudentModel studentDelete = studencontroller.getStudent(idDelete);
        if (studentDelete == null) {
            System.out.println("Student not found");
        } else {
            studencontroller.deleteStudent(idDelete);
            showListStudent();
        }


    }

    private void editStuden() {
        showListStudent();
        System.out.println("Enter id to edit");

        int idEdit = -1;

        try {
            idEdit = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            editStuden();
        }
        StudentModel studentEdit = studencontroller.getStudent(idEdit);
        System.out.println("Enter new Student name");
        String newName = scanner.nextLine();
        if (newName.trim().equals("")) {
            newName = studentEdit.getName();
        }
        System.out.println("Enter new Student Age");
        String ageString = scanner.nextLine();
        int newage;
        if (ageString.trim().equals("")) {
            newage = studentEdit.getAge();
        } else {
            newage = Integer.parseInt(ageString);
        }
        ////classroom edit
        List<ClassroomModel> classroomlist = classroomController.getClassroomList();
        for (ClassroomModel classroom : classroomlist) {
            System.out.println(classroom);
        }
        System.out.println("Enter new Student Classroom");
        int newIdClassroom;
        String idString = scanner.nextLine();
        if (idString.trim().equals("")) {
            newIdClassroom = studentEdit.getClassroomModel().getId();
        } else {
            newIdClassroom = Integer.parseInt(idString);
        }
        StudentModel newStudent = new StudentModel(idEdit, newName, newage, classroomController.getClassroom(newIdClassroom));
        studencontroller.editStudent(newStudent);
        showListStudent();

    }

    private void createStudent() {
        System.out.println("Enter student name");
        String name = scanner.nextLine();
        System.out.println("Enter student age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student classroom");
        List<ClassroomModel> classroomlist = classroomController.getClassroomList();
        for (ClassroomModel classroom : classroomlist) {
            System.out.println(classroom);
        }
        int idClassroom = Integer.parseInt(scanner.nextLine());
        int lastId = studentList.get(studentList.size() - 1).getId();
        ClassroomModel classroomCreate = classroomController.getClassroom(idClassroom);
        StudentModel studentCreate = new StudentModel(lastId + 1, name, age, classroomCreate);
        studencontroller.save(studentCreate);
        showListStudent();

    }

    private void showListStudent() {
        for (StudentModel student : studentList) {
            System.out.println(student);
        }
    }


}
