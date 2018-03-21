package io;

import java.io.Serializable;

/**
 * Created by Aif Balaev
 * on 20/03/2018.
 */
public class Animal implements Serializable {
    private static final long serialVerisonUID = 2L;
    private transient String name;
    private transient int age = 10;
    private char type = 'C';

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
