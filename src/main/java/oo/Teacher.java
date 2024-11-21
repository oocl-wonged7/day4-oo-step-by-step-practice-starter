package oo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private static String TEACHER_INTRODUCTION = " I am a teacher.";
    private ArrayList<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.klasses = new ArrayList<>();
    }

    public Teacher(int id, String name, int age, School school) {
        super(id, name, age, school);
        this.klasses = new ArrayList<>();
        school.addPerson(this);
    }

    public void addKlass(Klass klass) {
        this.klasses.add(klass);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + TEACHER_INTRODUCTION;
        if (klasses.size() > 0) {
            String klassesString = klasses.stream().map(klass -> klass.getNumber().toString()).collect(Collectors.joining(", "));
            introduction += String.format(" I teach Class %s.", klassesString);
        }
        return introduction;
    }

    public void assignTo(Klass klass) {
        klass.addTeacher(this);
    }

    public Boolean belongsTo(Klass klass) {
        if (klass == null) {
            return false;
        }
        if (this.klasses.size() > 0) {
            return this.klasses.contains(klass);
        }
        return false;
    }

    public Boolean isTeaching(Student student) {
        if (student == null || this.klasses.size() > 0) {
            return false;
        }
        return this.klasses.contains(student.getKlass());
    }
}
