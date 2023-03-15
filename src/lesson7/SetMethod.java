package lesson7;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMethod {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        /**
         * 由於 add 時，在內部會用 hashcode 排序，使用者無法預知誰在前，誰在後，所以不支援索引，就不會有 get、set、remove(index)方法
         * 可轉成 list、array、迴圈的方式取出
         */
        // System.out.println(set.get(0)); //
        Object[] setArray = set.toArray();
        // List<String> list = set.stream().toList(); // Java 16
        String[] setArray2 = set.toArray(new String[]{});
        System.out.println(setArray[0]);
        System.out.println(setArray2[2]);
        displaySet(set);

        System.out.println("========== remove element ==========");
        set.remove("a");
        displaySet(set);

        System.out.println("========== remove all ==> clear ==========");
        set.clear();
        displaySet(set);

        System.out.println("========== contains ==========");
        Set<Integer> s = Set.of(1, 2, 3, 4, 5);
        System.out.println(s.contains(3));
    }

    private static void displaySet(Set<? extends CharSequence> set) {
        for (var i : set) {
            System.out.println(i);
        }

//        Iterator<? extends CharSequence> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
