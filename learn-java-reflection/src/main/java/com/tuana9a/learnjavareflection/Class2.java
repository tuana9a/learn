package com.tuana9a.learnjavareflection;

public class Class2 {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
