package lesson11.clazz;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TransferThreadSafe {
    public static void main(String[] args) {
        // transfer
        List<Object> list1 = Collections.synchronizedList(new ArrayList<>());
        Set<Object> set1 = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> map1 = Collections.synchronizedMap(new HashMap<>());

        // synchronized
        Vector<Object> list2 = new Vector<>();
        Hashtable<Object, Object> map2 = new Hashtable<>();

        // memory
        CopyOnWriteArrayList<Object> list3 = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<Object> set3 = new CopyOnWriteArraySet<>();
        ConcurrentHashMap<Object, Object> map3 = new ConcurrentHashMap<>();
    }
}
