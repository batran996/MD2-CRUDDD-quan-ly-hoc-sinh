package model;

public class StudentModel {
    private int id;
    private String name;
    private int age;
    private ClassroomModel classroomModel;

    public StudentModel() {
    }

    public StudentModel(int id, String name, int age, ClassroomModel classroomModel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classroomModel = classroomModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassroomModel getClassroomModel() {
        return classroomModel;
    }

    public void setClassroomModel(ClassroomModel classroomModel) {
        this.classroomModel = classroomModel;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classroomModel=" + classroomModel.getName() +
                '}';
    }
}
