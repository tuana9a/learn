package com.tuana9a.learnjavabasic;

//class Class1 extends Abstract1{
public class Class1 {

    public String name;

    public int age;

    public Class1(String name) {
        this.name = "Class1-" + name;
    }

    public void sing() {
        System.out.println("Class1.sing()");
    }

    public String getName() {
        return name;
    }
}
