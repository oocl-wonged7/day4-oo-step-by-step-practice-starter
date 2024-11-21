package oo;

public class Student extends Person {
    private static String STUDENT_INTRODUCTION = " I am a student.";
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + STUDENT_INTRODUCTION;
        if (klass != null) {
            String classIntrodction = String.format(" I am in class %d.", klass.getNumber());
            introduction += classIntrodction;
        }
        return introduction;
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public Boolean isIn(Klass klass) {
        if (this.klass == null) {
            return false;
        }
        return this.klass.equals(klass);
    }
}
