package view;

import controller.ClassroomController;
import model.ClassroomModel;

import java.util.List;
import java.util.Scanner;

public class ClassroomView {
    ///////từ vieu gọi đối tượng từ tầng contoller để triển khai hàm từ sevice;
    ClassroomController classroomController = new ClassroomController();
    Scanner scanner = new Scanner(System.in);
    List<ClassroomModel> classroomList = classroomController.getClassroomList();

    public void menu() {

        System.out.println("menu");
        System.out.println("1.Show list classroom");
        System.out.println("2.Create Classroom");
        System.out.println("3.Edit Classroom");
        System.out.println("4.Delete Classroom");
        System.out.println("5.Back");

        int choice = 0;
        /////////goi lại hàm menu nếu như nhập k phải số;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            menu();
        }
        /////////////////////viết manu lựa chọn
        switch (choice) {
            case 1:
                showListClassroom();//đã đổi tên để cho gọn
                break;
            case 2:
                createClassroom();
                break;
            case 3:
                editClassroom();
                break;
            case 4:
                deleteClassroom();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice");

        }
        menu();

    }



    private void deleteClassroom() {
        System.out.println("enter idClassroom Dlete");
        int idDelete = -1;

        try {
            idDelete = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            menu();
        }
        ClassroomModel classroomDlete = classroomController.getClassroom(idDelete);
        if (classroomDlete == null) {
            System.out.println("Classroom not found");
        } else {
            System.out.println("chọn Y để xóa hoặc N để hủy");

            boolean repeat;
            do {
                String choice = scanner.nextLine();
                repeat = false;
                if (choice.equalsIgnoreCase("y")) {
                    classroomController.deleteClassroom(idDelete);
                    System.out.println("Delete success");
                    showListClassroom();

                } else if (choice.equalsIgnoreCase("N")) {
                    System.out.println("not delete");
                    showListClassroom();

                } else {
                    System.out.println("sai cú pháp");
                    repeat = true;
                }
            }while (repeat);
        }

    }

    private void editClassroom() {
        System.out.println("Enter id");
        int idEdit = 0;

        try {
            idEdit = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            menu();
        }

        ClassroomModel classroom = classroomController.getClassroom(idEdit);
        if (classroom == null) {
            System.out.println("Classroom not found");
        } else {
            System.out.println("Enter new classroom name");
            String newName = "";
            newName = checkName(newName);
            for (ClassroomModel c:classroomList) {
                if (newName.equalsIgnoreCase(c.getName())){
                    System.out.println("Classroom existed");
                    return;
                }
            }
            classroomController.editClassroom(new ClassroomModel(idEdit, newName));
            showListClassroom();
        }
    }

    private void createClassroom() {
        System.out.println("Enter classroom Name");
        //// check ky tu dac biet cua classroom name;
        String name = "";
        name = checkName(name);
        for (ClassroomModel c:classroomList) {
            if (name.equalsIgnoreCase(c.getName())){
                System.out.println("Classroom existed");

                return;
            }
        }

        int lastId = classroomList.get(classroomList.size() - 1).getId();
        ///tạo class cần truyền vào với id tăng 1 và tên mới;
        ClassroomModel classroom = new ClassroomModel(lastId + 1, name);
        classroomController.saveClassroom(classroom);
        showListClassroom();
    }

    private String checkName(String name) {
        while (!name.matches("[a-zA-Z0-9]+")) {
            name = scanner.nextLine();
            if (!name.matches("[a-zA-Z0-9]+\"")) {
                System.out.println("Invalid name, Enter again");
            }
        }
        return name;
    }

    private void showListClassroom() {

        for (ClassroomModel classroom : classroomList) {
            System.out.println(classroom);
        }
    }


}
