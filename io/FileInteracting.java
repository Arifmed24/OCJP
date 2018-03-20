package io;

import java.io.File;

/**
 * Created by Aif Balaev
 * on 20/03/2018.
 */
public class FileInteracting {
    public static void main(String[] args) {
//        File file =  new File("C:\\Users\\abalaev\\Documents\\SCJP\\ocjp\\src\\main\\resources\\example.txt");
        File file = new File("C:\\Users\\abalaev\\Documents\\SCJP\\ocjp\\src\\main\\resources");
        System.out.println("File exists:" + file.exists());
        if (file.exists()) {
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Is File: " + file.isFile());
            System.out.println("Parent path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("File size: " + file.length());
                System.out.println("File last mofified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(subfile.getName());
                }
            }
        }
    }
}
