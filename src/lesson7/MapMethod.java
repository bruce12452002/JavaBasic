package lesson7;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class MapMethod {
    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        System.out.println(map.get("a"));
        System.out.println(map.getOrDefault("b", 8));
        System.out.println(map.size());

        map.put("a", 7); // 一樣的 key 為修改
        map.putIfAbsent("a", 8); // key 沒有才增加

        System.out.println(map.containsKey("a")); // 有無此 key
        System.out.println(map.containsValue(7)); // 有無此 value

        /**
         * 如果 key b 不存在，就塞 key b value 2
         * 如果 key b 存在，就將舊的值加上新的值
         */
        map.merge("b", 2, (o, n) -> o + n);
        System.out.println(map);
        map.merge("b", 20, (o, n) -> o + n);
        System.out.println(map);

//        map.remove("a"); // 刪除 key 是 a 的
//        map.remove("a", 10); // 刪除 key 是 a 且 value 是 10 的
//        map.clear();

//        map.computeIfAbsent("c", k -> 100); // 如果 key c 不存在，就塞 key c value 100
//        System.out.println(map);

//        map.computeIfPresent("b", (k, v) -> v * 2); // 如果 key b 存在，就將 key b 的 value * 2
//        System.out.println(map);

        /**
         * 不管 key 存不存在都會塞 key
         * 注意：key 不存在時，v 為 null
         */
        map.compute("c", (k, v) -> {
            v = Optional.ofNullable(v).orElse(1);
            return v * 2;
        });
        System.out.println(map);
    }

    private static void displayKeyOfMap(Map<Integer, String> map) {
        for (Integer k : map.keySet()) {
            System.out.println(k);
        }
        // map.keySet().forEach(System.out::println);
    }

    private static void displayValueOfMap(Map<Integer, String> map) {
        for (String v : map.values()) {
            System.out.println(v);
        }
        // map.values().forEach(System.out::println);
    }

    private static void displayMap(Map<Integer, String> map) {
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> kv : entries) {
            System.out.println(kv.getKey() + "=" + kv.getValue());
        }
        // map.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
