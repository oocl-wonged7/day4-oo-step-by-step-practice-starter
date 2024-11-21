package oo;

public class Teacher extends Person {
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return ("My name is " + name + ". I am " + age + " years old. I am a teacher.");
    }
}
