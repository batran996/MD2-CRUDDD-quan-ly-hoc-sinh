package controller;

import model.StudentModel;
import sevice.student.IStudentSevice;
import sevice.student.StudentSeviceIMPL;

import java.util.List;

public class Studencontroller {
    IStudentSevice studentSevice = new StudentSeviceIMPL();
    public List<StudentModel>getListStudent(){
        return studentSevice.finAll();
    }
    public void save(StudentModel student){
        studentSevice.save(student);
    }


    public StudentModel getStudent(int idEdit) {
        return studentSevice.findById(idEdit);
    }
    public void editStudent(StudentModel student){
        studentSevice.edit(student);
    }

    public void deleteStudent(int idDelete) {
        studentSevice.remove(idDelete);
    }
}
