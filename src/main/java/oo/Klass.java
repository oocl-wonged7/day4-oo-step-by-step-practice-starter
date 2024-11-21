package oo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Klass {
    private int number;
    private Student leader;
    private Set<Teacher> teachers;
    private Set<Student> students;

    public Klass(int number) {
        this.number = number;
        this.teachers = new HashSet<>();
        this.students = new HashSet<>();
    }

    public Integer getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student studentToBeLeader) {
        if (studentToBeLeader.getKlass() != this) {
            System.out.println("It is not one of us.");
            return;
        }
        this.leader = studentToBeLeader;

        teachers.forEach(teacher -> teacher.acknowledgeLeaderAssignment(this));
        students.stream().filter(student -> student != studentToBeLeader).forEach(student -> student.acknowledgeLeaderAssignment(this));
    }

    public Boolean isLeader(Student student) {
        return this.leader == student;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.addKlass(this);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setKlass(this);
    }

    public void attach(Person person) {
        if (person instanceof Teacher teacher) {
            addTeacher(teacher);
        } else if (person instanceof Student student) {
            addStudent(student);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klass klass)) return false;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
