package lesson10.advanced.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        try (OutputStream writer = new FileOutputStream("testSerializable.ser");
             ObjectOutputStream out = new ObjectOutputStream(writer)
        ) {
            out.writeObject(new Animal(1, "rat", 57.5));
            Animal.c = 'B';
            out.writeObject(Animal.c);
        }
        System.out.println("finish");
    }
}
