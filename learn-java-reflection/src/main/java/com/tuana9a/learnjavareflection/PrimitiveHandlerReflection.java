package com.tuana9a.learnjavareflection;

public class PrimitiveHandlerReflection {

    public Object newInstance(Class<?> klass) {
        if (klass.isPrimitive()) {
            if (klass.getName().equals("int")) {
                return 0;
            }
            if (klass.getName().equals("long")) {
                return 0;
            }
        }
        return null;
    }
}
