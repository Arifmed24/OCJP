package io;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Aif Balaev
 * on 20/03/2018.
 */
public class InputSreamDemo {
    public static void main(String[] args) throws Exception {
        InputStream is = null;
        byte[] buffer = new byte[20];
        char c;

        try {

            // new input stream created
            is = new FileInputStream("C:\\\\Users\\\\abalaev\\\\Documents\\\\SCJP\\\\ocjp\\\\src\\\\main\\\\resources\\\\example.txt");

            System.out.println("Characters printed:");

            // read stream data into buffer
            is.read(buffer, 3, is.available());
//            is.read(buffer, 3, 5);

            // for each byte in the buffer
            for (byte b : buffer) {

                // convert byte to character
                if (b == 0)

                    // if b is empty
                    c = '-';
                else

                    // if b is read
                    c = (char) b;

                // prints character
                System.out.print(c);
            }

        } catch (Exception e) {

            // if any I/O error occurs
            e.printStackTrace();
        } finally {

            // releases system resources associated with this stream
            if (is != null)
                is.close();
        }
    }
}
