package com.tuana9a.learnjavareflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;

public class ObjectConstructorReflection<T> {
    private final Class<T> type;

    public ObjectConstructorReflection(Class<T> type) {
        this.type = type;
    }

    public T newInstance() {
        try {
            Field[] fields = type.getDeclaredFields();
            PrimitiveHandlerReflection primitiveHandlerReflection = new PrimitiveHandlerReflection();
            Constructor<T>[] constructors = (Constructor<T>[]) type.getConstructors();
            List<Object> initArgs = new LinkedList<>();
            Constructor<T> constructor = constructors[0];
            for (Parameter parameter : constructor.getParameters()) {
                String parameterName = parameter.getName();
                Class parameterType = parameter.getType();
                initArgs.add(primitiveHandlerReflection.newInstance(parameterType));
            }
            return (T) constructor.newInstance(initArgs.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
