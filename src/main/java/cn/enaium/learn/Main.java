package cn.enaium.learn;

import cn.enaium.learn.classes.Test2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Enaium
 */
public class Main {

    private static final ClassContainer classContainer = new ClassContainer();

    public static void main(String[] args) {
        System.out.println(classContainer.create(Test2.class));
        System.out.println(classContainer.create(Test2.class));
        System.out.println(classContainer.create(Test2.class, new Test2()));
        for (Map.Entry<Class<?>, Object> classObjectEntry : classContainer.getClasses().entrySet()) {
            System.out.println(classObjectEntry.getKey());
        }
    }
}
