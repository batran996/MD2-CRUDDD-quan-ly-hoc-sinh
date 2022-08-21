package sevice.student;

import model.ClassroomModel;
import model.StudentModel;
import sevice.classrom.ClassroomSeviceIMPL;

import java.util.ArrayList;
import java.util.List;

public class StudentSeviceIMPL implements IStudentSevice {
    static List<StudentModel> studentList = new ArrayList<>();

    static {
        List<ClassroomModel> classroomList = new ClassroomSeviceIMPL().finAll();
        studentList.add(new StudentModel(1, "ba", 20, classroomList.get(0)));
        studentList.add(new StudentModel(2, "bon", 21, classroomList.get(0)));
        studentList.add(new StudentModel(3, "nam", 25, classroomList.get(1)));
        studentList.add(new StudentModel(4, "sau", 18, classroomList.get(1)));
    }


    @Override
    public List<StudentModel> finAll() {
        return studentList;
    }

    @Override
    public void save(StudentModel student) {
        studentList.add(student);
    }

    @Override
    public StudentModel findById(int id) {
        for (StudentModel student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        StudentModel removeStudent = findById(id);
        studentList.remove(removeStudent);
    }

    @Override
    public void edit(StudentModel student) {
        StudentModel studentEdit = findById(student.getId());
        studentEdit.setName(student.getName());
        studentEdit.setAge(student.getAge());
        studentEdit.setClassroomModel(student.getClassroomModel());
    }
}
