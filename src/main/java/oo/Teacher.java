package oo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private static String TEACHER_INTRODUCTION = " I am a teacher.";
    private ArrayList<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String introduction = super.introduce() + TEACHER_INTRODUCTION;
        if (klasses != null) {
            String klassesString = klasses.stream().map(klass -> klass.getNumber().toString()).collect(Collectors.joining(", "));
            introduction += String.format(" I teach Class %s.",klassesString);
        }
        return introduction;
    }

    public void assignTo(Klass klass) {
        if (klass == null) {
            return;
        }
        if (this.klasses == null) {
            this.klasses = new ArrayList<>();
        }
        this.klasses.add(klass);
    }

    public Boolean belongsTo(Klass klass) {
        if (klass == null) {
            return false;
        }
        if (this.klasses != null) {
            return this.klasses.contains(klass);
        }
        return false;
    }

    public Boolean isTeaching(Student student) {
        if (student == null || this.klasses == null) {
            return false;
        }
        return this.klasses.contains(student.getKlass());
    }
}
