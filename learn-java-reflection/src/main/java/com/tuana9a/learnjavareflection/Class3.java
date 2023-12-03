package com.tuana9a.learnjavareflection;

public class Class3<T> {
    private Class<T> klass;
    private String name;

    public Class<T> getKlass() {
        return klass;
    }

    public String getKlassName() {
        return klass.getName();
    }

    @Override
    public String toString() {
        return "Class3{" +
                "klass=" + klass +
                ", name='" + name + '\'' +
                '}';
    }
}
