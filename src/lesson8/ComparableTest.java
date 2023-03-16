package lesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable<ComparableTest> {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ComparableTest(Integer number) {
        this.number = number;
    }

    public ComparableTest() {
    }

    @Override
    public int compareTo(ComparableTest o) {
        return this.number - o.number;
    }

    public static void main(String[] args) {
        List<ComparableTest> list = new ArrayList<>();
        list.add(new ComparableTest(10));
        list.add(new ComparableTest(21));
        list.add(new ComparableTest(18));
        list.add(new ComparableTest(102));
        list.add(new ComparableTest(-1));

        Collections.sort(list);
        list.forEach(s -> System.out.println(s.number));
    }
}
