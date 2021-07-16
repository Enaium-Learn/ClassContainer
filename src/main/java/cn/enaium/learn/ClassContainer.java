package cn.enaium.learn;

import cn.enaium.learn.classes.Test1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Enaium
 */
public class ClassContainer {

    private final HashMap<Class<?>, Object> classes = new HashMap<>();

    public ClassContainer() {
        List<Class<?>> scanClasses = new ArrayList<>(List.of(Test1.class));
        scanClasses.forEach(it -> {
            try {
                classes.put(it, it.getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    public <T> T create(Class<T> klass, Object instance) {
        classes.put(klass, instance);
        return (T) classes.get(klass);
    }

    public <T> T create(Class<T> klass) {
        if (classes.get(klass) == null) {
            try {
                classes.put(klass, klass.getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return (T) classes.get(klass);
    }

    public HashMap<Class<?>, Object> getClasses() {
        return classes;
    }
}
