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

    public String introduce(){
        return ("My name is " + name +  ". I am "+ age+" years old.");
    }

    @Override
    public boolean equals(Object anotherPerson){
        if (anotherPerson == null || !(anotherPerson instanceof Person)){
            return false;
        }
        else if (this.id == ((Person) anotherPerson).id){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
