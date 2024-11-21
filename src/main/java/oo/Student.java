package oo;

public class Student extends Person {
    private Klass klass;
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction ="My name is " + name + ". I am " + age + " years old. I am a student.";
        if (klass != null) {
            String classIntrodction = " I am in class " + klass.getNumber() + ".";
            introduction += classIntrodction;
        }
        return introduction;
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public Boolean isIn(Klass klass) {
        if (this.klass == null){
            return false;
        }
        return this.klass.equals(klass);
    }
}
