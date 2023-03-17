List<I>：有順序，依插入的順序
    ※ArrayList：記憶體連續
    ※LinkedList：記憶體不連續
    Stack：後進先出
Set<I>：不重覆
    ※HashSet
    SortedSet：有排序
        TreeSet：按照 Unicode 由小到大排序(不可塞 null)
Queue<I>：先進先出
    PriorityQueue：有排序(不可塞 null)
    ArrayBlockingQueue(不可塞 null)
    LinkedBlockingQueue(不可塞 null)
    Deque<I>：有 Queue、Stack 特性，只要調用不同方法即可
        ArrayDeque(不可塞 null)
        LinkedList

Iterable --> Collection --> Set、Queue、List --> Stack

Map<I>：
    ※HashMap
    SortedMap<I>
        TreeMap：key 有排序(key 不可塞 null)