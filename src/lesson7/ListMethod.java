package lesson7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListMethod {
    public static void main(String[] args) {
        // MEMORY
        List<String> list1 = new ArrayList<>();
        // List<String> list2 = new LinkedList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");

        Set<String> s = new HashSet<>();
        s.add("aa");
        list1.addAll(s); // 在最後插入元素
//        list1.addAll(1, s); // 在指定的索引插入元素
        System.out.println(list1.get(0));
//        list1.size();
//        list1.contains("");
//        list1.containsAll(Collection);
//        list1.isEmpty();

//        Object[] objects = list1.toArray();
        displayList(list1);

        System.out.println("========== set ==========");
        list1.set(0, "aa");
        displayList(list1);

        /**
         * list 裡的元素是數字，remove 時，會以 index 為主
         * 這時如果想刪除裡面的元素，可用迴圈判斷後再刪除
         *
         * ※ 刪除時 index 會自動往上要注意
         *
         */
        System.out.println("========== remove element ==========");
        list1.remove("aa");
        displayList(list1);

        System.out.println("========== remove index ==========");
        list1.remove(0);
        displayList(list1);

        System.out.println("========== removeAll removeIf ==========");
        List<String> list2 = Stream.of("a", "b", "c", "c", "b", "a").collect(Collectors.toList());
        list2.removeIf(ss -> ss.equals("c"));
        System.out.println(list2);

        List<String> list3 = new ArrayList<>() {{
            add("a");
        }};
        list2.removeAll(list3);
        System.out.println(list2);

        System.out.println("========== remove all ==> clear ==========");
        list1.clear();
        displayList(list1);

        System.out.println("========== contains ==========");
        List<Integer> ls = List.of(1, 2, 3, 4, 5);
        System.out.println(ls.contains(3));

        System.out.println("========== 排序、反轉 ==========");
        Collections.sort(list1); // ls 元素內容不可變，不能排序、反轉
        Collections.reverse(list1); // ls 元素內容不可變，不能排序、反轉
        System.out.println(ls);

//        ls.indexOf();
//        ls.lastIndexOf();
//        ls.retainAll(Collection) // 保留兩個 Collection 相同的元素
//        ls.iterator()
//        ls.listIterator();
//        ls.subList();
    }

    private static void displayList(List<? extends CharSequence> list) {
        for (var i : list) {
            System.out.println(i);
        }

//        Iterator<? extends CharSequence> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
