package oo;

import java.util.Objects;

public class Person {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    public void acknowledgeLeaderAssignment(Klass klass) {
        if (this instanceof Student) {
            System.out.println(String.format("I am %s, student of Class %d. I know %s become Leader.", name, klass.getNumber(), klass.getLeader().name));
        } else if (this instanceof Teacher) {
            System.out.println(String.format("I am %s, teacher of Class %d. I know %s become Leader.", name, klass.getNumber(), klass.getLeader().name));
        }
    }

    @Override
    public boolean equals(Object anotherPerson) {
        if (anotherPerson == null || !(anotherPerson instanceof Person)) {
            return false;
        } else if (this.id == ((Person) anotherPerson).id) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
