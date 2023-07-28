package lesson4;

import java.util.Arrays;

public class ArrayTest {
    /**
     * 三種宣告陣列的方式
     */
    private void declareArray() {
        // 第一種
        String[] s1 = new String[5];
        s1[0] = "a";

        // 第二種
        String[] s2 = new String[]{"a", "b", "c"};

        // 第三種
        String[] s3 = {"a", "b", "c"}; // 和第二種一樣，但較簡潔，所以第二種很少人用

        setArray(s3); // ... 就是陣列
    }

    private void setArray(String... arr) {
    }
//    private void setArray(String[] arr) {
//    }

    public static void main(String[] args) {
//        fillArray();
//        sort();
//        passByReference();
//        passByValue();
//        dim2();
        dim2Special();
    }

    private static void sort() {
        int[] arr = {9, 5, 2, 7};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        System.out.println(Arrays.binarySearch(arr, 5));
        System.out.println(Arrays.binarySearch(arr, 45)); // 找不到回傳陣列長度加 1 * -1
    }

    private static void passByReference() {
        int[] arr = {9, 5, 2, 7};
        int[] arr2 = arr;
        arr[0] = 999;
        System.out.println(arr2[0]);
    }

    private static void passByValue() {
        int[] arr = {9, 5, 2, 7};
        int[] arr2 = Arrays.copyOf(arr, arr.length); // 從索引 0 開始
        int[] arr3 = Arrays.copyOfRange(arr, 0, arr.length); // 可以自訂起始索引，0~資料長度就等同 copyOf
//        Integer[] iarr = new Integer[]{1, 2, 3};
//        Number[] arr3 = Arrays.copyOf(iarr, arr.length, Number[].class); // 如果陣列型態不想和來源一樣，可用第三個參數

//        int[] systemArr = new int[arr.length];
        /**
         * src：     來源陣列
         * srcPos：  來源陣列從索引多少開始複製
         * dest：    目的陣列
         * destPos： 目的陣列從索引多少開始
         * length：  複製幾個
         */
//        System.arraycopy(arr, 0, systemArr, 0, arr.length);

        arr[0] = 999;
        for (int i : arr2) {
            System.out.println(i);
        }
    }

    private static void dim2() {
//        int[][] arr = new int[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
        int[][] arr2 = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
        System.out.println(arr2.length);
        System.out.println(arr2[0].length);
        System.out.println(arr2[1].length);
        System.out.println(arr2[2].length);
        System.out.println();

        // 方法一
        for (var i = 0; i < arr2.length; i++) {
            for (var j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // 方法二
        for (var i : arr2) {
            for (var j : i) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 方法三
        System.out.println(Arrays.deepToString(arr2));

        // 方法四
        Arrays.stream(arr2).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    private static void dim2Special() {
        int[][] arr2 = new int[3][]; // 可以先宣告 row 就好；但不可只宣告 column
        arr2[0] = new int[5];
        arr2[1] = new int[]{1, 2};
//        arr2[2] = {1, 2}; // 這種方式不能省略 new int[]
    }

    private static void fillArray() {
        // int 預設 0； Integer 預設 null
        int[] arr = new int[5];
        Arrays.fill(arr, 10);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
