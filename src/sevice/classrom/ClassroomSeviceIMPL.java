package sevice.classrom;

import model.ClassroomModel;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

public class ClassroomSeviceIMPL implements IClassroomSevice {
    static List<ClassroomModel> classroomList = new ArrayList<>();

    static {
        classroomList.add(new ClassroomModel(1, "JV062022"));
        classroomList.add(new ClassroomModel(2, "JV072022"));
    }


    @Override
    public List<ClassroomModel> finAll() {
        return classroomList;

    }

    @Override
    public void save(ClassroomModel classroom) {
        classroomList.add(classroom);
    }

    @Override
    public ClassroomModel findById(int id) {
        for (ClassroomModel classroomModel : classroomList) {
            return classroomModel;
        }
        return null;
    }

    @Override
    public void remove(int id) {
        ClassroomModel classroomDelete = findById(id);
        classroomList.remove(classroomDelete);

    }

    @Override
    public void edit(ClassroomModel classroomModel) {
        ClassroomModel classroomEdit = findById(classroomModel.getId());
        classroomEdit.setName(classroomModel.getName());
    }
}
