package com.tuana9a.learnjavaspring;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearnSpringTests {
    @Test
    public void test1() throws InterruptedException {
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        context.getBeanFactory().registerSingleton("otherCar", new Car());

        System.out.println("======before destroy=====");

        Tyre tyre = (Tyre) context.getBean("tyre");
        Car car = (Car) context.getBean("car");
        Car otherCar = (Car) context.getBean("otherCar");

        context.getBeanFactory().destroyBean(car);
        context.getBeanFactory().destroyBean(otherCar);
        context.getBeanFactory().destroyBean(tyre);

        System.out.println("======after destroy=====");

        System.out.println(context.getBean("otherCar"));
        System.out.println(context.getBean("car"));

        context.close();
    }

    class Wtf implements MethodReplacer {
        @Override
        public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
            // TODO Auto-generated method stub
            return null;
        }
    }

    @Test
    public void test2() throws InterruptedException {
        
    }
}
