package com.tuana9a.learnjavareflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class LearnReflectionTests {
    @Test
    public void test1() throws IllegalAccessException {
        ObjectConstructorReflection<Class1> objectConstructorReflection = new ObjectConstructorReflection<>(Class1.class);
        Class1 class1 = objectConstructorReflection.newInstance();
        assert class1 != null;
        ObjectParserReflection<Class1> objectParserReflection = new ObjectParserReflection<>(Class1.class);
        objectParserReflection.readObject(class1);
    }

    @Test
    public void test2() {
        ObjectConstructorReflection<Class2> objectConstructorReflection = new ObjectConstructorReflection<>(Class2.class);
        Class2 class2 = objectConstructorReflection.newInstance();
        assert class2 != null;
        System.out.println(class2);
    }

    @Test
    public void test3() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Class klass3 = Class3.class;
        Class3<String> k3 = new Class3<>();
        System.out.println("1: " + klass3.getGenericSuperclass());
        Constructor constructor = klass3.getConstructors()[0];
        System.out.println("2: " + Arrays.toString(constructor.getParameters()));
        System.out.println("3: " + Arrays.toString(constructor.getGenericParameterTypes()));
        System.out.println("4: " + Arrays.toString(klass3.getGenericInterfaces()));
//        System.out.println("4: " + Arrays.toString(((ParameterizedType) klass3.getGenericSuperclass()).getActualTypeArguments()));
        Object any = constructor.newInstance();
        System.out.println("5: " + any);
    }
}
