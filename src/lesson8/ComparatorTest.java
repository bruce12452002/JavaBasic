package lesson8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest implements Comparator<ComparatorTest> {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ComparatorTest(Integer number) {
        this.number = number;
    }

    public ComparatorTest() {
    }

    @Override
    public int compare(ComparatorTest o1, ComparatorTest o2) {
        return o1.number - o2.number;
    }

    public static void main(String[] args) {
        List<ComparatorTest> list = new ArrayList<>();
        list.add(new ComparatorTest(10));
        list.add(new ComparatorTest(21));
        list.add(new ComparatorTest(18));
        list.add(new ComparatorTest(102));
        list.add(new ComparatorTest(-1));


        Collections.sort(list, new ComparatorTest());
//        list.sort(new ComparatorTest());
        list.forEach(s -> System.out.println(s.number));
    }
}
