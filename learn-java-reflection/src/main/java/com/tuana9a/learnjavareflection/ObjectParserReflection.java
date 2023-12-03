package com.tuana9a.learnjavareflection;

import java.lang.reflect.Field;

public class ObjectParserReflection<T> {
    private final Class<T> type;

    public ObjectParserReflection(Class<T> type) {
        this.type = type;
    }

    public void readObject(T object) throws IllegalAccessException {
        Field[] fields = type.getDeclaredFields();
        int fieldNumber = fields.length;
        for (int i = 0; i < fieldNumber; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            System.out.printf("Field(%d)\t %-20s %-20s\n", i, "name=\"" + f.getName() + "\"", "value=\"" + f.get(object) + "\"");
        }
    }
}
