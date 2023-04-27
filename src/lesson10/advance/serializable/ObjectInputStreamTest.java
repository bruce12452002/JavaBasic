package lesson10.advance.serializable;

import java.io.*;

public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (InputStream reader = new FileInputStream("testSerializable.ser");
             ObjectInputStream in = new ObjectInputStream(reader)
        ) {
            Object o = in.readObject();
            System.out.println(o);
        }
        System.out.println("finish");
    }
}
