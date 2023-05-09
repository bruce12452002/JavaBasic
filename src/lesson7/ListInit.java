package lesson7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListInit {
    public static void main(String[] args) {
        initList1();
        initList2();
        initList3();
        initList4();
        initList5();
        initList6();
        initList7();
    }

    private static void initList1() {
        System.out.println("initList1");
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        System.out.println(list);
    }

    private static void initList2() {
        System.out.println("initList2");
        List<String> list = new ArrayList<>() {
            {
                add("aa");
                add("bb");
            }
        };
        System.out.println(list);
    }

    private static void initList3() {
        System.out.println("initList3");
        List<String> list = Arrays.asList("aa", "bb"); // 元素長度不可變
        // List<String> list = Arrays.asList(new String[]{"aa", "bb"});
        System.out.println(list);
    }

    private static void initList4() {
        System.out.println("initList4");
        Stream.of("aa", "bb").collect(Collectors.toList()).forEach(System.out::println);
        Stream.of("aa", "bb").toList().forEach(System.out::println); // Java 16

        LinkedList<String> list = Stream.of("aa", "bb").collect(Collectors.toCollection(LinkedList::new));
    }

    private static void initList5() {
        System.out.println("initList5");
        List<String> list = List.of("aa", "bb"); // Java 9，元素內容不可變
        System.out.println(list);
    }

    private static void initList6() {
        System.out.println("initList6");
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");

        List<String> list = new ArrayList<>(set);
        System.out.println(list);
    }

    private static void initList7() {
        System.out.println("initList7");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        List<String> list = new ArrayList<>(map.keySet());
        List<Integer> list2 = new ArrayList<>(map.values());
        System.out.println(list);
    }
}
