package oo;

public class Teacher extends Person {
    private static String TEACHER_INTRODUCTION = " I am a teacher.";
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + TEACHER_INTRODUCTION;
        return introduction;
    }
}
