package com.lannister;

import java.util.Objects;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name +"]";
    }

    //对象在被回收之前，这个方法会被调用
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("回收Person!");
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person)o;
       if(this.age == person.age && this.name.equals(person.name)) {
           return true;
       }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
