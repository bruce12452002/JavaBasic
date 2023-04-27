package lesson10.advance.serializable;

import java.io.Serial;
import java.io.Serializable;

/**
 * transient 和 static 不會被序列化
 *
 * serialVersionUID 為序列化時固定的序號，如果不寫會隨機生成，但有可能會序列化失敗
 * 假設 serialVersionUID 為 1，序列化之後生成檔案了，修改成 10
 * 這時反序列會失敗，因為序號不相同無法反序列化
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
