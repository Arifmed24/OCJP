package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aif Balaev
 * on 20/03/2018.
 */
public class ObjectStreamSample {
    public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFile))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Animal) {
                    animals.add((Animal) object);
                }
            }
        } catch (Exception e) {
            //
        }
        return animals;
    }

    public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream((new BufferedOutputStream(new FileOutputStream(dataFile))))) {
            for (Animal animal : animals) {
                out.writeObject(animal);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bear", 2, 'B'));
        animals.add(new Animal("Tiger", 3, 'T'));

        File dataFile = new File("animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
    }
}
