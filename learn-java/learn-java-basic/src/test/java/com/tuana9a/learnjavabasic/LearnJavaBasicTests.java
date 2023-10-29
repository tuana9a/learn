package com.tuana9a.learnjavabasic;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;

public class LearnJavaBasicTests {
    @Test
    public void test1() {
        // TEST ALL
        int[][] a = new int[][]{
                {1, 2, 3},
                {1}
        };

        System.out.println(a[0].length);
        System.out.println(a[1].length);
    }

    @Test
    public void test2() {
        //TEST BREAK OUTER
        outer:
        while (true) {
            int i = 0;
            while (true) {
                if (i > 10)
                    break outer;
                System.out.println(i);
                ++i;
            }
        }
    }

    @Test
    public void test3() throws IOException, ClassNotFoundException {
        //TEST GHI OBJECT RA FILE VÀ ĐỌC OBJECT TỪ FILE
        Class1 temp = new Class1("Gemdino");
        temp.age = 20;
        File f = new File("./object.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(temp);
        oos.close();
        fos.close();
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Class1 temp1 = (Class1) ois.readObject();
        System.out.println(temp1.name + " - " + temp1.age);
        ois.close();
        fis.close();
    }

    @Test
    public void test4() throws IOException {
        //TEST XỬ LÝ FILE
        File file = new File("test/error.png");
        System.out.println(file.exists());
        ImageIO.read(new File("test/error.png"));
        if (file.isDirectory()) System.out.println("Directory");
        else if (file.isFile()) System.out.println("File");
        else System.out.println("Unknown File");
    }

    @Test
    public void test5() {
        //TEST XỬ LÝ COLLECTION ITERATOR
        List<Class2> temp = new ArrayList<Class2>() {{
            add(new Class2("obj1"));
            add(new Class2("obj2"));
        }};
        Class2 temp1 = new Class2("tuan");
        temp.add(temp1);
        temp.add(temp1);

        Set<String> temp3 = new HashSet<String>() {{
            add("abc");
            add("abce");
            add("abcf");
            add("abcd");
        }};

        System.out.println(temp.size());
        for (Iterator<Class2> iterator = temp.iterator(); iterator.hasNext(); ) {
            Class2 string = iterator.next();
            // Remove the current element from the iterator and the list.
            iterator.remove();
        }
        System.out.println(temp.size());
    }

    @Test
    public void test6() {
        try {
            throw new CustomException("tuan dep trai vo dich");
        } catch (CustomException e) {
            System.out.println(e.errorMessage);
        }
    }
}