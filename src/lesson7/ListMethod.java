package lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        // MEMORY
        List<String> list1 = new ArrayList<>();
        // List<String> list2 = new LinkedList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1.get(0));
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
