package lesson10.advanced.serializable;

import java.io.Serial;
import java.io.Serializable;

/**
 * transient 和 static 不會被序列化
 */
public class Animal implements Serializable {
    @Serial // JDK 14
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private transient double price;
    private final boolean isAnimal = true;
    static char c = 'A';

    public Animal(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAnimal=" + isAnimal +
                ", c=" + c +
                '}';
    }
}
