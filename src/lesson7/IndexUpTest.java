package lesson7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IndexUpTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {{
            add("a");
            add("b");
            add("b");
            add("b");
            add("b");
            add("c");
        }};

        // index 自動往上
//        for (var i = 0; i < list.size(); i++) {
//            if ("b".equals(list.get(i))) {
//                list.remove(i);
//            }
//        }
//        System.out.println(list);

        // 解決方法一：迴圈從後往前
//        for (var i = list.size(); i > 0; i--) {
//            if ("b".equals(list.get(i - 1))) {
//                list.remove(i - 1);
//            }
//        }
//        System.out.println(list);

        // 解決方法二： remove(Object)
//        for (var i = 0; i < list.size(); i++) {
//            list.remove("b");
//        }
//        System.out.println(list);

        // 解決方法三：iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("b".equals(iterator.next())) {
                // list.remove("b"); // 使用了 iterator，但刪除用的確是 list，會造成只能刪除倒數第二筆的情形
                iterator.remove();
            }
        }

        // 解決方法四：removeIf
//        list.removeIf("b"::equals);
    }
}
