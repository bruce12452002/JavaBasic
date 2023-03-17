package lesson7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * functional   Throws exception    Returns special value
 * Insert       add(e)              offer(e)
 * Remove       remove()            poll()
 * Examine      element()           peek()
 */
public class QueueTest {
    public static void main(String[] args) {
        test();

    }

    private static void test() {
//        Queue<Integer> p = new PriorityQueue<>();
//        Queue<Integer> p = new ArrayBlockingQueue<>(8);
        Queue<Integer> p = new LinkedBlockingQueue<>();
        p.offer(4);
        p.offer(7);
        p.offer(1);
        p.offer(3);
        System.out.println(p);
        System.out.println(p.element());
    }

    /**
     * First or Last               First Element (Head)                             Last Element (Tail)
     * functional           Throws exception        Special value           Throws exception        Special value
     * Insert               addFirst(e)             offerFirst(e)           addLast(e)、add       offerLast(e)、offer
     * Remove               removeFirst()、remove   pollFirst()、poll        removeLast()            pollLast()
     * Examine              getFirst()、element     peekFirst()、peek        getLast()               peekLast()
     */
    private static void dequeTest() {
        Deque<Integer> d = new ArrayDeque<>();
    }
}
