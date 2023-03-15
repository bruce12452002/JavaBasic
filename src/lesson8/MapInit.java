package lesson8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapInit {
    public static void main(String[] args) {
//        initMap1();
//        initMap2();
//        initMap3();
        initMap4();
//        initMap5();
//        initMap6();
//        initMap7();
    }

    private static void initMap1() {
        System.out.println("initMap1");
        Map<String, Integer> map = new HashMap<>();
        map.put("aa", 11);
        map.put("bb", 22);
        System.out.println(map);
    }

    private static void initMap2() {
        System.out.println("initMap2");
        Map<String, Integer> map = new HashMap<>() {
            {
                put("aa", 11);
                put("bb", 22);
            }
        };
        System.out.println(map);
    }

//    private static void initMap3() {
//        System.out.println("initMap3");
//        List<String> list = Arrays.asList("aa", "bb"); // 元素長度不可變
//        // List<String> list = Arrays.asList(new String[]{"aa", "bb"});
//        System.out.println(list);
//    }

    private static void initMap4() {
        System.out.println("initMap4");
        Stream.of("aa", "bb").collect(Collectors.toMap(Function.identity(), a -> a.charAt(0))) // 通常是 Map 裡有物件
                .forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void initMap5() {
        System.out.println("initMap5");
        Map<String, Integer> map = Map.of("aa", 11, "bb", 22); // Java 9，元素內容不可變
        System.out.println(map);
    }

    private static void initMap6() {
        System.out.println("initMap6");
        Set<String> set = new HashSet<>() {{
            add("aa");
            add("bb");
        }};
        Map<String, Integer> map = new HashMap<>();
        int i = 0;

//        Iterator<String> it = set.iterator();
//        while (it.hasNext()) {
//            map.put(it.next(), i++);
//        }
//        System.out.println(map);

        for (Iterator<String> it2 = set.iterator(); it2.hasNext(); ) {
            map.put(it2.next(), i++);
        }
        System.out.println(map);
    }

    private static void initMap7() {
        System.out.println("initMap7");
        List<String> list = new ArrayList<>() {{
            add("aa");
            add("bb");
        }};

        Map<String, Integer> map = new HashMap<>();
        for (var i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        System.out.println(map);
    }
}
