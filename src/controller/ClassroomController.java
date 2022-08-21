package controller;

import model.ClassroomModel;
import sevice.classrom.ClassroomSeviceIMPL;
import sevice.classrom.IClassroomSevice;

import java.util.List;

public class ClassroomController {
    //tạo đối tượng từ interface IClass sevice;
    IClassroomSevice classroomSevice = new ClassroomSeviceIMPL();

    public List<ClassroomModel> getClassroomList() {
        return classroomSevice.finAll();
    }


    public void saveClassroom(ClassroomModel classroom) {
        //từ model gọi từ classroom bên sevice..
        classroomSevice.save(classroom);
    }

    public ClassroomModel getClassroom(int id) {
        return classroomSevice.findById(id);
    }

    public void editClassroom(ClassroomModel classroomModel) {
        classroomSevice.edit(classroomModel);
    }
    public void deleteClassroom(int id){
        classroomSevice.remove(id);
    }
}
