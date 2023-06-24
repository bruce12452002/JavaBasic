package lesson7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Fail-fast
 * 每修改集合的元素，有個變數 modCount，都會加 1
 * Iterator 裡有個 expectedModCount 變數，第一次是從 modCount 賦值過來的
 * 只要判斷 modCount != expectedModCount 就會報 ConcurrentModificationException 錯
 * <p>
 * Fail-safe
 * java.util.concurrent 的集合可以邊循環邊刪除
 * <p>
 * 假設有兩個執行緒在調用 map，一個在循環裡查看，一個判除裡面的元素，這樣就造成不同步，而產生上面的錯
 * 這個機制也影響到了單執行緒，所以單執行緒也會有這個錯
 */
public class FailFast {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(); // list set map 都一樣
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) { // 使用 for 也是一樣的道理
            System.out.println(it.next());
            map.clear();
        }
    }
}
