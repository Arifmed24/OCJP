package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Aif Balaev
 * on 20/03/2018.
 */
public class FileInputOutputStream {
    public static void copy(File source, File destination) throws IOException {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File source = new File("C:\\Users\\abalaev\\Documents\\SCJP\\ocjp\\src\\main\\java\\io\\Zoo.java");
        File destination = new File("C:\\Users\\abalaev\\Documents\\SCJP\\ocjp\\src\\main\\java\\io\\ZooCopy.java");
        copy(source, destination);
    }
}
