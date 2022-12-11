public class IncrementTest {
    public static void main(String[] args) {
        int x = 1;
        System.out.println(x + 10); // x + 10 不影響原本的 x
        System.out.println(x);

        // x 的值給 temp，temp 再給 x
        int temp = 0;
        temp = x + 10;
        x = temp;
        System.out.println(x); // 11
        // 可簡化成 x = x + 10; 先看等號右邊，x + 10 後的結果給左邊，所以 x = 11

        System.out.println("========================分隔線========================");
        increment();
    }

    private static void increment() {
        // 如果只要將變數 + 1，還可以用 ++；又如果只要將變數 -1，還可以用 --
        // x++ 或 ++x => x = x + 1
        int x = 1;
        System.out.println("x=" + ++x); // ++x，不是 x = ++x

        // ++ 寫在變數前叫前置遞增；寫在變數後面叫後置遞增；-- 就是前置遞減和後置遞減
        int y = 1;
        System.out.println(++y); // 前置遞增馬上加 1 並印出
        System.out.println(y++); // 後置遞增先印出舊值，然後再加 1，所以下次要使用時才會發現加 1 了
        System.out.println("y=" + y); // 3

        int z = 1;
        int result = z++ + ++z; // 1 + 3
        System.out.println("result=" + result); // 4
        System.out.println("z=" + z); // 3
    }
}
