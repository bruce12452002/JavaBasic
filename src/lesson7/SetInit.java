package lesson7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetInit {
    public static void main(String[] args) {
        initSet1();
        initSet2();
        initSet3();
        initSet4();
        initSet5();
        initSet6();
        initSet7();
    }


    private static void initSet1() {
        System.out.println("initSet1");
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        System.out.println(set);
    }

    private static void initSet2() {
        System.out.println("initSet2");
        Set<String> set = new HashSet<>() {
            {
                add("aa");
                add("bb");
            }
        };
        System.out.println(set);
    }

    private static void initSet3() {
        System.out.println("initSet3");
        List<String> list = Arrays.asList("aa", "bb", "aa"); // 元素長度不可變，list 轉 set
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }

    private static void initSet4() {
        System.out.println("initSet4");
        Stream.of("aa", "bb").collect(Collectors.toSet()).forEach(System.out::println);
//        Stream.of("aa", "bb").toSet().forEach(System.out::println); // 並沒有 toSet()

        LinkedHashSet<String> set = Stream.of("aa", "bb").collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void initSet5() {
        System.out.println("initSet5");
        Set<String> set = Set.of("aa", "bb"); // Java 9，元素內容不可變
        System.out.println(set);
    }

    private static void initSet6() {
        System.out.println("initSet6");
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");

        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }

    private static void initSet7() {
        System.out.println("initSet7");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        Set<String> set = new HashSet<>(map.keySet());
        Set<Integer> set2 = new HashSet<>(map.values());
        System.out.println(set);
    }
}
